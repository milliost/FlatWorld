package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.model.games.abstraction.Game;
import com.example.servingwebcontent.model.games.abstraction.Lobby;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public final class FlatWorldLobbyImpl extends Lobby {
    public FlatWorldLobbyImpl() {
        super(4, name, Game.NameOfTheGame.FLATWORLD);
    }



}

