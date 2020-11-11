package org.example.hotel.repository;

import org.example.hotel.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepo extends JpaRepository<Guest, Long> {
    Guest findByEmail(String email);
}
