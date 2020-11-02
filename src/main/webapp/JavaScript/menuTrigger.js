let opened = false;
function setVisibilityToElements(elements, visibility){
    let i;
    for(i = 0; i<elements.length; i++){
        elements[i].style.visibility = visibility;
    }
}

function menuTrigger() {
    const menu = $("#accountMenu");
    if(opened === true){
        setVisibilityToElements(document.getElementsByClassName("menuElement"),"hidden");
        menu.animate({height: '0'},"fast",function(){
            document.getElementById("accountMenu").style.visibility = "hidden";
        });
    }
    else {
        document.getElementById("accountMenu").style.visibility = "visible";
        menu.animate({height: menu.get(0).scrollHeight},"fast",function(){
            $(this).height('auto');
            setVisibilityToElements(document.getElementsByClassName("menuElement"),"visible");
        });
    }
    opened = opened === false;
}