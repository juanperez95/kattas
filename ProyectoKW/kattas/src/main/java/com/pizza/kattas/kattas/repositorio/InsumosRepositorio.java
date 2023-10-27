package com.pizza.kattas.kattas.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pizza.kattas.kattas.entidades.Insumos;

@Repository("InsumosRepo")
public interface InsumosRepositorio extends JpaRepository<Insumos,Serializable>{
    // Sentencia nativa para buscar insumo por nombre o categoria.
    @Query(value = "SELECT * FROM insumos isu WHERE isu.nombre LIKE %?1% OR isu.categoria LIKE %?1%", nativeQuery=true)
    public List<Insumos> findAll(String palabraClave);
    public Insumos findById(int id);
}
