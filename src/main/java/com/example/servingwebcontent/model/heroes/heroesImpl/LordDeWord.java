package com.example.servingwebcontent.model.heroes.heroesImpl;

import com.example.servingwebcontent.model.heroes.HeroType;
import com.example.servingwebcontent.model.heroes.Hero;
import lombok.Getter;

@Getter
public class LordDeWord extends Hero {

    public LordDeWord(){
        super("Лорд де Словв");
        setHeroType(HeroType.LORD_DE_WORDE);
    }
    @Override
    public boolean win(int player,int param) {
        if(player==2) return param>=7;
        else if (player==3) return param>=5;
        return  param>=4;
    }
}
