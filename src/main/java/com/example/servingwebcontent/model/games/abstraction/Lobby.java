package com.example.servingwebcontent.model.games.abstraction;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Класс собирает будующих игроков
 */
public abstract class Lobby implements LobbyService {

    @Getter
    private final String lobbyName;
    private final Game.NameOfTheGame nameOfTheGame;
    private final String[] names;

    public Lobby(int maxNumOfPlayers, String lobbyName, Game.NameOfTheGame nameOfTheGame) {
        names = new String[maxNumOfPlayers];
        this.lobbyName = lobbyName;
        this.nameOfTheGame = nameOfTheGame;
    }

    /**
     * @param numOfChair номер стула
     * @param name       имя игрока севшего на него
     */
    public void sitOnChair(int numOfChair, String name) {
        upChair(name);
        names[numOfChair] = name;
    }

    public String toString() {
        return Arrays.toString(names);
    }

    public Player[] makePlayerArrayForGame() {
        ArrayList<String> nEw = new ArrayList<>(Arrays.asList(names));
        nEw.removeIf(Objects::isNull);
        String[] namesWithoutNull = nEw.stream().toList().toArray(new String[0]);

        Player[] players = new Player[namesWithoutNull.length];
        for (int i = 0; i < namesWithoutNull.length; i++) {
            players[i].setName(namesWithoutNull[i]);
        }

        return players;
    }
    public int maxNumOfPlayers(){
        return names.length;
    }
    public int quantityPlayersNow(){
        return (int) Arrays.stream(names).filter(Objects::nonNull).count();
    }
    public String getNameOfTheGame(){
        return nameOfTheGame.name();
    }

    private void upChair(String name) {
        int idOfChair = Arrays.asList(names).indexOf(name);
        if (idOfChair != -1) names[idOfChair] = null;
    }
}
