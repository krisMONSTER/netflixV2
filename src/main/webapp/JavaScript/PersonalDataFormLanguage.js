$(document).ready(function(){
    let language = getCookie("lang");
    if(language == null){
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish"){
        set("first_name_label", "Imię");
        set("last_name_label", "Nazwisko");
        set("country_label", "Kraj");
        set("address_label", "Adres");
        set("submit_text", "Edytuj");
        set("log_out", "Wyloguj się");
        set("language", "Język");
    }
    else if (language === "english"){
        set("first_name_label", "Name");
        set("last_name_label", "Surname");
        set("country_label", "Country");
        set("address_label", "Address");
        set("submit_text", "Edit");
        set("log_out", "Logout");
        set("language", "Language");
    }
    function set(id, content) {
        let element = document.getElementById(id);
        if(element != null){
            element.innerHTML = content;
        }
    }
});