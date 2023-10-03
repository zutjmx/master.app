package com.zutjmx.master.app.controllers;

import com.zutjmx.master.app.dtos.LoginForm;
import com.zutjmx.master.app.dtos.RespuestaDto;
import com.zutjmx.master.app.dtos.Usuario;
import com.zutjmx.master.app.services.FakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public ResponseEntity<RespuestaDto> login(@RequestBody LoginForm loginForm) {
        RespuestaDto respuestaDto = fakerService.login(loginForm.getUsuario(), loginForm.getPassword());
        return new ResponseEntity<>(respuestaDto, respuestaDto.getCodigo()==1? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }

    @PostMapping("/login-arreglo")
    public ResponseEntity<RespuestaDto> loginArreglo(@RequestBody LoginForm loginForm) {
        RespuestaDto respuestaDto = fakerService.loginArreglo(loginForm);
        return new ResponseEntity<>(respuestaDto, respuestaDto.getCodigo()==1? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }

    @PostMapping("/login-operador-ternario")
    public ResponseEntity<RespuestaDto> loginOperadorTernario(@RequestBody LoginForm loginForm) {
        RespuestaDto respuestaDto = fakerService.loginOperadorTernario(loginForm);
        return new ResponseEntity<>(respuestaDto, respuestaDto.getCodigo()==1? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }
}
