package com.example.servingwebcontent.model;

import com.example.servingwebcontent.controllers.GameController;
import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.events.CustomSpringEvent;
import com.example.servingwebcontent.model.heroes.HeroType;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
public class Game{
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);
    private Player[] players;
    private int card;
    public Game(User[] users){

        players = new Player[users.length];
        List<HeroType> heroesPool = HeroType.getListOfHeroes();

        for (int i = 0; i<players.length; i++){
            players[i]=new Player();
            players[i].setName(users[i].getName());
            players[i].setMoney(10);
            players[i].getCards();
            players[i].setHeroType(getRandomHero(players.length, heroesPool));
            logger.info(players[i].getHeroType().getName());
        }
    }

    public Player start(){
        while (true) {
            for (Player turnPlayer : players) {
                if (turnPlayer.getHeroType().win(
                        turnPlayer.getHeroType(),
                        players.length,
                        0)) {
                    return turnPlayer;
                } else {
                    We
                    logger.info("ход сделан");
                }
            }
        }
    }

    private HeroType getRandomHero(int numberOfPlayers, List<HeroType> heroesPool){
        switch (numberOfPlayers){
            case 2 ->{
                heroesPool.remove(HeroType.CHRYSOPRASE);
                int random = (int)(Math.random()*6);
                HeroType returnedHero = heroesPool.get(random);
                heroesPool.remove(returnedHero);
                return returnedHero;
            }
            case 3->{
                heroesPool.remove(HeroType.LORD_RUST);
                int random = (int)(Math.random()*6);
                HeroType returnedHero = heroesPool.get(random);
                heroesPool.remove(returnedHero);
                return returnedHero;
            }
            case 4->{
                int random = (int)(Math.random()*6);
                HeroType returnedHero = heroesPool.get(random);
                heroesPool.remove(returnedHero);
                return returnedHero;
            }
        }
        return HeroType.CHRYSOPRASE;
    }
    private void addHeroes(){

    }
}
