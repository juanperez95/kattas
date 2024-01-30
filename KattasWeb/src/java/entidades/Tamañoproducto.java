/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author familia perez
 */
@Entity
@Table(name = "tama\u00f1oproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tama\u00f1oproducto.findAll", query = "SELECT t FROM Tama\u00f1oproducto t"),
    @NamedQuery(name = "Tama\u00f1oproducto.findByIdTama\u00f1o", query = "SELECT t FROM Tama\u00f1oproducto t WHERE t.idTama\u00f1o = :idTama\u00f1o"),
    @NamedQuery(name = "Tama\u00f1oproducto.findByNombreTama\u00f1o", query = "SELECT t FROM Tama\u00f1oproducto t WHERE t.nombreTama\u00f1o = :nombreTama\u00f1o")})
public class Tamañoproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTama\u00f1o")
    private Integer idTamaño;
    @Size(max = 50)
    @Column(name = "nombreTama\u00f1o")
    private String nombreTamaño;
    @OneToMany(mappedBy = "fkTama\u00f1o", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public Tamañoproducto() {
    }

    public Tamañoproducto(Integer idTamaño) {
        this.idTamaño = idTamaño;
    }

    public Integer getIdTamaño() {
        return idTamaño;
    }

    public void setIdTamaño(Integer idTamaño) {
        this.idTamaño = idTamaño;
    }

    public String getNombreTamaño() {
        return nombreTamaño;
    }

    public void setNombreTamaño(String nombreTamaño) {
        this.nombreTamaño = nombreTamaño;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTamaño != null ? idTamaño.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tamañoproducto)) {
            return false;
        }
        Tamañoproducto other = (Tamañoproducto) object;
        if ((this.idTamaño == null && other.idTamaño != null) || (this.idTamaño != null && !this.idTamaño.equals(other.idTamaño))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tama\u00f1oproducto[ idTama\u00f1o=" + idTamaño + " ]";
    }
    
}
