package com.example.servingwebcontent.model.games.flatWorld.cards;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;


@Getter
public abstract class Card{
    private String name;
    private int money;
    private ActionEnum first;
    private ActionEnum second;
    private ActionEnum third;
    private ActionEnum fourth;
    private ActionEnum fifth;

    public Card(String name, ActionEnum... actionEnum) {
        this.name = name;
        switch (actionEnum.length){
            case 5 -> fifth = actionEnum[4];
            case 4 -> fourth = actionEnum[3];
            case 3 -> third = actionEnum[2];
            case 2 -> second = actionEnum[1];
            case 1 -> first = actionEnum[0];
        }
    }
    public Card(String name, int money, ActionEnum... actionEnum) {
      this(name, actionEnum);
      this.money = money;
    }


  public List<ActionEnum> returnActions() {
    ActionEnum[] actionEnum = new ActionEnum[5];
        actionEnum[0] = first;
        actionEnum[1] = second;
        actionEnum[2] = third;
        actionEnum[3] = fourth;
        actionEnum[4] = fifth;
        return Arrays.stream(actionEnum).toList();
    }

    @Override
    public String toString(){
        return name;
    }
}
