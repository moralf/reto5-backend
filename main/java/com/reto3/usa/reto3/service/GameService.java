/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Client;
import com.reto3.usa.reto3.entity.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto3.usa.reto3.repository.GameRepository;
import java.util.Optional;

/**
 *
 * @author G8 grupo 9
 */
@Service
public class GameService {
    @Autowired
    private GameRepository repositoryG;
    
    //Crud - Create - post
    public Game saveGame(Game game){
        return repositoryG.save(game);
    }
    
    //Crud - Read - get
    public List<Game> getGameAll() {
        return repositoryG.findAll();
    }
    
    //Crud - Update - put
    public Game updateGame(Game game) {
        Game existGame=repositoryG.findById(game.getId()).orElse(null);
        existGame.setName(game.getName());
        existGame.setDeveloper(game.getDeveloper());
        existGame.setYear(game.getYear());
        existGame.setDescription(game.getDescription());
        return repositoryG.save(existGame);
    }

    //Crud - Delete - delete
    public String deleteGame(int id_game){
        repositoryG.deleteById(id_game);
        return "Registro de ID: "+id_game+" ha sido eliminado";
    }
    
    //Metodos con ID
    public Optional <Game> getGame(int id_game){
        return repositoryG.findById(id_game);
    }  
}
