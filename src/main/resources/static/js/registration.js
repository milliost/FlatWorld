let block = document.querySelector('.block');

let name = document.querySelector('.name');
let checkPass = document.querySelector('.repeatPass')
let checkEmail= document.querySelector('.email')

let tofName = false;
let tofPass = false;
let tofEmail = false;

setTimeout(function () {block.classList.add('open')}, 500)

name.oninput = function() {
    checkNames(document.getElementById("name").value);
}
function checkNames(value) {

    let url = "http://94.19.137.150/registration/checkName?name=" + value;
    let request = new XMLHttpRequest();
    request.open("GET", url);
    request.responseType = "text";
    request.onload = function () {
        if (request.response === "true") { //имя есть в БД
            document.getElementById("checkName").style.display = "block";
            tofName = false;
            goGreenOrRed();
        } else{
            document.getElementById("checkName").style.display = "none";
            tofName = true;
            goGreenOrRed();
        }
    };
    request.send();
}


checkPass.oninput = function (){
    if( document.getElementById("pass").value!==""
        &&
        document.getElementById("pass").value === document.getElementById("repeatPass").value
    ){
        document.getElementById("checkPass").style.display = "none";
        tofPass = true;
        goGreenOrRed();
    }else {
        document.getElementById("checkPass").style.display = "block";
        tofPass = false;
        goGreenOrRed();
    }
}

checkEmail.oninput = function (){
    let str = document.getElementById("email").value;
    let correct = str.length >= 6    // минимальная длина для точки, собаки, домена + по букве между ними
        && str.includes('@')    // есть собака
        && str.includes('.');   // есть точка
    if(correct) {
        tofEmail=true;
        goGreenOrRed();}
    else {
        tofEmail=false
        goGreenOrRed();}
}

function goGreenOrRed() {
    if (tofName && tofPass && tofEmail) {
        document.getElementById('button').disabled =false;}
    else {
        document.getElementById('button').disabled=true;}
}