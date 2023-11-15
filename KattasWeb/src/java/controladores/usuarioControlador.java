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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Roberto_Diaz
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class usuarioControlador implements Serializable {

    private Usuario usuario, usuarioSesion;
    private Habilitado habilitado;
    private Perfil perfil;
    private Cargo cargo;
    private int identificacion=0;
    private String email, clave;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
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
        usuarioSesion = this.retornoSesion();
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
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
    
    
    public String agregarUsuario() throws ParseException{
        Date fecha = new Date();        
        DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechaTemporal = formato.format(fecha);
        usuario.setFechaRegistro(formato.parse(fechaTemporal));
        usuario.setFkPerfil(perfilFacade.find(3));
        usuario.setFkHabilitado(habilitadoFacade.find(1));
        usuario.setFkidCargo(cargoFacade.find(4));
        usuFacade.create(usuario);
        usuario = new Usuario();     
        
        return "dashboardUsuarios?cedula=xx";
        
    }
    
    public List<Usuario> consultarUsuario(){
        return usuFacade.findAll();
    }
    
    public String preEditar(Usuario usuario){
        this.usuario= usuario;
        return "editarUsuario";
    }
    public String editar(){
        usuario.setFkPerfil(perfilFacade.find(perfil.getIdPerfil()));
        usuario.setFkHabilitado(habilitadoFacade.find(habilitado.getIdHabilitado()));
        usuario.setFkidCargo(cargoFacade.find(cargo.getIdCargo()));
        usuFacade.edit(usuario);
        usuario = new Usuario();
        return "dashboardUsuarios";
        
    }
    public void eliminar(Usuario usuario){
        usuFacade.remove(usuario);
        
    }
    
    public Usuario filtro(){
        System.out.println(usuario.getContrasena());        
        return usuFacade.find(identificacion);       
    }
    
    
    public String validarLogin(){
        Usuario user = null;
        user = usuFacade.UserLogin(clave, email);
        if(user != null){    
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", user);
            return "dashboardUsuarios";
        }
        return "";
    }
    
    public Usuario retornoSesion(){
        return (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
    }
    
}
