package com.example.servingwebcontent.model.heroes.heroesImpl;

import com.example.servingwebcontent.model.heroes.HeroType;
import com.example.servingwebcontent.model.heroes.Hero;
import lombok.Getter;

@Getter
public class LordRust extends Hero {

    public LordRust(){
        super("Лорд Ржав");
        setHeroType(HeroType.LORD_RUST);
    }
    @Override
    public boolean win(int player,int param) {
        if(player==2) return param>=7;
        else if (player==3) return param>=5;
        return  param>=4;
    }
}
