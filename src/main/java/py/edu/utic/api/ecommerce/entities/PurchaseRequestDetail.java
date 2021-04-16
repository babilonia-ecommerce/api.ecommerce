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
@Table(name = "pedido_compras_detalle", catalog = "babilonia_center", schema = "public")
@XmlRootElement
public class PurchaseRequestDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurchaseRequestDetailPK purchaseRequestDetailPK;
    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Column(name = "precio_compra")
    private Integer precioCompra;
    @JoinColumn(name = "id_mercaderia", referencedColumnName = "id_mercaderia", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "id_pedido_compra", referencedColumnName = "id_pedido_compra", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PurchaseRequest purchaseRequest;

    public PurchaseRequestDetail() {
    }

    public PurchaseRequestDetail(PurchaseRequestDetailPK purchaseRequestDetailPK) {
        this.purchaseRequestDetailPK = purchaseRequestDetailPK;
    }

    public PurchaseRequestDetail(PurchaseRequestDetailPK purchaseRequestDetailPK, int cantidad) {
        this.purchaseRequestDetailPK = purchaseRequestDetailPK;
        this.cantidad = cantidad;
    }

    public PurchaseRequestDetail(int idPedidoCompra, int idMercaderia) {
        this.purchaseRequestDetailPK = new PurchaseRequestDetailPK(idPedidoCompra, idMercaderia);
    }

    public PurchaseRequestDetailPK getPurchaseRequestDetailPK() {
        return purchaseRequestDetailPK;
    }

    public void setPurchaseRequestDetailPK(PurchaseRequestDetailPK purchaseRequestDetailPK) {
        this.purchaseRequestDetailPK = purchaseRequestDetailPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Integer precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseRequestDetailPK != null ? purchaseRequestDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseRequestDetail)) {
            return false;
        }
        PurchaseRequestDetail other = (PurchaseRequestDetail) object;
        if ((this.purchaseRequestDetailPK == null && other.purchaseRequestDetailPK != null) || (this.purchaseRequestDetailPK != null && !this.purchaseRequestDetailPK.equals(other.purchaseRequestDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.PurchaseRequestDetail[ purchaseRequestDetailPK=" + purchaseRequestDetailPK + " ]";
    }
    
}
