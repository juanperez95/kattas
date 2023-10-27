/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Habilitado;
import facades.HabilitadoFacade;
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
@Named(value = "habilitadoControlador")
@SessionScoped
public class habilitadoControlador implements Serializable {

    @EJB
    private HabilitadoFacade habilitadoFacade;
    
    private Habilitado habilitado;
    
    @PostConstruct
    public void init(){
        habilitado = new Habilitado();
    }
    public habilitadoControlador() {
    }

    public Habilitado getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Habilitado habilitado) {
        this.habilitado = habilitado;
    }
    
    public List<Habilitado> consultarHabilitado(){
        return habilitadoFacade.findAll();
    }
}
