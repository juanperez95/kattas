package com.pizza.kattas.kattas.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizza.kattas.kattas.entidades.Insumos;

@Repository("InsumosRepo")
public interface InsumosRepositorio extends JpaRepository<Insumos,Serializable>{
    
}
