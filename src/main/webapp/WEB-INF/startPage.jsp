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
    <title>Mov On</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/newStyles.css">
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
                <a href="#services" class="navbar__link" id="services-page">Services</a>
            </li>
            <li class="navbar__btn">
                <a href="${pageContext.request.contextPath}/LoginNav" class="button" id="signup">Sign Up</a>
            </li>
            <li class="navbar__item">
                <a href="${pageContext.request.contextPath}/LoginNav" class="navbar__link" id="login">Log In</a>
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
<div class="main" id="id">
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
<script src="${pageContext.request.contextPath}/JavaScript/app.js"></script>
</body>
</html>
