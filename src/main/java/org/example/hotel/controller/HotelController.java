package org.example.hotel.controller;


import org.example.hotel.entity.Role;
import org.example.hotel.entity.User;
import org.example.hotel.repository.HotelRepo;
import org.example.hotel.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/hotels")
@PreAuthorize("hasAuthority('ADMIN')")
public class HotelController {
    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping
    public String hotelList(Model model) {
        model.addAttribute("hotels", hotelRepo.findAll());
        return "th_hotels";
    }
}
