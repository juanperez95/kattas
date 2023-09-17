package com.pizza.kattas.kattas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pizza.kattas.kattas.entidades.Insumos;
import com.pizza.kattas.kattas.servicios.InsumosServicio;

@Controller
public class IndexControlador {

    @Autowired
    InsumosServicio insumoServicio;

    @GetMapping("/")
    public String index(Model modelo) {
        Insumos insumo = new Insumos("Jamon","Carnes","Existente",10,null,null);
        insumoServicio.agregarInsumo(insumo);
        return "login";
    }

}
