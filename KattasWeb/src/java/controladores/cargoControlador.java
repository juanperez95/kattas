/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Cargo;
import facades.CargoFacade;
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
@Named(value = "cargoControlador")
@SessionScoped
public class cargoControlador implements Serializable {

    @EJB
    private CargoFacade cargoFacade;
    
    private Cargo cargo;
    
    @PostConstruct
    public void init(){
        cargo = new Cargo();
    }
    public cargoControlador() {
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    public List<Cargo> consultarCargo(){
        return cargoFacade.findAll();
    }
}
