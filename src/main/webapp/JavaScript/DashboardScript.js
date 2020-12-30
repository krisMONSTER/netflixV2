function executeRequest() {
    request().then(handleData);
}

function request() {
    return $.ajax({
        type: "POST",
        url: "GetPersonalData",
        async: false
    });

}

function handleData(data) {
    document.getElementById("content_div").innerHTML = data;
    setTableLabels();
}

$(document).ready(function () {
    $("#edit_div").click(function () {
        executeRequest();
    });
});