/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author familia perez
 */
@Entity
@Table(name = "productos_insumos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosInsumos.findAll", query = "SELECT p FROM ProductosInsumos p"),
    @NamedQuery(name = "ProductosInsumos.findByIdpi", query = "SELECT p FROM ProductosInsumos p WHERE p.idpi = :idpi"),
    @NamedQuery(name = "ProductosInsumos.findByCantidadInsumos", query = "SELECT p FROM ProductosInsumos p WHERE p.cantidadInsumos = :cantidadInsumos")})
public class ProductosInsumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpi")
    private Integer idpi;
    @Column(name = "cantidadInsumos")
    private Integer cantidadInsumos;
    @JoinColumn(name = "fk_idProducto", referencedColumnName = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto fkidProducto;
    @JoinColumn(name = "fk_idInsumo", referencedColumnName = "idInsumo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Insumo fkidInsumo;

    public ProductosInsumos() {
    }

    public ProductosInsumos(Integer idpi) {
        this.idpi = idpi;
    }

    public Integer getIdpi() {
        return idpi;
    }

    public void setIdpi(Integer idpi) {
        this.idpi = idpi;
    }

    public Integer getCantidadInsumos() {
        return cantidadInsumos;
    }

    public void setCantidadInsumos(Integer cantidadInsumos) {
        this.cantidadInsumos = cantidadInsumos;
    }

    public Producto getFkidProducto() {
        return fkidProducto;
    }

    public void setFkidProducto(Producto fkidProducto) {
        this.fkidProducto = fkidProducto;
    }

    public Insumo getFkidInsumo() {
        return fkidInsumo;
    }

    public void setFkidInsumo(Insumo fkidInsumo) {
        this.fkidInsumo = fkidInsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpi != null ? idpi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosInsumos)) {
            return false;
        }
        ProductosInsumos other = (ProductosInsumos) object;
        if ((this.idpi == null && other.idpi != null) || (this.idpi != null && !this.idpi.equals(other.idpi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProductosInsumos[ idpi=" + idpi + " ]";
    }
    
}
