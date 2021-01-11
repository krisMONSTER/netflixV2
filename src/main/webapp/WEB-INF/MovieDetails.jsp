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
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/Cookies.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/MovieDetailsScript.js"></script>
    <script>
        $(document).ready(function () {
            let language = getCookie("lang");
            if(language == null){
                setCookie("lang", "english", 1);
                language = "english";
            }
            if(language === "polish"){

            }
            else if(language === "english"){

            }

            <%
            String title = request.getParameter("title");
            %>

            set("title", "<%=title%>");
            getMovieDescription();
        });

        function set(id, content) {
            let element = document.getElementById(id);
            if(element != null){
                element.innerHTML = content;
            }
        }

        function getMovieDescription() {
            request().then(handleData);
        }

        function request() {
            return $.ajax({
                type: "POST",
                url: "GetMovieDescription",
                async: false,
                data: { title: "<%=title%>"}
            });
        }

        function handleData(data){
            set("description", data);
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
<div id="title_div">
    <h1 id="title"></h1>
</div>
<div id="description_div">
    <p id="description"></p>
</div>
<div id="controls_div">
</div>
</body>
</html>
