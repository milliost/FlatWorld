package com.example.servingwebcontent.model.games.flatWorld.map.districts;

import com.example.servingwebcontent.model.games.flatWorld.map.District;
import org.springframework.stereotype.Component;

@Component
public class DollySisters extends District {

  public DollySisters() {
    super("Сёстры Долли", 1, 6, false, 1, 2, 3, 12);
  }

  @Override
  public void effect() {
  }
}
