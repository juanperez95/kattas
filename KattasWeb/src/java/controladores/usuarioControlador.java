/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import email.Mailer;
import entidades.Cargo;
import entidades.Habilitado;
import entidades.Perfil;
import entidades.Usuario;
import facades.CargoFacade;
import facades.HabilitadoFacade;
import facades.PerfilFacade;
import facades.UsuarioFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Roberto_Diaz
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class usuarioControlador implements Serializable {

    private Usuario usuario, usuarioSesion; // usuarioSesion va a tenern el objeto en el diccionario para la sesion.
    private Habilitado habilitado;
    private Perfil perfil;
    private Cargo cargo;
    private int identificacion = 0, validar = 0;
    private String email, clave;

    public int getValidar() {
        return validar;
    }

    public void setValidar(int validar) {
        this.validar = validar;
    }

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
    public void init() {
        usuario = new Usuario();
        habilitado = new Habilitado();
        cargo = new Cargo();
        perfil = new Perfil();
        usuarioSesion = this.retornoSesion();
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
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

    public String agregarUsuario() throws ParseException, UnsupportedEncodingException, NoSuchAlgorithmException {
        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechaTemporal = formato.format(fecha);

        if (!usuFacade.CorreoLogin(usuario.getEmail())) {
            usuario.setFechaRegistro(formato.parse(fechaTemporal));
            usuario.setFkPerfil(perfilFacade.find(3));
            usuario.setFkHabilitado(habilitadoFacade.find(1));
            usuario.setFkidCargo(cargoFacade.find(4));
            usuario.setContrasena(usuFacade.encriptarClave(usuario.getContrasena()));
            usuFacade.create(usuario);
            //Mailer.send(usuario.getEmail(), "Registro Kattas Web", mensajeConEstilo());
            usuario = new Usuario();
            validar = 0;
            return "login";
        } else {
            validar = 1;
            return "agregarUsuario";

        }

    }

    public List<Usuario> consultarUsuario() {
        return usuFacade.findAll();
    }

    public String preEditar(Usuario usuario) {
        this.usuario = usuario;
        return "editarUsuario";
    }

    public String editar() {
        usuario.setFkPerfil(perfilFacade.find(perfil.getIdPerfil()));
        usuario.setFkHabilitado(habilitadoFacade.find(habilitado.getIdHabilitado()));
        usuario.setFkidCargo(cargoFacade.find(cargo.getIdCargo()));
        usuFacade.edit(usuario);
        usuario = new Usuario();
        return "dashboardUsuarios";

    }

    public void eliminar(Usuario usuario) {
        usuario.setFkHabilitado(habilitadoFacade.find(2));
        usuFacade.edit(usuario);

    }

    // Filtro para buscar por medio del documento del usuario.
    public Usuario filtro() {
        System.out.println(usuario.getContrasena());
        return usuFacade.find(identificacion);
    }

    // Validar el inicio de sesion
    public String validarLogin() throws IOException, NoSuchAlgorithmException {

        Usuario user = null;
        user = usuFacade.UserLogin(clave, email); // Recibir el objeto de la clase Usuario.

        if (user != null) {
            validar = 0;

            if (user.getFkHabilitado().getIdHabilitado() == 2) {
                validar = 2;
                return "login";
            }
            // Validar los roles y redirigir a la pagina correspondiente.
            switch (user.getFkPerfil().getIdPerfil()) {
                case 1:
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", user);
                    return "dashboardUsuarios";
                case 3:
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userSession", user);
                    return "dashboardUsuarios";
            }
        }
        validar = 1; // La variable sirve para validar las alertas.
        return "";

    }

    // Crear la sesion para cuando se haya validado toda la informacion del usuario.
    public Usuario retornoSesion() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userSession");
    }

    // Eliminar el mapeo para cuando se cierre la sesion.
    public void cerrarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("userSession");
        ExternalContext redirigir = FacesContext.getCurrentInstance().getExternalContext(); // Redirigir a las paginas dentro del proyecto.
        redirigir.redirect(redirigir.getRequestContextPath() + "/index.xhtml");
    }

    public String mensajeConEstilo() {
        return "<img src='https://i.postimg.cc/GhrDCHvp/Logokatta-s-sin-fondo.png'/ style=\"float: left; width: 300px;\">" + "<p style=\"color: black;font-weight: bold; font-size: 20px; top: 50px;\"> Gracias por formar parte de nuestra comunidad.</p> ";

    }

}
