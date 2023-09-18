package com.zutjmx.master.app.controllers;

import com.zutjmx.master.app.dtos.RespuestaDto;
import com.zutjmx.master.app.dtos.Usuario;
import com.zutjmx.master.app.services.FakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/faker")
public class FakerController {
    @Autowired
    private FakerService fakerService;

    @GetMapping("/nombre-completo")
    public ResponseEntity<RespuestaDto> getNombreCompleto() {
        return new ResponseEntity<>(fakerService.generaNombreCompleto(), HttpStatus.OK);
    }

    @GetMapping("listar-usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return new ResponseEntity<>(fakerService.listaDeUsuarios(), HttpStatus.OK);
    }
}
