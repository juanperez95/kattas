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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Roberto_Diaz
 */
@Entity
@Table(name = "habilitado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habilitado.findAll", query = "SELECT h FROM Habilitado h"),
    @NamedQuery(name = "Habilitado.findByIdHabilitado", query = "SELECT h FROM Habilitado h WHERE h.idHabilitado = :idHabilitado"),
    @NamedQuery(name = "Habilitado.findByTipoHabilitado", query = "SELECT h FROM Habilitado h WHERE h.tipoHabilitado = :tipoHabilitado")})
public class Habilitado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHabilitado")
    private Integer idHabilitado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "tipoHabilitado")
    private String tipoHabilitado;
    @OneToMany(mappedBy = "fkHabilitado", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Habilitado() {
    }

    public Habilitado(Integer idHabilitado) {
        this.idHabilitado = idHabilitado;
    }

    public Habilitado(Integer idHabilitado, String tipoHabilitado) {
        this.idHabilitado = idHabilitado;
        this.tipoHabilitado = tipoHabilitado;
    }

    public Integer getIdHabilitado() {
        return idHabilitado;
    }

    public void setIdHabilitado(Integer idHabilitado) {
        this.idHabilitado = idHabilitado;
    }

    public String getTipoHabilitado() {
        return tipoHabilitado;
    }

    public void setTipoHabilitado(String tipoHabilitado) {
        this.tipoHabilitado = tipoHabilitado;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHabilitado != null ? idHabilitado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habilitado)) {
            return false;
        }
        Habilitado other = (Habilitado) object;
        if ((this.idHabilitado == null && other.idHabilitado != null) || (this.idHabilitado != null && !this.idHabilitado.equals(other.idHabilitado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Habilitado[ idHabilitado=" + idHabilitado + " ]";
    }
    
}
