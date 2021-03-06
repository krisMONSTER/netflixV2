$(document).ready(function () {
    let language = getCookie("lang");
    if (language == null) {
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish") {
        get("log_out").innerHTML = "Wyloguj się";
        get("language").innerHTML = "Język";
        get("acquired_movies_div").innerHTML = "Moje filmy";
        get("archive_div").innerHTML = "Archiwum";
        get("edit_div").innerHTML = "Dane osobowe";
        get("wallet_div").innerHTML = "Mój potfel";
    } else if (language === "english") {
        get("log_out").innerHTML = "Logout";
        get("language").innerHTML = "Language";
        get("acquired_movies_div").innerHTML = "My movies";
        get("archive_div").innerHTML = "Archive";
        get("edit_div").innerHTML = "Personal data";
        get("wallet_div").innerHTML = "My wallet";
    }
});

function setTableLabels() {
    let language = getCookie("lang");
    if (language == null) {
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish") {
        get("first_name").innerHTML = "Imię";
        get("last_name").innerHTML = "Nazwisko";
        get("country").innerHTML = "Kraj";
        get("address").innerHTML = "Adres";
        get("submit_text").innerHTML = "Edytuj";
    } else if (language === "english") {
        get("first_name").innerHTML = "Name";
        get("last_name").innerHTML = "Surname";
        get("country").innerHTML = "Country";
        get("address").innerHTML = "Address";
        get("submit_text").innerHTML = "Edit";
    }
}

function setChargeAccountLabel() {
    let language = getCookie("lang");
    if (language == null) {
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish") {
        get("charge").innerHTML = "Doładuj";
    } else if (language === "english") {
        get("charge").innerHTML = "Top up";
    }
}


function get(id) {
    return document.getElementById(id);
}