import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import com.company.model.DemandeConges;

// Récupérer l'instance de processus en cours
ProcessAPI processAPI = apiAccessor.getProcessAPI();
ProcessInstance processInstance = processAPI.getProcessInstance(processInstanceId);

// Initialiser nouvelle demande
DemandeConges nouvelleDemande = new DemandeConges();
nouvelleDemande.setIdDemandeur(processInstance.getStartedBy());
nouvelleDemande.setDateDebut(contratDemande.get("dateDebut"));
nouvelleDemande.setNombreJours(contratDemande.get("nombreJours"));
return nouvelleDemande;