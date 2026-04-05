package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import com.mycompany.demabitesutilidades.SeguridadUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Clase ClienteDAO con metodos para la gestion de clientes.
 * Todas las consultas a la base de datos reacionadas con CLIENTES FRECUENTES.
 * @author Jesus Omar, Dario Verdugo, Emily Lara
 */
public class ClienteDAO implements IClienteDAO{

    private static final Logger LOGGER = Logger.getLogger(ClienteDAO.class.getName());
    
    /**
     * Registra un nuevo cliente frecuente en el sistema.
     * @param nuevoClienteFrecuente DTO con la informacion del cliente que se registrara.
     * @return El cliente frecuente creado con su ID generado.
     * @throws PersistenciaException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public ClienteFrecuente generarClienteFrecuente(
            NuevoClienteFrecuenteDTO nuevoClienteFrecuente
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();

            // Buscamos por HASH para validar duplicados
            String telHash = SeguridadUtil.hash(nuevoClienteFrecuente.getTelefono());
            
            String jpql = "SELECT c FROM ClienteFrecuente c WHERE c.telefonoHash = :hash";
            TypedQuery<ClienteFrecuente> query = entityManager.createQuery(jpql, ClienteFrecuente.class);
            query.setParameter("hash", telHash);

            if (!query.getResultList().isEmpty()) {
                throw new PersistenciaException("Ya existe un cliente con ese número de teléfono");
            }

            // Crear entidad con datos encriptados y hash
            ClienteFrecuente clienteFrecuente = new ClienteFrecuente(
                    nuevoClienteFrecuente.getNombres(),
                    nuevoClienteFrecuente.getApellidoPaterno(),
                    nuevoClienteFrecuente.getApellidoMaterno(),
                    nuevoClienteFrecuente.getEmail(),
                    SeguridadUtil.encriptar(nuevoClienteFrecuente.getTelefono()), // AES
                    telHash, // SHA-256
                    LocalDate.now()
            );

            entityManager.persist(clienteFrecuente);
            entityManager.getTransaction().commit();

            return clienteFrecuente;

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo crear un nuevo cliente frecuente", ex);
        }
    }
    
    /**
     * Edita un cliente frecuente del sistema.
     * @param dto DTO con los datos actualizados.
     * @return El cliente frecuente con los cambios aplicados.
     * @throws PersistenciaException Si el cliente no existe o falla la actualizacion.
     */
    @Override
    public ClienteFrecuente editarClienteFrecuente(
            NuevoClienteFrecuenteActualizadoDTO dto
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();

            ClienteFrecuente clienteExistente = entityManager.find(ClienteFrecuente.class, dto.getId());

            // Validar duplicado usando Hash
            String nuevoHash = SeguridadUtil.hash(dto.getTelefono());
            String jpql = "SELECT c FROM ClienteFrecuente c WHERE c.telefonoHash = :hash";
            TypedQuery<ClienteFrecuente> query = entityManager.createQuery(jpql, ClienteFrecuente.class);
            query.setParameter("hash", nuevoHash);

            List<ClienteFrecuente> resultados = query.getResultList();
            if (!resultados.isEmpty()) {
                ClienteFrecuente otro = resultados.get(0);
                if (!otro.getId().equals(dto.getId())) {
                    throw new PersistenciaException("Teléfono ya en uso por otro cliente");
                }
            }

            // Actualizar campos de seguridad
            clienteExistente.setTelefonoEncriptado(SeguridadUtil.encriptar(dto.getTelefono()));
            clienteExistente.setTelefonoHash(nuevoHash);
            clienteExistente.setEmail(dto.getEmail());

            entityManager.merge(clienteExistente);
            entityManager.getTransaction().commit();

            return clienteExistente;

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al editar el cliente", ex);
        }
    }
    
    /**
     * Consulta todos los clientes frecuentes que se encuentran en el sistema.
     * @return La lista de clientes frecuentes en el sistema.
     * @throws PersistenciaException Si hay un error en la consulta.
     */
    @Override
    public List<ClienteFrecuente> consultarTodos() throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            String jpql = "SELECT c FROM ClienteFrecuente c";
            TypedQuery<ClienteFrecuente> query = entityManager.createQuery(jpql, ClienteFrecuente.class);
            List<ClienteFrecuente> clientes = query.getResultList();
            entityManager.getTransaction().commit();
            return clientes;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al consultar clientes", ex);
        }
    }
    
    /**
     * Método filtrar.
     * @param filtro
     * @return lista Clientes Frecuentes
     * @throws PersistenciaException 
     * Método dinámico que filtra tanto por nombre como por correo o por telefono al mismo tiempo.
     * Es implementado en el buscador de la tabla de cliientes.
     */
    @Override
    public List<ClienteFrecuente> filtrar(String filtro) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();

            // Si el filtro parece un teléfono (solo números), buscamos por HASH exacto.
            // Si es texto, buscamos por nombre/correo normalmente.
            String jpql;
            if (filtro.matches("\\d+")) { 
                jpql = "SELECT c FROM ClienteFrecuente c WHERE c.telefonoHash = :filtroHash";
            } else {
                jpql = "SELECT c FROM ClienteFrecuente c WHERE LOWER(c.nombres) LIKE :filtro " +
                       "OR (c.email IS NOT NULL AND LOWER(c.email) LIKE :filtro)";
            }

            TypedQuery<ClienteFrecuente> query = entityManager.createQuery(jpql, ClienteFrecuente.class);

            if (filtro.matches("\\d+")) {
                query.setParameter("filtroHash", SeguridadUtil.hash(filtro));
            } else {
                query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");
            }

            return query.getResultList();

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al buscar clientes", ex);
        }
    }
    
    /**
     * Busca clientes frecuentes con su ID.
     * @param id ID del cliente frecuente a buscar.
     * @return El cliente frecuente encontrado.
     * @throws PersistenciaException Si no encuentra al cliente o ocurre un error en la busqueda.
     */
    @Override
    public ClienteFrecuente consultarPorId(Long id) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            ClienteFrecuente cliente = entityManager.find(ClienteFrecuente.class, id);
            return cliente; 
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar el cliente", ex);
        }
    }
    
    /**
     * Método Consutar Por Teléfono
     * @param telefono
     * @return Cliente Frecuente
     * @throws PersistenciaException
     * Este método se encarga de consultar y validar si ya existe un numero de
     * teléfono registrado.
     * Este método es utilizado al momento de validar la existencia del registro de un cliente con el mismo número.
     */
    @Override
    public ClienteFrecuente consultarPorTelefono(String telefono) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            
            // Consulta por Hash
            String jpql = "SELECT c FROM ClienteFrecuente c WHERE c.telefonoHash = :hash";
            TypedQuery<ClienteFrecuente> query = entityManager.createQuery(jpql, ClienteFrecuente.class);
            query.setParameter("hash", SeguridadUtil.hash(telefono));

            List<ClienteFrecuente> resultados = query.getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);

        } catch (PersistenceException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al consultar por teléfono", e);
        }
    }
}
