package org.example.hotel.repository;

import org.example.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
    Hotel findByUsername(String username);
}
