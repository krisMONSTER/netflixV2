function logIn() {
    test().then(handleData);
}

function handleData(data) {
    if(data === "succeeded"){
        //window.location.href = "${pageContext.request.contextPath}/WEB-INF/LoggedIn.html";
        alert("yaaaay");
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

$(document).ready(function() {
    $('#login, #password').click(function() {
        $("#errMsg").hide();
    });
});