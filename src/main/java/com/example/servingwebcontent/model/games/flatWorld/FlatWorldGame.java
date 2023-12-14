package com.example.servingwebcontent.model.games.flatWorld;

import com.example.servingwebcontent.controllers.game.LobbyController;
import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.games.abstraction.Player;
import com.example.servingwebcontent.model.games.flatWorld.cards.Card;
import com.example.servingwebcontent.model.games.flatWorld.cards.Deck;
import com.example.servingwebcontent.model.games.flatWorld.comandHandler.CardCommandHandler;
import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import com.example.servingwebcontent.model.games.flatWorld.entities.evilEntity.Demon;
import com.example.servingwebcontent.model.games.flatWorld.entities.evilEntity.Ogr;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.CanPlayerDoAction;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroType;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl.TurnInFlatWorldImpl;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FlatWorldGame {

    private final static long id = 0;
    private CanPlayerDoAction canPlayerDoAction;
    private CardCommandHandler cardCommandHandler;
    private FlatWorldPlayer[] flatWorldPlayers;
    private List<HeroType> heroesPool = HeroType.getListOfHeroes();
    private List<Entity> demonsAndOgres = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(LobbyController.class);
    private Deck deck;

    public FlatWorldGame(Player[] players) {

        deck = new Deck();
        flatWorldPlayers = new FlatWorldPlayer[players.length];
        for (int i = 0; i < flatWorldPlayers.length; i++) {
            flatWorldPlayers[i] = new FlatWorldPlayer(
                    players[i].getName(),
                    getRandomHero(flatWorldPlayers.length, heroesPool));

            while (flatWorldPlayers[i].quantityCard() < 5) flatWorldPlayers[i].addCard(deck.takeCard());

            logger.info(flatWorldPlayers[i].getHeroType().getName());
            logger.info(flatWorldPlayers[i].arrayOfCards());
        }
        makeDemonsAndOgres();
        start();
    }

    public void nextTurn(String userName) {
        if (canPlayerDoAction.itIsMyTurn(userName)) canPlayerDoAction.nextTurn();
    }

    private void start() {
        canPlayerDoAction = new TurnInFlatWorldImpl(flatWorldPlayers, flatWorldPlayers[0]);
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

    private void makeDemonsAndOgres() {
        for (int i = 0; i < 4; i++) {
            if (i < 3) {
                Demon d = new Demon();
                Ogr o = new Ogr();
                demonsAndOgres.add(d);
                demonsAndOgres.add(o);
            } else {
                Demon d = new Demon();
                demonsAndOgres.add(d);
            }
        }
    }

    public void playCard(String player, int cardIndexFromThePlayersHand) {
        for (FlatWorldPlayer flatWorldPlayer1 : flatWorldPlayers) {
            if (flatWorldPlayer1.getName().equals(player)) {
                Card playedCard = flatWorldPlayer1.getCardByIndex(cardIndexFromThePlayersHand);

            }

        }
    }

    private FlatWorldPlayer getPlayerByName(String name) {
        for (FlatWorldPlayer flatWorldPlayer : flatWorldPlayers) {
            if (flatWorldPlayer.getName().equals(name)) return flatWorldPlayer;
        }
        return null;
    }
}
