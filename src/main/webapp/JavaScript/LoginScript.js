
function logIn() {
    test().then(handleData);
}

function handleData(data) {
    if(data === "succeeded"){
        window.location.href = "./LoggedIn.html";
        //alert(window.location.href);

    }
    else if(data === "failed"){
        alert("niepoprawne dane");
    }
    else if(data === "SQLfail") {
        alert("kod jest błędny ! ! !");
    }
}

function test() {
    return $.ajax({
        type: "POST",
        url: "LogIn",
        async: false,
        data: $('form[name="form"]').serialize(),
    });
}