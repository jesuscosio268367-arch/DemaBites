package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdominio.Comanda;
import com.mycompany.demabitesdominio.DetalleComanda;
import com.mycompany.demabitesdominio.EstadoComanda;
import com.mycompany.demabitesdominio.Mesa;
import com.mycompany.demabitesdominio.Producto;
import com.mycompany.demabitesdtos.DetalleComandaDTO;
import com.mycompany.demabitesdtos.NuevaComandaDTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * DAO para la gestión de comandas siguiendo el esquema de la clase.
 * Implementa las operaciones CRUD para la entidad Comanda utilizando JPA.
 * @author Emily Lara
 */
public class ComandaDAO implements IComandaDAO {

    private static final Logger LOGGER = Logger.getLogger(ComandaDAO.class.getName());

    /**
     * Registra una nueva comanda en el sistema mapeando los datos de un DTO.
     * @param nuevaComanda El objeto DTO con los datos de la comanda y sus detalles.
     * @return La entidad Comanda guardada con su folio generado automáticamente.
     * @throws PersistenciaException Si la transacción falla o la base de datos rechaza el registro.
     */
    @Override
    public Comanda agregarComanda(NuevaComandaDTO nuevaComanda) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();

            //Primero generamos el folio con el metodo privado del final
            String folioGenerado = generarFolio(entityManager); 

            //Luego se convierte NuevaComandaDTO a Comanda (osea, el mapeado)
            Comanda comanda = new Comanda();
            comanda.setFolio(folioGenerado); //Seteamos el folio con ayuda de lo que nos haya devuelto el metodo privado
            comanda.setFechaHora(nuevaComanda.getFechaHora()); //Seteamos fecha y hora
            comanda.setEstado(EstadoComanda.ABIERTA); // Estado inicial
            comanda.setTotal(nuevaComanda.getTotal()); // Seteamos el total
            
            //Vinculamos la mesa
            Mesa mesa = entityManager.find(Mesa.class, nuevaComanda.getMesa().getId());
            comanda.setMesa(mesa); 

            // Vincular el Cliente (solo si el DTO trae uno, sino queda en null como "Cliente General")
            if (nuevaComanda.getCliente() != null && nuevaComanda.getCliente().getId() != null) {
                ClienteFrecuente cliente = entityManager.getReference(ClienteFrecuente.class, nuevaComanda.getCliente().getId());
                comanda.setCliente(cliente);
            }

            //Ahora convertimos DetalleComandaDTO a DetalleComanda
            List<DetalleComanda> nuevosDetalles = new LinkedList<>();
            for (DetalleComandaDTO detalleDTO : nuevaComanda.getDetalles()) {
                DetalleComanda detalle = new DetalleComanda(); //Creamos un nuevo detalle 
                detalle.setCantidad(detalleDTO.getCantidad());//Buscamos la cantidad del producto que se llevará
                detalle.setPrecioVenta(detalleDTO.getPrecioVenta()); //Buscamos el precio
                detalle.setComentarios(detalleDTO.getComentarios()); //Buscamos los comentarios
                
                // Vinculamos el producto referenciado
                Producto producto = entityManager.find(Producto.class, detalleDTO.getProducto().getId());
                detalle.setProducto(producto);
                
                // Relación bidireccional
                detalle.setComanda(comanda); //relacionamos los detalles con la comanda que estamos levantando
                nuevosDetalles.add(detalle); //agregamos los detalles a la lista
            }
            comanda.setDetalles(nuevosDetalles);

            //Operaciones de base de datos
            entityManager.persist(comanda);
            entityManager.getTransaction().commit();
            return comanda;

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se logró registrar la comanda", ex);
        }
    }

    /**
     * Modifica el estado actual de una comanda registrada.
     * @param id Identificador interno de la comanda.
     * @param nuevoEstado El estado al que se desea cambiar.
     * @return La comanda con el estado modificado.
     * @throws PersistenciaException Si no se logra actualizar el estado en base de datos.
     */
    @Override
    public Comanda actualizarEstado(Long id, EstadoComanda nuevoEstado) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            
            Comanda comandaGuardada = entityManager.find(Comanda.class, id); //Buscamos la comanda en la base de datos
            if (comandaGuardada != null) { // si la comanda guardada es nula
                comandaGuardada.setEstado(nuevoEstado);
                entityManager.persist(comandaGuardada);
            }
            
            entityManager.getTransaction().commit();
            return comandaGuardada;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se logró modificar el estado de la comanda", ex);
        }
    }

    /**
     * Busca y retorna una comanda utilizando su ID mediante Criteria y TypedQuery.
     * @param id El identificador único de la comanda.
     * @return La entidad Comanda correspondiente al ID.
     * @throws PersistenciaException Si ocurre un error al consultar JPA.
     */
    @Override
    public Comanda consultar(Long id) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Comanda> cq = cb.createQuery(Comanda.class);
            Root<Comanda> root = cq.from(Comanda.class);
            
            cq.select(root).where(cb.equal(root.get("id"), id));
            
            TypedQuery<Comanda> query = entityManager.createQuery(cq);
            Comanda comanda = query.getSingleResult();
            
            entityManager.getTransaction().commit();
            return comanda;
        } catch (NoResultException ex) {
            return null; // Retorna null si no lo encuentra, para que no truene el programa
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se logró consultar la comanda por ID", ex);
        }
    }

    /**
     * Busca y retorna una comanda utilizando su folio.
     * @param folio El string del folio a buscar (ej. OB-20231024-001).
     * @return La entidad Comanda encontrada, o null si no existe.
     * @throws PersistenciaException Si la consulta a la base de datos falla.
     */
    @Override
    public Comanda consultarPorFolio(String folio) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Comanda> cq = cb.createQuery(Comanda.class);
            Root<Comanda> root = cq.from(Comanda.class);
            
            cq.select(root).where(cb.equal(root.get("folio"), folio));
            
            TypedQuery<Comanda> query = entityManager.createQuery(cq);
            Comanda comanda = query.getSingleResult();
            
            entityManager.getTransaction().commit();
            return comanda;
        } catch (NoResultException ex) {
            return null;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se logró consultar la comanda por folio", ex);
        }
    }

    /**
     * Recupera la lista completa de todas las comandas en el sistema.
     * @return Una colección List con todas las comandas.
     * @throws PersistenciaException Si la consulta falla.
     */
    @Override
    public List<Comanda> consultarTodos() throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            
            // 1. Obtenemos el CriteriaBuilder
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            // 2. Creamos el objeto CriteriaQuery especificando qué va a devolver (Comanda)
            CriteriaQuery<Comanda> cq = cb.createQuery(Comanda.class);
            // 3. Definimos el "FROM" de la consulta
            Root<Comanda> root = cq.from(Comanda.class);
            // 4. Armamos el SELECT (Select * de Comanda)
            cq.select(root);
            
            // Ejecutamos la consulta
            TypedQuery<Comanda> query = entityManager.createQuery(cq);
            List<Comanda> comandas = query.getResultList();
            
            entityManager.getTransaction().commit();
            return comandas;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se lograron consultar las comandas", ex);
        }
    }

    /**
     * Método privado de apoyo para generar el folio automáticamente.
     * Busca la última comanda registrada en el día actual y genera el siguiente
     * número consecutivo manteniendo el formato OB-YYYYMMDD-XXX.
     * @param em El EntityManager activo utilizado para la consulta.
     * @return El folio generado como String.
     */
    private String generarFolio(EntityManager em) {
        LocalDate hoy = LocalDate.now(); 
        String fechaStr = hoy.format(DateTimeFormatter.ofPattern("yyyyMMdd")); 
        String prefijo = "OB-" + fechaStr + "-"; 
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // Como solo queremos devolver el String del folio, el query es de tipo String
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<Comanda> root = cq.from(Comanda.class);
        
        // SELECT c.folio
        cq.select(root.get("folio"));
        // WHERE c.folio LIKE 'prefijo%'
        cq.where(cb.like(root.get("folio"), prefijo + "%"));
        // ORDER BY c.folio DESC
        cq.orderBy(cb.desc(root.get("folio")));
        
        TypedQuery<String> query = em.createQuery(cq);
        query.setMaxResults(1); 
        
        try {
            String ultimoFolio = query.getSingleResult();
            String[] partes = ultimoFolio.split("-");
            int consecutivo = Integer.parseInt(partes[2]);
            consecutivo++; 
            return prefijo + String.format("%03d", consecutivo);
            
        } catch (NoResultException e) {
            return prefijo + "001";
        }
    }
}