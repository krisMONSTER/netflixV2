<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <title>MovOn</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logoV2.png" type="image/icon type">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/GeneralStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/NavbarStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/LanguagePanelStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/LoggedInStyle.css">
    <link href="${pageContext.request.contextPath}/Bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/Cookies.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LanguagePanelScript.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LoggedInScript.js"></script>
    <script src="${pageContext.request.contextPath}/DataTables/js/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/DataTables/js/dataTables.bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LoggedInLanguage.js"></script>
    <script>
        function setLanguage(lang){
            setCookie("lang", lang, 1);
            window.location.href = "${pageContext.request.contextPath}/Welcome";
        }
        function movieDetails(title){
            let action = "rent";
            window.location.href = "${pageContext.request.contextPath}/MovieDetailsNav?title=" + title +"&action=" + action;
        }
    </script>
</head>
<body>
<nav class="navbar">
    <div class="navbar__container">
        <a href="${pageContext.request.contextPath}/Welcome"><img id="logo_img" src="${pageContext.request.contextPath}/images/logoBialeV2.png" alt="Logo firmy"></a>
        <ul class="navbar__menu">
            <li class="navbar__item">
                <span class="navbar__link" id="language"></span>
            </li>
            <li class="navbar__item">
                <a href="${pageContext.request.contextPath}/LogOut" class="navbar__link" id="log_out"></a>
            </li>
            <li class="navbar__item">
                <a href="${pageContext.request.contextPath}/DashboardNav">
                    <img id="dashboard_img" src="${pageContext.request.contextPath}/images/user_biały.png" alt="dashboard">
                </a>
            </li>
        </ul>
    </div>
</nav>
<nav class="navbar">
    <div class="navbar__container">
        <ul class="navbar__menu">
            <li class="navbar__item">
                <a class="navbar__link" id="search_div"></a>
            </li>
            <li class="navbar__item">
                <a class="navbar__link" id="recommended_div"></a>
            </li>
        </ul>
    </div>
</nav>
<%--<div id="panel">
    <div id="panel_content">
        <div class="panel_element" id="search_div">
            <span id="search"></span>
        </div>
        <div class="panel_element" id="recommended_div">
            <span id="recommended"></span>
        </div>
    </div>
</div>--%>
<div id="content_options_div"></div>
<div id="content_div">
</div>
<div id="language_div">
    <p onclick="setLanguage('english')" class="language_element">English</p>
    <hr class="language_element" id="language_hr">
    <p onclick="setLanguage('polish')" class="language_element">Polski</p>
</div>
</body>
</html>
