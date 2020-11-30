<%--
  Created by IntelliJ IDEA.
  User: krizu
  Date: 29.11.2020
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <title>MovOn</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logoV2.png" type="image/icon type">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/GeneralStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/WelcomePageStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/ImagesStyle.css">
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/MenuTrigger.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LoggedOutScript.js"></script>

</head>
<body style="background-color: steelblue">
<div id="banner_div">
    <div id="logo_div"><a href="${pageContext.request.contextPath}/Welcome"><img id="logo_img"
                                                                                 src="${pageContext.request.contextPath}/images/logoV2.png"
                                                                                 alt="Logo firmy"></a></div>
    <div id="user_div"><img id="account_img" src="${pageContext.request.contextPath}/images/user_szary.png" alt="Konto">
    </div>
</div>
<div id="panel">
    <div class="wrap">
        <div class="panel_element" onmouseover="mouseOverPanelElement(this)" onmouseout="mouseOutPanelElement(this)"
             id="search_div">
            <span id="search"></span>
        </div>
        <div class="panel_element" onmouseover="mouseOverPanelElement(this)" onmouseout="mouseOutPanelElement(this)"
             id="test_div">
            <span>Testowy formularz</span>
        </div>
    </div>
</div>
<div id="content_options_div"></div>
<div id="content_div">

</div>
<div id="menu_div">
    <p onclick="window.location.href = '${pageContext.request.contextPath}/LoginNav'" class="menu_element"
       id="log_in"></p>
    <hr class="menu_element">
    <p class="menu_element" id="register"></p>
</div>
</body>
<script src="${pageContext.request.contextPath}/JavaScript/LoggedOutLanguage.js"></script>
</html>
