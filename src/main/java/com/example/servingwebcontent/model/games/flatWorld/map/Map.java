package com.example.servingwebcontent.model.games.flatWorld.map;

import com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity.Slave;
import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Map implements MapService {

  List<District> districts;

  @Override
  public void addSlave(int indexOfDistrict, FlatWorldPlayer player) {
    districts.get(indexOfDistrict).addEntity(new Slave(player));
  }

  @Override
  public void addConflict(int indexOfDistrict) {
    districts.get(indexOfDistrict).addConflict();
  }

  @Override
  public void buyHouse(int indexOfDistrict, FlatWorldPlayer flatWorldPlayer) {
    districts.get(indexOfDistrict).buyHouse(flatWorldPlayer);
  }

  @Override
  public void kill(int district, FlatWorldPlayer player){
    districts.get(district).kill(player);
  }

  @Override
  public void removeConflict(int indexOfDistrict) {
    districts.get(indexOfDistrict).removeConflict();
  }
}

