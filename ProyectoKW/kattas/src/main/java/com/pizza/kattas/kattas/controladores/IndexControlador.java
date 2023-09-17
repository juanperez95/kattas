package com.pizza.kattas.kattas.controladores;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pizza.kattas.kattas.entidades.Usuarios;
import com.pizza.kattas.kattas.servicios.InsumosServicio;
import com.pizza.kattas.kattas.servicios.UsuarioServicio;

@Controller
public class IndexControlador {

    @Autowired
    InsumosServicio insumoServicio;

    @Autowired
    UsuarioServicio userServicio;

    @GetMapping("/addroles")
    public String index(Model modelo) {
        List<Usuarios> listaUser = new ArrayList();
        listaUser.add(new Usuarios("10", "juan", "perez", "admin@gmail.com", "123", "role_admin"));
        listaUser.add(new Usuarios("20", "jayson", "vargas", "empl@gmail.com", "123", "role_emp"));
        listaUser.add(new Usuarios("30", "sergio", "pinzon", "user@gmail.com", "123", "role_user"));
        modelo.addAttribute("insumos", insumoServicio.listarInsumos());
        for(Usuarios user : listaUser){
            userServicio.guardarUsuario(user);
        }
        return "redirect:/home?addrol";
    }

    @GetMapping({"/","home"})
    public String home(){
        return "dashboard";
    }

}
