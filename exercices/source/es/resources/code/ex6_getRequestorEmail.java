import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.identity.ContactData;

// Get APIs
ProcessAPI processAPI = apiAccessor.getProcessAPI();
IdentityAPI identityAPI = apiAccessor.getIdentityAPI();
// Get process initiator
ProcessInstance processInstance = processAPI.getProcessInstance(processInstanceId);
long initiatorUserId = processInstance.getStartedBy();
// Get email from process initiator
ContactData contactData = identityAPI.getUserContactData(initiatorUserId, false);
return contactData.getEmail();