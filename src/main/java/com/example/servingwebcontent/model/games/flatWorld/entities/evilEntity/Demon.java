package com.example.servingwebcontent.model.games.flatWorld.entities.evilEntity;

import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import com.example.servingwebcontent.model.games.flatWorld.entities.EntityType;

public class Demon extends Entity {
    public Demon() {
        setCanKill(true);
        setCanSwap(true);
        setEntityType(EntityType.DEMON);
    }
}
