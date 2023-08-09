package com.example.servingwebcontent.model.heroes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Hero implements winer{
private String name;
private HeroType heroType;

    public Hero(String name ) {
        this.name=name;
    }
}

