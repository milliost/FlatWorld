package com.example.servingwebcontent.model.games.flatWorld.heroes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HeroServiceImpl implements HeroService {

  @Override
  @Bean
  public List<HeroType> getListOfHeroes() {
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
  @Override
  public HeroType getRandomHero(List<HeroType> heroesPool, int numberOfPlayers) {
    switch (numberOfPlayers) {
      case 2 -> {
        heroesPool.remove(HeroType.CHRYSOPRASE);
        heroesPool.remove(HeroType.LORD_RUST);
        int random = (int) (Math.random() * heroesPool.size());
        HeroType returnedHero = heroesPool.get(random);
        heroesPool.remove(returnedHero);
        return returnedHero;
      }
      case 3 -> {
        heroesPool.remove(HeroType.LORD_RUST);
        int random = (int) (Math.random() * heroesPool.size());
        HeroType returnedHero = heroesPool.get(random);
        heroesPool.remove(returnedHero);
        return returnedHero;
      }
      case 4 -> {
        int random = (int) (Math.random() * heroesPool.size());
        HeroType returnedHero = heroesPool.get(random);
        heroesPool.remove(returnedHero);
        return returnedHero;
      }
    }
    return HeroType.CHRYSOPRASE;
  }
}
