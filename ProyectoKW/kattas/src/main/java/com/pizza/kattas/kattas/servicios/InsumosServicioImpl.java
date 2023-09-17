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
    public List<Insumos> listarInsumos() {
        return insumosRepo.findAll();
    }

    @Override
    public Insumos agregarInsumo(Insumos insumo) {
        return insumosRepo.save(insumo);
    }

    @Override
    public Insumos actualizarInsumo(Insumos insumo) {
        return insumosRepo.save(insumo);
    }

    @Override
    public Insumos buscarInsumo(int id) {
        return insumosRepo.findById(id).get();
    }

    @Override
    public void borrarInsumo(int id) {
        insumosRepo.deleteById(id);
    }
    
}
