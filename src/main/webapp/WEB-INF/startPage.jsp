<%--
  Created by IntelliJ IDEA.
  User: krizu
  Date: 30.11.2020
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <title>MovOn</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/GeneralStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/SubmitStyle.css">
    <link rel="icon" href="${pageContext.request.contextPath}/images/logoV2.png" type="image/icon type">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/newStyles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/LanguagePanelStyle.css">
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/app.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/StartPageLanguage.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/Cookies.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LanguagePanelScript.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/SubmitScript.js"></script>
    <script>
        function setLanguage(lang){
            setCookie("lang", lang, 1);
            window.location.href = "${pageContext.request.contextPath}/Welcome";
        }
    </script>
</head>
<body>
<!-- Navbar Section -->
<nav class="navbar">
    <div class="navbar__container">
        <a href="#hero"><img id="logo_img" src="${pageContext.request.contextPath}/images/logoBialeV2.png" alt="Logo firmy"></a>
        <!-- <a href="#home" id="navbar__logo">MovOn</a> -->
        <div class="navbar__toggle" id="mobile-menu">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </div>
        <ul class="navbar__menu">
            <li class="navbar__item">
                <a href="#home" class="navbar__link" id="home-page"></a>
            </li>
            <li class="navbar__item">
                <a href="#about" class="navbar__link" id="about-page"></a>
            </li>
            <li class="navbar__item">
                <a href="#services" class="navbar__link" id="services-page"></a>
            </li>
            <li class="navbar__item">
                <a href="#sign-up" class="navbar__link_2" id="signup"></a>
            </li>
            <!-- <li class="navbar__btn">
                <a href="#sign-up" class="button" id="signup">Sign Up</a>
            </li> -->
            <li class="navbar__item">
                <a href="${pageContext.request.contextPath}/navigation.Login" class="navbar__link" id="login"></a>
            </li>
            <li class="navbar__item">
                <a class="navbar__link" id="language"></a>
            </li>
        </ul>
    </div>
</nav>

<!-- Hero Section -->
<div class="hero" id="home">
    <div class="hero__container">
        <p class="hero__heading" id="hero__heading"><p class="hero__heading__continue" id="hero__heading_continue"></p></p>
        <h1 class="hero__description" id="hero__description"></h1>
        <button class="main__btn"><a href="#" id="main__btn"></a></button>
    </div>
</div>

<!-- About Section -->
<div class="main" id="about">
    <div class="main__container">
        <div class="main__img--container">
            <div class="main__img--card"><img id="film_img" src="${pageContext.request.contextPath}/images/iconFilmBlack.png" alt="film_img"></div>
        </div>
        <div class="main__content">
            <h1 id="main__content_h1"></h1>
            <h2 id="main__content_h2"></h2>
            <h3 id="main__content_h3"></h3>
            <h2 id="main__content_h4"></h2>
        </div>
    </div>
</div>

<!-- Services Section -->
<div class="services" id="services">
    <h1 id="top__films"></h1>
    <div class="services__wrapper">
        <!-- <div class="services__card"> -->
        <div class="film__img--card">
            <img id="film_Przelecz_ocalonych" src="${pageContext.request.contextPath}/images/Przelecz ocalonych.jpg" alt = "Przelecz ocalonych">
            <h2 id="hacksaw__ridge"></h2>
            <p id="hacksaw__ridge__year"></p>
        </div>
        <!-- </div> -->
        <!-- <div class="services__card"> -->
        <div class="film__img--card">
            <img id="film_Joker" src="${pageContext.request.contextPath}/images/Joker.jpg" alt = "Joker">
            <h2 id="joker"></h2>
            <p id="joker__year"></p>
        </div>
        <!-- </div> -->
        <!-- <div class="services__card"> -->
        <div class="film__img--card">
            <img id="film_King" src="${pageContext.request.contextPath}/images/King.jpg" alt = "King">
            <h2 id="king"></h2>
            <p id="king__year"></p>
        </div>
        <!-- </div> -->
        <!-- <div class="services__card"> -->
        <div class="film__img--card">
            <img id="film_Tenet" src="${pageContext.request.contextPath}/images/Tenet.jpg" alt = "Tenet">
            <h2 id="tenet"></h2>
            <p id="tenet__year"></p>
        </div>
        <!-- </div> -->
    </div>
</div>

<!-- Features Section -->
<div class="main_sign_up" id="sign-up">
    <div class="main__container_sign_up">
        <div class="main__content_sign_up">
            <h1 id="join__us"></h1>
            <h2 id="join__us__more"></h2>
            <a id="login_label"></a><br>
            <form id="form" name="form" action="${pageContext.request.contextPath}/Register" method="post">
                <label><input type="text" name="login" id="login_text"></label><br><br><br>
                <a id="pass_label"></a><br>
                <label><input type="password" name="password" id="password"></label><br><br><br>
                <a id="email_label"></a><br>
                <label><input type="email" name="email" id="email"></label><br><br><br>
                <div class="submit"><p id="submit"></p></div>
                <input type="submit" style="visibility: hidden; position: absolute;" />
                <!-- <button class="main__btn"><a href="#home" id="submit"></a></button> -->
    <%--            <div id="submit"><p id="submit_text"></p></div>--%>
            </form>
        </div>
    </div>
</div>


<!-- Footer Section -->
<div class="footer__container">
    <div class="footer__links">
        <div class="footer__link--wrapper">
            <div class="footer__link--items">
                <h2 id="about__us"></h2>
                <a id="about__us_1" href="/sign-up"></a>
                <a id="about__us_2" href="/"></a>
                <a id="about__us_3" href="/"></a>
                <a id="about__us_4" href="/"></a>
            </div>
            <div class="footer__link--items">
                <h2 id="contact__us"></h2>
                <a id="contact__us_1" href="/"></a>
                <a id="contact__us_2" href="/"></a>
                <a id="contact__us_3" href="/"></a>
            </div>
        </div>
        <div class="footer__link--wrapper">
            <div class="footer__link--items">
                <h2 id="videos"></h2>
                <a id="videos_1" href="/"></a>
                <a id="videos_2" href="/"></a>
            </div>
            <div class="footer__link--items">
                <h2 id="social__media"></h2>
                <a href="/">Instagram</a>
                <a href="/">Facebook</a>
                <a href="/">YouTube</a>
                <a href="/">Twitter</a>
            </div>
        </div>
    </div>
    <section class="social__media">
        <div class="social__media--wrap">
            <div class="footer__logo">
                <a href="/" id="footer__logo">MOVE ON</a>
            </div>
            <p id="rights" class="website__rights"></p>
            <div class="social__icons">
                <a href="/" class="social__icon--link" target="_blank"
                ><i class = "fab fa-instagram"></i
                ></a>
                <a href="/" class="social__icon--link"
                ><i class = "fab fa-facebook-f"></i
                ></a>
                <a href="/" class="social__icon--link"
                ><i class = "fab fa-youtube"></i
                ></a>
                <a href="/" class="social__icon--link"
                ><i class = "fab fa-linkedin"></i
                ></a>
                <a href="/" class="social__icon--link"
                ><i class = "fab fa-twitter"></i
                ></a>
            </div>
        </div>
    </section>
</div>
<div id="language_div">
    <p onclick="setLanguage('english')" class="language_element">English</p>
    <hr class="language_element" id="language_hr">
    <p onclick="setLanguage('polish')" class="language_element">Polski</p>
</div>
</body>
</html>
