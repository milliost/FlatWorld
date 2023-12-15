package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.config.WebSocketEventListener;
import com.example.servingwebcontent.model.games.abstraction.Player;
import com.example.servingwebcontent.model.games.abstraction.LobbyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс собирает будующих игроков
 */
@Service
public class FlatWorldLobbyImpl implements LobbyService {

    private final String[] names = new String[4];


    /**
     * @param numOfChair номер стула
     * @param name       имя игрока севшего на него
     */
    public void sitOnChair(int numOfChair, String name) {
        upChair(name);
        names[numOfChair] = name;
    }

    @Override
    public String toString() {
        return Arrays.toString(names);
    }

    public Player[] makePlayerArrayForGame() {
        ArrayList<String> nEw = new ArrayList<>(Arrays.asList(names));
        nEw.removeAll(null);
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

