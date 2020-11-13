package org.example.hotel.controller;

import org.example.hotel.entity.Role;
import org.example.hotel.entity.User;
import org.example.hotel.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller // This means that this class is a Controller
// @RequestMapping(path="") // This means URL's start with /demo (after Application path)
public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model){
        return "hello";
    }

//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

//    @PostMapping("/registration")
//    public String addUser(User user, Model model) {
//        User userFromDb = userRepo.findByUsername(user.getUsername());
//
//        if (userFromDb != null) {
//            model.addAttribute("message", "User exists!");
//            return "registration";
//        }
//
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        userRepo.save(user);
//
//        return "redirect:/login";
//    }

    @PostMapping("registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb!=null){
            model.put("message", "User Exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }

}
