package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.EstadoComanda;
import com.mycompany.demabitesdominio.Mesa;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Implementación de acceso a datos para la entidad Mesa utilizando JPA.
 * Contiene las consultas directas a la base de datos.
 * @author Emily Lara
 * 270719
 */
public class MesaDAO implements IMesaDAO {

    private static final Logger LOGGER = Logger.getLogger(MesaDAO.class.getName());

    /**
     * Consulta y recupera una lista de las mesas que no están asociadas 
     * a ninguna comanda que se encuentre en estado ABIERTA.
     * @return Lista de entidades {@link Mesa} disponibles.
     * @throws PersistenciaException Si ocurre un error de JPA o de conexión a la base de datos.
     */
    @Override
    public List<Mesa> consultarMesasDisponibles() throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            
            String jpql = "SELECT m FROM Mesa m WHERE m.id NOT IN "
                        + "(SELECT c.mesa.id FROM Comanda c WHERE c.estado = :estadoAbierta)";
            
            TypedQuery<Mesa> query = entityManager.createQuery(jpql, Mesa.class);
            query.setParameter("estadoAbierta", EstadoComanda.ABIERTA);
            
            List<Mesa> mesasDisponibles = query.getResultList();
            
            entityManager.getTransaction().commit();
            return mesasDisponibles;
            
        } catch (PersistenceException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Error al consultar las mesas disponibles en la base de datos.", e);
        }
    }
}