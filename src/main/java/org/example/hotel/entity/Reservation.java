package org.example.hotel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int guestNum;
    private Date checkInDate;
    private Date checkOutDate;
    @ManyToOne
    private Guest guest;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Room> rooms = new HashSet<Room>();


}
