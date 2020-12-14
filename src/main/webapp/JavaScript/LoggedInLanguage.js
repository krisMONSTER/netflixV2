$(document).ready(function(){
    let language = getCookie("lang");
    if(language == null){
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish"){
        get("log_out").innerHTML = "Wyloguj się";
        get("search").innerHTML = "Wyszukaj";
        get("language").innerHTML = "Język";
        get("recommended").innerHTML = "Polecane";
    }
    else if (language === "english"){
        get("log_out").innerHTML = "Logout";
        get("search").innerHTML = "Search";
        get("language").innerHTML = "Language";
        get("recommended").innerHTML = "Recommended";
    }
    function get(id){
        return document.getElementById(id);
    }
});