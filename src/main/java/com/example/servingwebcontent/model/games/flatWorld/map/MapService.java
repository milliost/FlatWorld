package com.example.servingwebcontent.model.games.flatWorld.map;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;

public interface MapService {

  void addSlave(int district, FlatWorldPlayer flatWorldPlayer);
  void addConflict(int district);
  void buyHouse(int district, FlatWorldPlayer flatWorldPlayer);
  void kill(int district, FlatWorldPlayer player);
  void removeConflict(int district);

}
