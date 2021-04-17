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
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "presupuesto_compras_detalle", catalog = "babilonia_center", schema = "public")
@XmlRootElement
public class budgetDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected budgetDetailPK budgetDetailPK;
    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio_compra", nullable = false)
    private int precioCompra;
    @JoinColumn(name = "id_mercaderia", referencedColumnName = "id_mercaderia", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "id_presupuesto_compra", referencedColumnName = "id_presupuesto_compra", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Budget budget;

    public budgetDetail() {
    }

    public budgetDetail(budgetDetailPK budgetDetailPK) {
        this.budgetDetailPK = budgetDetailPK;
    }

    public budgetDetail(budgetDetailPK budgetDetailPK, int cantidad, int precioCompra) {
        this.budgetDetailPK = budgetDetailPK;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
    }

    public budgetDetail(int idPresupuestoCompra, int idMercaderia) {
        this.budgetDetailPK = new budgetDetailPK(idPresupuestoCompra, idMercaderia);
    }

    public budgetDetailPK getBudgetDetailPK() {
        return budgetDetailPK;
    }

    public void setBudgetDetailPK(budgetDetailPK budgetDetailPK) {
        this.budgetDetailPK = budgetDetailPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetDetailPK != null ? budgetDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof budgetDetail)) {
            return false;
        }
        budgetDetail other = (budgetDetail) object;
        if ((this.budgetDetailPK == null && other.budgetDetailPK != null) || (this.budgetDetailPK != null && !this.budgetDetailPK.equals(other.budgetDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.budgetDetail[ budgetDetailPK=" + budgetDetailPK + " ]";
    }
    
}
