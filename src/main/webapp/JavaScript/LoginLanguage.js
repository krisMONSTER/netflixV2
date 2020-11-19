let language = "polish";
if (language === "polish"){
    document.form.submit.value = "Zaloguj się";
    get("login_label").innerHTML = "Login";
    get("pass_label").innerHTML = "Hasło";
}
else if (language === "english"){
    document.form.submit.value = "Log in";
    get("login_label").innerHTML = "Login";
    get("pass_label").innerHTML = "Password";
}

function get(id){
    return document.getElementById(id);
}