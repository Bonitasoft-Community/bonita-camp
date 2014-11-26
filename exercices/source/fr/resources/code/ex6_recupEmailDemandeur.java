import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.identity.ContactData;

// Récupération APIs
ProcessAPI processAPI = apiAccessor.getProcessAPI();
IdentityAPI identityAPI = apiAccessor.getIdentityAPI();
// Récupération initiateur du processus
ProcessInstance processInstance = processAPI.getProcessInstance(processInstanceId);
long initiatorUserId = processInstance.getStartedBy();
// Récupération email de l'initiateur
ContactData contactData = identityAPI.getUserContactData(initiatorUserId, false);
return contactData.getEmail();