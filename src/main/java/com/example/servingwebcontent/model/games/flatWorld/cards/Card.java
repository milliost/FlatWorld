package com.example.servingwebcontent.model.games.flatWorld.cards;

import jakarta.validation.constraints.Null;
import lombok.Getter;


@Getter
public abstract class Card {
    private final String name;
    private CardActions first;
    private CardActions second;
    private CardActions third;
    private CardActions fourth;
    private CardActions fifth;
    private int money;

    public Card(String name, CardActions... cardActions) {
        this.name = name;
        switch (cardActions.length){
            case 5 -> fifth = cardActions[4];
            case 4 -> fourth = cardActions[3];
            case 3 -> third = cardActions[2];
            case 2 -> second = cardActions[1];
            case 1 -> first = cardActions[0];
        }
    }

    public Card(String name, int money, CardActions... cardActions) {
        this(name, cardActions);
        this.money = money;
    }

    public CardActions[] returnActions() {
        CardActions[] actions = new CardActions[5];
        actions[0] = first;
        actions[1] = second;
        actions[2] = third;
        actions[3] = fourth;
        actions[4] = fifth;
        return actions;
    }
    @Override
    public String toString(){
        return name;
    }
}
