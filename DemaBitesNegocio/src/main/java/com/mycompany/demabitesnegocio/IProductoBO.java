package com.mycompany.demabitesnegocio;

import Enums.Tipo;
import com.mycompany.demabitesdominio.Producto;
import com.mycompany.demabitesdtos.NuevoProductoActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoProductoDTO;
import com.mycompany.demabitesdtos.ProductoEstadoActualizadoDTO;
import java.util.List;

/**
 * Interfaz que define los metodos BO para las validaciones de la entidad Producto.
 * @author Dario
 */
public interface IProductoBO {
    
    /**
     * Validaciones para el registro de un nuevo producto en el sistema.
     * @param nuevoProducto El DTO del producto que se agregara al sistema.
     * @return El producto agregado al sistema con su ID generado.
     * @throws NegocioException Si un campo esta vacio o es inadecuado.
     */
    public abstract Producto GenerarProducto(NuevoProductoDTO nuevoProducto)
            throws NegocioException;
    
    /**
     * Validaciones para la edicion de un producto existente en el sistema.
     * @param nuevoProductoActualizado El DTO con los datos actualizados.
     * @return El producto con cambios aplicados.
     * @throws NegocioException Si un campo esta vacio, es inadecuado o no se encuentra ningun registro con ese ID.
     */
    public abstract Producto editarProducto(NuevoProductoActualizadoDTO nuevoProductoActualizado)
            throws NegocioException;
    
    /**
     * Validaciones para la edicion del estado de un producto existente en el sistema.
     * @param productoEstadoActualizado DTO con el estado actualizado.
     * @return El producto con el estado aplicado.
     * @throws NegocioException Si no se encuentra ningun registro con ese ID.
     */
    public abstract Producto editarEstadoProducto(ProductoEstadoActualizadoDTO productoEstadoActualizado)
            throws NegocioException;
    
    /**
     * Validaciones para la consulta de todos los productos que se encuentran en el sistema.
     * @return Lista de productos que se encuentran en el sistema.
     * @throws NegocioException Si no se encuentran registros.
     */
    public abstract List<Producto> buscarTodos()
            throws NegocioException;
    
    /**
     * Validaciones para la consulta todos los productos activos que se encuentran en el sistema.
     * @return Lista de productos activos que se encuentran en el sistema.
     * @throws NegocioException Si no se encuentran registros activos.
     */
    public abstract List<Producto> buscarActivos()
            throws NegocioException;
    
    /**
     * Validaciones para la busqueda de un producto por su ID.
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     * @throws NegocioException Si no se encuentra ningun registro con ese ID.
     */
    public abstract Producto buscarPorId(Long id)
            throws NegocioException;
    
    /**
     * Validaciones para la consulta de productos por un filtro de nombre.
     * @param filtro El String que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws NegocioException Si no se encuentra ningun registro con ese filtro.
     */
    public abstract List<Producto> localizarPorNombre(String filtro)
            throws NegocioException;
    
    /**
     * Validaciones para la consulta de productos filtrandolos por su categoria.
     * @param tipo El tipo de producto que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws NegocioException Si no se encuentra ningun registro con ese filtro.
     */
    public abstract List<Producto> localizarPorCategoria(Tipo tipo)
            throws NegocioException;
    
    
    /**
     * Validaciones para consultar productos filtrandolos por su categoria y tipo.
     * @param filtro El String que actuara como filtro.
     * @param tipo El tipo de producto que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws NegocioException Si no se encuentra ningun registro con ese filtro.
     */
    public abstract List<Producto> localizarPorNombreYCategoria(String filtro, Tipo tipo)
            throws NegocioException;
}