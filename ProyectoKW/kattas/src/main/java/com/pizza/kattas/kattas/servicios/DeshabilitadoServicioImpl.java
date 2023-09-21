package com.pizza.kattas.kattas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.kattas.kattas.entidades.InsumoDisabled;

import com.pizza.kattas.kattas.repositorio.DeshabilitadoRepositorio;
@Service
public class DeshabilitadoServicioImpl implements DeshabilitadoServicio {

@Autowired
DeshabilitadoRepositorio deshDatos;

    @Override
    public List<InsumoDisabled> listarDeshabilitados() {
        return deshDatos.findAll();
    }

    @Override
    public InsumoDisabled guardarDeshabilitados(InsumoDisabled insumos) {
        return deshDatos.save(insumos);
    }

    @Override
    public void borrarDeshabilitados(int id) {
        deshDatos.deleteById(id);
    }

    @Override
    public InsumoDisabled buscarDeshabilitado(int id) {
        return deshDatos.findById(id).get();
    }
    
}
