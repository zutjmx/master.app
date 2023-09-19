package com.zutjmx.master.app.services;

import com.github.javafaker.Faker;
import com.zutjmx.master.app.dtos.RespuestaDto;
import com.zutjmx.master.app.dtos.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class FakerService {
    private Faker faker = new Faker(new Locale("es-MX"));

    public RespuestaDto generaNombreCompleto() {
        RespuestaDto respuestaDto = new RespuestaDto();
        respuestaDto.setCodigo(1);
        respuestaDto.setMensaje(faker.name().fullName());
        return respuestaDto;
    }

    public List<Usuario> listaDeUsuarios() {
        List<Usuario> usuarioList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Usuario usuario = new Usuario();
            String username = faker.name().username();
            String email = username.concat("@").concat(faker.internet().domainName());
            usuario.setUsername(username);
            usuario.setNombre(faker.name().firstName());
            usuario.setApellidoPaterno(faker.name().lastName());
            usuario.setApellidoMaterno(faker.name().lastName());
            usuario.setEmail(email);
            usuarioList.add(usuario);
        }
        return usuarioList;
    }

    public RespuestaDto login(String usuario, String password) {
        RespuestaDto respuestaDto = new RespuestaDto();
        boolean autenticado = false;
        if (usuario.equals("zutjmx") && password.equals("sistemas")) {
            autenticado = true;
        }
        respuestaDto.setCodigo(autenticado?1:0);
        respuestaDto.setMensaje(autenticado?"Login exitoso":"Login fallido");
        return respuestaDto;
    }
}
