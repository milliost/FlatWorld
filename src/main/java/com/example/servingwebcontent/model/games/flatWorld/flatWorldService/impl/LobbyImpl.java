package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.model.games.abstraction.Player;
import com.example.servingwebcontent.model.games.abstraction.LobbyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Класс собирает будующих игроков
 */
@Service
@AllArgsConstructor
public class LobbyImpl implements LobbyService {

    private List<String> names;


    /**
     * чтобы сесть на стул нужно встать с предыдущего, если ты вообще сидишь
     *
     * @param numOfChair номер стула
     * @param name       имя игрока севшего на него
     */
    public void sitOnChair(int numOfChair, String name) {
        upChair(name);
        names.add(numOfChair, name);
    }

    @Override
    public String toString() {
        return names.toString();
    }

    public Player[] makePlayerArrayForGame() {
        Player[] players = new Player[names.size()];
        for (int i = 0; i < names.size(); i++) {
            players[i].setName(names.get(i));
        }

        return players;
    }

    private void upChair(String name) {
        int idOfChair = names.indexOf(name);
        if (idOfChair != -1) {
            names.remove(idOfChair);
        }
    }


}

