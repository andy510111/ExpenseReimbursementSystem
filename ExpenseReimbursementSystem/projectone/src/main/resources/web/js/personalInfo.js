let loggedUser = "http://localhost:8501/login";

fetch(loggedUser)
  .then((reponse) => reponse.json())
  .then((json) => personalData(json))
  .catch((err) => console.log("request failed", err));


  function personalData(response) {
      let emailForm = document.getElementById("emailInput");
      let firstName = document.getElementById("firstName");
      let lastName = document.getElementById("lastName");
      let password = document.getElementById("password");

      let username = document.getElementById("username");
      emailForm.setAttribute("value", response.email);
      firstName.setAttribute("value", response.firstName);
      lastName.setAttribute("value", response.lastName);
      password.setAttribute("value", response.password);
      username.setAttribute("value", response.username);
    
  }

let infoSubmit = document.getElementById("info-submit");

infoSubmit.addEventListener("click", function() {
  
  alert("Information updating...");
});

let cancelButton = document.getElementById("cancel-infoButton");

cancelButton.addEventListener("click", function() {
  window.location.replace("./employeepage.html");
});
  