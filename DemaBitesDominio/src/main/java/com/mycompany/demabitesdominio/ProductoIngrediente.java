package com.mycompany.demabitesdominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entidad que representa la relacion entre Producto y sus Ingredientes.
 * @author Jesus Omar
 */
@Entity
public class ProductoIngrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidadRequerida", nullable = false)
    private Double cantidadRequerida;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente", nullable = false)
    private Ingrediente ingrediente;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    /**
     * Contructor vacio.
     */
    public ProductoIngrediente() {

    }

    /**
     * Contructor con todos los atributos de ProductoIngredeinte a excepcion del ID.
     * @param cantidadRequerida La cantidad de unidades del ingrediente necesaria para hacer el producto.
     * @param ingrediente El ingrediente necesario para hacer el producto.
     * @param producto El producto que se hace.
     */
    public ProductoIngrediente(Double cantidadRequerida, Ingrediente ingrediente, Producto producto) {
        this.cantidadRequerida = cantidadRequerida;
        this.ingrediente = ingrediente;
        this.producto = producto;
    }

    /** @return El ID de la relacion producto - ingrediente. */
    public Long getId() {
        return id;
    }

    /** @param id El ID asignado a la relacion producto - ingrediente. */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return La cantidad de unidades del ingrediente para realizar el producto. */
    public Double getCantidadRequerida() {
        return cantidadRequerida;
    }

    /** @param cantidadRequerida La cantidad de unidades de ingredientes 
     * que se asignaran a la realizacion del producto. */
    public void setCantidadRequerida(Double cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    /** @return El ingrediente que se utiliza para realizar el producto. */
    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    /** @param ingrediente El ingrediente que se asignara al producto. */
    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    /** @return El producto en el que se centra la relacion. */
    public Producto getProducto() {
        return producto;
    }

    /** @param producto El producto asignado a la relacion. */
    public void setProducto(Producto producto) {
        this.producto = producto;
    } 

    /**
     * @return Genera el hash de identidad del objeto utilizando el ID.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara la igualdad de dos clientes basandose en el ID.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProductoIngrediente)) {
            return false;
        }
        ProductoIngrediente other = (ProductoIngrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * @return Devuelve un String con los atributos de la relacion ProductoIngrediente.
     */
    @Override
    public String toString() {
        return "ProductoIngrediente{" +
                "id=" + id +
                ", cantidadRequerida=" + cantidadRequerida +
                ", ingrediente=" + ingrediente +
                ", producto=" + producto +
                '}';
    }
}
    
