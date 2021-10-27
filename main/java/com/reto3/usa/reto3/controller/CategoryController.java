/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.controller;

import com.reto3.usa.reto3.entity.Category;
import com.reto3.usa.reto3.entity.Game;
import com.reto3.usa.reto3.service.CategoryService;
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
@RequestMapping("/api/Category/")
public class CategoryController {
        @Autowired
        private CategoryService service;
    
        @GetMapping("all")
        public List<Category>findAllCategory(){
                return service.getCategoryAll();
        }
    
        @PostMapping("save")
        public ResponseEntity addCategory(@RequestBody Category category){
                service.saveCategory(category);
                return ResponseEntity.status(201).build();
        }

        @PutMapping("update")
        public ResponseEntity updateCategory(@RequestBody Category category) {
                service.updateCategory(category);
                return ResponseEntity.status(201).build();
        }
    
        @GetMapping("/{id}")
        public Optional<Category> getCategoty(@PathVariable("id") int id_category){
            return service.getCategory(id_category);
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable("id") int id_category){
            service.deleteCategory(id_category);
            return ResponseEntity.status(204).build();
    }
}
