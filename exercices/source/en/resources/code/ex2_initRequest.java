def leaveRequestVar = new com.company.model.LeaveRequest()
leaveRequestVar.leaveStart = requestInput.leaveStart
leaveRequestVar.dayCount = requestInput.dayCount

// Retrieve current process instance
def processInstance = apiAccessor.processAPI.getProcessInstance(processInstanceId)
// Add requestor id to the new request
leaveRequestVar.requestorId = processInstance.startedBy

return leaveRequestVar
