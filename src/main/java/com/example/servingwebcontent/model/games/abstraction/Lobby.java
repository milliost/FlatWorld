package com.example.servingwebcontent.model.games.abstraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Класс собирает будующих игроков
 */
public abstract class Lobby implements LobbyService {
    private final String[] names;

    public Lobby(int maxNumOfPlayers) {
        names = new String[maxNumOfPlayers];
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

    private void upChair(String name) {
        int idOfChair = Arrays.asList(names).indexOf(name);
        if (idOfChair != -1) names[idOfChair] = null;
    }
}
