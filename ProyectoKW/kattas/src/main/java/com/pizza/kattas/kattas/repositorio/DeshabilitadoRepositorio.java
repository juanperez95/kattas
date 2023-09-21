package com.pizza.kattas.kattas.repositorio;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizza.kattas.kattas.entidades.InsumoDisabled;



@Repository("InsumoDesha")
public interface DeshabilitadoRepositorio extends JpaRepository <InsumoDisabled,Serializable> {
    
}
