/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.utic.api.ecommerce.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Usuario
 */
@Embeddable
public class PurchaseRequestDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_pedido_compra", nullable = false)
    private int idPedidoCompra;
    @Basic(optional = false)
    @Column(name = "id_mercaderia", nullable = false)
    private int idMercaderia;

    public PurchaseRequestDetailPK() {
    }

    public PurchaseRequestDetailPK(int idPedidoCompra, int idMercaderia) {
        this.idPedidoCompra = idPedidoCompra;
        this.idMercaderia = idMercaderia;
    }

    public int getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(int idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public int getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(int idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedidoCompra;
        hash += (int) idMercaderia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseRequestDetailPK)) {
            return false;
        }
        PurchaseRequestDetailPK other = (PurchaseRequestDetailPK) object;
        if (this.idPedidoCompra != other.idPedidoCompra) {
            return false;
        }
        if (this.idMercaderia != other.idMercaderia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.PurchaseRequestDetailPK[ idPedidoCompra=" + idPedidoCompra + ", idMercaderia=" + idMercaderia + " ]";
    }
    
}
