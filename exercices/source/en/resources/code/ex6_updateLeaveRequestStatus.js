for (let line of $data.leaveRequestStatus) {
    if (line.isApproved === null) {
        line.isApprovedLabel = "In progress";
    } else if (line.isApproved) {
        line.isApprovedLabel = "Approved";
    } else {
        line.isApprovedLabel = "Rejected";
    }
}
