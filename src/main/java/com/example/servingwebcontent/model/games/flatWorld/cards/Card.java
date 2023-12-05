package com.example.servingwebcontent.model.games.flatWorld.cards;

import com.example.servingwebcontent.model.games.flatWorld.CardActions;
import lombok.Setter;

@Setter
public abstract class Card {
    private CardActions first;
    private CardActions second;
    private CardActions third;
    private CardActions fourth;
    private CardActions fifth;
    public CardActions[] returnActions(){
        CardActions[] actions = new CardActions[5];
        actions[0]=first;
        actions[1]=second;
        actions[2]=third;
        actions[3]=fourth;
        actions[4]=fifth;
        return actions;
    }
}
