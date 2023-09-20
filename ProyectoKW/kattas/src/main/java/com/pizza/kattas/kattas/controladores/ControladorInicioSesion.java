package com.pizza.kattas.kattas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.kattas.kattas.entidades.Insumos;
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
    @GetMapping("/dashboard-insumos") // Recoger parametro desde metodo get para validar si se realiza una busqueda
    public String dashboarInsumos(Model modelos, @RequestParam(name = "palabra", required = false) String palabra){
        modelos.addAttribute("insumos", insumoData.listarInsumos(palabra));
        modelos.addAttribute("adicionarInsumo", new Insumos());
        return "dashboard_insumos";
    }

    // Ruta para crear el insumo.
    @PostMapping("/add-insumo")
    public String addInsumo(@ModelAttribute("adicionarInsumo") Insumos insumo, Model modelo){
        insumoData.agregarInsumo(insumo);
        return "redirect:/sesion/dashboard-insumos?exito"; // Si fue exitoso imprime un mensaje de insumo agregado!.
    }
    // Actualzar el insumo.
    @PostMapping("/update-insumo")
    public String actualizarInsumos(@ModelAttribute("update_insumo") Insumos insumo){
        insumoData.actualizarInsumo(insumo);
        return "redirect:/sesion/dashboard-insumos?exito_actualizado";
    }

    // Eliminar un insumo
    @GetMapping("/eliminar-insumo/{id}")
    public String borrarInsumos(@PathVariable("id") int id){
        insumoData.borrarInsumo(id);
        return "redirect:/sesion/dashboard-insumos?exito_borrado"; // Indicar que fue borrado el insumo.
    }
}