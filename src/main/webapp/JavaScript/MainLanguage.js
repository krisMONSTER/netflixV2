let language = "english";
if (language === "polish"){
    get("log_in").innerHTML = "Zaloguj się";
    get("register").innerHTML = "Zarejestruj się";
    get("search").innerHTML = "Wyszukaj";
}
else if (language === "english"){
    get("log_in").innerHTML = "Log in";
    get("register").innerHTML = "Register";
    get("search").innerHTML = "Search";
}

function get(id){
    return document.getElementById(id);
}