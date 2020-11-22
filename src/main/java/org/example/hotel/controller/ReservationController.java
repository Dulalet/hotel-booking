package org.example.hotel.controller;

import org.example.hotel.entity.Guest;
import org.example.hotel.service.EmployeeService;
import org.example.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String viewReservations(Model model){
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "th_reservationindex";
    }



}
