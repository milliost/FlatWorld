package com.example.servingwebcontent.model.games.flatWorld.player;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class FlatWorldPlayerServiceImpl implements FlatWorldPlayersService {

  @Override
  @Lookup
  public FlatWorldPlayer getPlayer() {
    return null;
  }
}
