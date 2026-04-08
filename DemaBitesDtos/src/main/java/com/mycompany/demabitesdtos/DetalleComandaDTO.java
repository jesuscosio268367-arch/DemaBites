package com.mycompany.demabitesdtos;

/**
 * Clase DTO(Data Transfer Object) que representa el Detalle de una Comanda.
 * Esta clase sirve para transportar la información sobre los productos específicos,
 * sus cantidades y notas particulares dentro de una orden.
 * * @author Emily Lara
 * 270719
 */
public class DetalleComandaDTO {

    private Long id;
    private Integer cantidad;
    private Double precioVenta;
    private String comentarios;
    private ProductoDTO producto;

    /**
     * Constructor por defecto.
     * Crea una instancia vacía de DetalleComandaDTO.
     */
    public DetalleComandaDTO() {
        
    }

    /**
     * Constructor que inicializa un DetalleComandaDTO con sus datos requeridos.
     * * @param cantidad El número de unidades solicitadas de este producto.
     * @param precioVenta El precio del producto al momento de realizar la comanda.
     * @param comentarios Notas especiales solicitadas por el cliente.
     * @param producto El DTO del producto ordenado.
     */
    public DetalleComandaDTO(Long id, Integer cantidad, Double precioVenta, String comentarios, ProductoDTO producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.comentarios = comentarios;
        this.producto = producto;
    }

    /**
     * Obtiene el identificador único del detalle de la comanda.
     * @return El id del detalle.
     */
    public Long getId(){ 
        return id;
    }
    
    /**
     * Establece el identificador único del detalle de la comanda.
     * @param id El nuevo id a asignar.
     */
    public void setId(Long id){ 
        this.id = id; 
    }

    /**
     * Obtiene la cantidad solicitada del producto.
     * @return La cantidad de unidades.
     */
    public Integer getCantidad(){ 
        return cantidad; 
    }
    
    /**
     * Establece la cantidad solicitada del producto.
     * @param cantidad La nueva cantidad a asignar.
     */
    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad; 
    }

    /**
     * Obtiene el precio de venta del producto registrado en este detalle.
     * @return El precio histórico al que se vendió el producto.
     */
    public Double getPrecioVenta(){ 
        return precioVenta; 
    }
    
    /**
     * Establece el precio de venta para este detalle.
     * @param precioVenta El nuevo precio a asignar.
     */
    public void setPrecioVenta(Double precioVenta){ 
        this.precioVenta = precioVenta; 
    }

    /**
     * Obtiene los comentarios o notas especiales del cliente para este producto.
     * @return Una cadena de texto con las especificaciones (o nulo si no hay notas).
     */
    public String getComentarios(){ 
        return comentarios; 
    }
    
    /**
     * Establece los comentarios o notas especiales para este producto.
     * @param comentarios Las instrucciones especiales del cliente.
     */
    public void setComentarios(String comentarios){ 
        this.comentarios = comentarios; 
    }

    /**
     * Obtiene el producto asociado a esta línea de la comanda.
     * @return Un objeto ProductoDTO que representa el platillo o bebida.
     */
    public ProductoDTO getProducto(){
        return producto; 
    }
    
    /**
     * Establece el producto para esta línea de la comanda.
     * @param producto El objeto ProductoDTO a asociar.
     */
    public void setProducto(ProductoDTO producto){
        this.producto = producto; 
    }
}