/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Categoria;
import entidades.Estado;
import entidades.Insumo;
import facades.CategoriaFacade;
import facades.EstadoFacade;
import facades.InsumoFacade;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;

/**
 *
 * @author Roberto_Diaz
 */
@Named(value = "insumoControlador")
@SessionScoped
@RequestScoped
public class insumoControlador implements Serializable {

    @EJB
    CategoriaFacade categoriaFacade;

    @EJB
    EstadoFacade estadoFacade;

    @EJB
    InsumoFacade insumoFacade;

    private Insumo insumo;
    private Categoria categoria;
    private Estado estado;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @PostConstruct
    public void init() {
        insumo = new Insumo();
        estado = new Estado();
        categoria = new Categoria();
        // Manejar el auto_increment con el atributo  
        insumo.setIdInsumo(insumoFacade.count() + 1);
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public insumoControlador() {
    }

    public void insumoVacio() {
        insumo = new Insumo();
    }

    public void crearInsumo() throws ParseException {

        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechaTemporal = formato.format(fecha);
        insumo.setFechaEntrada(formato.parse(fechaTemporal));
        insumo.setFkEstado(estadoFacade.find(1));
        insumo.setFkidCategoria(categoriaFacade.find(categoria.getIdCategoria()));

        insumoFacade.create(insumo);

        insumo = new Insumo();
        insumo.setIdInsumo(insumoFacade.count() + 1);
        confirm();

    }

    public List<Insumo> consultarInsumos() {
        return insumoFacade.findAll();
    }

    public String preEditarInsumo(Insumo insumo) {
        this.insumo = insumo;
        return "dashboardInsumos";
    }

    public void editarInsumo() {
        insumo.setFkidCategoria(categoriaFacade.find(categoria.getIdCategoria()));
        insumoFacade.edit(insumo);
        insumo = new Insumo();
        confirmEdit();
    }
    
    public void inabilitarInsumo(Insumo insumo){
        insumo.setFkEstado(estadoFacade.find(3));
        insumoFacade.edit(insumo);
        insumo = new Insumo();
    }

    public void confirm() {
        addMessage("¡Registro Exitoso!", "Insumo añadido");
    }

    public void confirmEdit() {
        addMessage("¡Cambio Exitoso!", "Insumo editado");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
