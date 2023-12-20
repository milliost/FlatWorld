package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.abstraction.Game;
import com.example.servingwebcontent.model.games.abstraction.Lobby;
import com.example.servingwebcontent.model.games.abstraction.Player;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public class FlatWorldLobbyImpl extends Lobby {

    public FlatWorldLobbyImpl(String lobbyName) {//бля я хочу создать класс только после запроса как нахуй!?!?!?!?
        super(4, Game.TypeOfTheGame.FLATWORLD, lobbyName);
        setLobbyName(lobbyName);

    }

    @Override
    public Player[] makePlayerArrayForGame() {
        return super.makePlayerArrayForGame();
    }
}

