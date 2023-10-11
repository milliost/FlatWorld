package com.example.servingwebcontent.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class ActionsOfPlayers {
    private boolean[] turnOfPlayers = {false,false,false,false};
    private boolean[] ChooseDistrict = {false,false,false,false};
    private int thisPlayer;

    public void startGame(){
        turnOfPlayers[0]=true;
        thisPlayer = 0;
    }
    public void nextPlayer(){
        turnOfPlayers[thisPlayer]=false;
        thisPlayer+=1;
        if(thisPlayer+1==5){thisPlayer=0;}
        turnOfPlayers[thisPlayer]=true;
    }
}
