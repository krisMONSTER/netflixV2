function executePersonalDataRequest() {
    personalDataRequest().then(handlePersonalData);
}

function executeWalletRequest() {
    walletRequest().then(handleWalletData);
}

function executeAcquiredMovies(){
    acquiredMoviesRequest().then(handleAcquiredMovies);
}

function executeTopUpWalletRequest() {
    topUpWalletRequest().then(handleTopUpWalletData);
}

function executeArchiveRequest() {
    archiveRequest().then(handleArchive);
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

function topUpWalletRequest() {
    return $.ajax({
        type: "POST",
        url: "TopUpWallet",
        async: false
    });
}

function acquiredMoviesRequest(){
    return $.ajax({
        type: "POST",
        url: "GetAcquiredMovies",
        async: false
    });
}

function archiveRequest(){
    return $.ajax({
        type: "POST",
        url: "GetArchive",
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
    setChargeAccountLabel();
    $("#submit_div").click(function () {
        executeTopUpWalletRequest();
    });
}

function handleAcquiredMovies(data){
    document.getElementById("content_div").innerHTML = data;
}

function handleArchive(data){
    document.getElementById("content_div").innerHTML = data;
}

function handleTopUpWalletData(data) {
    if (data === "success") {
        executeWalletRequest();
    } else {
        alert("DUPA");
    }
}

$(document).ready(function () {
    $("#edit_div").click(function () {
        executePersonalDataRequest();
    });
    $("#wallet_div").click(function () {
        executeWalletRequest();
    });
    $("#acquired_movies_div").click(function () {
        executeAcquiredMovies();
    });
    $("#archive_div").click(function () {
        executeArchiveRequest();
    });
});