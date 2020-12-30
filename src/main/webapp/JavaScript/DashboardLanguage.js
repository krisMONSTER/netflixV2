$(document).ready(function(){
    let language = getCookie("lang");
    if(language == null){
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish"){
        get("log_out").innerHTML = "Wyloguj się";
        get("language").innerHTML = "Język";
        get("acquired_movies").innerHTML = "Moje filmy";
        get("archive").innerHTML = "Archiwum";
        get("edit").innerHTML = "Dane osobowe";
        get("wallet").innerHTML = "Mój potfel";
    }
    else if (language === "english"){
        get("log_out").innerHTML = "Logout";
        get("language").innerHTML = "Language";
        get("acquired_movies").innerHTML = "My movies";
        get("archive").innerHTML = "Archive";
        get("edit").innerHTML = "Personal data";
        get("wallet").innerHTML = "My wallet";
    }
});

function setTableLabels(){
    let language = getCookie("lang");
    if(language == null){
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish"){
        get("first_name").innerHTML = "Imię";
        get("last_name").innerHTML = "Nazwisko";
        get("country").innerHTML = "Kraj";
        get("address").innerHTML = "Adres";
    }
    else if (language === "english"){
        get("first_name").innerHTML = "Name";
        get("last_name").innerHTML = "Surname";
        get("country").innerHTML = "Country";
        get("address").innerHTML = "Address";
    }
}

function get(id){
    return document.getElementById(id);
}