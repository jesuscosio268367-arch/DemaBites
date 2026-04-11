package com.mycompany.demabitesdtos;

import Enums.EstadoProducto;

/**
 * DTO para la actualizacion de estado de un producto.
 * @author Dario
 */
public class ProductoEstadoActualizadoDTO {
    private Long id;
    private EstadoProducto estado;

    /**
     * Contructor vacio.
     */
    public ProductoEstadoActualizadoDTO() {
        
    }

    /**
     * Contructor con todos los atributos.
     * @param id El ID del producto para editar su estado.
     * @param estado El estado que se editara.
     */
    public ProductoEstadoActualizadoDTO(Long id, EstadoProducto estado) {
        this.id = id;
        this.estado = estado;
    }

    /**
     * Contructor con el atributo estado.
     * @param estado El estado que tendra el producto.
     */
    public ProductoEstadoActualizadoDTO(EstadoProducto estado) {
        this.estado = estado;
    }

    /** @return El ID unico del producto. */
    public Long getId() {
        return id;
    }

    /** @param id El ID asignado al producto. */
    public void setId(Long id) {
        this.id = id;
    }

   /** @return El estado del producto. */
    public EstadoProducto getEstado() {
        return estado;
    }

    /** @param estado El estado asignado al producto (valor predeterminado "ACTIVO"). */
    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }
    
}
