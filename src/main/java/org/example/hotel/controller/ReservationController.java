package org.example.hotel.controller;

import org.example.hotel.config.StringToDateConversion;
import org.example.hotel.entity.*;
import org.example.hotel.repository.GuestRepo;
import org.example.hotel.repository.RoomRepo;
import org.example.hotel.repository.RoomTypeRepo;
import org.example.hotel.service.EmployeeService;
import org.example.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@PreAuthorize("hasAuthority('USER') or hasAuthority('MANAGER') or hasAuthority('ADMIN')")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private GuestRepo guestRepo;
    @Autowired
    private RoomTypeRepo roomTypeRepo;
    @Autowired
    private RoomRepo roomRepo;

    @GetMapping("/reservations")
    public String viewReservations(Model model){
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "th_reservationindex";
    }

    @GetMapping("/newReservation")
    public String showNewReservationForm(Model model){
        Hotel hotel = new Hotel();
        Reservation reservation = new Reservation();
        Guest guest = new Guest();
        List<String> HotelList = Arrays.asList("Ritz Carlton Almaty", "St Regis Astana", "Rixos President Astana", "Rixos Almaty");
        model.addAttribute("reservation", reservation);
        List<String> RoomTypeList = Arrays.asList("Single", "Double", "Family", "Luxe");
        model.addAttribute("HotelList", HotelList);
        model.addAttribute("RoomTypeList", RoomTypeList);
        model.addAttribute("reservation", reservation);
        model.addAttribute("hotel", hotel);
        model.addAttribute("guest", guest);
        return "th_newReservation";
    }

    @PostMapping("/saveReservation")
    public String saveEmployee(Model model,
                               @ModelAttribute("reservation") Reservation reservation,
                               @ModelAttribute("guest") Guest guest,
                               @ModelAttribute("roomType") RoomType roomType,
                               @ModelAttribute("room") Room room){
        reservation.setGuest(guest);
//        roomType.setRooms((Set<Room>) room);
//        room.setReservations((Set<Reservation>) reservation);

        reservationService.saveReservation(reservation);
        guestRepo.save(guest);
        roomTypeRepo.save(roomType);
        roomRepo.save(room);

        return "redirect:/hello";
    }

//    @GetMapping("/reservationUpdate/{id}")
//    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
//        Reservation reservation = reservationService.getReservationById(id);
//        model.addAttribute("employee", reservation);
//        return "th_update_reservation";
//    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        this.reservationService.deleteReservationById(id);
        return "redirect:/reservations";
    }

//    @GetMapping("/newguest")
//    public String newGuestPage(Model model){
//        Guest guest = new Guest();
//        model.addAttribute("guest", guest);
//        return "newGuest";
//    }
//
//    @PostMapping("addguest")
//    public String addGuest(@ModelAttribute("reservation") Reservation reservation){
//
//    }

}
