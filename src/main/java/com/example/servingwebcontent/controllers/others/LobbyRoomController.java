package com.example.servingwebcontent.controllers.others;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.abstraction.Lobby;
import com.example.servingwebcontent.model.games.abstraction.LobbyRoomService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class LobbyRoomController {

    ArrayList<Lobby> lobbies;
    LobbyRoomService LRS;
    @GetMapping("/lobbyRoom")
    public String lobbyRoom(Model model){
        model.addAttribute("lobbies", lobbies);
        return "lobbies";
    }

    @MessageMapping("/create")
    @SendTo("/lobbies")
    public ChatMessage create(@Payload ChatMessage chatMessage) {
        LRS.create(chatMessage.getSender(), chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/join")
    @SendTo("/lobbies")
    public ChatMessage join(@Payload ChatMessage chatMessage) {
        LRS.join(chatMessage.getSender(), chatMessage.getContent());
        return chatMessage;
    }


}
