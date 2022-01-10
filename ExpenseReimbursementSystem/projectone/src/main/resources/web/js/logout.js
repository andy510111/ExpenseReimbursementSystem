let logoutButton = document.getElementById("logout-button");
let logoutUrl = "http://localhost:8501/logout";


logoutButton.addEventListener("click", (e) => {
    console.log("works");
    e.preventDefault();
    fetch(logoutUrl, {
        method: "POST",
        body: JSON.stringify({
            logout: "log-out"
        })
    })
        .then((response) => response.text())
        .then((json) => redirect(json))
        .then(result => {
            if (result === "Clearing user session...") {
                alert("logging out....");
            }
        })
        .catch((err) => console.log("Unable to log out", err))
});

function redirect(response) {
    console.log(response);
    if (response === "Clearing user session..") {
        window.location.href = "http://localhost:8501/index.html";

    } else {
        alert("error occured while logging out");
    }
}

let submitButton = document.getElementById("submitBt");

submitButton.addEventListener("click", function() {
    alert("submitting reimbursement...");
})