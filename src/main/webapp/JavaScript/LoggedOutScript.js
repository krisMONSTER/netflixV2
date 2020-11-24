function mouseOverPanelElement(element){
    element.style.background = "rgba(100,100,100,1)";
}

function mouseOutPanelElement(element){
    element.style.background = "rgba(100,100,100,0.5)";
}

$(document).ready(function () {

    $("#search_div").click(function() {
        $("#content_div").html("<p>halo halo</p>");
    });

    $("#test_div").click(function () {
        $("#content_div").html("<form id=\"rejestracja\" method=\"post\" action=\"./Register\">" +
            "Dodaj account:<br>" +
            "<label for=\"login\">Login:</label><br>" +
            "<input type=\"text\" id=\"login\" name=\"login\"><br>" +
            "<label for=\"haslo\">Haslo:</label><br>" +
            "<input type=\"password\" id=\"haslo\" name=\"haslo\"><br>" +
            "<label for=\"email\">Email:</label><br>" +
            "<input type=\"text\" id=\"email\" name=\"email\"><br>" +
            "<label>Czy zweryfikowany:</label><br>" +
            "<input type=\"radio\" id=\"tak\" name=\"weryfikacja\" value = \"1\" required>" +
            "<label for=\"tak\">tak</label><br>" +
            "<input type=\"radio\" id=\"nie\" name=\"weryfikacja\" value = \"0\">" +
            "<label for=\"nie\">nie</label><br>" +
            "<input type=\"submit\" value=\"Submit\">" +
            "</form>");
    })
});