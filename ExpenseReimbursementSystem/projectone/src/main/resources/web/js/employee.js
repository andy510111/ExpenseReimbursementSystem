let apiUrl = "http://localhost:8501/reimbursement";
let loggedUser = "http://localhost:8501/login";
let logginUserNum;
let loggedFirstName;

//  fetch user information
fetch(loggedUser)
  .then((reponse) => reponse.json())
  .then((json) => userData(json))
  .catch((err) => console.log("request failed", err));

  // fetch reimbursements
fetch(apiUrl)
  .then((response) => response.json())
  .then((json) => populateData(json))
  .catch((err) => console.log("Request Failed", err));

  // set loggin user id 
function userData (response) {
  console.log(response); 
  logginUserNum = response.userId;
  loggedFirstName = response.firstName;
  let employeeContainer = document.getElementById("employee-container");
  let nameDisplay = document.createElement("h1");
  nameDisplay.innerHTML = `Welcome ${loggedFirstName}`;
  employeeContainer.prepend(nameDisplay);
};

// populate based on user iddsxc
function populateData(response) {
  let pendingSection = document.getElementById("pending-body");
  let resolvedSection = document.getElementById("resolved-body");
 // console.log(logginUserNum);  3
  response.forEach((row) => {
    const tr = document.createElement("tr");
    console.log(row);
    // append to pending
    if ((row.resolved === false) && (row.authorId === logginUserNum)) {
      for (const cell in row) {
       
        const td = document.createElement("td");
        td.textContent = row[cell];
        tr.appendChild(td);
      }
      pendingSection.appendChild(tr);
    }

    // append to resolved
    if ((row.resolved === true) && (row.authorId === logginUserNum)) {
      for (const cell in row) {
        const td = document.createElement("td");
        td.textContent = row[cell];
        tr.appendChild(td);
      }
      resolvedSection.appendChild(tr);
    }
  }) 

}
