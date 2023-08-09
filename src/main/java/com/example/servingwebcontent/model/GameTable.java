package com.example.servingwebcontent.model;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameTable {
    private UserService us;
    private User[] chairs = new User[5];

    public void sitOnChair(int numOfChair,User user){
        chairs[getChair(user)]=null;
        chairs[numOfChair]=getCurrentUser();
    }

    public void startGame(){
        Game game= new Game(makeUserArrayForGame());
        game.start();
    }


    public User[] makeUserArrayForGame(){

        int k =0;
        for(int i = 0; i<chairs.length; i++){
            if (chairs[i]!=null) k++;
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
            if(chairs[i].getName().equals(user.getName())) return i;
        }
        return -1;
    }
    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return us.findByName(auth.getName());
    }
}
