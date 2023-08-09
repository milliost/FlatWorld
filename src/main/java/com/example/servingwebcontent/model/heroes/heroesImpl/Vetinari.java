package com.example.servingwebcontent.model.heroes.heroesImpl;

import com.example.servingwebcontent.model.heroes.HeroType;
import com.example.servingwebcontent.model.heroes.Hero;
import lombok.Getter;

@Getter
public class Vetinari extends Hero {

    public Vetinari(){
        super("Лорд Витинари");
        setHeroType(HeroType.VETINARI);
    }
    @Override
    public boolean win(int player,int param) {
        if(player==2) return param>=11;
        else if (player==3) return param>=10;
        return  param>=9;
    }
}
