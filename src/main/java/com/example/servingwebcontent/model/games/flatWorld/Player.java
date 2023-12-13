package com.example.servingwebcontent.model.games.flatWorld;

import com.example.servingwebcontent.model.games.flatWorld.cards.Card;
import com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity.House;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player{

    private final String name;
    private int money =10;
    private HeroType heroType;
    private List<Card> cards= new ArrayList<>();
    private String debuffs;
    private int house = 6;
    private int slave = 12;

    public Player(String name, HeroType heroType){
        this.name=name;
        this.heroType=heroType;
    }

    public void transferFunds(int money){
        this.money=this.money + money;
    }
    public void writeOffFunds(int money){
        this.money=this.money - money;
    }
    public void swapHero(HeroType heroType){
        this.heroType=heroType;
    }
    public Card getCardByIndex(int index){return cards.get(index);}
    public void addCard(Card card){
        cards.add(card);
    }
    public void dropCard(int numOfCard){
        cards.remove(numOfCard);
    }
    public int quantityCard(){ return cards.size();}
    public String arrayOfCards(){return cards.toString();}

    public House getObjHouse(){
            house=-1;
            return new House(this);
    }
}
