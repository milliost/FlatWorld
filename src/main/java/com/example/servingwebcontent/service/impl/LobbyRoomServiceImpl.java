package com.example.servingwebcontent.service.impl;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.abstraction.Game;
import com.example.servingwebcontent.model.games.abstraction.Lobby;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl.FlatWorldLobbyImpl;
import com.example.servingwebcontent.service.LobbyRoomService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class LobbyRoomServiceImpl implements LobbyRoomService {

    private ArrayList<Lobby> lobbies;
    private SimpMessageSendingOperations messagingTemplate;
    @Override
    public void create(String lobbyName, Game.TypeOfTheGame type) {

        switch (type){
            case FLATWORLD ->   {
                sendChatMessage(lobbyName, type.name());
                 Lobby lobby = new FlatWorldLobbyImpl(lobbyName);
                lobby.setLobbyName(lobbyName);
                lobbies.add(lobby);
                }
            case MORE -> sendChatMessage(lobbyName, type.name());

        }
    }

    @Override
    public void join() {

    }

    @Override
    public List<Lobby> history() {
        create("sas", Game.TypeOfTheGame.FLATWORLD);
        return lobbies;
    }

    private void sendChatMessage(String lobbyName, String stringType){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.CREATE);
        chatMessage.setSender(lobbyName);
        chatMessage.setContent(stringType);
        messagingTemplate.convertAndSend("/lobbies", chatMessage);
    }
}
