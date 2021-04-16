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
public class budgetDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_presupuesto_compra", nullable = false)
    private int idPresupuestoCompra;
    @Basic(optional = false)
    @Column(name = "id_mercaderia", nullable = false)
    private int idMercaderia;

    public budgetDetailPK() {
    }

    public budgetDetailPK(int idPresupuestoCompra, int idMercaderia) {
        this.idPresupuestoCompra = idPresupuestoCompra;
        this.idMercaderia = idMercaderia;
    }

    public int getIdPresupuestoCompra() {
        return idPresupuestoCompra;
    }

    public void setIdPresupuestoCompra(int idPresupuestoCompra) {
        this.idPresupuestoCompra = idPresupuestoCompra;
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
        hash += (int) idPresupuestoCompra;
        hash += (int) idMercaderia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof budgetDetailPK)) {
            return false;
        }
        budgetDetailPK other = (budgetDetailPK) object;
        if (this.idPresupuestoCompra != other.idPresupuestoCompra) {
            return false;
        }
        if (this.idMercaderia != other.idMercaderia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.budgetDetailPK[ idPresupuestoCompra=" + idPresupuestoCompra + ", idMercaderia=" + idMercaderia + " ]";
    }
    
}
