package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.FlatWorldPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Lobby implements LobbyService {

    private String[] names = new String[4];
    public void sitOnChair(int numOfChair, String name) {
        upChair(name);
        names[numOfChair] = name;
    }

    public String toString() {
        return Arrays.toString(names);
    }

    @Bean
    public FlatWorldPlayer[] makePlayerArrayForGame() {
        ArrayList<String> nEw = new ArrayList<>(Arrays.asList(names));
        nEw.removeIf(Objects::isNull);
        String[] namesWithoutNull = nEw.stream().toList().toArray(new String[0]);

        FlatWorldPlayer[] players = new FlatWorldPlayer[namesWithoutNull.length];
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

    private void upChair(String name) {
        int idOfChair = Arrays.asList(names).indexOf(name);
        if (idOfChair != -1) names[idOfChair] = null;
    }
}
