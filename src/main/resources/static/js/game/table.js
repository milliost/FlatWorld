let table = document.querySelector('#table');
const row = 5;
const column = 7;

createTable();
writeTD(0,0,"Игрок")
writeTD(0,1,"Ход")
writeTD(0,2,"Карты")
writeTD(0,3,"Деньги")
writeTD(0,4,"Юниты")
writeTD(0,5,"Дома")
writeTD(0,6,"Дебафы")
addButtonToTD(1,0)
addButtonToTD(2,0)
addButtonToTD(3,0)
addButtonToTD(4,0)
function createTable() {

    let tableEl = document.createElement('table');
    for (let i = 0; i < row; i++) {
        let row = tableEl.insertRow(i);
        for (let j = 0; j < column; j++) {
            let cell = row.insertCell();
        }
    }
    table.appendChild(tableEl);
}

function writeTD(rowNow,columnNow,object){
    const tds = document.getElementsByTagName("td");
    const i = (rowNow) * column + (columnNow);
    tds[i].innerHTML = object
}
function addButtonToTD(rowNow,columnNow){
    const tds = document.getElementsByTagName("td");
    const i = (rowNow) * column + (columnNow);
    const btn = document.createElement('input');
    btn.type = "button";
    btn.className = "btn";
    btn.id = rowNow;
    btn.value = 'стул '+rowNow;
    tds[i].appendChild(btn);
    btn.addEventListener("click", function() { sendMessage(btn.id); });
}

function sendMessage(id) {
    if(stompClient) {
        var chatMessage = {
            sender: username,
            content: id,
            type: 'SIT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}