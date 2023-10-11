package com.example.servingwebcontent.model.Cards.Green;

import com.example.servingwebcontent.model.Cards.CardActions;
import com.example.servingwebcontent.model.Cards.Card;
import org.springframework.stereotype.Component;

@Component
public class MrGrill extends Card {
    private final int money = 1;

    public MrGrill(){
        setFirst(CardActions.KILL);
        setSecond(CardActions.MONEY);
    }

    public int getMoney(){
        return money;
    }
}
