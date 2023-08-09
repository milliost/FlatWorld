package com.example.servingwebcontent.model.heroes.heroesImpl;

import com.example.servingwebcontent.model.heroes.HeroType;
import com.example.servingwebcontent.model.heroes.Hero;
import lombok.Getter;

@Getter
public class Chrysoprase extends Hero {

     public Chrysoprase(){
         super("Хризопраз");
         setHeroType(HeroType.CHRYSOPRASE);
     }
    @Override
    public boolean win(int player,int param) {
        return param >= 50;
    }
}
