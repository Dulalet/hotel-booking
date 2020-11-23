package org.example.hotel.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int floor;

    @JsonManagedReference
    @ManyToOne
    private Hotel hotel;

    @JsonManagedReference
    @ManyToOne
    private RoomType roomtype;

    @JsonManagedReference
    @ManyToMany
    private Set<Reservation> reservations;




}
