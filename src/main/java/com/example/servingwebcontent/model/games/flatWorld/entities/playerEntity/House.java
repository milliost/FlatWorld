package com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity;

import com.example.servingwebcontent.model.games.flatWorld.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.entities.EntityType;

public class House extends PlayerEntity {
    public House(FlatWorldPlayer owner) {
        super(owner);
        setCanKill(false);
        setCanSwap(false);
        setEntityType(EntityType.HOUSE);
    }
}
