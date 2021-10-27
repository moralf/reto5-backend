/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto3.usa.reto3.repository;

import com.reto3.usa.reto3.entity.Reservation;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author G8 grupo 9
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    
    @Query("SELECT r FROM Reservation r WHERE startDate BETWEEN ?1 AND ?2")
    List<Reservation> fechaReservation(Calendar inicio, Calendar fin);
    
    /*@Query("SELECT r FROM Reservation r WHERE status='completed' or 'cancelled'")
    List<Reservation> Reservation(status);*/
    
   /* @Query("SELECT r FROM Reservation r order by idReservation desc")
    List<Reservation> findAllAsc();*/
    
    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
    List<Object[]> countTotalClientByReservation();

}
