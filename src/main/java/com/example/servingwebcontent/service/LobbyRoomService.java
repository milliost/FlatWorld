package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.games.abstraction.Game;
import com.example.servingwebcontent.model.games.abstraction.Lobby;

import java.util.List;

public interface LobbyRoomService {
    void create(String lobbyName, Game.TypeOfTheGame typeOfTheGame);
    void join();
    List<Lobby> history();



}
