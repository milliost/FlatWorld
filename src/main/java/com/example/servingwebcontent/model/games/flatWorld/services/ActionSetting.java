package com.example.servingwebcontent.model.games.flatWorld.services;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.Instruction;

public interface ActionSetting {
  Instruction setAndPlay(FlatWorldPlayer player, Instruction Instruction);
}
