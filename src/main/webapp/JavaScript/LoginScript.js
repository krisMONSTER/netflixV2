function logIn(){
    $(document).ready(function(){
        $.ajax({
            type: "POST",
            url: "LogIn",
            data: $('form[name="form"]').serialize(),
            async: false,
            success: function(response){
                if(response === "succeeded"){
                    window.location.href = "./LoggedIn.html";
                }
                else if(response === "failed"){
                    alert("niepoprawne dane");
                }
                else if(response === "SQLfail") {
                    alert("kod jest błędny ! ! !");
                }
            }
        });
    });
}