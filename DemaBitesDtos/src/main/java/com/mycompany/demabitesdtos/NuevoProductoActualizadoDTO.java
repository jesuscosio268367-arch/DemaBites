package com.mycompany.demabitesdtos;

import Enums.Tipo;
import java.util.List;

/**
 * DTO para actualizar un producto ya existente en el sistema.
 * @author Dario
 */
public class NuevoProductoActualizadoDTO {
    private Long id;
    private Double precio;
    private String descripcion;
    private List<IngredienteProductoDTO> ingredientes;
    private byte[] imagenProducto;
    
    //Solo para visualizacion
    private Tipo tipoProducto;
    private String nombre;

    /**
     * Contructor vacio.
     */
    public NuevoProductoActualizadoDTO() {
        
    }

    /**
     * Contructor con todos los atributos a excepcion del ID, nombre y tipoProducto.
     * @param precio El precio que tendra el producto.
     * @param descripcion Una breve descripcion del producto.
     * @param ingredientes Lista de ingredientes que conforman el producto.
     * @param imagenProducto Imagen del producto.
     */
    public NuevoProductoActualizadoDTO(Double precio, String descripcion, List<IngredienteProductoDTO> ingredientes, byte[] imagenProducto) {
        this.precio = precio;
        this.descripcion = descripcion;
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

    /** @return La descripcion del producto. */
    public String getDescripcion() {
        return descripcion;
    }

    /** @param descripcion La descripcion asignada al producto. */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** @return Lista de ingredientes que componen al producto. */
    public List<IngredienteProductoDTO> getIngredientes() {
        return ingredientes;
    }

    /** @param ingredientes La lista de ingredientes asignados al producto. */
    public void setIngredientes(List<IngredienteProductoDTO> ingredientes) {
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

    /** @return El tipo producto asignado al producto. */
    public Tipo getTipoProducto() {
        return tipoProducto;
    }

    /** @param tipoProducto El tipo de producto que se le asignada al producto. */
    public void setTipoProducto(Tipo tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
}
