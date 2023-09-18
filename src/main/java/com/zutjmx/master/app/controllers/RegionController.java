package com.zutjmx.master.app.controllers;

import com.zutjmx.master.app.entities.Region;
import com.zutjmx.master.app.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regiones")
public class RegionController {
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Region>> listaRegiones() {
        return new ResponseEntity<List<Region>>(regionRepository.findAll(), HttpStatus.OK);
    }
}
