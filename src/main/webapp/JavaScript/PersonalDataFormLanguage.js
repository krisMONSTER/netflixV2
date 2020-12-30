$(document).ready(function(){
    let language = getCookie("lang");
    if(language == null){
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish"){
        get("first_name_label").innerHTML = "Imię";
        get("last_name_label").innerHTML = "Nazwisko";
        get("country_label").innerHTML = "Kraj";
        get("address_label").innerHTML = "Adres";
        get("submit_text").innerHTML = "Edytuj";
        get("log_out").innerHTML = "Wyloguj się";
        get("language").innerHTML = "Język";
    }
    else if (language === "english"){
        get("first_name_label").innerHTML = "Name";
        get("last_name_label").innerHTML = "Surname";
        get("country_label").innerHTML = "Country";
        get("address_label").innerHTML = "Address";
        get("submit_text").innerHTML = "Edit";
        get("log_out").innerHTML = "Logout";
        get("language").innerHTML = "Language";
    }
    function get(id){
        return document.getElementById(id);
    }
});