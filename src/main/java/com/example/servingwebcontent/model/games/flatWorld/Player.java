package com.example.servingwebcontent.model.games.flatWorld;

import com.example.servingwebcontent.model.games.flatWorld.cards.Card;
import com.example.servingwebcontent.model.games.flatWorld.heroes.HeroType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@Component
public class Player{

    private String name;
    private int money;
    private ArrayList<Card> cards;
    private String debuffs;
    private HeroType heroType;
}
