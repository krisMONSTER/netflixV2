$(document).ready(function () {
    $("#submit").click(function () {
        $('#form').submit();
    });
    $('#login, #password').click(function() {
        $("#errMsg").hide();
    });

});