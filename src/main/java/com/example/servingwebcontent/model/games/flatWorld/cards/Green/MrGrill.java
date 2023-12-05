package com.example.servingwebcontent.model.games.flatWorld.cards.Green;

import com.example.servingwebcontent.model.games.flatWorld.CardActions;
import com.example.servingwebcontent.model.games.flatWorld.cards.Card;
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
