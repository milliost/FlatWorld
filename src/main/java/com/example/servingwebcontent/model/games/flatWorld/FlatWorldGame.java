package com.example.servingwebcontent.model.games.flatWorld;

import com.example.servingwebcontent.model.games.flatWorld.cards.Deck;
import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.CanPlayerDoAction;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroType;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class FlatWorldGame {

  private final static long id = 0;
  private FlatWorldPlayer[] players;
  private List<HeroType> heroesPool;
  private List<Entity> demonsAndOgres;
  private Deck deck;
  private CanPlayerDoAction canPlayerDoAction;

  public void start(FlatWorldPlayer[] players) {
    for (FlatWorldPlayer player : players) {
      player.setHeroType(getRandomHero(players.length, heroesPool));

      while (player.quantityCard() < 5) {
        player.addCard(deck.takeCard());
      }

    }
    canPlayerDoAction.start(players, players[0]);
  }

  private HeroType getRandomHero(int numberOfPlayers, List<HeroType> heroesPool) {
    switch (numberOfPlayers) {
      case 2 -> {
        heroesPool.remove(HeroType.CHRYSOPRASE);
        heroesPool.remove(HeroType.LORD_RUST);
        int random = (int) (Math.random() * heroesPool.size());
        HeroType returnedHero = heroesPool.get(random);
        heroesPool.remove(returnedHero);
        return returnedHero;
      }
      case 3 -> {
        heroesPool.remove(HeroType.LORD_RUST);
        int random = (int) (Math.random() * heroesPool.size());
        HeroType returnedHero = heroesPool.get(random);
        heroesPool.remove(returnedHero);
        return returnedHero;
      }
      case 4 -> {
        int random = (int) (Math.random() * heroesPool.size());
        HeroType returnedHero = heroesPool.get(random);
        heroesPool.remove(returnedHero);
        return returnedHero;
      }
    }
    return HeroType.CHRYSOPRASE;
  }
}
