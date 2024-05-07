package com.example.servingwebcontent.model.games.flatWorld.heroes;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface HeroService {
  List<HeroType> getListOfHeroes();
  HeroType getRandomHero(List<HeroType> heroesPool, int numberOfPlayers);
}
