package com.pizza.kattas.kattas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizza.kattas.kattas.entidades.Usuarios;

@Repository("UsuarioRepo")
public interface UsuarioRepo extends JpaRepository<Usuarios,String>{
    
    public Usuarios findByCorreo(String correo);
}
