/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Client;
import com.reto3.usa.reto3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G8 grupo 9
 */
@Service
public class ClientService{
        @Autowired
        private ClientRepository repositoryC;

        //Crud - Create - post
        public Client saveClient(Client client){
            return repositoryC.save(client);
        }

        //Crud - Read - get
        public List<Client> getClientAll() {
            return repositoryC.findAll();
        }

        //Crud - Update - put
        public Client updateClient(Client client) {
            Client existClient=repositoryC.findById(client.getIdClient()).orElse(null);
            existClient.setEmail(client.getEmail());
            existClient.setPassword(client.getPassword());
            existClient.setName(client.getName());
            existClient.setAge(client.getAge());
            return repositoryC.save(existClient);
        }

        //Crud - Delete - delete
        public String deleteClient(int id_client){
            repositoryC.deleteById(id_client);
            return "Registro de ID: "+id_client+" ha sido eliminado";
        }
        
        //Metodos con ID
        public Optional <Client> getClient(int id_client){
            return repositoryC.findById(id_client);
        }      
}
