package com.project1.Controllers;

import com.project1.Repository.UserRepo;
import com.project1.models.Role;
import com.project1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(User user, BindingResult bindingResult, Model model) {
        User userFromDb = userRepo.findByEmail(user.getEmail());
        if (userFromDb != null) {
            bindingResult.rejectValue("email", "error.email", "User with this Email already exist");
            return ("reg");
        }
        //if (bindingResult.hasErrors()) {
        //    return new ModelAndView("reg");
        //}
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return ("redirect:/hello");
    }
}
