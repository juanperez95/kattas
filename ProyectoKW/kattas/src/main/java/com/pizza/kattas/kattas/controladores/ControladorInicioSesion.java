package com.pizza.kattas.kattas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pizza.kattas.kattas.servicios.InsumosServicio;
import com.pizza.kattas.kattas.servicios.UsuarioServicio;

@Controller
@RequestMapping("/sesion")
public class ControladorInicioSesion {

    @Autowired
    UsuarioServicio userData;

    @Autowired
    InsumosServicio insumoData;
    
    @GetMapping("/dashboard-user")
    public String dashboard(Model dom){
        dom.addAttribute("usuarios", userData.listarUsuarios());
        return "dashboard";
    }

    // Lista los insumos que hay en la base de datos
    @GetMapping("/dashboard-insumos")
    public String dashboarInsumos(Model modelos){
        modelos.addAttribute("insumos", insumoData.listarInsumos());
        return "dashboard_insumos";
    }
}
