package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.Producto;
import Enums.Tipo;
import com.mycompany.demabitesdtos.NuevoProductoActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoProductoDTO;
import com.mycompany.demabitesdtos.ProductoEstadoActualizadoDTO;
import java.util.List;

/**
 * Interfaz que define los metodos DAO para la entidad Producto.
 * @author Dario
 */
public interface IProductoDAO {
    
    /**
     * Registra un nuevo producto en el sistema.
     * @param nuevoProducto El DTO del producto que se agregara al sistema.
     * @return El producto agregado al sistema con su ID generado.
     * @throws PersistenciaException Si ocurre un error en el sistema 
     * o ya existe algun producto igual.
     */
    public abstract Producto GenerarProducto(NuevoProductoDTO nuevoProducto)
            throws PersistenciaException;
    
    /**
     * Edita un producto existente en el sistema.
     * @param nuevoProductoActualizado El DTO con los datos actualizados.
     * @return El producto con cambios aplicados.
     * @throws PersistenciaException Si ocurre un error en el sistema 
     * o ya existe algun producto igual.
     */
    public abstract Producto editarProducto(NuevoProductoActualizadoDTO nuevoProductoActualizado)
            throws PersistenciaException;
    
    /**
     * Edita el estado de un producto existente en el sistema.
     * @param productoEstadoActualizado DTO con el estado actualizado.
     * @return El producto con el estado aplicado.
     * @throws PersistenciaException Si ocurre un error en el sistema.
     */
    public abstract Producto editarEstadoProducto(ProductoEstadoActualizadoDTO productoEstadoActualizado)
            throws PersistenciaException;
    
    /**
     * Consulta todos los productos que se encuentran en el sistema.
     * @return Lista de productos que se encuentran en el sistema.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public abstract List<Producto> buscarTodos()
            throws PersistenciaException;
    
    /**
     * Consulta todos los productos activos que se encuentran en el sistema.
     * @return Lista de productos activos que se encuentran en el sistema.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public abstract List<Producto> buscarActivos()
            throws PersistenciaException;
    
    /**
     * Busca un producto por su ID.
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public abstract Producto buscarPorId(Long id)
            throws PersistenciaException;
    
    /**
     * Consulta productos por un filtro de nombre.
     * @param filtro El String que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public abstract List<Producto> localizarPorNombre(String filtro)
            throws PersistenciaException;
    
    /**
     * Consulta productos filtrandolos por su categoria.
     * @param tipo El tipo de producto que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public abstract List<Producto> localizarPorCategoria(Tipo tipo)
            throws PersistenciaException;
    
    /**
     * Consulta productos filtrandolos por su categoria y tipo.
     * @param filtro El String que actuara como filtro.
     * @param tipo El tipo de producto que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public abstract List<Producto> localizarPorNombreYCategoria(String filtro, Tipo tipo)
            throws PersistenciaException;
}
