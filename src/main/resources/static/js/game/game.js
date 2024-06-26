'use strict';

let chatPage = document.querySelector('#chat-page');
let messageForm = document.querySelector('#messageForm');
let messageInput = document.querySelector('#message');
let messageArea = document.querySelector('#messageArea');
let connectingElement = document.querySelector('.connecting');
let stompClient = null;
let username = null;
let colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];
getMyName()
function getMyName() {
    var x = new XMLHttpRequest();
    x.open("GET", "/myName", true);
    x.onload = function (){
        username = x.responseText;
        connect()
    }
    x.send(null);
}
function connect() {
    if(username) {
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    }

}
function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);
    // Tell your username to the server
    stompClient.send("/app/chat.sendMessage",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )
    stompClient.send("/app/chat.sendMessage",
        {},
        JSON.stringify({sender: username, type: 'LOBBY'})
    )
    connectingElement.style.display = "none"
}
function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}
function sendMessage(event,content) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}
function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    var messageElement = document.createElement('li');
    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' подключился!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' отключился!';
    } else if (message.type === 'SIT') {
        messageElement.classList.add('event-message');
        var chair = message.content;
        message.content = message.sender + ' занял ' + chair + ' место';
        document.getElementById(chair).value = message.sender
    } else if (message.type === 'LOBBY') {
        messageElement.classList.add('event-message');
        let content = message.content.replace('[','').replace(']','');
        let names = content.split(",");

        let buttom = document.querySelectorAll('button')
        alert(buttom[1].value)
    }else if (message.type === 'HISTORY') {
        messageElement.classList.add('chat-message');

        let players = JSON.parse(message.content);
        alert(players[0].name);
        

    } else {
        messageElement.classList.add('chat-message');
        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);
        messageElement.appendChild(avatarElement);
        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }
    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);
    messageElement.appendChild(textElement);
    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}
function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}
messageForm.addEventListener('submit', sendMessage, true)

function dice() {

    if(stompClient) {
        var chatMessage = {
            sender: username,
            content: "sas",
            type: 'INSTRUCTION',
            actionEnum: 'DICE',
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
}
function startGame() {

    if(stompClient) {
        var chatMessage = {
            sender: username,
            content: "Начал игру",
            type: 'START'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
}

function endTurn() {
    makeMessageAndSend4("окончил ход",'ENDTURN',0,username)
}
function playCard(numOfCard) {
    makeMessageAndSend4("сыграл",'INSTRUCTION',numOfCard,username)
}
function makeMessageAndSend2(content,type) {
    if(stompClient) {
        var chatMessage = {
            sender: username,
            content: content,
            type: type
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
}
function makeMessageAndSend4(content,INSTRUCTION, parameter, instructionPlayer) {
    if(stompClient) {
        var chatMessage = {
            sender: username,
            content: content,
            type: 'INSTRUCTION',
            actionEnum: INSTRUCTION,
            parameter: parameter,
            instructionPlayer: instructionPlayer

        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
}