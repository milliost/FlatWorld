package com.example.servingwebcontent.model.games.flatWorld;

import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import com.example.servingwebcontent.model.games.flatWorld.cards.Deck;
import com.example.servingwebcontent.model.games.flatWorld.cards.DeckService;
import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroService;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroType;
import com.example.servingwebcontent.model.games.flatWorld.map.MapService;
import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.player.PlayerService;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class FlatWorldGame implements PlayerService {

  private FlatWorldPlayer[] players;
  private List<HeroType> heroesPool;
  private DeckService deckService;
  private Logger logger = LoggerFactory.getLogger(FlatWorldGame.class);
  private HeroService heroService;


  public FlatWorldGame(List<HeroType> heroesPool,
      HeroService heroService, DeckService deckService) {
    this.heroesPool = heroesPool;
    this.heroService = heroService;
    this.deckService = deckService;
  }


  public FlatWorldPlayer findPlayer(String string) {
    logger.info(Arrays.toString(players));
    for (FlatWorldPlayer player : players) {
      if (player.getName().equals(string)) {
        logger.info(player.getName());
        return player;
      }
    }
    return null;
  }

  public void start(FlatWorldPlayer[] players) {
    for (FlatWorldPlayer player : players) {
      player.setHeroType(heroService.getRandomHero(heroesPool, players.length));
        deckService.getCardsUpToPlayerMax(player);
    }
    this.players = players;
    this.players[0].addWhatCanPlayerDo(ActionEnum.PLAYCARD);
    logger.info(Arrays.toString(this.players));
    logger.info("Игра начата");
  }

  @Override
  public FlatWorldPlayer getPlayerByName(String name) {
    return findPlayer(name);
  }
}
