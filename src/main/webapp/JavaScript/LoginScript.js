function logIn(){
    $(document).ready(function(){
       $.post("LogIn", $('form[name="form"]').serialize(), function(responseText) {
            if(responseText === "succeeded"){
                window.location.href = "./LoggedIn.html";
            }
            else if(responseText === "failed"){
                alert("niepoprawne dane");
            }
            else if(responseText === "SQLfail") {
                alert("kod jest błędny ! ! !");
            }
        });
    });
}