/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Estado;
import facades.EstadoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Roberto_Diaz
 */
@Named(value = "estadoControlador")
@SessionScoped
public class EstadoControlador implements Serializable {

    @EJB
    EstadoFacade estadoFacade;
    
    Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
    public void init(){
        estado = new Estado();
    }
    
    public EstadoControlador() {
    }
    
    public List<Estado> consultarEstados(){
        return estadoFacade.findAll();
    }
}
