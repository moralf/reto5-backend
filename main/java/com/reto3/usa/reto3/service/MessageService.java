/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Message;
import com.reto3.usa.reto3.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G8 grupo 9
 */
@Service
public class MessageService {
        @Autowired
        private MessageRepository repositoryM;
        
        //Crud - Create - post
        public Message saveMessage(Message message){
                return repositoryM.save(message);
        }
        
        //Crud - Read - get
        public List<Message> getMessageAll() {
                return repositoryM.findAll();
            }
    
        //Crud - Update - put
        public Message updateMessage(Message message) {
                Message existMessage=repositoryM.findById(message.getIdMessage()).orElse(null);
                existMessage.setMessageText(message.getMessageText());
                return repositoryM.save(existMessage);
        }

        //Crud - Delete - delete
        public String deleteMessage(Message message){
                repositoryM.deleteById(message.getIdMessage());
                return "Registro de ID: "+message.getIdMessage()+" ha sido eliminado";
        }
}
