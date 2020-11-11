package org.example.hotel.controller;

import org.example.hotel.entity.Guest;
import org.example.hotel.repository.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller // This means that this class is a Controller
@RequestMapping(path="") // This means URL's start with /demo (after Application path)

public class LoginController {
    @Autowired
    private GuestRepo guestRepo;

    @GetMapping("")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model){
        return "hello";
    }

    @GetMapping("/registration")
    public String register(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Guest guest, Map<String, Object> model){
        Guest guestFromDB = guestRepo.findByEmail(guest.getEmail());

        if (guestFromDB != null){
            model.put("message", "User exists");
            return "registration";
        }

        guestRepo.save(guest);
        return "redirect:/login";
    }

}
