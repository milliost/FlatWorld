package com.example.servingwebcontent.controllers.others;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.abstraction.Game;
import com.example.servingwebcontent.model.games.abstraction.Lobby;
import com.example.servingwebcontent.service.LobbyRoomService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class LobbyRoomController {

    LobbyRoomService LRS;
    @GetMapping("/lobbies")
    public String lobbyRoom(Model model){

        model.addAttribute("lobbies", LRS.history());
        return "lobbies";
    }

    @PostMapping("/create")
    public String create(@RequestParam String lobbyName, String typeOfTheGame) {

        LRS.create(lobbyName, Game.TypeOfTheGame.valueOf(typeOfTheGame));

        switch (Game.TypeOfTheGame.valueOf(typeOfTheGame)){
            case FLATWORLD -> {
                return "game";
            }
        }
        return null;
    }

    @MessageMapping("/join")
    @SendTo("/lobbies")
    public ChatMessage join(@Payload ChatMessage chatMessage) {
        LRS.join();
        return chatMessage;
    }


}
