package com.mycompany.demabitespersistencia.adapters;

import com.mycompany.demabitesdominio.Producto;
import Enums.Tipo;
import com.mycompany.demabitesdtos.NuevoProductoDTO;

/**
 * Adapter encargado de convetrir el DTO de productos a dominio para su gestion.
 * @author Dario
 */
public class NuevoProductoDTOAProductoAdapter {
    
    /**
     * Tranforma NuevoProductoDTO a una entidad Producto.
     * @param nuevoProducto El DTO con los datos del producto.
     * @return Un producto para ser persistido.
     */
    public static Producto adaptar(NuevoProductoDTO nuevoProducto){
        Tipo tipo = Tipo.PLATILLO; 
        if (nuevoProducto.getTipoProducto() == Enums.Tipo.BEBIDA) {
            tipo = Tipo.BEBIDA;
        } else if (nuevoProducto.getTipoProducto() == Enums.Tipo.POSTRE) {
            tipo = Tipo.POSTRE;
        }

        Producto producto = new Producto();
        producto.setNombre(nuevoProducto.getNombre());
        producto.setPrecio(nuevoProducto.getPrecio());
        producto.setDescripcion(nuevoProducto.getDescripcion());
        producto.setTipoProducto(tipo);
        producto.setEstado(Enums.EstadoProducto.ACTIVO);
        producto.setImagenProducto(nuevoProducto.getImagenProducto());
        
        return producto;
    }
}
