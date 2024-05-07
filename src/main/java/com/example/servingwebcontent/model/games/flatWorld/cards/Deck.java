package com.example.servingwebcontent.model.games.flatWorld.cards;

import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.KILL;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.MONEY;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.NEXTCARD;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.POLICE;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.PROPERTY;
import static com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum.SERVITOR;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class Deck implements DeckService {

  private Card[] deck = new Card[101];
  private GreenCard[] green = new GreenCard[48];
  private BrownCard[] brown = new BrownCard[53];

  private Cataclysme cataclysme;

  public Deck() {
    makeGreenCards();
    shuffle(green);
    shuffle(brown);
    System.arraycopy(green, 0, deck, 0, green.length);
    System.arraycopy(brown, 0, deck, green.length, brown.length);
  }

  @Override
  public void getCardsUpToPlayerMax(FlatWorldPlayer player) {
    if (player.getCards().size() < player.getMaxCard()) {
      for (int i = 0; i < (player.getMaxCard() - player.getCards().size()); i++) {
        player.addCard(takeFirstNotNullCardFromDeck());
      }

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
    return null;
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

}
