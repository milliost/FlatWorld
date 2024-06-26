package com.example.servingwebcontent.model.games.flatWorld.map;

import com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity.House;
import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.cards.Card;
import com.example.servingwebcontent.model.games.flatWorld.entities.Entity;
import com.example.servingwebcontent.model.games.flatWorld.entities.EntityType;
import com.example.servingwebcontent.model.games.flatWorld.entities.evilEntity.Demon;

import com.example.servingwebcontent.model.games.flatWorld.entities.playerEntity.Slave;
import java.util.ArrayList;
import java.util.List;

public abstract class District{
    private String name;
    private int number;
    private int housePrice;
    private boolean conflict;
    private int[] numbersOfNeighboringDistricts;
    private FlatWorldPlayer ownerOfHouse;
    private List<Entity> entities= new ArrayList<>();

    public District(String name, int number, int housePrice, boolean conflict, int... numbersOfNeighboringDistricts){
        this.name=name;
        this.number=number;
        this.housePrice=housePrice;
        this.numbersOfNeighboringDistricts=numbersOfNeighboringDistricts;
    }

    public void addConflict(){
        conflict=true;
    }
    public void removeConflict(){
        if(!entities.contains(new Demon())) conflict=false;//переопределить метод equals для entity через enum type=Demon
    }
    
    public boolean buyHouse(FlatWorldPlayer buyer){
        if(!conflict && buyer.getMoney() >= housePrice && buyer.getHouse() > 0){
            buyer.writeOffFunds(housePrice);
            ownerOfHouse = buyer;
            entities.add(new House(ownerOfHouse));
            return true;
        }else{ 
            return false;
            
        }
    }
    
    public boolean buyHouse(FlatWorldPlayer buyer, Card card){//тут должно быть ветление на Взяткера, телку которая выкупает без конфликта и того чела за пол цены
            if(card.getName().equals("Взяткер Позолот")){

                if(ownerOfHouse!=null && conflict && buyer.getMoney() >= housePrice && buyer.getHouse()>0){
                    ownerOfHouse.transferFunds(housePrice);
                    buyer.writeOffFunds(housePrice);
                    ownerOfHouse=buyer;
                    return true;
                }else
                    return false;
            } return false;
    }


    public void addEntity(Entity entity){
        entities.add(entity);
    }
    public abstract void effect();
    public void kill(FlatWorldPlayer player){
        for (Entity slave: entities){
            if(slave.getEntityType()== EntityType.SLAVE){
                Slave newSlave = (Slave) slave;
                if (newSlave.getOwner()==player){
                    entities.remove(slave);
                    break;
                }
            }
        }

    }
}
        