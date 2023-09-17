package com.pizza.kattas.kattas.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pizza.kattas.kattas.servicios.InsumosServicio;

@Controller
public class IndexControlador {

    @Autowired
    InsumosServicio insumoServicio;

    @GetMapping("/")
    public String index(Model modelo) {
        modelo.addAttribute("insumos", insumoServicio.listarInsumos());
        return "dashboard_insumos";
    }

}
