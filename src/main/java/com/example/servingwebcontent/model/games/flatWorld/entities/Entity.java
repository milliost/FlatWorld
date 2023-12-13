package com.example.servingwebcontent.model.games.flatWorld.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity{
    boolean canKill;
    boolean canSwap;
    EntityType entityType;
    @Override
    public boolean equals(Object obj) {
        if(this.getClass()==obj.getClass())
            return (this.getEntityType() == ( (Entity)obj ).getEntityType());
        else
            return false;
    }
}