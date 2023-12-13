package com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity;

import com.example.servingwebcontent.model.games.flatWorld.Player;
import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import com.example.servingwebcontent.model.games.flatWorld.entities.EntityType;
import lombok.Getter;

@Getter
public abstract class PlayerEntity extends Entity {
    Player owner;
    public PlayerEntity(Player owner) {
        this.owner=owner;
    }
}
