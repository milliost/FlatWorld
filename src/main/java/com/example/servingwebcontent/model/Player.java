package com.example.servingwebcontent.model;

import com.example.servingwebcontent.model.Cards.Card;
import com.example.servingwebcontent.model.heroes.Hero;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Player {

    private String name;
    private int money;
    private ArrayList<Card> cards;
    private String debuffs;
    private Hero hero;
}
