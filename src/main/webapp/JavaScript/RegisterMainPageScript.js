function registerRequest() {
    return $.ajax({
        type: "POST",
        url: "IsRegisterAvailable",
        async: false,
        data: $('form[name="register_form"]').serialize()
    });

}

function handleData(data) {
    if (data !== "yes") {
        let snackbar = document.getElementById("snackbar");
        snackbar.innerHTML = data
        snackbar.className = "show";
        setTimeout(function () {
            snackbar.className = snackbar.className.replace("show", "");
        }, 3000);
    } else {

        document.getElementById("register_form").submit();

    }


}

function checkIfAvailable() {
    registerRequest().then(handleData);
}


$(document).ready(function () {

    $("#submit_div").click(function () {
        checkIfAvailable();
    });

});