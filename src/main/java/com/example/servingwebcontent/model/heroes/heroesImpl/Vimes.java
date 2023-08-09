package com.example.servingwebcontent.model.heroes.heroesImpl;

import com.example.servingwebcontent.model.heroes.HeroType;
import com.example.servingwebcontent.model.heroes.Hero;
import lombok.Getter;

@Getter
public class Vimes extends Hero {

    public Vimes(){
        super("Командор Ваймс");
        setHeroType(HeroType.VETINARI);
    }
    @Override
    public boolean win(int player,int param) {
        return param == 0;
    }
}
