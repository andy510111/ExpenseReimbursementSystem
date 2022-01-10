let reimbursementUrl = ("http://localhost:8501/reimbursement");
let reimButton = document.getElementById("reim-button");

// add to reimbursement db
fetch(reimbursementUrl)
    .then((response) => response.json())
    .then((json) => getAllReimbursements(json))
    .catch((err) => console.log("Request failed", err));



function getAllReimbursements(response) {
    let pendingBody = document.getElementById("pending-body");
    let resolvedBody = document.getElementById("resolved-body");
    let form = document.getElementById("updating-pendingForms");
    let selectList = document.getElementById("reimbursement-id");
    response.forEach((row) => {
        let option = document.createElement("option");
        if (row.resolved === false) {
        option.value = row.reimbursementId;
        option.text = row.reimbursementId;
        selectList.appendChild(option);
        }
        console.log(row);
        const tr = document.createElement("tr");
        if (row.resolved === false) {
            for (const cell in row) {
                const td = document.createElement("td");
                td.textContent = row[cell];
                tr.appendChild(td);
            } 
            pendingBody.appendChild(tr);
        }

        if (row.resolved === true) {
            for (const cell in row) {
                const td = document.createElement("td");
                td.textContent = row[cell];
                tr.appendChild(td);
            } 
            resolvedBody.appendChild(tr);
        }
    })
}

reimButton.addEventListener("click", function(e) {
    window.location.replace("./managerpage.html");
})