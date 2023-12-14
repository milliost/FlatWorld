package com.example.servingwebcontent.controllers.others;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.service.UserDTOService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@AllArgsConstructor
public class UsersController {

    private UserDTOService userService;
    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @PostMapping("/users")
    public String usersFind(@RequestParam(name = "email", required=false) String email, Model model){
        if(email.equals("all")) return users(model);
        else {
        User user = userService.findAllUsers().stream().filter(user1 -> user1.getEmail().equals(email)).findAny().orElse(null);
        model.addAttribute("users", user);
        return "users";
        }
    }
    @ResponseBody
    @GetMapping("/myName")
    public String myName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth.getName();
    }
}
