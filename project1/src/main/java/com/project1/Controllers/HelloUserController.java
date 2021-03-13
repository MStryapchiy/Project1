package com.project1.Controllers;

import com.project1.Repository.UserRepo;
import com.project1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HelloUserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/HelloUser")
    public String HelloUser(Model model, User user) {
        model.addAttribute("useruser", userRepo.findByUsername(user.getUsername()));
        return "HelloUser";
    }
}
