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
public class PurchaseOrderDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_orden_compras", nullable = false)
    private int idOrdenCompras;
    @Basic(optional = false)
    @Column(name = "id_mercaderia", nullable = false)
    private int idMercaderia;

    public PurchaseOrderDetailPK() {
    }

    public PurchaseOrderDetailPK(int idOrdenCompras, int idMercaderia) {
        this.idOrdenCompras = idOrdenCompras;
        this.idMercaderia = idMercaderia;
    }

    public int getIdOrdenCompras() {
        return idOrdenCompras;
    }

    public void setIdOrdenCompras(int idOrdenCompras) {
        this.idOrdenCompras = idOrdenCompras;
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
        hash += (int) idOrdenCompras;
        hash += (int) idMercaderia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderDetailPK)) {
            return false;
        }
        PurchaseOrderDetailPK other = (PurchaseOrderDetailPK) object;
        if (this.idOrdenCompras != other.idOrdenCompras) {
            return false;
        }
        if (this.idMercaderia != other.idMercaderia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.PurchaseOrderDetailPK[ idOrdenCompras=" + idOrdenCompras + ", idMercaderia=" + idMercaderia + " ]";
    }
    
}
