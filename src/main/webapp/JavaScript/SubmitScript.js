function logInRequest() {
    return $.ajax({
        type: "POST",
        url: "LogIn",
        async: false,
        data: $('form[name="form"]').serialize()
    });
}


function handleData(data) {
    if (!(data === null || data === "")) {
        let snackbar = document.getElementById("snackbar");
        snackbar.innerHTML = data
        snackbar.className = "show";
        setTimeout(function () {
            snackbar.className = snackbar.className.replace("show", "");
        }, 3000);
    } else {
        window.location.href = "Welcome";


    }
}


function logIn() {
    logInRequest().then(handleData)
}


$(document).ready(function () {
    $(".submit").click(function () {
        logIn();
    });

});