package com.project1.project1;

import com.project1.db.Role;
import com.project1.db.User;
import com.project1.db.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    private UserRepo userRepo;

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        //if (userFromDb != null) {
        //    model.put("userForm", "User exists!");
        //    return "reg";
        //}

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "hello";
    }
}
