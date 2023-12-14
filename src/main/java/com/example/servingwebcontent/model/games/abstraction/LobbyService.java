package com.example.servingwebcontent.model.games.abstraction;

public interface LobbyService {
     void sitOnChair(int numOfChair, String player);
     Player[] makePlayerArrayForGame();
     String toString();
}
