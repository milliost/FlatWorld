package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.services.FlatWorldPlayersService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Lobby implements LobbyService {

  private final FlatWorldPlayersService flatWorldPlayersService;
  private final String[] names = new String[4];
  private final Logger logger = LoggerFactory.getLogger("Лобби");

  public Lobby(FlatWorldPlayersService flatWorldPlayersService){
    this.flatWorldPlayersService = flatWorldPlayersService;;
  }

  public void sitOnChair(int numOfChair, String name) {
    upChair(name);
    names[numOfChair] = name;
    logger.info(names[numOfChair] + " сел за " + numOfChair);
  }

  public String toString() {
    return Arrays.toString(names);
  }

  @Bean
  public FlatWorldPlayer[] makePlayerArrayForGame() {
    ArrayList<String> nEw = new ArrayList<>(Arrays.asList(names));
    nEw.removeIf(Objects::isNull);
    nEw.trimToSize();
    String[] namesWithoutNull;
    namesWithoutNull = nEw.toArray(new String[0]);
    logger.info(Arrays.toString(namesWithoutNull));

    FlatWorldPlayer[] players = new FlatWorldPlayer[namesWithoutNull.length];
    for (int i = 0; i < namesWithoutNull.length; i++) {
      players[i] = flatWorldPlayersService.getPlayer();
      players[i].setName(namesWithoutNull[i]);
    }
    return players;
  }


  private void upChair(String name) {
    int idOfChair = Arrays.asList(names).indexOf(name);
    if (idOfChair != -1) {
      names[idOfChair] = null;
    }
  }
}
