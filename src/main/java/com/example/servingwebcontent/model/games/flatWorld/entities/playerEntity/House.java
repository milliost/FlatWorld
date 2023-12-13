package com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity;

import com.example.servingwebcontent.model.games.flatWorld.Player;
import com.example.servingwebcontent.model.games.flatWorld.entities.EntityType;

public class House extends PlayerEntity {
    public House(Player owner) {
        super(owner);
        setCanKill(false);
        setCanSwap(false);
        setEntityType(EntityType.HOUSE);
    }
}
