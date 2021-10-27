/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.controller;

import com.reto3.usa.reto3.entity.Client;
import com.reto3.usa.reto3.entity.Game;
import com.reto3.usa.reto3.service.GameService;
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
@RequestMapping("/api/Game/")
public class GameController {
    @Autowired
    private GameService service;
    
    @GetMapping("all")
    public List<Game>findAllGame(){
        return service.getGameAll();
    }
    
    @PostMapping("save")
    public ResponseEntity addGame(@RequestBody Game game){
        service.saveGame(game);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("update")
    public ResponseEntity updateGame(@RequestBody Game game) {
        service.updateGame(game);
        return ResponseEntity.status(201).build();
    }
    
   /* @DeleteMapping("delete")
    public ResponseEntity deleteGame(@RequestBody Game game) {
        service.deleteGame(game);
        return ResponseEntity.status(204).build();
    } */
    
    @GetMapping("/{id}")
    public Optional<Game> getGame(@PathVariable("id") int id_game){
        return service.getGame(id_game);
        }
        
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id_game){
        service.deleteGame(id_game);
        return ResponseEntity.status(204).build();
    }
}