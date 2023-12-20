package com.example.servingwebcontent.model.games.abstraction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Game {
    private TypeOfTheGame name;
    private Player[] players;
    public enum TypeOfTheGame{
        FLATWORLD,
        MORE
    }
    public abstract void start();
}
