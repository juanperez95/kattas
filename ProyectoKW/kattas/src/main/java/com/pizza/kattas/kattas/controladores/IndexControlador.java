package com.pizza.kattas.kattas.controladores;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pizza.kattas.kattas.entidades.Insumos;
import com.pizza.kattas.kattas.entidades.Usuarios;
import com.pizza.kattas.kattas.servicios.InsumosServicio;
import com.pizza.kattas.kattas.servicios.UsuarioServicio;

@Controller
public class IndexControlador {

    @Autowired
    InsumosServicio insumoServicio;

    @Autowired
    UsuarioServicio userServicio;
    // Agregar roles predeterminados al dar la ruta por metodo get.
    @GetMapping("/addroles")
    public String index(Model modelo) {
        List<Usuarios> listaUser = new ArrayList();
        listaUser.add(new Usuarios(10, "juan", "perez", "3213217777", "admin@gmail.com", "1995-08-19", "Masculino", "Suba", "Compartir", "Cra 115", "321", "role_admin"));
        listaUser.add(new Usuarios(20, "sergio", "pinzon", "3213217777", "emp@gmail.com", "2004-08-19", "Masculino", "Fontibon", "No se", "Cra 115", "321", "role_emp"));
        listaUser.add(new Usuarios(30, "jayson", "vargas", "3213217777", "user@gmail.com", "2001-08-19", "Masculino", "Engativa", "No se", "Cra 115", "321", "role_user"));
        Insumos in = new Insumos("jamon", "carnes", "existente", 0, Date.valueOf("2023-08-19"), Date.valueOf("2023-08-20"));
        insumoServicio.agregarInsumo(in);
        for(Usuarios user : listaUser){
            userServicio.guardarUsuario(user);
        }
        return "redirect:/home";
    }
    // Pagina de inicio 
    @GetMapping({"/","home"})
    public String home(Model dom){
        dom.addAttribute("usuario", new Usuarios());
        return "registro";
    }

    @PostMapping("/registro")
    public String registroUsuario(@ModelAttribute("usuario") Usuarios usuario, Model dom ){
        // Insertar desde el formulario de clientes el rol usuario
        usuario.setRol("role_user");
        userServicio.guardarUsuario(usuario);
        return "redirect:/inicio-sesion?exito";
    }

    @GetMapping("/inicio-sesion")
    public String login(){
        return "login";
    }
}
