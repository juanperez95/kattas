/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author familia perez
 */
@Entity
@Table(name = "insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i"),
    @NamedQuery(name = "Insumo.findByIdInsumo", query = "SELECT i FROM Insumo i WHERE i.idInsumo = :idInsumo"),
    @NamedQuery(name = "Insumo.findByNombreInsumo", query = "SELECT i FROM Insumo i WHERE i.nombreInsumo = :nombreInsumo"),
    @NamedQuery(name = "Insumo.findByFechaVencimiento", query = "SELECT i FROM Insumo i WHERE i.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Insumo.findByFechaEntrada", query = "SELECT i FROM Insumo i WHERE i.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Insumo.findByCantidadExistente", query = "SELECT i FROM Insumo i WHERE i.cantidadExistente = :cantidadExistente")})
public class Insumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInsumo")
    private Integer idInsumo;
    @Size(max = 30)
    @Column(name = "nombreInsumo")
    private String nombreInsumo;
    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "fechaEntrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Column(name = "cantidadExistente")
    private Integer cantidadExistente;
    @OneToMany(mappedBy = "fkidInsumo", fetch = FetchType.LAZY)
    private List<ProductosInsumos> productosInsumosList;
    @JoinColumn(name = "fk_idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria fkidCategoria;
    @JoinColumn(name = "fk_estado", referencedColumnName = "idEstado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado fkEstado;

    public Insumo() {
    }

    public Insumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    @XmlTransient
    public List<ProductosInsumos> getProductosInsumosList() {
        return productosInsumosList;
    }

    public void setProductosInsumosList(List<ProductosInsumos> productosInsumosList) {
        this.productosInsumosList = productosInsumosList;
    }

    public Categoria getFkidCategoria() {
        return fkidCategoria;
    }

    public void setFkidCategoria(Categoria fkidCategoria) {
        this.fkidCategoria = fkidCategoria;
    }

    public Estado getFkEstado() {
        return fkEstado;
    }

    public void setFkEstado(Estado fkEstado) {
        this.fkEstado = fkEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsumo != null ? idInsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.idInsumo == null && other.idInsumo != null) || (this.idInsumo != null && !this.idInsumo.equals(other.idInsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Insumo[ idInsumo=" + idInsumo + " ]";
    }
    
}
