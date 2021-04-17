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
@Table(name = "orden_compras", catalog = "babilonia_center", schema = "public")
@XmlRootElement
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_compras", nullable = false)
    private Integer idOrdenCompras;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private Character estado;
    @Basic(optional = false)
    @Column(name = "obsevacion", nullable = false, length = 200)
    private String obsevacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
    private Collection<PurchaseOrderDetail> purchaseOrderDetailCollection;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    @ManyToOne(optional = false)
    private Employee idEmpleado;
    @JoinColumn(name = "id_presupuesto_compra", referencedColumnName = "id_presupuesto_compra", nullable = false)
    @ManyToOne(optional = false)
    private Budget idPresupuestoCompra;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @ManyToOne(optional = false)
    private Provider idProveedor;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer idOrdenCompras) {
        this.idOrdenCompras = idOrdenCompras;
    }

    public PurchaseOrder(Integer idOrdenCompras, Date fecha, Character estado, String obsevacion) {
        this.idOrdenCompras = idOrdenCompras;
        this.fecha = fecha;
        this.estado = estado;
        this.obsevacion = obsevacion;
    }

    public Integer getIdOrdenCompras() {
        return idOrdenCompras;
    }

    public void setIdOrdenCompras(Integer idOrdenCompras) {
        this.idOrdenCompras = idOrdenCompras;
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

    public String getObsevacion() {
        return obsevacion;
    }

    public void setObsevacion(String obsevacion) {
        this.obsevacion = obsevacion;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetail> getPurchaseOrderDetailCollection() {
        return purchaseOrderDetailCollection;
    }

    public void setPurchaseOrderDetailCollection(Collection<PurchaseOrderDetail> purchaseOrderDetailCollection) {
        this.purchaseOrderDetailCollection = purchaseOrderDetailCollection;
    }

    public Employee getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Employee idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Budget getIdPresupuestoCompra() {
        return idPresupuestoCompra;
    }

    public void setIdPresupuestoCompra(Budget idPresupuestoCompra) {
        this.idPresupuestoCompra = idPresupuestoCompra;
    }

    public Provider getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Provider idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenCompras != null ? idOrdenCompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.idOrdenCompras == null && other.idOrdenCompras != null) || (this.idOrdenCompras != null && !this.idOrdenCompras.equals(other.idOrdenCompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.PurchaseOrder[ idOrdenCompras=" + idOrdenCompras + " ]";
    }
    
}
