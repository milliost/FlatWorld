package com.example.servingwebcontent.model.games.flatWorld.map.districts;

import com.example.servingwebcontent.model.games.flatWorld.map.District;

public class DollySisters extends District {
    public DollySisters(String name, int number, int housePrice, boolean conflict, int... numbersOfNeighboringDistricts) {
        super(name, number, housePrice, conflict, numbersOfNeighboringDistricts);
    }

    @Override
    public void effect() {

    }
}
