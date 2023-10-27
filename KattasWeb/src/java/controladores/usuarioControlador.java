/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Cargo;
import entidades.Habilitado;
import entidades.Perfil;
import entidades.Usuario;
import facades.CargoFacade;
import facades.HabilitadoFacade;
import facades.PerfilFacade;
import facades.UsuarioFacade;
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
@Named(value = "usuarioControlador")
@SessionScoped
public class usuarioControlador implements Serializable {

    private Usuario usuario;
    private Habilitado habilitado;
    private Perfil perfil;
    private Cargo cargo;
    
    @EJB
    private UsuarioFacade usuFacade;
    @EJB
    private CargoFacade cargoFacade;
    @EJB
    private PerfilFacade perfilFacade;
    @EJB
    private HabilitadoFacade habilitadoFacade;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        habilitado= new Habilitado();
        cargo=new Cargo();
        perfil=new Perfil();
    }
    
    public usuarioControlador() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habilitado getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Habilitado habilitado) {
        this.habilitado = habilitado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    
    public String agregarUsuario(){
        usuario.setFkPerfil(perfilFacade.find(perfil.getIdPerfil()));
        usuario.setFkHabilitado(habilitadoFacade.find(habilitado.getIdHabilitado()));
        usuario.setFkidCargo(cargoFacade.find(cargo.getIdCargo()));
        usuFacade.create(usuario);
        usuario = new Usuario();
        return "usuarioConsultar";
        
    }
    
    public List<Usuario> consultarUsuario(){
        return usuFacade.findAll();
    }
    
    public String preEditar(Usuario usuario){
        this.usuario= usuario;
        return "usuarioEditar";
    }
    public String editar(){
        usuFacade.edit(usuario);
        usuario = new Usuario();
        return "usuarioConsultar";
        
    }
    public void eliminar(Usuario usuario){
        usuFacade.remove(usuario);
        
    }
    
    
}
