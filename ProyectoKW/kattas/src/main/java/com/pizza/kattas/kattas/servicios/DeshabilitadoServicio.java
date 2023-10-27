package com.pizza.kattas.kattas.servicios;

import java.util.List;

import com.pizza.kattas.kattas.entidades.InsumoDisabled;

public interface DeshabilitadoServicio {
    public List <InsumoDisabled> listarDeshabilitados();
    public InsumoDisabled guardarDeshabilitados(InsumoDisabled insumos);
    public void borrarDeshabilitados(int id);
    public InsumoDisabled buscarDeshabilitado(int id);
}
