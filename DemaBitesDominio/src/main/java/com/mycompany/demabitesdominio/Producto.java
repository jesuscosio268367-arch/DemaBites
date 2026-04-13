package com.mycompany.demabitesdominio;

import Enums.EstadoProducto;
import Enums.Tipo;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad que representa un Producto dentro del sistema.
 * @author emy
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoProducto", nullable = false)
    private Tipo tipoProducto;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoProducto estado;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<ProductoIngrediente> ingredientes;
    
    @Lob
    @Column(name = "imagen", nullable = true)
    private byte[] imagenProducto;

    /**
     * Constructor vacio.
     */
    public Producto() {

    }

    /**
     * Contructor con todos los atributos del producto a excepcion del ID.
     * @param nombre El nombre del producto.
     * @param precio El precio que tendra el producto.
     * @param tipoProducto El tipo de producto (platillo, bebida, postre).
     * @param descripcion Una breve descripcion del producto.
     * @param estado El estado en el que se encuentra el producto (Activo, Inactivo).
     * @param ingredientes Lista de ingredientes que conforman el producto.
     * @param imagenProducto Imagen del producto.
     */
    public Producto(String nombre, Double precio, Tipo tipoProducto, String descripcion, EstadoProducto estado, List<ProductoIngrediente> ingredientes, byte[] imagenProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ingredientes = ingredientes;
        this.imagenProducto = imagenProducto;
    }

    /** @return El ID unico del producto. */
    public Long getId() {
        return id;
    }

    /** @param id El ID asignado al producto. */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return El nombre del producto. */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre El nombre asignado al producto. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return El precio del producto. */
    public Double getPrecio() {
        return precio;
    }

    /** @param precio El precio asignado al producto. */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /** @return El tipo del producto. */
    public Tipo getTipoProducto() {
        return tipoProducto;
    }

    /** @param tipoProducto El tipo de producto asignado al producto. */
    public void setTipoProducto(Tipo tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /** @return La descripcion del producto. */
    public String getDescripcion() {
        return descripcion;
    }

    /** @param descripcion La descripcion asignada al producto. */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** @return El estado del producto. */
    public EstadoProducto getEstado() {
        return estado;
    }

    /** @param estado El estado asignado al producto (valor predeterminado "ACTIVO"). */
    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    /** @return Lista de ingredientes que componen al producto. */
    public List<ProductoIngrediente> getIngredientes() {
        return ingredientes;
    }

    /** @param ingredientes La lista de ingredientes asignados al producto. */
    public void setIngredientes(List<ProductoIngrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    /** @return La imagen del producto asignada. */
    public byte[] getImagenProducto() {
        return imagenProducto;
    }

    /** @param imagenProducto La imagen asignada al producto. */
    public void setImagenProducto(byte[] imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    /**
     * Metodo hashCode de la entidad Producto.
     * @return Genera el hash de identidad del objeto utilizando el ID.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara la igualdad de dos productos basandose en el ID.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Metodo toString de la entidad Producto.
     * @return Devuelve una texto de los atributos del Producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", precio=" + precio +
                ", tipoProducto=" + tipoProducto +
                ", descripcion=" + descripcion +
                ", estado=" + estado +
                ", ingredientes=" + ingredientes +
                '}';
    }
}