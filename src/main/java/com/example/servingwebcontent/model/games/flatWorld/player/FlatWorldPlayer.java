package com.example.servingwebcontent.model.games.flatWorld.player;

import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import com.example.servingwebcontent.model.games.flatWorld.cards.Card;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@JsonAutoDetect
public class FlatWorldPlayer implements PlayerEndTurnService {

  private String name;
  private int money = 10;
  private int maxCard = 5;
  private HeroType heroType;
  private List<Card> cards = new LinkedList<>();
  private String debuffs;
  private int house = 6;
  private int slave = 12;
  private List<ActionEnum> whatCanPlayerDo = new ArrayList<>();
  private boolean turn = false;

  public void transferFunds(int money) {
    this.money = this.money + money;
  }

  public void writeOffFunds(int money) {
    this.money = this.money - money;
  }

  public Card getCardByIndex(int index) {
    return cards.get(index);
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public void dropCard(int numOfCard) {
    cards.remove(numOfCard);
  }

  public int quantityCard() {
    return cards.size();
  }

  public String arrayOfCards() {
    return cards.toString();
  }

  public void addWhatCanPlayerDo(ActionEnum actionEnum){
    whatCanPlayerDo.add(actionEnum);
  }
  public void playCard(int index){
    whatCanPlayerDo.addAll(cards.get(index).returnActions());
  }

  @Override
  public void setWhatCanPlayerDoToNothing() {
        whatCanPlayerDo.removeIf(actionEnum -> actionEnum != ActionEnum.HAND);
  }

  @Override
  public void addPlayCardAction() {
    whatCanPlayerDo.add(ActionEnum.PLAYCARD);
  }

  @Override
  public String toString() {
    return
        "{"+
        '"'+"name"+'"'  +":"+  '"'+name+'"'+  ","+
        '"'+"money"+'"'  +":"+  +money+ ","+
        '"'+"cards"+'"'  +":"   +cards.size()+","+
        '"'+"debuffs"+'"'  +":"+  '"'+debuffs+'"'+","+
        '"'+"house"+'"'  +":"   +house+","+
        '"'+"slave"+'"'  +":" + slave +","+
        '"'+"turn"+'"'  +":"+  '"'+turn+'"'+","+
        "}";
  }
}
