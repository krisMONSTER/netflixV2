$(document).ready(function(){
    let language = getCookie("lang");
    if(language == null){
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish"){
        get("log_out").innerHTML = "Wyloguj się";
        get("search_div").innerHTML = "Wyszukaj";
        get("language").innerHTML = "Język";
        get("recommended_div").innerHTML = "Polecane";
    }
    else if (language === "english"){
        get("log_out").innerHTML = "Logout";
        get("search_div").innerHTML = "Search";
        get("language").innerHTML = "Language";
        get("recommended_div").innerHTML = "Recommended";
    }
    function get(id){
        return document.getElementById(id);
    }
});