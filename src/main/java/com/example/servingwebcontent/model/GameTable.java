package com.example.servingwebcontent.model;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameTable {
    private UserService us;
    private User[] chairs = new User[5];

    public void sitOnChair(int numOfChair,User user){
        int chairNow = getChair(user); //выдает -1 когда юзер только подключился
        if(chairNow!=-1){chairs[chairNow]=null;} //проверка на -1
        chairs[numOfChair]=user;
    }
    public void upChair(int numOfChair){
        chairs[numOfChair]=null;
    }
    public User[] makeUserArrayForGame(){

        int k =0;
        for (User user : chairs) {
            if (user != null) k++;
        }

        User[] userArrayForGame = new User[k];

        int i = 0;
        for (User chair : chairs) {

            if (chair != null) {
                userArrayForGame[i] = chair;
                i++;
            }

        }

        return userArrayForGame;
    }
    private int getChair(User user){
        for(int i=0; i<chairs.length; i++){
            if(chairs[i]!=null && chairs[i]==user){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chairs.length; i++){
            sb.append(i).append(" ");
            if(chairs[i]!=null){
                sb.append(chairs[i].getName()).append(" ");
            }else sb.append("null ");
        }
        return sb.toString();
    }
}

