package com.pizza.kattas.kattas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.kattas.kattas.entidades.Insumos;
import com.pizza.kattas.kattas.repositorio.InsumosRepositorio;

@Service("InsumosServicio")
public class InsumosServicioImpl implements InsumosServicio{

    @Autowired
    InsumosRepositorio insumosRepo;

    @Override
    public List<Insumos> listarInsumos(String palabra) { // Validar para la busqueda si el valor llega vacio o no.
        if(palabra != null){
            return insumosRepo.findAll(palabra);
        }
        return insumosRepo.findAll();
    }
    // Agregar insumos a la bd
    @Override
    public Insumos agregarInsumo(Insumos insumo) {
        return insumosRepo.save(insumo);
    }
    // Actualizar el insumo
    @Override
    public Insumos actualizarInsumo(Insumos insumo) {
        return insumosRepo.save(insumo);
    }
    // Buscar el insumo por id para la actualizacion del mismo.
    @Override
    public Insumos buscarInsumo(int id) {
        return insumosRepo.findById(id);
    }
    // Eliminar el insumo de la bd.
    @Override
    public void borrarInsumo(int id) {
        insumosRepo.deleteById(id);
    }
    
}
