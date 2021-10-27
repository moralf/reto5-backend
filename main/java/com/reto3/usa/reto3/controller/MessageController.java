/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.controller;

import com.reto3.usa.reto3.entity.Message;
import com.reto3.usa.reto3.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/Message/")
public class MessageController {
        @Autowired
        private MessageService service;
    
        @GetMapping("all")
        public List<Message>findAllMessage(){
                return service.getMessageAll();
        }
    
        @PostMapping("save")
        public ResponseEntity addMessage(@RequestBody Message message){
                service.saveMessage(message);
                return ResponseEntity.status(201).build();
        }

        @PutMapping("update")
        public ResponseEntity updateMessage(@RequestBody Message message) {
                service.updateMessage(message);
                return ResponseEntity.status(201).build();
        }
    
        @DeleteMapping("delete")
        public ResponseEntity deleteMessage(@RequestBody Message message) {
                service.deleteMessage(message);
                return ResponseEntity.status(204).build();
        }    

        
        
        
        
        
        
        
}
