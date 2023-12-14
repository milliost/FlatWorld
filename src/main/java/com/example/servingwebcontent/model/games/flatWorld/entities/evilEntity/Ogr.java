package com.example.servingwebcontent.model.games.flatWorld.entities.evilEntity;

import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import com.example.servingwebcontent.model.games.flatWorld.entities.EntityType;

public class Ogr extends Entity {
    public Ogr() {
        setCanKill(true);
        setCanSwap(true);
        setEntityType(EntityType.OGR);
    }
}
