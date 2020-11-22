package org.example.hotel.controller;

import org.example.hotel.config.StringToDateConversion;
import org.example.hotel.entity.Employee;
import org.example.hotel.entity.Guest;
import org.example.hotel.entity.Reservation;
import org.example.hotel.service.EmployeeService;
import org.example.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@PreAuthorize("hasAuthority('USER') or hasAuthority('MANAGER') or hasAuthority('ADMIN')")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public String viewReservations(Model model){
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "th_reservationindex";
    }

    @GetMapping("/newReservation")
    public String showNewReservationForm(Model model){
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "th_newReservation";
    }

    @PostMapping("/saveReservation")
    public String saveEmployee(@ModelAttribute("reservation") Reservation reservation){
//        if (reservation.getCheckInDate() >= reservation.getCheckOutDate()){
//
//        }

//        reservation.setCheckInDate(StringToDateConversion.getDayMonthYearFromStringDate(reservation.getCheckInDate()));
        reservationService.saveReservation(reservation);
        return "redirect:/reservations";
    }

}
