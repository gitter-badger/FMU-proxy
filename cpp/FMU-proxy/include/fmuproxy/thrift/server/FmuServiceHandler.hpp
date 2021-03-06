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

#ifndef FMU_PROXY_FMUSERVICEHANDLER_H
#define FMU_PROXY_FMUSERVICEHANDLER_H

#include <vector>
#include <unordered_map>

#include <fmi4cpp/fmi2/fmi4cpp.hpp>

#include "../common/FmuService.h"

namespace fmuproxy::thrift::server {

    class FmuServiceHandler : virtual public FmuServiceIf {

    private:
        std::unordered_map<FmuId, std::shared_ptr<fmi4cpp::fmi2::Fmu>> &fmus_;
        std::unordered_map<InstanceId, std::unique_ptr<fmi4cpp::fmi2::FmuSlave>> slaves_;

    public:
        explicit FmuServiceHandler(std::unordered_map<FmuId, std::shared_ptr<fmi4cpp::fmi2::Fmu>> &fmus);


        void getModelDescription(ModelDescription &_return, const FmuId &fmu_id) override;

        void createInstanceFromCS(InstanceId &_return, const FmuId &fmu_id) override;


        void createInstanceFromME(InstanceId &_return, const FmuId &fmu_id,
                                  const ::fmuproxy::thrift::Solver &solver) override;

        Status::type setupExperiment(const InstanceId &instanceId, double start, double stop,
                                     double tolerance) override;

        Status::type enterInitializationMode(const InstanceId &instanceId) override;

        Status::type exitInitializationMode(const InstanceId &instanceId) override;

        void step(::fmuproxy::thrift::StepResult &_return, const InstanceId &instance_id,
                  double step_size) override;

        Status::type reset(const InstanceId &instance_id) override;

        Status::type terminate(const InstanceId &instance_id) override;

        void readInteger(::fmuproxy::thrift::IntegerRead &_return, const InstanceId &instance_id,
                         const ValueReferences &vr) override;

        void readReal(::fmuproxy::thrift::RealRead &_return, const InstanceId &instance_id,
                      const ValueReferences &vr) override;

        void readString(::fmuproxy::thrift::StringRead &_return, const InstanceId &instance_id,
                        const ValueReferences &vr) override;

        void readBoolean(::fmuproxy::thrift::BooleanRead &_return, const InstanceId &instance_id,
                         const ValueReferences &vr) override;

        Status::type writeInteger(const InstanceId &instance_id, const ValueReferences &vr,
                                  const IntArray &value) override;

        Status::type writeReal(const InstanceId &instance_id, const ValueReferences &vr,
                               const RealArray &value) override;

        Status::type writeString(const InstanceId &instance_id, const ValueReferences &vr,
                                 const StringArray &values) override;

        Status::type writeBoolean(const InstanceId &instance_id, const ValueReferences &vr,
                                  const BooleanArray &value) override;

        void getFMUstate(GetFmuStateResult &_return, const InstanceId &instance_id) override;

        Status::type setFMUstate(const InstanceId &instance_id, FmuState state) override;

        Status::type freeFMUstate(const InstanceId &instance_id, FmuState state) override;

        void serializeFMUstate(SerializeFmuStateResult &_return, const InstanceId &instance_id,
                               FmuState state) override;

        void deSerializeFMUstate(DeSerializeFmuStateResult &_return, const InstanceId &instance_id,
                                 const std::string &state) override;

        void getCoSimulationAttributes(::fmuproxy::thrift::CoSimulationAttributes &_return,
                                       const InstanceId &instanceId) override;

        bool canCreateInstanceFromCS(const FmuId &fmuId) override;

        bool canCreateInstanceFromME(const FmuId &fmuId) override;

        void getDirectionalDerivative(DirectionalDerivativeResult &_return, const InstanceId &slave_id,
                                      const ValueReferences &vUnknownRef, const ValueReferences &vKnownRef,
                                      const std::vector<double> &dvKnownRef) override;

    };

}

#endif //FMU_PROXY_FMUSERVICEHANDLER_H
