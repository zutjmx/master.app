package com.zutjmx.master.app.services;

import com.github.javafaker.Faker;
import com.zutjmx.master.app.dtos.LoginForm;
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
        if ((usuario.equals("zutjmx") && password.equals("sistemas")) ||
            (usuario.equals("admin") && password.equals("sysadmin"))) {
            autenticado = true;
        }
        respuestaDto.setCodigo(autenticado?1:0);
        respuestaDto.setMensaje(autenticado?"Bienvenido usuario ".concat(usuario):"Usuario o contraseña incorrectos");
        return respuestaDto;
    }

    public RespuestaDto loginArreglo(LoginForm loginForm) {
        RespuestaDto respuestaDto = new RespuestaDto();
        LoginForm usuarioAutenticado = new LoginForm();
        boolean autenticado = false;
        List<LoginForm> loginForms = new ArrayList<>();
        loginForms.add(new LoginForm("zutjmx","sistemas"));
        loginForms.add(new LoginForm("sysadmin","linux"));
        loginForms.add(new LoginForm("dba","mariadb"));
        loginForms.add(new LoginForm("devops","devopsagile"));
        for (LoginForm login: loginForms) {
            if (login.getUsuario().equals(loginForm.getUsuario()) && login.getPassword().equals(loginForm.getPassword())) {
                autenticado = true;
                usuarioAutenticado.setUsuario(login.getUsuario());
                usuarioAutenticado.setPassword(login.getPassword());
                break;
            }
        }
        respuestaDto.setCodigo(autenticado?1:0);
        respuestaDto.setMensaje(autenticado?"Bienvenido usuario ".concat(usuarioAutenticado.getUsuario()):"Usuario o contraseña incorrectos");
        return respuestaDto;
    }

    public RespuestaDto loginOperadorTernario(LoginForm loginForm) {
        RespuestaDto respuestaDto = new RespuestaDto();
        boolean autenticado = (loginForm.getUsuario().equals("zutjmx") && loginForm.getPassword().equals("sistemas"))? true:false;
        respuestaDto.setCodigo(autenticado?1:0);
        respuestaDto.setMensaje(autenticado?"Bienvenido usuario ".concat(loginForm.getUsuario()):"Usuario o contraseña incorrectos");
        return respuestaDto;
    }
}
