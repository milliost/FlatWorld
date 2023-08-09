package com.example.servingwebcontent.model.heroes.heroesImpl;

import com.example.servingwebcontent.model.heroes.HeroType;
import com.example.servingwebcontent.model.heroes.Hero;
import lombok.Getter;

@Getter
public class Dragon extends Hero {

    public Dragon(){
        super("Дракон - Король Гербов");
        setHeroType(HeroType.DRAGON);
    }
    @Override
    public boolean win(int player,int param) {
        return param >= 8;
    }
}
