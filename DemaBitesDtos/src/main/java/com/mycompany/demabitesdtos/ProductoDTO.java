package com.mycompany.demabitesdtos;

/**
 * DTO para el registro de un nuevo producto.
 * @author emyla
 */
public class ProductoDTO {
    private Long id;
    private String nombre; 
    private Double precio;

    /**
     * Contructor vacio.
     */
    public ProductoDTO(){
    
    }

    /**
     * Contructor con todos los atributos.
     * @param id El id del producto.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     */
    public ProductoDTO(Long id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    /** @return Obtiene el id del producto. */
    public Long getId(){
        return id; 
    }
    
    /** @param id El id que se le asignara al producto. */
    public void setId(Long id){ 
        this.id = id; 
    }

    /** @return Obtiene el nombre del producto. */
    public String getNombre(){
        return nombre;
    }
    
    /** @param nombre El nombre que se le asignara al producto. */
    public void setNombre(String nombre){ 
        this.nombre = nombre; 
    }

    /** @return Obtiene el precio del producto. */
    public Double getPrecio() {
        return precio;
    }

    /** @param precio El precio que se le asignara al producto. */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
     
    /**
     * Metodo toString.
     * @return devuelve el nombre.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
