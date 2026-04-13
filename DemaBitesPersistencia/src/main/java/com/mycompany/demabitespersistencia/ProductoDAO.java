package com.mycompany.demabitespersistencia;

import Enums.EstadoProducto;
import com.mycompany.demabitesdominio.Producto;
import com.mycompany.demabitesdominio.ProductoIngrediente;
import Enums.Tipo;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.IngredienteProductoDTO;
import com.mycompany.demabitesdtos.NuevoProductoActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoProductoDTO;
import com.mycompany.demabitesdtos.ProductoEstadoActualizadoDTO;
import com.mycompany.demabitespersistencia.adapters.NuevoProductoDTOAProductoAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Clase ProductoDAO con metodos para la gestion de productos.
 * @author Dario
 */
public class ProductoDAO implements IProductoDAO{

    private static final Logger LOGGER = Logger.getLogger(ProductoDAO.class.getName());
    
    /**
     * Registra un nuevo producto en el sistema.
     * @param nuevoProducto El DTO del producto que se agregara al sistema.
     * @return El producto agregado al sistema con su ID generado.
     * @throws PersistenciaException Si ocurre un error en el sistema 
     * o ya existe algun producto igual.
     */
    @Override
    public Producto GenerarProducto(
            NuevoProductoDTO nuevoProducto
    ) throws PersistenciaException {
        Producto producto = NuevoProductoDTOAProductoAdapter.adaptar(nuevoProducto);
        try{
           EntityManager entityManager = ManejadorConexiones.crearEntityManager();
           entityManager.getTransaction().begin();
           
           List<ProductoIngrediente> receta = new ArrayList<>();
        
            if (nuevoProducto.getIngredientes() != null) {
                for (IngredienteProductoDTO ingredienteProducto : nuevoProducto.getIngredientes()) {
                    ProductoIngrediente detalle = new ProductoIngrediente();
                    detalle.setCantidadRequerida(ingredienteProducto.getCantidadRequerida());
                    Ingrediente ingrediente = entityManager.getReference(Ingrediente.class, ingredienteProducto.getIdIngrediente());
                    detalle.setIngrediente(ingrediente);
                    detalle.setProducto(producto);
                    receta.add(detalle);
                }
                producto.setIngredientes(receta);
            } 
           
           entityManager.persist(producto);
           entityManager.getTransaction().commit();
           return producto;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo crear el producto.", ex);
        }
    }

    /**
     * Edita un producto existente en el sistema.
     * @param nuevoProductoActualizado El DTO con los datos actualizados.
     * @return El producto con cambios aplicados.
     * @throws PersistenciaException Si ocurre un error en el sistema 
     * o ya existe algun producto igual.
     */
    @Override
    public Producto editarProducto(
            NuevoProductoActualizadoDTO nuevoProductoActualizado
    ) throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            
            Producto producto = entityManager.find(Producto.class, nuevoProductoActualizado.getId());
            if(producto == null){
                throw new PersistenciaException("Producto no encontrado.");
            }
            
            producto.setNombre(nuevoProductoActualizado.getNombre());
            producto.setPrecio(nuevoProductoActualizado.getPrecio());
            producto.setDescripcion(nuevoProductoActualizado.getDescripcion());
            producto.setImagenProducto(nuevoProductoActualizado.getImagenProducto());
            
            if(producto.getIngredientes() != null){
                producto.getIngredientes().clear();
            }else{
                producto.setIngredientes(new ArrayList<>());
            }
            entityManager.flush();
            if (nuevoProductoActualizado.getIngredientes() != null) {
                for (IngredienteProductoDTO ingredienteProducto : nuevoProductoActualizado.getIngredientes()) {
                    ProductoIngrediente detalle = new ProductoIngrediente();
                    detalle.setCantidadRequerida(ingredienteProducto.getCantidadRequerida());
                    Ingrediente ingrediente = entityManager.getReference(Ingrediente.class, ingredienteProducto.getIdIngrediente());
                    detalle.setIngrediente(ingrediente);
                    detalle.setProducto(producto);
                    producto.getIngredientes().add(detalle);
                }
            }
            
            entityManager.merge(producto);
            entityManager.getTransaction().commit();
            return producto;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo editar el producto", ex);
        }
    }

    /**
     * Edita el estado de un producto existente en el sistema.
     * @param productoEstadoActualizado DTO con el estado actualizado.
     * @return El producto con el estado aplicado.
     * @throws PersistenciaException Si ocurre un error en el sistema.
     */
    @Override
    public Producto editarEstadoProducto(
            ProductoEstadoActualizadoDTO productoEstadoActualizado
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();

            Producto producto = entityManager.find(Producto.class, productoEstadoActualizado.getId());
            if (producto == null) {
                throw new PersistenciaException("Producto no encontrado.");
            }

            EstadoProducto nuevoEstado = EstadoProducto.ACTIVO;
            if (productoEstadoActualizado.getEstado() == Enums.EstadoProducto.INACTIVO) {
                nuevoEstado = EstadoProducto.INACTIVO;
            }
            
            producto.setEstado(nuevoEstado);
            entityManager.merge(producto);
            entityManager.getTransaction().commit();
            return producto;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al cambiar el estado del producto.", ex);
        }
    }

    /**
     * Consulta todos los productos que se encuentran en el sistema.
     * @return Lista de productos que se encuentran en el sistema.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    @Override
    public List<Producto> buscarTodos() throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            TypedQuery<Producto> query = entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
            return query.getResultList();
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al consultar todos los productos.", ex);
        }
    }
    
    /**
     * Consulta todos los productos activos que se encuentran en el sistema.
     * @return Lista de productos activos que se encuentran en el sistema.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    @Override
    public List<Producto> buscarActivos() throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            TypedQuery<Producto> query = entityManager.createQuery("SELECT p FROM Producto p WHERE p.estado = :estado", Producto.class);
            query.setParameter("estado", Enums.EstadoProducto.ACTIVO);
            return query.getResultList();
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al consultar todos los productos activos.", ex);
        }
    }

    /**
     * Busca un producto por su ID.
     * @param id El ID del producto a buscar.
     * @return El producto encontrado.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    @Override
    public Producto buscarPorId(Long id) throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            Producto producto = entityManager.find(Producto.class, id);
            if (producto != null && producto.getEstado() != EstadoProducto.ACTIVO) {
                return null;
            }
            return producto;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al consultar por ID.", ex);
        }
    }

    /**
     * Consulta productos por un filtro de nombre.
     * @param filtro El String que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    @Override
    public List<Producto> localizarPorNombre(String filtro) throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            TypedQuery<Producto> query = entityManager.createQuery
            ("SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(:filtro) AND p.estado = :estado", Producto.class);
            query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");
            query.setParameter("estado", EstadoProducto.ACTIVO);
            return query.getResultList();
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al filtrar por nombre.", ex);
        }
    }

    /**
     * Consulta productos filtrandolos por su categoria.
     * @param tipo El tipo de producto que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    @Override
    public List<Producto> localizarPorCategoria(Tipo tipo) throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            TypedQuery<Producto> query = entityManager.createQuery
            ("SELECT p FROM Producto p WHERE p.tipoProducto = :tipo AND p.estado = :estado", Producto.class);
            query.setParameter("tipo", tipo);
            query.setParameter("estado", EstadoProducto.ACTIVO);
            return query.getResultList();
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al filtrar por categoria.", ex);
        }
    }

    /**
     * Consulta productos filtrandolos por su categoria y tipo.
     * @param filtro El String que actuara como filtro.
     * @param tipo El tipo de producto que actuara como filtro.
     * @return Lista de productos que coinciden por el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    @Override
    public List<Producto> localizarPorNombreYCategoria(String filtro, Tipo tipo) throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            TypedQuery<Producto> query = entityManager.createQuery(
                    "SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(:filtro) " +
                    "AND p.tipoProducto = :tipo AND p.estado = :estado", 
                    Producto.class);
            query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");
            query.setParameter("tipo", tipo);
            query.setParameter("estado", EstadoProducto.ACTIVO);
            return query.getResultList();
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al filtrar por categoria y nombre.", ex);
        }
    }
    
}
