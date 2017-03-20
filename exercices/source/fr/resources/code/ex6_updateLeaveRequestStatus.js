for (let line of $data.demandeConges) {
    if (line.estApprouvee === null) {
        line.estApprouveeLabel = "En cours";
    } else if (line.estApprouvee) {
        line.estApprouveeLabel = "Approuvee";
    } else {
        line.estApprouveeLabel = "Rejetee";
    }
}
