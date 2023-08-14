
    let table2 = document.createElement('table');
    let thead = document.createElement('thead');
    let tbody = document.createElement('tbody');

    table2.appendChild(thead);
    table2.appendChild(tbody);
    document.getElementById('table2').appendChild(table2);

    let row_1 = document.createElement('tr');

    let heading_1 = document.createElement('th');
    heading_1.innerHTML = "Место";
    let heading_2 = document.createElement('th');
    heading_2.innerHTML = "Ход";
    let heading_3 = document.createElement('th');
    heading_3.innerHTML = "Имя";
    let heading_4 = document.createElement('th');
    heading_4.innerHTML = "Деньги";
    let heading_5 = document.createElement('th');
    heading_5.innerHTML = "Карты";
    let heading_6 = document.createElement('th');
    heading_6.innerHTML = "Дебафы";
    let heading_7 = document.createElement('th');
    heading_7.innerHTML = "Герой";

    row_1.appendChild(heading_1);
    row_1.appendChild(heading_2);
    row_1.appendChild(heading_3);
    row_1.appendChild(heading_4);
    row_1.appendChild(heading_5);
    row_1.appendChild(heading_6);
    row_1.appendChild(heading_7);
    thead.appendChild(row_1);


// Creating and adding data to second row of the table
    let row_2 = document.createElement('tr');
    let row_2_data_1 = document.createElement('td');
    row_2_data_1.innerHTML =    "<form action=\"listReferred\" method=\"get\">"+
                                "<input class=\"cellbut\" type=\"button\" id=\"button1\" value=\"1\"/>"+
                                 "</form>";
    let row_2_data_2 = document.createElement('td');
    row_2_data_2.innerHTML = "James Clerk";
    let row_2_data_3 = document.createElement('td');
    row_2_data_3.innerHTML = "Netflix";

    row_2.appendChild(row_2_data_1);
    row_2.appendChild(row_2_data_2);
    row_2.appendChild(row_2_data_3);
    tbody.appendChild(row_2);


// Creating and adding data to third row of the table
    let row_3 = document.createElement('tr');
    let row_3_data_1 = document.createElement('td');
    row_3_data_1.innerHTML =    "<form action=\"listReferred\" method=\"get\">"+
                                "<input class=\"cellbut\" type=\"button\" id=\"button2\" value=\"2\"/>"+
                                "</form>";
    let row_3_data_2 = document.createElement('td');
    row_3_data_2.innerHTML = "Adam White";
    let row_3_data_3 = document.createElement('td');
    row_3_data_3.innerHTML = "Microsoft";

    row_3.appendChild(row_3_data_1);
    row_3.appendChild(row_3_data_2);
    row_3.appendChild(row_3_data_3);
    tbody.appendChild(row_3);

    let row_4 = document.createElement('tr');
    let row_4_data_1 = document.createElement('td');
    row_4_data_1.innerHTML =    "<form action=\"listReferred\" method=\"get\">"+
                                "<input class=\"cellbut\" type=\"button\" id=\"button3\" value=\"3\"/>"+
                                "</form>";
    let row_4_data_2 = document.createElement('td');
    row_4_data_2.innerHTML = "Adam White";
    let row_4_data_3 = document.createElement('td');
    row_4_data_3.innerHTML = "Microsoft";

    row_4.appendChild(row_4_data_1);
    row_4.appendChild(row_4_data_2);
    row_4.appendChild(row_4_data_3);
    tbody.appendChild(row_4);

    let row_5 = document.createElement('tr');
    let row_5_data_1 = document.createElement('td');
    row_5_data_1.innerHTML =    "<form action=\"listReferred\" method=\"get\">"+
                                "<input class=\"cellbut\" type=\"button\" id=\"button4\" value=\"4\"/>"+
                                "</form>";
    let row_5_data_2 = document.createElement('td');
    row_5_data_2.innerHTML = "Adam White";
    let row_5_data_3 = document.createElement('td');
    row_5_data_3.innerHTML = "Microsoft";

    row_5.appendChild(row_5_data_1);
    row_5.appendChild(row_5_data_2);
    row_5.appendChild(row_5_data_3);
    tbody.appendChild(row_5);

    var buttonStart=document.querySelector('#buttonStart');
    var button1=document.querySelector('#button1');
    var button2=document.querySelector('#button2');
    var button3=document.querySelector('#button3');
    var button4=document.querySelector('#button4');

    buttonStart.addEventListener('click',start,false)
    button1.addEventListener('click',but,false)
    button2.addEventListener('click',but,false)
    button3.addEventListener('click',but,false)
    button4.addEventListener('click',but,false)

function but(event){
        event.preventDefault()

    if(stompClient) {
        var chatMessage = {
            sender: username,
            content: event.target.id,
            type: 'SIT'

        };
        stompClient.send("/app/chat.chair", {}, JSON.stringify(chatMessage));

    }
    event.preventDefault();

}
function start(event){
    if(stompClient) {
        var chatMessage = {
            sender: username,
            content: event.target.id,
            type: 'SIT'

        };
        stompClient.send("/app/chat.start", {}, JSON.stringify(chatMessage));

    }
    event.preventDefault();
}

function tableName(row,name){
        if(row===0){
            row_2_data_3.innerHTML = name;
        } else if(row===1){
            row_3_data_3.innerHTML = name;
        } else if(row===2){
            row_4_data_3.innerHTML = name;
        } else if(row===3){
            row_5_data_3.innerHTML = name;
        }else {
        }
    }