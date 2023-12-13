package com.example.servingwebcontent.model.games.flatWorld;

import com.example.servingwebcontent.controllers.game.LobbyController;
import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.games.flatWorld.cards.Deck;
import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import com.example.servingwebcontent.model.games.flatWorld.entities.evilEntity.Demon;
import com.example.servingwebcontent.model.games.flatWorld.entities.evilEntity.Ogr;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroType;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.Turn;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl.TurnInFlatWorldImpl;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {

    private final static long id = 0;
    private Turn turn;
    private Player[] players;
    private List<HeroType> heroesPool = HeroType.getListOfHeroes();
    private List<Entity> demonsAndOgres = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(LobbyController.class);
    private Deck deck;

    public Game(User[] users) {

        deck = new Deck();
        players = new Player[users.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(
                    users[i].getName(),
                    getRandomHero(players.length, heroesPool));

            while (players[i].quantityCard()<5) players[i].addCard(deck.takeCard());

            logger.info(players[i].getHeroType().getName());
            logger.info(players[i].arrayOfCards());
        }
        makeDemonsAndOgres();
        start();
    }

    public void nextTurn(String userName) {
        if (turn.itIsMyTurn(userName)) turn.nextTurn();
    }

    private void start() {
        turn = new TurnInFlatWorldImpl(players, players[0]);
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

    public void playCard(ChatMessage cm) {
        if (turn.itIsMyTurn(cm.getSender())) {
            int numberOfCard = Integer.parseInt(cm.getContent());
            String sender = cm.getSender();
            getPlayerByName(sender).getCards();

        }

    }

    private Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) return player;
        }
        return null;
    }
}
