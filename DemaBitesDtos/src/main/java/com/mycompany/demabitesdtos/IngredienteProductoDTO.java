package com.mycompany.demabitesdtos;

/**
 * DTO que crear una relacion Ingrediente - Producto.
 * @author Dario
 */
public class IngredienteProductoDTO {
    private Long idIngrediente;
    private Double cantidadRequerida;
    
    // Campos extra para informacion de la interfaz no se persisitiran.
    private String nombre;
    private String unidad;
   
    /**
     * Contructor vacio.
     */
    public IngredienteProductoDTO() {
        
    }

    /**
     * Contructor con todos los campos.
     * @param idIngrediente El ingrediente necesario para hacer el producto.
     * @param cantidadRequerida La cantidad de unidades del ingrediente necesaria para hacer el producto.
     */
    public IngredienteProductoDTO(Long idIngrediente, Double cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
        this.idIngrediente = idIngrediente;
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

    /** @return El id del ingrediente que se utiliza para realizar el producto. */
    public Long getIdIngrediente() {
        return idIngrediente;
    }

    /** @param idIngrediente El id del ingrediente que se asignara al producto. */
    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    /** @return El nombre del ingrediente que se utiliza para realizar el producto. */
    public String getNombre() {
        return nombre;
    }

     /** @param nombre El nombre del ingrediente que se asignara al producto. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** @return La unidad del ingrediente que se utiliza para realizar el producto. */
    public String getUnidad() {
        return unidad;
    }

     /** @param unidad La unidad del ingrediente que se asignara al producto. */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    
}
