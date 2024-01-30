/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Categoria;
import facades.CategoriaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Roberto_Diaz
 */
@Named(value = "categoriaControlador")
@SessionScoped
public class categoriaControlador implements Serializable {

    @EJB
    CategoriaFacade categoriaFacade;

    Categoria categoria;

    @PostConstruct
    public void init() {
        categoria = new Categoria();
    }

    public categoriaControlador() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public List<Categoria> consultarCategorias(){
        return  categoriaFacade.findAll();
    }
}
