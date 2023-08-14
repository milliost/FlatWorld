package com.example.servingwebcontent.model;

import com.example.servingwebcontent.config.WebSocketEventListener;
import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.heroes.Hero;
import com.example.servingwebcontent.model.heroes.heroesImpl.*;
import com.example.servingwebcontent.service.UserService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private WebSocketEventListener WSEL;
    private UserService us;
    private Player[] players;

    private Chrysoprase chrysoprase;
    private Dragon dragon;
    private LordDeWord lordDeWord;
    private LordRust lordRust;
    private LordSelachii lordSelachii;
    private Vetinari vetinari;
    private Vimes vimes;
    public Game(User[] users){
        players = new Player[users.length];
        for (int i = 0; i<players.length; i++){
            players[i]=new Player();
            players[i].setName(users[i].getName());
            players[i].setMoney(10);
            players[i].getCards();
            players[i].setHero(getRandomHero(players.length));

        }
    }

    public void start(){
        boolean win = false;
        while (!win){
            for (Player turnPlayer : players) {
                if (turnPlayer.getHero().win(players.length, 5)){
                    us.addWin();
                    win = true;
                } else {
                    WSEL.h();
                }
            }

        }
    }
    public Player getPlayer(int i){return players[i];}

    private Hero getRandomHero(int numberOfPlayers){//дописать т.к. герои повторяются
        if (numberOfPlayers==2){
        Hero[] heroes =new Hero[]{dragon,lordDeWord,lordRust,lordSelachii,vetinari,vimes};
        return heroes[(int)(Math.random()*6)];}

        else if (numberOfPlayers==3) {
            Hero[] heroes =new Hero[]{chrysoprase,dragon,lordDeWord,lordSelachii,vetinari,vimes};
            return heroes[(int)(Math.random()*6)];}

        else{
            Hero[] heroes =new Hero[]{chrysoprase,dragon,lordDeWord, lordRust,lordSelachii,vetinari,vimes};
            return heroes[(int)(Math.random()*7)];
        }
    }
}
