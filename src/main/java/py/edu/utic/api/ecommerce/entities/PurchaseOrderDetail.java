/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.utic.api.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@MappedSuperclass
@Table(name = "orden_compras_detalle", catalog = "babilonia_center", schema = "public")
@XmlRootElement
public class PurchaseOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurchaseOrderDetailPK purchaseOrderDetailPK;
    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio", nullable = false)
    private int precio;
    @JoinColumn(name = "id_mercaderia", referencedColumnName = "id_mercaderia", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "id_orden_compras", referencedColumnName = "id_orden_compras", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseOrder purchaseOrder;

    public PurchaseOrderDetail() {
    }

    public PurchaseOrderDetail(PurchaseOrderDetailPK purchaseOrderDetailPK) {
        this.purchaseOrderDetailPK = purchaseOrderDetailPK;
    }

    public PurchaseOrderDetail(PurchaseOrderDetailPK purchaseOrderDetailPK, int cantidad, int precio) {
        this.purchaseOrderDetailPK = purchaseOrderDetailPK;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public PurchaseOrderDetail(int idOrdenCompras, int idMercaderia) {
        this.purchaseOrderDetailPK = new PurchaseOrderDetailPK(idOrdenCompras, idMercaderia);
    }

    public PurchaseOrderDetailPK getPurchaseOrderDetailPK() {
        return purchaseOrderDetailPK;
    }

    public void setPurchaseOrderDetailPK(PurchaseOrderDetailPK purchaseOrderDetailPK) {
        this.purchaseOrderDetailPK = purchaseOrderDetailPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderDetailPK != null ? purchaseOrderDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderDetail)) {
            return false;
        }
        PurchaseOrderDetail other = (PurchaseOrderDetail) object;
        if ((this.purchaseOrderDetailPK == null && other.purchaseOrderDetailPK != null) || (this.purchaseOrderDetailPK != null && !this.purchaseOrderDetailPK.equals(other.purchaseOrderDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.PurchaseOrderDetail[ purchaseOrderDetailPK=" + purchaseOrderDetailPK + " ]";
    }
    
}
