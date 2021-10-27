/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Client;
import com.reto3.usa.reto3.entity.CountReservation;
import com.reto3.usa.reto3.entity.Reservation;
import com.reto3.usa.reto3.entity.Cont;
import com.reto3.usa.reto3.repository.ReservationRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G8 grupo 9
 */
@Service
public class ReservationService {
                      
        @Autowired
        private ReservationRepository repositoryR;
    
        //Crud - Create - post
        public Reservation saveReservation(Reservation reservation){
            return repositoryR.save(reservation);
        }
    
        //Crud - Read - get
        public List<Reservation> getReservationAll() {
            return repositoryR.findAll();
        }
    
        //Crud - Update - put
        public Reservation updateReservation(Reservation reservation) {
               Reservation existReservation=repositoryR.findById(reservation.getIdReservation()).orElse(null);
               existReservation.setStartDate(reservation.getStartDate());
               existReservation.setDevolutionDate(reservation.getDevolutionDate());
               return repositoryR.save(existReservation);
        }

        //Crud - Delete - delete
        public String deleteReservation(Reservation reservation){
            repositoryR.deleteById(reservation.getIdReservation());
            return "Registro de ID: "+reservation.getIdReservation()+" ha sido eliminado";
        }

        public List<Reservation> fechaReservation(Calendar inicio, Calendar fin){
            return repositoryR.fechaReservation(inicio, fin);
        }
        
        public Cont countReservationStatus(){
            List<Reservation> Status=repositoryR.findAll();
            int cancelled = 0;
            int completed = 0;
            for (Reservation oneReservation:Status){
                if (oneReservation.getStatus().equals("cancelled")){
                   cancelled+=1; 
                }
                else if (oneReservation.getStatus().equals("completed")){
                    completed+=1;
                }
            }
            Cont statusCont=new Cont();
            statusCont.setCancelled(cancelled);
            statusCont.setCompleted(completed);
            
            return statusCont;
        }
        
        public List<CountReservation> getTopReservation(){
            List<CountReservation> res=new ArrayList<>();

            List<Object[]> report=repositoryR.countTotalClientByReservation();
                for(int i=0;i<report.size();i++){
                    res.add(new CountReservation((Long) report.get(i)[1],(Client)report.get(i)[0] ));
                }
            return res;
        }
}       
     
