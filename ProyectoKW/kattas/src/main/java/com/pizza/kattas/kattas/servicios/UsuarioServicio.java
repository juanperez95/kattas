package com.pizza.kattas.kattas.servicios;


import com.pizza.kattas.kattas.entidades.Usuarios;

public interface UsuarioServicio {
    
    public Usuarios buscarUsuarioEmail(String email);

    public Usuarios guardarUsuario(Usuarios user);
}