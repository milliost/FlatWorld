package com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.entities.EntityType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class House extends PlayerEntity {
    public House(FlatWorldPlayer owner) {
        super(owner);
        setCanKill(false);
        setCanSwap(false);
        setEntityType(EntityType.HOUSE);

    }
}
