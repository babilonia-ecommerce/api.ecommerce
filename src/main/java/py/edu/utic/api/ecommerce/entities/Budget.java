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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity
@Table(name = "presupuesto_compras", catalog = "babilonia_center", schema = "public")
@XmlRootElement
public class Budget implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_presupuesto_compra", nullable = false)
    private Integer idPresupuestoCompra;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private Character estado;
    @Column(name = "observacion", length = 200)
    private String observacion;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    @ManyToOne(optional = false)
    private Employee idEmpleado;
    @JoinColumn(name = "id_pedido_compra", referencedColumnName = "id_pedido_compra", nullable = false)
    @ManyToOne(optional = false)
    private PurchaseRequest idPedidoCompra;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @ManyToOne(optional = false)
    private Provider idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budget")
    private Collection<budgetDetail> budgetDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresupuestoCompra")
    private Collection<PurchaseOrder> purchaseOrderCollection;

    public Budget() {
    }

    public Budget(Integer idPresupuestoCompra) {
        this.idPresupuestoCompra = idPresupuestoCompra;
    }

    public Budget(Integer idPresupuestoCompra, Date fecha, Character estado) {
        this.idPresupuestoCompra = idPresupuestoCompra;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdPresupuestoCompra() {
        return idPresupuestoCompra;
    }

    public void setIdPresupuestoCompra(Integer idPresupuestoCompra) {
        this.idPresupuestoCompra = idPresupuestoCompra;
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

    public Employee getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Employee idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public PurchaseRequest getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(PurchaseRequest idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public Provider getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Provider idProveedor) {
        this.idProveedor = idProveedor;
    }

    @XmlTransient
    public Collection<budgetDetail> getBudgetDetailCollection() {
        return budgetDetailCollection;
    }

    public void setBudgetDetailCollection(Collection<budgetDetail> budgetDetailCollection) {
        this.budgetDetailCollection = budgetDetailCollection;
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
        hash += (idPresupuestoCompra != null ? idPresupuestoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.idPresupuestoCompra == null && other.idPresupuestoCompra != null) || (this.idPresupuestoCompra != null && !this.idPresupuestoCompra.equals(other.idPresupuestoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.Budget[ idPresupuestoCompra=" + idPresupuestoCompra + " ]";
    }
    
}
