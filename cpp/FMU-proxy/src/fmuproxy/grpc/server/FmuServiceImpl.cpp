/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

#include <vector>

#include <fmuproxy/grpc/server/FmuServiceImpl.hpp>

#include "../../util/simple_id.hpp"
#include "grpc_server_helper.hpp"

using namespace std;
using namespace fmuproxy::grpc;
using namespace fmuproxy::grpc::server;

using ::grpc::Status;
using ::grpc::ServerContext;

namespace {

    fmi2String strToChar(const std::string &s) {
        char *pc = new char[s.size() + 1];
        std::strcpy(pc, s.c_str());
        return pc;
    }

}

FmuServiceImpl::FmuServiceImpl(unordered_map<string, shared_ptr<fmi4cpp::fmi2::Fmu>> &fmus) : fmus_(fmus) {}

::Status FmuServiceImpl::CanCreateInstanceFromCS(ServerContext *context,
                                                 const ::fmuproxy::grpc::CanCreateInstanceFromCSRequest *request,
                                                 Bool *response) {
    auto &fmu = fmus_[request->fmu_id()];
    response->set_value(fmu->supportsCoSimulation());
    return ::Status::OK;
}

::Status FmuServiceImpl::CanCreateInstanceFromME(ServerContext *context,
                                                 const CanCreateInstanceFromMERequest *request, Bool *response) {
    auto &fmu = fmus_[request->fmu_id()];
    response->set_value(fmu->supportsModelExchange());
    return ::Status::OK;
}

::Status FmuServiceImpl::GetModelDescription(ServerContext *context, const GetModelDescriptionRequest *request,
                                             ModelDescription *response) {
    const auto &fmu = fmus_[request->fmu_id()];
    grpcType(*response, *fmu->getModelDescription());
    return ::Status::OK;
}

::Status FmuServiceImpl::CreateInstanceFromCS(ServerContext *context, const CreateInstanceFromCSRequest *request,
                                              InstanceId *response) {
    auto &fmu = fmus_[request->fmu_id()];

    const string instance_id = generate_simple_id(10);
    slaves_[instance_id] = fmu->asCoSimulationFmu()->newInstance();
    response->set_value(instance_id);
    cout << "Created new FMU instance with id=" << instance_id << endl;
    return ::Status::OK;
}

::Status FmuServiceImpl::CreateInstanceFromME(ServerContext *context, const CreateInstanceFromMERequest *request,
                                              InstanceId *response) {
    //TODO implement from Model Exchange
    return ::Status(::grpc::StatusCode::UNIMPLEMENTED, "Model Exchange wrapper not available!");
}


::Status
FmuServiceImpl::SetupExperiment(::grpc::ServerContext *context, const ::fmuproxy::grpc::SetupExperimentRequest *request,
                                ::fmuproxy::grpc::StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->setupExperiment(request->start(), request->stop(), request->tolerance());
    response->set_status(grpcType(slave->getLastStatus()));
    return ::Status::OK;
}

::Status FmuServiceImpl::EnterInitializationMode(::grpc::ServerContext *context,
                                                 const ::fmuproxy::grpc::EnterInitializationModeRequest *request,
                                                 ::fmuproxy::grpc::StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->enterInitializationMode();
    response->set_status(grpcType(slave->getLastStatus()));
    return ::Status::OK;
}

::Status FmuServiceImpl::ExitInitializationMode(::grpc::ServerContext *context,
                                                const ::fmuproxy::grpc::ExitInitializationModeRequest *request,
                                                ::fmuproxy::grpc::StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->exitInitializationMode();
    response->set_status(grpcType(slave->getLastStatus()));
    return ::Status::OK;
}

::Status FmuServiceImpl::Step(ServerContext *context, const StepRequest *request, StepResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->doStep(request->step_size());
    response->set_status(grpcType(slave->getLastStatus()));
    response->set_simulation_time(slave->getSimulationTime());
    return ::Status::OK;
}

::Status FmuServiceImpl::Terminate(ServerContext *context, const TerminateRequest *request, StatusResponse *response) {
    const auto instance_id = request->instance_id();
    auto &slave = slaves_[instance_id];
    bool status = slave->terminate();
    response->set_status(grpcType(slave->getLastStatus()));
    slaves_.erase(instance_id);
    return ::Status::OK;
}

::Status FmuServiceImpl::Reset(ServerContext *context, const ResetRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    bool status = slave->reset();
    response->set_status(grpcType(slave->getLastStatus()));
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadInteger(ServerContext *context, const ReadRequest *request, IntegerRead *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Integer> read(vr.size());
    bool status = slave->readInteger(vr, read);
    response->set_status(grpcType(slave->getLastStatus()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadReal(ServerContext *context, const ReadRequest *request, RealRead *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Real> read(vr.size());
    bool status = slave->readReal(vr, read);
    response->set_status(grpcType(slave->getLastStatus()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadString(ServerContext *context, const ReadRequest *request, StringRead *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2String> read(vr.size());
    bool status = slave->readString(vr, read);
    response->set_status(grpcType(slave->getLastStatus()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status FmuServiceImpl::ReadBoolean(ServerContext *context, const ReadRequest *request, BooleanRead *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference>vr (request->value_references().begin(), request->value_references().end());
    vector<fmi2Boolean> read(vr.size());
    bool status = slave->readBoolean(vr, read);
    response->set_status(grpcType(slave->getLastStatus()));
    auto values = response->mutable_values();
    for (const auto value : read) {
        values->Add(value);
    }
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteInteger(ServerContext *context, const WriteIntegerRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Integer> values(request->values().begin(), request->values().end());
    bool status = slave->writeInteger(vr, values);
    response->set_status(grpcType(slave->getLastStatus()));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteReal(ServerContext *context, const WriteRealRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Real> values(request->values().begin(), request->values().end());
    bool status = slave->writeReal(vr, values);
    response->set_status(grpcType(slave->getLastStatus()));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteString(ServerContext *context, const WriteStringRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2String> values(vr.size());
    std::transform(request->values().begin(), request->values().end(), std::back_inserter(values), strToChar);
    bool status = slave->writeString(vr, values);
    response->set_status(grpcType(slave->getLastStatus()));
    return ::Status::OK;
}

::Status
FmuServiceImpl::WriteBoolean(ServerContext *context, const WriteBooleanRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];
    vector<fmi2ValueReference> vr(request->value_references().begin(), request->value_references().end());
    vector<fmi2Boolean> values(request->values().begin(), request->values().end());
    bool status = slave->writeBoolean(vr, values);
    response->set_status(grpcType(slave->getLastStatus()));
    return ::Status::OK;
}

::Status
FmuServiceImpl::GetFMUstate(ServerContext *context, const GetFMUstateRequest *request, GetFMUstateResponse *response) {
    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
    }

    //TODO

//    int64_t state;
//    bool status = grpcType(slave->getFMUstate(state));
//
//    response->set_state(state);
//    response->set_status(status);

    return ::Status::CANCELLED;
}

::Status
FmuServiceImpl::SetFMUstate(ServerContext *context, const SetFMUstateRequest *request, StatusResponse *response) {
    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
    }

    //TODO

//    bool status = grpcType(slave->setFMUstate(request->state()));
//    response->set_status(status);

    return ::Status::CANCELLED;
}

::Status
FmuServiceImpl::FreeFMUstate(ServerContext *context, const FreeFMUstateRequest *request, StatusResponse *response) {

    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canGetAndSetFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetAndSetFMUstate'!");
    }

    //TODO

//    int64_t _state = request->state();
//    bool status = grpcType(slave->freeFMUstate(_state));
//    response->set_status(status);

    return ::Status::CANCELLED;
}

::Status
FmuServiceImpl::SerializeFMUstate(ServerContext *context, const SerializeFMUstateRequest *request,
                                  SerializeFMUstateResponse *response) {

    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canSerializeFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'SerializeFMUstate'!");
    }

    //TODO

//    int64_t state = 0;
//    string serializedState;
//    const bool status = grpcType(slave->serializeFMUstate(state, serializedState));
//
//    response->set_status(status);
//    response->set_state(serializedState);

    return ::Status::CANCELLED;
}

::Status
FmuServiceImpl::DeSerializeFMUstate(ServerContext *context, const DeSerializeFMUstateRequest *request,
                                    DeSerializeFMUstateResponse *response) {

    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->canSerializeFMUstate()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'deSerializeFMUstate'!");
    }

    //TODO

//    int64_t state;
//    const bool status = grpcType(slave->deSerializeFMUstate(request->state(), state));
//
//    response->set_state(state);
//    response->set_status(status);

    return ::Status::CANCELLED;
}

::Status FmuServiceImpl::GetCoSimulationAttributes(ServerContext *context,
                                                   const GetCoSimulationAttributesRequest *request,
                                                   CoSimulationAttributes *response) {
    auto &slave = slaves_[request->instance_id()];
    auto md = slave->getModelDescription();

    response->set_model_identifier(md->modelIdentifier());
    response->set_can_get_and_set_fmustate(md->canGetAndSetFMUstate());
    response->set_can_serialize_fmustate(md->canSerializeFMUstate());
    response->set_can_handle_variable_communication_step_size(md->canHandleVariableCommunicationStepSize());
    response->set_max_output_derivative_order(md->maxOutputDerivativeOrder());
    response->set_provides_directional_derivative(md->providesDirectionalDerivative());

    return ::Status::OK;
}


::Status FmuServiceImpl::GetDirectionalDerivative(ServerContext *context,
                                                  const ::fmuproxy::grpc::GetDirectionalDerivativeRequest *request,
                                                  GetDirectionalDerivativeResponse *response) {

    auto &slave = slaves_[request->instance_id()];

    if (!slave->getModelDescription()->providesDirectionalDerivative()) {
        return ::Status(::grpc::StatusCode::UNAVAILABLE, "FMU does not have capability 'GetDirectionalDerivative'!");
    }

    vector<fmi2ValueReference> vKnownRef = vector<fmi2ValueReference>(request->v_known_ref().begin(),
                                                                      request->v_known_ref().end());
    vector<fmi2ValueReference> vUnknownRef = vector<fmi2ValueReference>(request->v_unknown_ref().begin(),
                                                                        request->v_unknown_ref().end());
    vector<fmi2Real> dvKnownRef = vector<fmi2Real>(request->dv_known_ref().begin(), request->dv_known_ref().end());
    vector<fmi2Real> dvUnknownRef(vUnknownRef.size());
    bool status = slave->getDirectionalDerivative(vKnownRef, vUnknownRef, dvKnownRef, dvUnknownRef);

    for (const auto &ref : dvUnknownRef) {
        response->add_dv_unknown_ref(ref);
    }
    response->set_status(grpcType(slave->getLastStatus()));

    return ::Status::OK;
}
