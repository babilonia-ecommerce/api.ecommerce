/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.utic.api.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "proveedores", catalog = "babilonia_center", schema = "public")
@XmlRootElement
public class Provider implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor", nullable = false)
    private Integer idProveedor;
    @Basic(optional = false)
    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "ruc", nullable = false, length = 20)
    private String ruc;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "tipo_persona", length = 3)
    private String tipoPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private Collection<PurchaseRequest> purchaseRequestCollection;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad", nullable = false)
    @ManyToOne(optional = false)
    private City idCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private Collection<Budget> budgetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private Collection<PurchaseOrder> purchaseOrderCollection;

    public Provider() {
    }

    public Provider(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Provider(Integer idProveedor, String razonSocial, String ruc, String direccion, String telefono, String email) {
        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @XmlTransient
    public Collection<PurchaseRequest> getPurchaseRequestCollection() {
        return purchaseRequestCollection;
    }

    public void setPurchaseRequestCollection(Collection<PurchaseRequest> purchaseRequestCollection) {
        this.purchaseRequestCollection = purchaseRequestCollection;
    }

    public City getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(City idCiudad) {
        this.idCiudad = idCiudad;
    }

    @XmlTransient
    public Collection<Budget> getBudgetCollection() {
        return budgetCollection;
    }

    public void setBudgetCollection(Collection<Budget> budgetCollection) {
        this.budgetCollection = budgetCollection;
    }

    @XmlTransient
    public Collection<PurchaseOrder> getPurchaseOrderCollection() {
        return purchaseOrderCollection;
    }

    public void setPurchaseOrderCollection(Collection<PurchaseOrder> purchaseOrderCollection) {
        this.purchaseOrderCollection = purchaseOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provider)) {
            return false;
        }
        Provider other = (Provider) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.Provider[ idProveedor=" + idProveedor + " ]";
    }
    
}
