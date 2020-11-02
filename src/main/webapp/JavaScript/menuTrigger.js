let opened = false;
function setVisibilityToElements(elements, visibility){
    let i;
    for(i = 0; i<elements.length; i++){
        elements[i].style.visibility = visibility;
    }
}

function menuTrigger() {
    if(opened === true){
        setVisibilityToElements(document.getElementsByClassName("menuOption"),"hidden");
        $("#accountMenu").animate({height: '0'},"fast",function(){
            document.getElementById("accountMenu").style.visibility = "hidden";
        });
    }
    else {
        document.getElementById("accountMenu").style.visibility = "visible";
        $("#accountMenu").animate({height: "20px"},"fast",function(){
            setVisibilityToElements(document.getElementsByClassName("menuOption"),"visible");
        });
    }
    opened = opened === false;
}