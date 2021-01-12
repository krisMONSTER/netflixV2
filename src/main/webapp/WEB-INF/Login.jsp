<%--
  Created by IntelliJ IDEA.
  User: krizu
  Date: 29.11.2020
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <title>MovOn</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logoV2.png" type="image/icon type">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/GeneralStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/LoginStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/SubmitStyle.css">
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/Cookies.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LoginScript.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LoginLanguage.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/SubmitScript.js"></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script>function recaptchaCallback() {
        $('.submit').removeAttr('style');
    }
    </script>
</head>
<body>
<div id="banner">
    <a href="${pageContext.request.contextPath}/Welcome">
        <img src="${pageContext.request.contextPath}/images/logoBialeV2.png" id="logo_img" style="width: 150px"
             alt="Logo firmy">
    </a>
</div>
<div id="form_div">
    <form id="form" name="form" action="${pageContext.request.contextPath}/LogIn" method="post">
        <a id="login_label"></a><br>
        <label><input type="text" name="login" id="login"></label><br><br>
        <a id="pass_label"></a><br>
        <label><input type="password" name="password" id="password"></label><br><br><br>
        <div class="g-recaptcha" data-callback="recaptchaCallback"
             data-sitekey="6LdtnSkaAAAAAJu4EggVb-Ty_OIJbrcLs-a9EwPH" data-theme="dark"></div>
        <div class="submit" style="pointer-events:none"><p id="submit_text"></p></div>
        <input type="submit" style="visibility: hidden; position: absolute;"/>
    </form>

</div>
</body>
</html>
