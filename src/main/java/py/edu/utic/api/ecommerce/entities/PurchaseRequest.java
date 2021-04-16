/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.utic.api.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@MappedSuperclass
@Table(name = "pedido_compras", catalog = "babilonia_center", schema = "public")
@XmlRootElement
public class PurchaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pedido_compra", nullable = false)
    private Integer idPedidoCompra;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private Character estado;
    @Column(name = "observacion", length = 200)
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseRequest")
    private Collection<PurchaseRequestDetail> purchaseRequestDetailCollection;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    @ManyToOne(optional = false)
    private Employee idEmpleado;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @ManyToOne(optional = false)
    private Provider idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedidoCompra")
    private Collection<Budget> budgetCollection;

    public PurchaseRequest() {
    }

    public PurchaseRequest(Integer idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public PurchaseRequest(Integer idPedidoCompra, Date fecha, Character estado) {
        this.idPedidoCompra = idPedidoCompra;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(Integer idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public Collection<PurchaseRequestDetail> getPurchaseRequestDetailCollection() {
        return purchaseRequestDetailCollection;
    }

    public void setPurchaseRequestDetailCollection(Collection<PurchaseRequestDetail> purchaseRequestDetailCollection) {
        this.purchaseRequestDetailCollection = purchaseRequestDetailCollection;
    }

    public Employee getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Employee idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Provider getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Provider idProveedor) {
        this.idProveedor = idProveedor;
    }

    @XmlTransient
    public Collection<Budget> getBudgetCollection() {
        return budgetCollection;
    }

    public void setBudgetCollection(Collection<Budget> budgetCollection) {
        this.budgetCollection = budgetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoCompra != null ? idPedidoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseRequest)) {
            return false;
        }
        PurchaseRequest other = (PurchaseRequest) object;
        if ((this.idPedidoCompra == null && other.idPedidoCompra != null) || (this.idPedidoCompra != null && !this.idPedidoCompra.equals(other.idPedidoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.PurchaseRequest[ idPedidoCompra=" + idPedidoCompra + " ]";
    }
    
}
