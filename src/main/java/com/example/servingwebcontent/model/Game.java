package com.example.servingwebcontent.model;

import com.example.servingwebcontent.controllers.game.LobbyController;
import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.Cards.Card;
import com.example.servingwebcontent.model.Cards.CardActions;
import com.example.servingwebcontent.model.heroes.HeroType;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
@Setter
public class Game{
    private final static long id = 0;
    private static final Logger logger = LoggerFactory.getLogger(LobbyController.class);
    private Player[] players;
    private ActionsOfPlayers actionsOfPlayers;
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

    public void start(){
        actionsOfPlayers.startGame();
    }

    public void playCard(Card card){
        for(CardActions action : card.returnActions()){
            if(action==null){break;}
            else {
                switch (action){
                    case SERVITOR -> actionsOfPlayers.
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
}
