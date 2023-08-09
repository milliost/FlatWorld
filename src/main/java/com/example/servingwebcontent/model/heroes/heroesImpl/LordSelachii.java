package com.example.servingwebcontent.model.heroes.heroesImpl;

import com.example.servingwebcontent.model.heroes.HeroType;
import com.example.servingwebcontent.model.heroes.Hero;
import lombok.Getter;

@Getter
public class LordSelachii extends Hero {

    public LordSelachii(){
        super("Лорд Селачи");
        setHeroType(HeroType.LORD_SELACHII);
    }
    @Override
    public boolean win(int player,int param) {
        if(player==2) return param>=7;
        else if (player==3) return param>=5;
        return  param>=4;
    }
}
