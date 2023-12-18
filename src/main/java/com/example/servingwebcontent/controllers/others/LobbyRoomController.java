package com.example.servingwebcontent.controllers.others;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LobbyRoomController {
    @GetMapping("/lobbyRoom")
    public String lobbyRoom(){
        return "lobbyRoom";
    }
    @GetMapping("/createLobby")
    public String createLobby(){
        return "game";
    }

}
