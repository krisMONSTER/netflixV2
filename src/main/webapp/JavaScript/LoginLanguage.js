let language = "english";
if (language === "polish"){
    document.form.submit.value = "Zaloguj się";
    get("login_label").innerHTML = "Login";
    get("pass_label").innerHTML = "Hasło";
    get("submit_text").innerHTML = "Zaloguj się";
}
else if (language === "english"){
    document.form.submit.value = "Log in";
    get("login_label").innerHTML = "Login";
    get("pass_label").innerHTML = "Password";
    get("submit_text").innerHTML = "Log In";
}

function get(id){
    return document.getElementById(id);
}