package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Clase ClienteDAO.
 * Todas las consultas a la base de datos reacionadas con CLIENTES FRECUENTES
 * @author Jesus Omar, Dario Verdugo, Emily Lara
 */
public class ClienteDAO implements IClienteDAO{

    private static final Logger LOGGER = Logger.getLogger(ClienteDAO.class.getName());
    
    @Override
    public ClienteFrecuente generarClienteFrecuente(
            NuevoClienteFrecuenteDTO nuevoClienteFrecuente
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();

            String jpql = "SELECT c FROM ClienteFrecuente c WHERE c.telefono = :telefono";
            TypedQuery<ClienteFrecuente> query =
                    entityManager.createQuery(jpql, ClienteFrecuente.class);
            query.setParameter("telefono", nuevoClienteFrecuente.getTelefono());

            List<ClienteFrecuente> resultados = query.getResultList();

            if (!resultados.isEmpty()) {
                throw new PersistenciaException("Ya existe un cliente con ese número de teléfono");
            }

            // Crear entidad
            ClienteFrecuente clienteFrecuente = new ClienteFrecuente(
                    nuevoClienteFrecuente.getNombres(),
                    nuevoClienteFrecuente.getApellidoPaterno(),
                    nuevoClienteFrecuente.getApellidoMaterno(),
                    nuevoClienteFrecuente.getEmail(),
                    nuevoClienteFrecuente.getTelefono(),
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
    
    
    @Override
    public ClienteFrecuente editarClienteFrecuente(
            NuevoClienteFrecuenteActualizadoDTO clienteFrecuenteActualizadoDTO
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();

            ClienteFrecuente clienteExistente = entityManager.find(
                    ClienteFrecuente.class, clienteFrecuenteActualizadoDTO.getId()
            );

            // Validamos que el teléfono que se quiere editar no sea reemplazado por uno existente 
            String jpql = "SELECT c FROM ClienteFrecuente c WHERE c.telefono = :telefono";
            TypedQuery<ClienteFrecuente> query =
                    entityManager.createQuery(jpql, ClienteFrecuente.class);
            query.setParameter("telefono", clienteFrecuenteActualizadoDTO.getTelefono());

            List<ClienteFrecuente> resultados = query.getResultList();

            if (!resultados.isEmpty()) {
                ClienteFrecuente otro = resultados.get(0);

                if (!otro.getId().equals(clienteFrecuenteActualizadoDTO.getId())) {
                    throw new PersistenciaException("Teléfono ya en uso");
                }
            }

            // Ya que validamos, ahora si actualizamos
            clienteExistente.setTelefono(clienteFrecuenteActualizadoDTO.getTelefono());
            clienteExistente.setEmail(clienteFrecuenteActualizadoDTO.getEmail());

            entityManager.merge(clienteExistente);
            entityManager.getTransaction().commit();

            return clienteExistente;

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al editar el cliente", ex);
        }
    }
    
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
            EntityManager entityManager = ManejadorConexiones.crearEntityManager(); // Creamos instancia para la conexión

            // A continuación se define la consulta JPQL (ojo, no es SQL directamente)
            String jpql = "SELECT c FROM ClienteFrecuente c " + // Seleccionamos a un cliente c de la tabla clienteFrecuente donde:
                          "WHERE LOWER(c.nombres) LIKE :filtro " + // su nombre (en miusculas) pueda ser como en el filtro (osea el texto que se resibió en la barra de busqueda)...
                          "OR c.telefono LIKE :filtro " + // O su teléfono sea como el que se recibió (filtro)...
                          "OR (c.email IS NOT NULL AND LOWER(c.email) LIKE :filtro)"; // O (si es que el correo no es nulo y lo pasamos a minusculas) que el correo sea igual           
            
            // Ahora vamos a crear la consulta tipada, asegurando que el resultado sea lo que esperamos (ClienteFrecuente) 
            TypedQuery<ClienteFrecuente> query =
                    entityManager.createQuery(jpql, ClienteFrecuente.class);

            // Esta linea es muy especial.
            query.setParameter("filtro", "%" + filtro.toLowerCase() + "%"); //Aquí definimos un parametro, hacemos que "filtro" sea 
            // minuscula y al asignarle % al inicio y al final, le decimos a la linea que busque coincidencia EN CUALQUIER parte del texto.

            return query.getResultList(); // Regresamos la lista de resultados

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al buscar clientes", ex);
        }
    }
    
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
            EntityManager entityManager = ManejadorConexiones.crearEntityManager(); // Se abre la instancia de conexion

            String jpql = "SELECT c FROM ClienteFrecuente c WHERE c.telefono = :telefono"; // Definimos la busqueda que haremos 
            TypedQuery<ClienteFrecuente> query = entityManager.createQuery(jpql, ClienteFrecuente.class); // Creamos la consulta y aseguramos el tipo del resultado (ClienteFrecuenta) 
            query.setParameter("telefono", telefono); // Asigna el valor recibido

            List<ClienteFrecuente> resultados = query.getResultList(); // Obtenemos la lista en lugar de un solo resultado

            if (resultados.isEmpty()) { // Si la lista está vacía, el teléfono está disponible
                return null;  
            }

            return resultados.get(0); // Si no está vacía, devolvemos el primer registro encontrado

        } catch (PersistenceException e) { 
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al validar la existencia del teléfono", e);
        }
    }
}
