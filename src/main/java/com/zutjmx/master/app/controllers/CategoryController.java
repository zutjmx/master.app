package com.zutjmx.master.app.controllers;

import com.zutjmx.master.app.entities.Category;
import com.zutjmx.master.app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Category>> listaCategorias() {
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
}
