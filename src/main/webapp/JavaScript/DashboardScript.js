function executePersonalDataRequest() {
    personalDataRequest().then(handlePersonalData);
}

function executeWalletRequest() {
    walletRequest().then(handleWalletData);
}

function personalDataRequest() {
    return $.ajax({
        type: "POST",
        url: "GetPersonalData",
        async: false
    });
}

function walletRequest() {
    return $.ajax({
        type: "POST",
        url: "GetWallet",
        async: false
    });


}

function handlePersonalData(data) {
    document.getElementById("content_div").innerHTML = data;
    setTableLabels();
    setImages();
    $(".edit_data").click(function () {
        let label = $(this).attr('id');
        editData(label);
    });
    $("#submit_div").click(function () {
        editData(null);
    })
}

function handleWalletData(data) {
    document.getElementById("content_div").innerHTML = data;

}

$(document).ready(function () {
    $("#edit_div").click(function () {
        executePersonalDataRequest();
    });
    $("#wallet_div").click(function () {
        executeWalletRequest();
    });
});