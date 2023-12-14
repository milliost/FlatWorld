package com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity;

import com.example.servingwebcontent.model.games.flatWorld.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import lombok.Getter;

@Getter
public abstract class PlayerEntity extends Entity {
    FlatWorldPlayer owner;
    public PlayerEntity(FlatWorldPlayer owner) {
        this.owner=owner;
    }
}
