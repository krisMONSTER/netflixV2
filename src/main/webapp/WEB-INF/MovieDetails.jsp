<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: krizu
  Date: 11.01.2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MovOn</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logoV2.png" type="image/icon type">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/GeneralStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/NavbarStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/MovieDetailsStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/SubmitStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/LanguagePanelStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Snackbar.css">
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/Cookies.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LanguagePanelScript.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/MovieDetailsScript.js"></script>
    <script>
        function set(id, content) {
            let element = document.getElementById(id);
            if(element != null){
                element.innerHTML = content;
            }
        }

        $(document).ready(function () {
            let language = getCookie("lang");
            if(language == null){
                setCookie("lang", "english", 1);
                language = "english";
            }
            if(language === "polish"){
                set("log_out", "Wyloguj się");
                set("language", "Język");
                set("submit_text", "Wypożycz");
            }
            else if(language === "english"){
                set("log_out", "Logout");
                set("language", "Language");
                set("submit_text", "Rent");
            }

            <%
            String title = request.getParameter("title");
            %>

            set("title", "<%=title%>");
            getMovieDescription();

            $("#rent").click(function () {
                checkPayment(document.getElementById("days").value);
            });
        });

        function setLanguage(lang){
            setCookie("lang", lang, 1);
            window.location.href = "${pageContext.request.contextPath}/MovieDetailsNav?title=" + "<%=title%>";
        }

        function getMovieDescription() {
            requestDescription().then(handleDescriptionData);
        }

        function requestDescription() {
            return $.ajax({
                type: "POST",
                url: "GetMovieDescription",
                async: false,
                data: { title: "<%=title%>"}
            });
        }

        function handleDescriptionData(data){
            set("description", data);
        }

        function checkPayment(days) {
            requestCheckPayment(days).then(handleCheckPayment);
        }

        function requestCheckPayment(days) {
            return $.ajax({
                type: "POST",
                url: "PaymentValidation",
                async: false,
                data: { title: "<%=title%>", days: days}
            });
        }

        function handleCheckPayment(data){
            if(data === "ok"){
                window.location.href = "${pageContext.request.contextPath}/DashboardNav";
            }
            else {
                let snackbar = document.getElementById("snackbar");
                snackbar.innerHTML = data
                snackbar.className = "show";
                setTimeout(function () {
                    snackbar.className = snackbar.className.replace("show", "");
                }, 3000);
            }
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
<div class="wrap">
    <div id="title_div" class="content_div">
        <h1 id="title"></h1>
    </div>
</div>
<div class="wrap">
    <div id="description_div" class="content_div">
        <p id="description"></p>
    </div>
</div>
<div class="wrap">
    <div id="controls_div" class="content_div">
        <div id="days_div">
            <label for="days"></label><input type="number" id="days" name="tentacles" min="1" max="30">
        </div>
        <div id="rent" class="submit"><p id="submit_text"></p></div>
        <input type="submit" style="visibility: hidden; position: absolute;" />
    </div>
</div>
<div id="snackbar"></div>
<div id="language_div">
    <p onclick="setLanguage('english')" class="language_element">English</p>
    <hr class="language_element" id="language_hr">
    <p onclick="setLanguage('polish')" class="language_element">Polski</p>
</div>
</body>
</html>
