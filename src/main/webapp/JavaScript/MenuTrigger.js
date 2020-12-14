let opened = false;
let isReady = true;

jQuery.fn.animateAuto = function(speed, callback){
    let elem, height, width;
    return this.each(function(i, el){
        el = jQuery(el); elem = el.clone().css({"height":"auto","width":"auto"}).appendTo("body");
        height = elem.css("height");
        width = elem.css("width");
        elem.remove();
        el.animate({"width":width,"height":height}, speed, callback);
    });
}

function setVisibilityToElements(elements, visibility){
    let i;
    for(i = 0; i<elements.length; i++){
        elements[i].style.visibility = visibility;
    }
}

$(document).ready(function (){
    $("#language").click(function () {
        if(isReady) {
            isReady = false;
            const menu = $("#menu_div");
            if (opened === true) {
                setVisibilityToElements(document.getElementsByClassName("menu_element"), "hidden");
                menu.animate({height: '0', width: '0'}, "fast", function () {
                    document.getElementById("menu_div").style.visibility = "hidden";
                    isReady = true;
                });
            } else {
                document.getElementById("menu_div").style.visibility = "visible";
                menu.animateAuto("fast", function () {
                    setVisibilityToElements(document.getElementsByClassName("menu_element"), "visible");
                    isReady = true;
                });
            }
            opened = !opened;
        }
    });
});