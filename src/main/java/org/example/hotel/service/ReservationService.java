package org.example.hotel.service;

import org.example.hotel.entity.Employee;
import org.example.hotel.entity.Reservation;
import org.example.hotel.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private final ReservationRepo reservationRepo;

    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }
}
