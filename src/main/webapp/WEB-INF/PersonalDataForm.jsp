<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MovOn</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/logoV2.png" type="image/icon type">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/GeneralStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/NavbarStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/SubmitStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/LanguagePanelStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/PersonalDataFormStyle.css">
    <script src="${pageContext.request.contextPath}/JavaScript/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/Cookies.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/LanguagePanelScript.js"></script>
    <script src="${pageContext.request.contextPath}/JavaScript/PersonalDataFormLanguage.js"></script>
    <%
        String input = request.getParameter("input");
        String name = request.getParameter("first_name");
        String surname = request.getParameter("last_name");
        String country = request.getParameter("country");
        String address = request.getParameter("address");
    %>
    <script>
        $(document).ready(function () {
            $("#submit").click(function () {
                $("#form").submit();

            });

            //alert("<%=input%>");
            if ("<%=input%>" === "null") {
                document.getElementById("first_name").value = "<%=name%>";
                document.getElementById("last_name").value = "<%=surname%>";
                document.getElementById("country").value = "<%=country%>";
                document.getElementById("address").value = "<%=address%>";
            } else if ("<%=input%>" === "first_name_btn")
                document.getElementById("first_name").value = "<%=name%>";
            else if ("<%=input%>" === "last_name_btn")
                document.getElementById("last_name").value = "<%=surname%>";
            else if ("<%=input%>" === "country_btn")
                document.getElementById("country").value = "<%=country%>";
            else if ("<%=input%>" === "address_btn")
                document.getElementById("address").value = "<%=address%>";
        })
        ;

        function setLanguage(lang) {
            setCookie("lang", lang, 1);
            window.location.href = "${pageContext.request.contextPath}/EditDataNav";
        }
    </script>

</head>
<body>
<nav class="navbar">
    <div class="navbar__container">
        <a href="${pageContext.request.contextPath}/Welcome"><img id="logo_img"
                                                                  src="${pageContext.request.contextPath}/images/logoBialeV2.png"
                                                                  alt="Logo firmy"></a>
        <ul class="navbar__menu">
            <li class="navbar__item">
                <span class="navbar__link" id="language"></span>
            </li>
            <li class="navbar__item">
                <a href="${pageContext.request.contextPath}/LogOut" class="navbar__link" id="log_out"></a>
            </li>
        </ul>
    </div>
</nav>
<div id="form_div">
    <form id="form" name="form" action="${pageContext.request.contextPath}/EditPersonalData?input=<%=input%>"
          method="post">
        <% if (input == null || input.equals("first_name_btn")) { %>
        <a id="first_name_label" class="form_label"></a><br>
        <label><input type="text" name="first_name" id="first_name"></label><br><br>
        <% } %>
        <% if (input == null || input.equals("last_name_btn")) { %>
        <a id="last_name_label" class="form_label"></a><br>
        <label><input type="text" name="last_name" id="last_name"></label><br><br>
        <% } %>
        <% if (input == null || input.equals("country_btn")) { %>
        <a id="country_label" class="form_label"></a><br>
        <label><select name="country" id="country" form="form">
            <option value="England">England</option>
            <option value="Germany">Germany</option>
            <option value="Poland">Poland</option>
        </select></label><br><br>
        <% } %>
        <% if (input == null || input.equals("address_btn")) { %>
        <a id="address_label" class="form_label"></a><br>
        <label><input type="text" name="address" id="address"></label><br><br>
        <% } %>
        <div class="submit" id="submit"><p id="submit_text"></p></div>
        <input type="submit" style="visibility: hidden; position: absolute;"/>
    </form>
</div>
<div id="language_div">
    <p onclick="setLanguage('english')" class="language_element">English</p>
    <hr class="language_element" id="language_hr">
    <p onclick="setLanguage('polish')" class="language_element">Polski</p>
</div>
</body>
</html>
