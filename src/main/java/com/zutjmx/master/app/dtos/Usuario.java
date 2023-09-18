package com.zutjmx.master.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String username;
    private String email;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
}
