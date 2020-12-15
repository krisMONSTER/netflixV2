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
    <link rel="icon" href="${pageContext.request.contextPath}/images/logoV2.png" type="image/icon type">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/newStyles.css">
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/app.js"></script>
</head>
<body>
<!-- Navbar Section -->
<nav class="navbar">
    <div class="navbar__container">
        <a href="#home"><img id="logo_img" src="${pageContext.request.contextPath}/images/logoBialeV2.png" alt="Logo firmy"></a>
        <!-- <a href="#home" id="navbar__logo">MovOn</a> -->
        <div class="navbar__toggle" id="mobile-menu">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </div>
        <ul class="navbar__menu">
            <li class="navbar__item">
                <a href="#home" class="navbar__link" id="home-page">Home</a>
            </li>
            <li class="navbar__item">
                <a href="#about" class="navbar__link" id="about-page">About</a>
            </li>
            <li class="navbar__item">
                <a href="#services" class="navbar__link" id="services-page">Top Films</a>
            </li>
            <li class="navbar__item">
                <a href="#sign-up" class="navbar__link_2" id="signup">Sign Up</a>
            </li>
            <!-- <li class="navbar__btn">
                <a href="#sign-up" class="button" id="signup">Sign Up</a>
            </li> -->
            <li class="navbar__item">
                <a href="${pageContext.request.contextPath}/navigation.Login" class="navbar__link" id="login">Log In</a>
            </li>
            <li class="navbar__item">
                <a href="#home" class="navbar__link" id="language">Language</a>
            </li>
        </ul>
    </div>
</nav>

<!-- Hero Section -->
<div class="hero" id="home">
    <div class="hero__container">
        <p class="hero__heading">Hold on.. <span>You're Breathtaking</span></p>
        <h1 class="hero__description">Move On </h1>
        <button class="main__btn"><a href="#">Explore</a></button>
    </div>
</div>

<!-- About Section -->
<div class="main" id="about">
    <div class="main__container">
        <div class="main__img--container">
            <div class="main__img--card"><img id="film_img" src="${pageContext.request.contextPath}/images/iconFilmBlack.png" alt="film_img"></div>
        </div>
        <div class="main__content">
            <h1>What do we do?</h1>
            <h2>We provide you with</h2>
            <h3> BREATHTAKING </h3>
            <h2>(as you) films!</h2>
        </div>
    </div>
</div>

<!-- Services Section -->
<div class="services" id="services">
    <h1>TOP FILMS</h1>
    <div class="services__wrapper">
        <!-- <div class="services__card"> -->
        <div class="film__img--card">
            <img id="film_Przelecz_ocalonych" src="${pageContext.request.contextPath}/images/Przelecz ocalonych.jpg" alt = "Przelecz ocalonych">
            <h2>Hacksaw Ridge</h2>
            <p>2016</p>
        </div>
        <!-- </div> -->
        <!-- <div class="services__card"> -->
        <div class="film__img--card">
            <img id="film_Joker" src="${pageContext.request.contextPath}/images/Joker.jpg" alt = "Joker">
            <h2>Joker</h2>
            <p>2019</p>
        </div>
        <!-- </div> -->
        <!-- <div class="services__card"> -->
        <div class="film__img--card">
            <img id="film_King" src="${pageContext.request.contextPath}/images/King.jpg" alt = "King">
            <h2>King</h2>
            <p>2019</p>
        </div>
        <!-- </div> -->
        <!-- <div class="services__card"> -->
        <div class="film__img--card">
            <img id="film_Tenet" src="${pageContext.request.contextPath}/images/Tenet.jpg" alt = "Tenet">
            <h2>Tenet</h2>
            <p>2020</p>
        </div>
        <!-- </div> -->
    </div>
</div>

<!-- Features Section -->
<div class="main_sign_up" id="sign-up">
    <div class="main__container_sign_up">
        <div class="main__content_sign_up">
            <h1>Join us now!</h1>
            <h2>You won't regret it.</h2>
            <a id="login_label">Login:</a><br>
            <label><input type="text" name="login" id="login_text"></label><br><br><br>
            <a id="pass_label">Password:</a><br>
            <label><input type="password" name="password" id="password"></label><br><br><br>
            <a id="email_label">E-mail:</a><br>
            <label><input type="email" name="email" id="email"></label><br><br><br>
            <div id="submit"><p id="submit_text"></p>Register</div>
        </div>
    </div>
</div>

<!-- Footer Section -->
<div class="footer__container">
    <div class="footer__links">
        <div class="footer__link--wrapper">
            <div class="footer__link--items">
                <h2>About Us</h2>
                <a href="/sign-up">How it works</a>
                <a href="/">Testimonials</a>
                <a href="/">Careers</a>
                <a href="/">Terms of Service</a>
            </div>
            <div class="footer__link--items">
                <h2>Contact Us</h2>
                <a href="/">Contact</a>
                <a href="/">Support</a>
                <a href="/">Destinations</a>
            </div>
        </div>
        <div class="footer__link--wrapper">
            <div class="footer__link--items">
                <h2>Videos</h2>
                <a href="/">Submit Video</a>
                <a href="/">Ambassadors</a>
                <a href="/">Agency</a>
            </div>
            <div class="footer__link--items">
                <h2>Social Media</h2>
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
            <p class="website__rights">© MOVE ON 2020. All rights reserved</p>
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
</body>
</html>
