package com.example.servingwebcontent.model;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.heroes.Hero;
import com.example.servingwebcontent.model.heroes.heroesImpl.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
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

        while (true){
            for (int i=0; i<players.length;i++){
                players[i]
            }
        }
    }
    public Player getPlayer(int i){return players[i];}

    private Hero getRandomHero(int numberOfPlayers){
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
