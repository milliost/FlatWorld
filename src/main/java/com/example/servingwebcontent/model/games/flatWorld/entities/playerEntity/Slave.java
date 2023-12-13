package com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity;

import com.example.servingwebcontent.model.games.flatWorld.Player;
import com.example.servingwebcontent.model.games.flatWorld.entities.EntityType;

public class Slave extends PlayerEntity {
    public Slave(Player owner) {
        super(owner);
        setCanKill(true);
        setCanSwap(true);
        setEntityType(EntityType.SLAVE);
    }
}
