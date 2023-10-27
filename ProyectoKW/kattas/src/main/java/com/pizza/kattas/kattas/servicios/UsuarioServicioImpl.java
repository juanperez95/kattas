package com.pizza.kattas.kattas.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.kattas.kattas.entidades.Usuarios;
import com.pizza.kattas.kattas.repositorio.UsuarioRepo;

@Service("UsuarioServicio")
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    UsuarioRepo userRepo;

    @Override
    public Usuarios buscarUsuarioEmail(String correo) {
        return userRepo.findByCorreo(correo);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios user) {
        return userRepo.save(user);
    }
    // Listar a los usuarios para mostrara desde la base de datos
    @Override
    public List<Usuarios> listarUsuarios() {
        return userRepo.findAll();
    }
    // Actualizar a un usuario
    @Override
    public Usuarios actualizarUsuarios(Usuarios user) {
        return userRepo.save(user);
    }
    // Buscar a un usuarios por su id.
    @Override
    public Usuarios buscarUsuarioId(int id) {
        return userRepo.findById(id);
    }
    //  Eliminar a un usuario.
    @Override
    public void borrarUsuario(int id) {
        userRepo.deleteById(id);
    }



    
    
}
