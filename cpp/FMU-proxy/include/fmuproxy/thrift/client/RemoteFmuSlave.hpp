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

#ifndef FMU_PROXY_REMOTEFMUINSTANCE_HPP
#define FMU_PROXY_REMOTEFMUINSTANCE_HPP

#include <fmi4cpp/fmi2/fmi4cpp.hpp>

#include "../common/FmuService.h"

namespace fmuproxy::thrift::client {

    class RemoteFmuSlave : public fmi4cpp::fmi2::FmuSlave {

    private:

        const InstanceId instanceId_;
        FmuServiceClient &client_;
        std::shared_ptr<fmi4cpp::fmi2::CoSimulationModelDescription> csModelDescription;

        Status::type lastStatus_;

        bool updateStatusAndReturnTrueOnOK(Status::type status);

    public:
        RemoteFmuSlave(const InstanceId &instanceId, FmuServiceClient &client,
                       const fmi4cpp::fmi2::ModelDescriptionBase &modelDescription);

        fmi4cpp::Status getLastStatus() const override;

        std::shared_ptr<fmi4cpp::fmi2::CoSimulationModelDescription> getModelDescription() const override;

        bool setupExperiment(double startTime = 0, double stopTime = 0, double tolerance = 0) override;

        bool enterInitializationMode() override;

        bool exitInitializationMode() override;

        bool reset() override;

        bool terminate() override;

        bool getFMUstate(fmi2FMUstate &state) override;

        bool setFMUstate(const fmi2FMUstate state) override;

        bool freeFMUstate(fmi2FMUstate &state) override;

        bool serializeFMUstate(const fmi2FMUstate &state, std::vector<fmi2Byte> &serializedState) override;

        bool deSerializeFMUstate(fmi2FMUstate &state, const std::vector<fmi2Byte> &serializedState) override;

        bool getDirectionalDerivative(const std::vector<fmi2ValueReference> &vUnkownRef,
                                            const std::vector<fmi2ValueReference> &vKnownRef,
                                            const std::vector<fmi2Real> &dvKnownRef,
                                            std::vector<fmi2Real> &dvUnknownRef) override;

        bool doStep(const double stepSize) override;

        bool cancelStep() override;

        bool readInteger(const fmi2ValueReference vr, fmi2Integer &ref) override;

        bool readInteger(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Integer> &ref) override;

        bool readReal(const fmi2ValueReference vr, fmi2Real &ref) override;

        bool readReal(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Real> &ref) override;

        bool readString(const fmi2ValueReference vr, fmi2String &ref) override;

        bool readString(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2String> &ref) override;

        bool readBoolean(const fmi2ValueReference vr, fmi2Boolean &ref) override;

        bool readBoolean(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Boolean> &ref) override;

        bool writeInteger(const fmi2ValueReference vr, fmi2Integer value) override;

        bool writeInteger(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Integer> &values) override;

        bool writeReal(const fmi2ValueReference vr, fmi2Real value) override;

        bool writeReal(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Real> &values) override;

        bool writeString(const fmi2ValueReference vr, fmi2String value) override;

        bool writeString(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2String> &values) override;

        bool writeBoolean(const fmi2ValueReference vr, fmi2Boolean value) override;

        bool writeBoolean(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Boolean> &values) override;

    };

}

#endif //FMU_PROXY_REMOTEFMUINSTANCE_HPP
