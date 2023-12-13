package com.example.servingwebcontent.model.games.flatWorld.cards;

import com.example.servingwebcontent.model.games.flatWorld.cards.Card;
import com.example.servingwebcontent.model.games.flatWorld.cards.CardActions;
import com.example.servingwebcontent.model.games.flatWorld.cards.CardColor;

public class GreenCard extends Card {
    private CardColor cardColor=CardColor.GREEN;

    public GreenCard(String name, CardActions... cardActions) {
        super(name, cardActions);
    }
    public GreenCard(String name,int money, CardActions... cardActions) {
        super(name,money, cardActions);
    }

}
