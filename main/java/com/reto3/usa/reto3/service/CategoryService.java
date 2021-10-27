/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Category;
import com.reto3.usa.reto3.entity.Game;
import com.reto3.usa.reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G8 grupo 9
 */
@Service
public class CategoryService {
        @Autowired
        private CategoryRepository repositoryCat;
    
        //Crud - Create - post
        public Category saveCategory(Category category){
                return repositoryCat.save(category);
        }
    
        //Crud - Read - get
        public List<Category> getCategoryAll() {
                return repositoryCat.findAll();
        }
    
        //Crud - Update - put
        public Category updateCategory(Category category) {
                Category existCategory=repositoryCat.findById(category.getId()).orElse(null);
                existCategory.setName(category.getName());
                existCategory.setDescription(category.getDescription());
                return repositoryCat.save(existCategory);
        }

        //Crud - Delete - delete
        public String deleteCategory(int id_category){
                repositoryCat.deleteById(id_category);
                return "Registro de ID: "+id_category+" ha sido eliminado";
        }
        //Metodos con ID
        public Optional <Category> getCategory(int id_category){
                return repositoryCat.findById(id_category);
    }  
}
