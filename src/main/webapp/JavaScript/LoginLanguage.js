$(document).ready(function(){
    let language = getCookie("lang");
    if(language == null){
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish"){
        get("login_label").innerHTML = "Login";
        get("pass_label").innerHTML = "Hasło";
        get("submit_text").innerHTML = "Zaloguj się";
    }
    else if (language === "english"){
        get("login_label").innerHTML = "Login";
        get("pass_label").innerHTML = "Password";
        get("submit_text").innerHTML = "Log in";
    }
    function get(id){
        return document.getElementById(id);
    }
});