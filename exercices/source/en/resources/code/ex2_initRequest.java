import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import com.company.model.LeaveRequest;

// Retrieve current process instance
ProcessAPI processAPI = apiAccessor.getProcessAPI();
ProcessInstance processInstance = processAPI.getProcessInstance(processInstanceId);

// Initiate new leave request
LeaveRequest newRequest = new LeaveRequest();
newRequest.setRequestorId(processInstance.getStartedBy());
newRequest.setLeaveStart(requestInput.get("leaveStart"));
newRequest.setDayCount(requestInput.get("dayCount"));
return newRequest;