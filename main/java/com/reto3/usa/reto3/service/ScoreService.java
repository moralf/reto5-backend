/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Score;
import com.reto3.usa.reto3.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G8 grupo 9
 */
@Service
public class ScoreService {
        @Autowired
        private ScoreRepository repositoryS;

        //Crud - Create - post
        public Score saveScore(Score score){
            return repositoryS.save(score);
        }

        //Crud - Read - get
        public List<Score> getScoreAll() {
            return repositoryS.findAll();
        }

        //Crud - Update - put
        public Score updateScore(Score score) {
            Score existScore=repositoryS.findById(score.getId()).orElse(null);
            existScore.setCalification(score.getCalification());
            existScore.setMessage(score.getMessage());
            return repositoryS.save(existScore);
        }

        //Crud - Delete - delete
        public String deleteScore(Score score){
                repositoryS.deleteById(score.getId());
                return "Registro de ID: "+score.getId()+" ha sido eliminado";
        }
}
