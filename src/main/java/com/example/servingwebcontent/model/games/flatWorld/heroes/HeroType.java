package com.example.servingwebcontent.model.games.flatWorld.heroes;

import com.example.servingwebcontent.model.games.flatWorld.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum HeroType implements winer{

    CHRYSOPRASE("Хризопраз"),
    DRAGON("Дракон - Король Гербов"),
    VETINARI("Лорд Витинари"),
    VIMES("Командор Ваймс"),
    LORD_RUST("Лорд Ржав"),
    LORD_DE_WORDE("Лорд де Словв"),
    LORD_SELACHII("Лорд Селачи");
    private final String name;

     HeroType(String name) {
        this.name = name;
    }

    @Override
    public boolean win(Player player, int param, int players) {
         switch (player.getHeroType()){
             case CHRYSOPRASE ->{return param>=50;}
             case DRAGON ->{return param>=8;}
             case VETINARI ->
             {
                 if(players==2) return param>=11;
                 else if (players==3) return param>=10;
                 return  param>=9;
             }
             case VIMES ->{return param==0;}
             case LORD_RUST, LORD_DE_WORDE, LORD_SELACHII ->
             {
                 if(players==2) return param>=7;
                 else if (players==3) return param>=5;
                 return  param>=4;
             }
         }
         return false;
    }
    public static List<HeroType> getListOfHeroes(){
         List<HeroType> heroTypeList = new ArrayList<>();
        heroTypeList.add(HeroType.CHRYSOPRASE);
        heroTypeList.add(HeroType.DRAGON);
        heroTypeList.add(HeroType.LORD_DE_WORDE);
        heroTypeList.add(HeroType.LORD_RUST);
        heroTypeList.add(HeroType.LORD_SELACHII);
        heroTypeList.add(HeroType.VETINARI);
        heroTypeList.add(HeroType.VIMES);
        return heroTypeList;
    }
}

