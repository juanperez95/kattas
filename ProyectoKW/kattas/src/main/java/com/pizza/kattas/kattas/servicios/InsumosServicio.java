package com.pizza.kattas.kattas.servicios;

import java.util.List;

import com.pizza.kattas.kattas.entidades.Insumos;

public interface InsumosServicio {
    
    public List<Insumos> listarInsumos(String palabra);
    public Insumos agregarInsumo(Insumos insumo);
    public Insumos actualizarInsumo(Insumos insumo);
    public Insumos buscarInsumo(int id);
    public void borrarInsumo(int id);
}
