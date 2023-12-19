package com.example.servingwebcontent.model.games.abstraction;

public interface LobbyRoomService {
    Lobby create(String lobbyName, String typeOfTheGame);
    void join();



}
