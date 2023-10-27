/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Perfil;
import facades.PerfilFacade;
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
@Named(value = "perfilControlador")
@SessionScoped
public class perfilControlador implements Serializable {

    @EJB
    private PerfilFacade perfilFacade;
    
    private Perfil perfil;
    
    @PostConstruct
    public void init(){
        perfil = new Perfil();
    }
    public perfilControlador() {
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public List<Perfil> consultarPerfil(){
        return perfilFacade.findAll();
    }
    
}
