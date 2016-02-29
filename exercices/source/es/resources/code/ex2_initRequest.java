def solicitudVacacionesVar = new com.company.model.SolicitudVacaciones()
solicitudVacacionesVar.diaInicio = solicitudInput.diaInicio
solicitudVacacionesVar.numDias = solicitudInput.numDias

// Tomar la instancia actual del proceso
def processInstance = apiAccessor.processAPI.getProcessInstance(processInstanceId);

// Añadir id del solicitante a la nueva peticion
solicitudVacacionesVar.solicitanteId = processInstance.startedBy;

return solicitudVacacionesVar