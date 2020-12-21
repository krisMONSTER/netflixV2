function startSearchThread() {
    let searchThreadStorage = "";
    let currentText;
    let changedTrigger = false;
    search();
    function search() {
        currentText = document.getElementById("search_form").elements[0].value;
        if (currentText == null) return;
        if(currentText === searchThreadStorage && !changedTrigger){
            setTimeout(search, 250);
        }
        else if(currentText !== searchThreadStorage && !changedTrigger){
            changedTrigger = true;
            searchThreadStorage = currentText;
            setTimeout(search, 750);
        }
        else if(currentText === searchThreadStorage && changedTrigger){
            executeRequest();
            changedTrigger = false;
            setTimeout(search, 250);
        }
        else if(currentText !== searchThreadStorage && changedTrigger){
            searchThreadStorage = currentText;
            setTimeout(search, 750);
        }
    }
}

function executeRequest() {
    request().then(handleData);
}

function request() {
    return $.ajax({
        type: "POST",
        url: "searchMovies",
        async: false,
        data: $('form[name="search_form"]').serialize()
    });

}

function handleData(data) {
    document.getElementById("content_div").innerHTML = data;

    $("#movies").dataTable({
        "iDisplayLength": 20,
        "aLengthMenu": [[10, 25, 50, 100,  -1], [10, 25, 50, 100, "All"]]
    });

}

$(document).ready(function () {

    $("#search_div").click(function () {
        $("#content_options_div").html("<form name='search_form' id='search_form' action='javascript:void(0);' " +
            "method='post' autocomplete='off'>" +
            "<input type='text' placeholder='Search...' name='search'>" +
            "</form>");
        startSearchThread();
    });

    $("#recommended_div").click(function () {
        $("#content_options_div").html("");
        $("#content_div").html("");
        /*
        "<form id=\"rejestracja\" method=\"post\" action=\"./Register\">" +
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
            "</form>"
         */
    });

});