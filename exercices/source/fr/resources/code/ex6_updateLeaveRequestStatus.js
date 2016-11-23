for (let line of $data.leaveRequestStatus) {
    if (line.estApprouvee === null) {
        line.estApprouveeLabel = "En cours";
    } else if (line.estApprouvee) {
        line.estApprouveeLabel = "Approuvee";
    } else {
        line.estApprouveeLabel = "Rejetee";
    }
}
