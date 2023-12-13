package com.example.servingwebcontent.model.games.flatWorld.cards;

import com.example.servingwebcontent.model.games.flatWorld.cards.Card;
import com.example.servingwebcontent.model.games.flatWorld.cards.CardActions;
import com.example.servingwebcontent.model.games.flatWorld.cards.CardColor;

public class BrownCard extends Card {
    private CardColor cardColor=CardColor.BROWN;

    public BrownCard(String name, CardActions... cardActions) {
        super(name, cardActions);
    }
    public BrownCard(String name,int money, CardActions... cardActions) {
        super(name,money, cardActions);
    }
}
