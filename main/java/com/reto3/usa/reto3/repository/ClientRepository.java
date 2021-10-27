/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto3.usa.reto3.repository;

import com.reto3.usa.reto3.entity.Client;
import com.reto3.usa.reto3.entity.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author G8 grupo 9
 */
public interface ClientRepository extends JpaRepository<Client, Integer>{

   
}
