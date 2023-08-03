package com.example.servingwebcontent.game;

import com.example.servingwebcontent.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class GameTable {
    private List<User> Users=new ArrayList<>();
    private User[] chairs = new User[4];
    private boolean[] ready = new boolean[4];
    public void addUser(User user){
        Users.add(user);
    }
    public List<User> getUsers(){
        return Users;
    }
    public void sit(int numberOfChair, User user){
        if (chairs[numberOfChair]==null) {
            chairs[numberOfChair]=user;
        }
    }
    public int getNumberOfChairs(User user){
        for(int i=0; i<4; i++){
            if (chairs[i]==user);
            return i;
        }
        return -1;
    }
    public void setReady(User user){
        ready[getNumberOfChairs(user)]=true;
    }
}
