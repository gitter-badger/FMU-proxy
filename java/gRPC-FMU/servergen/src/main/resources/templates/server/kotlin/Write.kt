
    /**
     * Autogenerated method
     */
    override fun write{{varName}} (req: {{protoFile}}.{{dataType}}Write, responseObserver: StreamObserver<FmiDefinitions.Status> ) {

        val fmuId = req.fmuId
        val fmu = fmus[fmuId]
        if (fmu != null) {
            fmu.variableAccessor.set{{typeName}}({{valueReference}}, req.value);
            statusReply(fmu.lastStatus, responseObserver);
        } else {
            LOG.warn("No FMU with id: {}", fmuId);
            statusReply(Fmi2Status.Error, responseObserver);
        }

    }