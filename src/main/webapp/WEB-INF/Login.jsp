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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/ImagesStyle.css">
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LoginScript.js"></script>
</head>
<body>
<div id="banner">
    <a href="${pageContext.request.contextPath}/Welcome">
        <img src="${pageContext.request.contextPath}/images/logoV2.png" id="logo_img" style="width: 150px" alt="Logo firmy">
    </a>
    <p id="test"></p>
</div>
<div id="form">
    <form name="form" onsubmit="logIn()" method="post">
        <br>
        <a id="login_label">Login</a><br>
        <label><input type="text" name="login" id="login"></label><br>
        <a id="pass_label">Haslo</a><br>
        <label><input type="password" name="password" id="password"></label><br><br>
        <input type="submit" name="submit"><br>
        <br>
    </form>
</div>
</body>
<script src="${pageContext.request.contextPath}/JavaScript/LoginLanguage.js"></script>
</html>
