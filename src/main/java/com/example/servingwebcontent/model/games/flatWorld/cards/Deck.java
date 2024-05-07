package com.example.servingwebcontent.model.games.flatWorld.cards;

import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.HOME;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.KILL;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.MONEY;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.NEXTCARD;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.POLICE;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.PROPERTY;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.SERVITOR;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import java.util.Arrays;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Deck implements DeckService {

  private Card[] deck = new Card[13];
  private GreenCard[] green = new GreenCard[11];
  private BrownCard[] brown = new BrownCard[2];

  private Logger logger = LoggerFactory.getLogger(Deck.class);
  private Cataclysme cataclysme;

  public Deck() {
    makeGreenCards();
    makeBrownCards();
    shuffle(green);
    shuffle(brown);
    System.arraycopy(green, 0, deck, 0, green.length);
    System.arraycopy(brown, 0, deck, green.length, brown.length);
    logger.info(toString());
  }

  @Override
  public void getCardsUpToPlayerMax(FlatWorldPlayer player) {
    while (player.getMaxCard()!=player.getCards().size()){
      player.addCard(takeFirstNotNullCardFromDeck());
    }
  }

  private Card takeFirstNotNullCardFromDeck() {
    for (int i = 0; i < deck.length; i++) {
      if (deck[i] != null) {
        Card temp = deck[i];
        deck[i] = null;
        return temp;
      }
    }
    return new GreenCard("этой краты не должно быть",0,MONEY);
  }

  private void makeGreenCards() {
    green[0] = new GreenCard("Мистр Грыль", 1, KILL, MONEY);
    green[1] = new GreenCard("Гроши", SERVITOR);
    green[2] = new GreenCard("Библиотекарь", PROPERTY);
    green[3] = new GreenCard("Бригада пожарных", PROPERTY, NEXTCARD);
    green[4] = new GreenCard("Доктор Проблемс", 3, KILL, MONEY);
    green[5] = new GreenCard("Тётушки Милосердия", 2, KILL, MONEY, SERVITOR);
    green[6] = new GreenCard("Сержант Ангва", POLICE, NEXTCARD);
    green[7] = new GreenCard("Капитан Моркоу", 1, SERVITOR, POLICE, MONEY);
    green[8] = new GreenCard("Человек - утка", PROPERTY);
    green[9] = new GreenCard("Клуб Розовая кошечка", 3, MONEY, NEXTCARD);
    green[10] = new GreenCard("Доктор Белолицый", PROPERTY, SERVITOR);

  }
  private void makeBrownCards(){
    brown[0] = new BrownCard("Привет", KILL,KILL, HOME);
    brown[1] = new BrownCard("Сержант Детрид",POLICE,POLICE);
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

  @Override
  public String takeCataclysmeCard() {
    return cataclysme.getName();
  }

  @Override
  @Lookup
  public Deck getDeck() {
    return null;
  }

  @Override
  public String toString() {
    return "Deck{" +
        "deck=" + Arrays.toString(deck) +
        '}';
  }
}
