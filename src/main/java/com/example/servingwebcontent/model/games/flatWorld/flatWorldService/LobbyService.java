package com.example.servingwebcontent.model.games.flatWorld.flatWorldService;

import com.example.servingwebcontent.entity.User;

public interface LobbyService {
     void sitOnChair(int numOfChair, User user);
     void upChair(User user);
     User[] makeUserArrayForGame();
    String toString();
}
