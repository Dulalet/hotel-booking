package org.example.hotel.service;

import org.example.hotel.entity.Reservation;
import org.example.hotel.entity.Reservation;
import org.example.hotel.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void saveReservation(Reservation reservation) {
        this.reservationRepo.save(reservation);
    }

    public Reservation getReservationById(long id) {
        Optional<Reservation> optional = reservationRepo.findById(id);
        Reservation reservation = null;
        if(optional.isPresent()){
            reservation = optional.get();
        }
        else{
            throw new RuntimeException(" Reservation not found by this id :: " + id);
        }
        return reservation;
    }

    public void deleteReservationById(long id) {
        this.reservationRepo.deleteById(id);
    }

}
