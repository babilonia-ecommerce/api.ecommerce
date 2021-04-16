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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@MappedSuperclass
@Table(name = "mercaderias", catalog = "babilonia_center", schema = "public")
@XmlRootElement
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mercaderia", nullable = false)
    private Integer idMercaderia;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "stock", nullable = false)
    private int stock;
    @Basic(optional = false)
    @Column(name = "precio_compra", nullable = false)
    private int precioCompra;
    @Basic(optional = false)
    @Column(name = "precio_venta", nullable = false)
    private int precioVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<PurchaseRequestDetail> purchaseRequestDetailCollection;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", nullable = false)
    @ManyToOne(optional = false)
    private Brand idMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<PurchaseOrderDetail> purchaseOrderDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<budgetDetail> budgetDetailCollection;

    public Product() {
    }

    public Product(Integer idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    public Product(Integer idMercaderia, String descripcion, int stock, int precioCompra, int precioVenta) {
        this.idMercaderia = idMercaderia;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Integer getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(Integer idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    @XmlTransient
    public Collection<PurchaseRequestDetail> getPurchaseRequestDetailCollection() {
        return purchaseRequestDetailCollection;
    }

    public void setPurchaseRequestDetailCollection(Collection<PurchaseRequestDetail> purchaseRequestDetailCollection) {
        this.purchaseRequestDetailCollection = purchaseRequestDetailCollection;
    }

    public Brand getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Brand idMarca) {
        this.idMarca = idMarca;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetail> getPurchaseOrderDetailCollection() {
        return purchaseOrderDetailCollection;
    }

    public void setPurchaseOrderDetailCollection(Collection<PurchaseOrderDetail> purchaseOrderDetailCollection) {
        this.purchaseOrderDetailCollection = purchaseOrderDetailCollection;
    }

    @XmlTransient
    public Collection<budgetDetail> getBudgetDetailCollection() {
        return budgetDetailCollection;
    }

    public void setBudgetDetailCollection(Collection<budgetDetail> budgetDetailCollection) {
        this.budgetDetailCollection = budgetDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMercaderia != null ? idMercaderia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idMercaderia == null && other.idMercaderia != null) || (this.idMercaderia != null && !this.idMercaderia.equals(other.idMercaderia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.utic.entities.Product[ idMercaderia=" + idMercaderia + " ]";
    }
    
}
