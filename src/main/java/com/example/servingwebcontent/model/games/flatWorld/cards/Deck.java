package com.example.servingwebcontent.model.games.flatWorld.cards;

import io.micrometer.common.lang.Nullable;

import java.util.Random;

public class Deck {
    private Card[] deck = new Card[101];
    private GreenCard[] green = new GreenCard[48];
    private BrownCard[] brown = new BrownCard[53];

    public Deck() {
        makeGreenCards();
        shuffle(green);
        shuffle(brown);
        System.arraycopy(green, 0, deck, 0, green.length);
        System.arraycopy(brown, 0, deck, green.length, brown.length);
    }

    /**
     * @return
     * null если колода карт пуста
     */
    @Nullable
    public Card takeCard() {
        for (int i = 0; i < deck.length; i++){
            if(deck[i]!=null){
                Card temp = deck[i];
                deck[i]=null;
                return temp;
            }
        }
        return null;
    }

    private void makeGreenCards() {
        green[0] = new GreenCard("Мистр Грыль", 1, CardActions.KILL, CardActions.MONEY);
        green[1] = new GreenCard("Гроши", CardActions.SERVITOR);
        green[2] = new GreenCard("Библиотекарь", CardActions.PROPERTY);
        green[3] = new GreenCard("Бригада пожарных", CardActions.PROPERTY, CardActions.NEXTCARD);
        green[4] = new GreenCard("Доктор Проблемс", 3, CardActions.KILL, CardActions.MONEY);
        green[5] = new GreenCard("Тётушки Милосердия", 2, CardActions.KILL, CardActions.MONEY, CardActions.SERVITOR);
        green[6] = new GreenCard("Сержант Ангва", CardActions.POLICE, CardActions.NEXTCARD);
        green[7] = new GreenCard("Капитан Моркоу", 1, CardActions.SERVITOR, CardActions.POLICE, CardActions.MONEY);
        green[8] = new GreenCard("Человек - утка", CardActions.PROPERTY);
        green[9] = new GreenCard("Клуб Розовая кошечка",3,CardActions.MONEY,CardActions.NEXTCARD);

    }

    private void shuffle(Card[] cards) {
        Random rnd = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int random = rnd.nextInt(i + 1);
            Card temp = cards[random];
            cards[random] = cards[i];
            cards[i] = temp;
        }
    }
}
