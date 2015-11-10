import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.process.ProcessInstance;

import com.company.model.SolicitudVacaciones;

// Obten la instancia del proceso actual
ProcessAPI processAPI = apiAccessor.getProcessAPI();
ProcessInstance processInstance = processAPI.getProcessInstance(processInstanceId);

// Inicializa nueva solicitud de vacaciones
SolicitudVacaciones nuevaSol = new SolicitudVacaciones();
nuevaSol.setSolicitanteId(processInstance.getStartedBy());
nuevaSol.setNumDias(solicitudInput.get("numDias"));
nuevaSol.setDiaInicio(solicitudInput.get("diaInicio"));
	
return nuevaSol;