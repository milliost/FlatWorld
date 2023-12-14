package com.example.servingwebcontent.model.games.abstraction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Game {
    private NameOfTheGame name;
    private Player[] players;
    public enum NameOfTheGame{
        FLATWORLD,
        MORE
    }
    public abstract void start();
}
