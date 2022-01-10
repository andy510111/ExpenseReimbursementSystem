let apiUrl = "http://localhost:8501/users";

fetch(apiUrl)
  .then((response) => response.json())
  .then((json) => populateTable(json))
  .catch((err) => console.log("Request Failed", err));

  // populate reimbursements
function populateTable(response) {
  console.log(response);
  let employeeTable = document.getElementById("employee-table");
  response.forEach((row) => {
    const tr = document.createElement("tr");
    console.log(row);
    for (const cell in row) {
      const td = document.createElement("td")
      td.textContent = row[cell];
      tr.appendChild(td);
    }
    employeeTable.appendChild(tr);
  });
}
