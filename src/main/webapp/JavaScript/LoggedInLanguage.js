let language = "polish";
if (language === "polish"){
    get("log_out").innerHTML = "Wyloguj się";
    get("search").innerHTML = "Wyszukaj";
}
else if (language === "english"){
    get("log_out").innerHTML = "Log out";
    get("search").innerHTML = "Search";
}

function get(id){
    return document.getElementById(id);
}