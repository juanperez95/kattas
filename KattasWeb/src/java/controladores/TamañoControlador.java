/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Tamañoproducto;
import facades.TamañoproductoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Roberto_Diaz
 */
@Named(value = "tamañoControlador")
@SessionScoped
public class TamañoControlador implements Serializable {

    
    @EJB
    TamañoproductoFacade tamañoFacade;
    
    Tamañoproducto tamañoProducto;

    public Tamañoproducto getTamañoProducto() {
        return tamañoProducto;
    }

    public void setTamañoProducto(Tamañoproducto tamañoProducto) {
        this.tamañoProducto = tamañoProducto;
    }
    
    
    
    
    public void init(){
        tamañoProducto = new Tamañoproducto();
    }
    
    public TamañoControlador() {
    }
    
    public List<Tamañoproducto> consultarTamaño(){
        return tamañoFacade.findAll();
    }
}
