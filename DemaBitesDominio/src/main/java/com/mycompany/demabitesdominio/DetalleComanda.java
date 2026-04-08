package com.mycompany.demabitesdominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase Entidad DetalleComanda.
 * Entidad JPA que representa la tabla intermedia "detalles_comanda".
 * Modela la relación entre una Comanda y los Productos que contiene, incluyendo
 * atributos específicos de esa venta (cantidad, precio histórico y comentarios).
 * * @author Emily Lara
 * 270719
 */
@Entity
@Table(name = "detalles_comanda")
public class DetalleComanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_venta", nullable = false)
    private Double precioVenta; 

    @Column(name = "comentarios", length = 255)
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "id_comanda", nullable = false)
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    /**
     * Constructor por defecto.
     */
    public DetalleComanda() {
        
    }

    /**
     * Constructor que inicializa la entidad DetalleComanda con sus datos operativos.
     * @param cantidad El número de unidades ordenadas del producto.
     * @param precioVenta El precio del producto fijado al momento de la orden.
     * @param comentarios Instrucciones específicas del cliente.
     * @param comanda La entidad Comanda a la que pertenece este detalle.
     * @param producto La entidad Producto que se está ordenando.
     */
    public DetalleComanda(Integer cantidad, Double precioVenta, String comentarios, Comanda comanda, Producto producto) {
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.comentarios = comentarios;
        this.comanda = comanda;
        this.producto = producto;
    }

    /**
     * Obtiene el identificador único autogenerado del detalle.
     * @return El id del detalle.
     */
    public Long getId() { return id; }
    
    /**
     * Establece el identificador único del detalle.
     * @param id El nuevo id a asignar.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Obtiene la cantidad de unidades solicitadas del producto.
     * @return La cantidad del producto.
     */
    public Integer getCantidad() { return cantidad; }
    
    /**
     * Establece la cantidad de unidades solicitadas del producto.
     * @param cantidad La nueva cantidad a asignar.
     */
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    /**
     * Obtiene el precio al que se vendió el producto en esta comanda específica.
     * Se almacena aquí para no alterar comandas históricas si el precio del producto cambia a futuro.
     * @return El precio de venta registrado.
     */
    public Double getPrecioVenta() { return precioVenta; }
    
    /**
     * Establece el precio de venta del producto para este detalle.
     * @param precioVenta El nuevo precio de venta a asignar.
     */
    public void setPrecioVenta(Double precioVenta) { this.precioVenta = precioVenta; }

    /**
     * Obtiene los comentarios o notas especiales para la preparación del producto.
     * @return Cadena de texto con comentarios (o nulo si no hay notas).
     */
    public String getComentarios() { return comentarios; }
    
    /**
     * Establece los comentarios o notas especiales de preparación.
     * @param comentarios Los nuevos comentarios a asignar.
     */
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    /**
     * Obtiene la comanda a la que pertenece este detalle.
     * @return La entidad Comanda asociada.
     */
    public Comanda getComanda() { return comanda; }
    
    /**
     * Establece la comanda a la que pertenecerá este detalle.
     * @param comanda La entidad Comanda a vincular.
     */
    public void setComanda(Comanda comanda) { this.comanda = comanda; }

    /**
     * Obtiene el producto que se está ordenando en esta línea de la comanda.
     * @return La entidad Producto asociada.
     */
    public Producto getProducto() { return producto; }
    
    /**
     * Establece el producto que se ordena en este detalle.
     * @param producto La entidad Producto a vincular.
     */
    public void setProducto(Producto producto) { this.producto = producto; }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetalleComanda)) {
            return false;
        }
        DetalleComanda other = (DetalleComanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleComanda{" + "id=" + id + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", comentarios=" + comentarios + '}';
    }
}