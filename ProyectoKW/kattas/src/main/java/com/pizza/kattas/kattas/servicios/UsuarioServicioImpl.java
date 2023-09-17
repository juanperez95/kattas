package com.pizza.kattas.kattas.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.kattas.kattas.entidades.Usuarios;
import com.pizza.kattas.kattas.repositorio.UsuarioRepo;

@Service("UsuarioServicio")
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    UsuarioRepo userRepo;

    @Override
    public Usuarios buscarUsuarioEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios user) {
        return userRepo.save(user);
    }



    
    
}
