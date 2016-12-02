def demandeCongesVar = new com.company.model.DemandeConges()
demandeCongesVar.dateDebut = demandeInput.dateDebut
demandeCongesVar.nombreJours = demandeInput.nombreJours

// Récupérer l'instance de processus en cours
def processInstance = apiAccessor.processAPI.getProcessInstance(processInstanceId)
// Ajouter l'identifiant du demandeur à la nouvelle demande
demandeCongesVar.idDemandeur = processInstance.startedBy

return demandeCongesVar
