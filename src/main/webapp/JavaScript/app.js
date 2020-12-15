$(document).ready(function () {
    const menu = document.querySelector('#mobile-menu');
    const menuLinks = document.querySelector('.navbar__menu');
    const navLogo = document.querySelector('#logo_img');


//Display Mobile Menu
    const mobileMenu = () => {
        menu.classList.toggle('is-active');
        menuLinks.classList.toggle('active');
    };

    menu.addEventListener('click', mobileMenu);



// // Show active menu when scrolling
    const highlightMenu = () => {
        const elem = document.querySelector('.highlight');
        const homeMenu = document.querySelector('#home-page');
        const aboutMenu = document.querySelector('#about-page');
        const servicesMenu = document.querySelector('#services-page');
        const signUpMenu = document.querySelector('#signup');
        let scrollPos = window.scrollY;

        //adds 'highlight' class to my menu items
        if(scrollPos < 600){
            homeMenu.classList.add('highlight');
            aboutMenu.classList.remove('highlight');
            return;
        } else if (scrollPos < 1400){
            aboutMenu.classList.add('highlight');
            homeMenu.classList.remove('highlight');
            servicesMenu.classList.remove('highlight');
            return;
        } else if (scrollPos < 2345){
            servicesMenu.classList.add('highlight');
            aboutMenu.classList.remove('highlight');
            signUpMenu.classList.remove('highlight');
            return;
        }
        else if (scrollPos < 3200){
            servicesMenu.classList.remove('highlight');
            signUpMenu.classList.add('highlight');
            return;
        }

        if((elem && scrollPos < 600) || elem){
            elem.classList.remove('highlight');
        }
    };

    window.addEventListener('scroll', highlightMenu);
    window.addEventListener('click', highlightMenu);

// Close mobile Menu when clicking on a menu item

    const hideMobileMenu = () => {
        const menuBars = document.querySelector('.is-active');

        if(menuBars){
            menu.classList.toggle('is-active');
            menuLinks.classList.remove('active');
        }
    };

    menuLinks.addEventListener('click', hideMobileMenu);
    navLogo.addEventListener('click', hideMobileMenu);

});

