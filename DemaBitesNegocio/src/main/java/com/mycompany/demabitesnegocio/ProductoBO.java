package com.mycompany.demabitesnegocio;

import Enums.Tipo;
import com.mycompany.demabitesdominio.Producto;
import com.mycompany.demabitesdtos.NuevoProductoActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoProductoDTO;
import com.mycompany.demabitesdtos.ProductoEstadoActualizadoDTO;
import com.mycompany.demabitespersistencia.IProductoDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 * Clase de objeto de negocio para la validacion de productos.
 * @author Dario
 */
public class ProductoBO implements IProductoBO{

    private final IProductoDAO productoDAO;
    
    /**
     * Contructor con la dao necesaria para la persistencia.
     * @param productoDAO instancia que implementa IProductoDAO.
     */
    public ProductoBO(IProductoDAO productoDAO){
        this.productoDAO = productoDAO;
    }
    
    /**
     * Validaciones para el registro de un nuevo producto en el sistema.
     * @param nuevoProducto El DTO del producto que se agregara al sistema.
     * @return El producto agregado al sistema con su ID generado.
     * @throws NegocioException Si un campo esta vacio o es inadecuado.
     */
    @Override
    public Producto GenerarProducto(NuevoProductoDTO nuevoProducto) throws NegocioException {
        if (nuevoProducto.getNombre() == null || nuevoProducto.getNombre().isBlank()) {
            throw new NegocioException("El nombre del producto no puede estar vacio.", null);
        }
        if (nuevoProducto.getNombre().length() > 50){
            throw new NegocioException("El nombre no puede ser tan largo.", null);
        }
        if (nuevoProducto.getPrecio() == null) {
            throw new NegocioException("El precio no debe ser nulo.", null);
        }
        if (nuevoProducto.getPrecio() <= 0) {
            throw new NegocioException("El precio debe ser un valor positivo.", null);
        }
        if (nuevoProducto.getTipoProducto() == null){
            throw new NegocioException("El tipo no puede ser nulo.", null);
        }
        if (nuevoProducto.getIngredientes() == null || nuevoProducto.getIngredientes().isEmpty()) {
            throw new NegocioException("No se puede crear un producto sin una receta (ingredientes).", null);
        }
        if (nuevoProducto.getDescripcion() == null){
            throw new NegocioException("No se puede crear un producto sin descripcion.", null);
        }
        try {
            Producto producto = productoDAO.GenerarProducto(nuevoProducto);
            return producto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar el producto.", ex);
        }
    }

    /**
     * Validaciones para la edicion de un producto existente en el sistema.
     * @param nuevoProductoActualizado El DTO con los datos actualizados.
     * @return El producto con cambios aplicados.
     * @throws NegocioException Si un campo esta vacio, es inadecuado o no se encuentra ningun registro con ese ID.
     */
    @Override
    public Producto editarProducto(NuevoProductoActualizadoDTO nuevoProductoActualizado) throws NegocioException {
        if (nuevoProductoActualizado.getId() == null || nuevoProductoActualizado.getId() <= 0) {
            throw new NegocioException("El ID del producto a editar no es valido.", null);
        }
        if (nuevoProductoActualizado.getNombre() == null || nuevoProductoActualizado.getNombre().isBlank()) {
            throw new NegocioException("El nombre del producto no puede estar vacio.", null);
        }
        if (nuevoProductoActualizado.getNombre().length() > 50) {
            throw new NegocioException("El nombre no puede ser tan largo.", null);
        }
        if (nuevoProductoActualizado.getPrecio() == null || nuevoProductoActualizado.getPrecio() <= 0) {
            throw new NegocioException("El precio debe ser un valor positivo.", null);
        }
        if (nuevoProductoActualizado.getIngredientes() == null || nuevoProductoActualizado.getIngredientes().isEmpty()) {
            throw new NegocioException("No se puede crear un producto sin una receta (ingredientes).", null);
        }
        if (nuevoProductoActualizado.getDescripcion() == null){
            throw new NegocioException("No se puede crear un producto sin descripcion.", null);
        }
        try {
            Producto producto = productoDAO.editarProducto(nuevoProductoActualizado);
            return producto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo actualizar el producto en el sistema.", ex);
        }
    }

    /**
     * Validaciones para la edicion del estado de un producto existente en el sistema.
     * @param productoEstadoActualizado DTO con el estado actualizado.
     * @return El producto con el estado aplicado.
     * @throws NegocioException Si no se encuentra ningun registro con ese ID.
     */
    @Override
    public Producto editarEstadoProducto(ProductoEstadoActualizadoDTO productoEstadoActualizado) throws NegocioException {
        if (productoEstadoActualizado.getId() == null || productoEstadoActualizado.getId() <= 0) {
        throw new NegocioException("ID de producto no valido para cambio de estado.", null);
        }
        if (productoEstadoActualizado.getEstado() == null) {
            throw new NegocioException("El nuevo estado no puede ser nulo.", null);
        }
        try {
            Producto producto = productoDAO.editarEstadoProducto(productoEstadoActualizado);
            return producto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al cambiar el estado del producto.", ex);
        }
    }

    /**
     * Validaciones para la consulta de todos los productos que se encuentran en el sistema.
     * @return Lista de productos que se encuentran en el sistema.
     * @throws NegocioException Si no se encuentran registros.
     */
    @Override
    public List<Producto> buscarTodos() throws NegocioException {
        try{
            List<Producto> listaProductos = productoDAO.buscarTodos();
            return listaProductos;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al cargar los productos.", ex);
        }
    }

    /**
     * Validaciones para la consulta todos los productos activos que se encuentran en el sistema.
     * @return Lista de productos activos que se encuentran en el sistema.
     * @throws NegocioException Si no se encuentran registros activos.
     */
    @Override
    public List<Producto> buscarActivos() throws NegocioException {
        try{
            List<Producto> listaProductosActivos = productoDAO.buscarActivos();
            return listaProductosActivos;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al cargar los productos activos.", ex);
        }
    }

    /**
     * Validaciones para la busqueda de un producto por su ID.
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     * @throws NegocioException Si no se encuentra ningun registro con ese ID.
     */
    @Override
    public Producto buscarPorId(Long id) throws NegocioException {
        if (id == null || id <= 0) {
            throw new NegocioException("ID de producto no valido para la busqueda.", null);
        }
        try {
            Producto producto = productoDAO.buscarPorId(id);
            if (producto == null) {
                throw new NegocioException("El producto con ID " + id + " no fue encontrado.", null);
            }
            return producto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar el producto por ID.", ex);
        }
    }

    /**
     * Validaciones para la consulta de productos por un filtro de nombre.
     * @param filtro El String que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws NegocioException Si no se encuentra ningun registro con ese filtro.
     */
    @Override
    public List<Producto> localizarPorNombre(String filtro) throws NegocioException {
        if (filtro == null || filtro.trim().isEmpty()) {
            return this.buscarTodos();
        }
        if (filtro.length() > 50) {
            throw new NegocioException("El filtro de busqueda es demasiado largo.", null);
        }
        try {
            List<Producto> listaProductos = productoDAO.localizarPorNombre(filtro);
            return listaProductos;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al realizar la busqueda por nombre.", ex);
        }
    }

    /**
     * Validaciones para la consulta de productos filtrandolos por su categoria.
     * @param tipo El tipo de producto que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws NegocioException Si no se encuentra ningun registro con ese filtro.
     */
    @Override
    public List<Producto> localizarPorCategoria(Tipo tipo) throws NegocioException {
        if (tipo == null) {
            throw new NegocioException("Debe seleccionar una categoria valida para filtrar.", null);
        }
        try {
            List<Producto> listaProductosTipo = productoDAO.localizarPorCategoria(tipo);
            return listaProductosTipo;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al filtrar los productos por categoria.", ex);
        }
    }

    /**
     * Validaciones para consultar productos filtrandolos por su categoria y tipo.
     * @param filtro El String que actuara como filtro.
     * @param tipo El tipo de producto que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws NegocioException Si no se encuentra ningun registro con ese filtro.
     */
    @Override
    public List<Producto> localizarPorNombreYCategoria(String filtro, Tipo tipo) throws NegocioException {
        if ((filtro == null || filtro.isBlank()) && tipo == null) {
            return this.buscarActivos();
        }
        if (filtro != null && filtro.length() > 50) {
            throw new NegocioException("El filtro de busqueda es demasiado largo.", null);
        }
        try {
            if (filtro != null && !filtro.isBlank() && tipo != null) {
                return productoDAO.localizarPorNombreYCategoria(filtro, tipo);
            }
            if (filtro != null && !filtro.isBlank()) {
                return productoDAO.localizarPorNombre(filtro);
            }
            return productoDAO.localizarPorCategoria(tipo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al realizar la busqueda.", ex);
        }
    }
    
}
