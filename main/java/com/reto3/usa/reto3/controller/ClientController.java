/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.controller;

import com.reto3.usa.reto3.entity.Client;
import com.reto3.usa.reto3.service.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author G8 grupo 9
 */
@RestController
@RequestMapping("/api/Client/")
public class ClientController {
        @Autowired
        private ClientService service;

        @GetMapping("all")
        public List<Client>findAllClient(){
            return service.getClientAll();
        }

        @PostMapping("save")
        public ResponseEntity addClient(@RequestBody Client client){
            service.saveClient(client);
            return ResponseEntity.status(201).build();
        }

        @PutMapping("update")
        public ResponseEntity updateClient(@RequestBody Client client) {
            service.updateClient(client);
            return ResponseEntity.status(201).build();
        }

        /*@DeleteMapping("delete")
        public ResponseEntity deleteClient(@RequestBody Client client) {
            service.deleteClient(client);
            return ResponseEntity.status(204).build();
        }*/  
        
        @GetMapping("/{id}")
        public Optional<Client> getClient(@PathVariable("id") int id_client){
            return service.getClient(id_client);
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable("id") int id_client){
        service.deleteClient(id_client);
        return ResponseEntity.status(204).build();
    }
}
