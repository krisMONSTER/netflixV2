$(document).ready(function(){
    let language = getCookie("lang");
    if(language == null){
        setCookie("lang", "english", 1);
        language = "english";
    }
    if (language === "polish"){
        // Navbar Section
        set("home-page", "Strona Główna");
        set("about-page", "O nas");
        set("services-page", "Top Filmy");
        set("signup", "Zapisz się");
        set("login", "Zaloguj się");
        set("language", "Język");

        //Hero Section
        set("hero__heading", "Stój..");
        set("hero__heading_continue", "Zaparłeś nam dech w piersiach!");
        set("hero__description", "Scrolluj dalej");
        set("main__btn", "Eksploruj");

        // About Section
        set("main__content_h1", "Co robimy?");
        set("main__content_h2", "Wypożyczamy Tobie filmy");
        set("main__content_h3", "Które poruszą Cię");
        set("main__content_h4", "Tak jak Ty nas :D");

        // Services Section
        set("top__films", "TOP FILMY");
        //Hacksaw Ridge
        set("hacksaw__ridge", "Hacksaw Ridge");
        set("hacksaw__ridge__year", "2016");
        //Hacksaw Ridge
        set("joker", "Joker");
        set("joker__year", "2019");
        //Hacksaw Ridge
        set("king", "King");
        set("king__year", "2019");
        //Hacksaw Ridge
        set("tenet", "Tenet");
        set("tenet__year", "2020");

        //Features Section
        set("join__us", "Dołącz do nas!");
        set("join__us__more", "Nie pożałujesz tego.");
        set("login_label", "Login:");
        set("pass_label", "Hasło:");
        set("email_label", "E-mail:");
        set("submit", "Zarejestruj");

        //Footer Section
        set("about__us", "O nas");
        set("about__us_1", "Jak to działa");
        set("about__us_2", "Referencje");
        set("about__us_3", "Kariera");
        set("about__us_4", "Warunki świadczenia usług");

        set("contact__us", "Skontaktuj się z nami");
        set("contact__us_1", "Kontakt");
        set("contact__us_2", "Pomoc");
        set("contact__us_3", "Lokalizacja");

        set("videos", "Filmy");
        set("videos_1", "Ambasadorzy");
        set("videos_2", "Agencja");

        set("social__media", "Media Społecznościowe");

        set("rights", "© MOVE ON 2020. Wszystkie prawa zarezerwowane");



    }
    else if (language === "english"){
        //Navbar Section
        set("home-page", "Home");
        set("about-page", "About");
        set("services-page", "Top Films");
        set("signup", "Sign Up");
        set("login", "Log in");
        set("language", "Language");

        //Hero Section
        set("hero__heading", "Hold on.. ");
        set("hero__heading_continue", "You're Breathtaking");
        set("hero__description", "Move On");
        set("main__btn", "Explore");

        // About Section
        set("main__content_h1", "What do we do?");
        set("main__content_h2", "We provide you with");
        set("main__content_h3", " BREATHTAKING ");
        set("main__content_h4", "(as you) films!");

        // Services Section
        set("top__films", "TOP FILMS");
        //Hacksaw Ridge
        set("hacksaw__ridge", "Hacksaw Ridge");
        set("hacksaw__ridge__year", "2016");
        //Hacksaw Ridge
        set("joker", "Joker");
        set("joker__year", "2019");
        //Hacksaw Ridge
        set("king", "King");
        set("king__year", "2019");
        //Hacksaw Ridge
        set("tenet", "Tenet");
        set("tenet__year", "2020");

        //Features Section
        set("join__us", "Join us now!");
        set("join__us__more", "You won't regret it.");
        set("login_label", "Login:");
        set("pass_label", "Password:");
        set("email_label", "E-mail:");
        set("submit", "Register");

        //Footer Section
        set("about__us", "About Us");
        set("about__us_1", "How it works");
        set("about__us_2", "Testimonials");
        set("about__us_3", "Careers");
        set("about__us_4", "Terms of Service");

        set("contact__us", "Contact Us");
        set("contact__us_1", "Contact");
        set("contact__us_2", "Support");
        set("contact__us_3", "Destinations");

        set("videos", "Videos");
        set("videos_1", "Ambassadors");
        set("videos_2", "Agency");

        set("social__media", "Social Media");

        set("rights", "© MOVE ON 2020. All rights reserved");



    }
    function set(id, content) {
        let element = document.getElementById(id);
        if(element != null){
            element.innerHTML = content;
        }
    }
});