for (let demande of $data.demandesConges) {
   if(demande.estApprouvee)  {
       demande.estApprouveeLabel = "Approuvée";
   } else if(demande.estApprouvee === false) {
       demande.estApprouveeLabel = "Rejetée";
   } else {
       demande.estApprouveeLabel = "En cours";
   }
}
