package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.model.games.abstraction.Lobby;
import com.example.servingwebcontent.model.games.abstraction.Player;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public final class FlatWorldLobbyImpl extends Lobby {
    public FlatWorldLobbyImpl() {
        super(4);
    }

    public Player[] makePlayerArrayForGame() {


        return null;
    }



}

