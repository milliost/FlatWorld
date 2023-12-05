package com.example.servingwebcontent.model.games.flatWorld;

import com.example.servingwebcontent.controllers.game.LobbyController;
import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroType;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.Turn;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl.TurnInFlatWorldImpl;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
public class Game{

    private final static long id = 0;
    private static final Logger logger = LoggerFactory.getLogger(LobbyController.class);
    private Player[] players;
    private List<HeroType> heroesPool = HeroType.getListOfHeroes();
    private Turn turn;
    public Game(User[] users){

        players = new Player[users.length];

        for (int i = 0; i<players.length; i++){
            players[i]=new Player();
            players[i].setName(users[i].getName());
            players[i].setMoney(10);
            players[i].getCards();
            players[i].setHeroType(getRandomHero(players.length, heroesPool));
            logger.info(players[i].getHeroType().getName());
            start();
        }
    }

    private void start(){
        turn = new TurnInFlatWorldImpl(players.length, 0);
    }
    public void nextTurn(String userName){
        if( turn.itIsMyTurn( getIntByUserName(userName) ) ) turn.nextTurn();
    }
    private int getIntByUserName(String userName){
        for (int i=0; i<players.length; i++){
            if (players[i].getName().equals(userName)) return i;
        }
        return -1;
    }

    private HeroType getRandomHero(int numberOfPlayers, List<HeroType> heroesPool){
        switch (numberOfPlayers){
            case 2 ->{
                heroesPool.remove(HeroType.CHRYSOPRASE);
                heroesPool.remove(HeroType.LORD_RUST);
                int random = (int)(Math.random()*heroesPool.size());
                HeroType returnedHero = heroesPool.get(random);
                heroesPool.remove(returnedHero);
                return returnedHero;
            }
            case 3->{
                heroesPool.remove(HeroType.LORD_RUST);
                int random = (int)(Math.random()*heroesPool.size());
                HeroType returnedHero = heroesPool.get(random);
                heroesPool.remove(returnedHero);
                return returnedHero;
            }
            case 4->{
                int random = (int)(Math.random()*heroesPool.size());
                HeroType returnedHero = heroesPool.get(random);
                heroesPool.remove(returnedHero);
                return returnedHero;
            }
        }
        return HeroType.CHRYSOPRASE;
    }
}
