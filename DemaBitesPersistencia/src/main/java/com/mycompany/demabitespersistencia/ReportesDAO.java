package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Clase ReportesDAO con metodos para la consulta de reportes.
 * @author Dario
 */
public class ReportesDAO implements IReportesDAO{
    
    private static final Logger LOGGER = Logger.getLogger(ReportesDAO.class.getName());

    @Override
    public List<ReporteClientesDTO> reporteClientes(
            String nombreCliente, Integer minVisitas
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
             String jpql="""
                    SELECT new dto.ReporteClienteDTO(c.nombre, COUNT(q.id), SUM(q.totalVenta), MAX(q.fechaHora))
                    FROM Cliente c
                    JOIN c.comandas q
                    WHERE (:nombre IS NULL OR c.nombre LIKE :nombre)
                    GROUP BY c.id, c.nombre
                    HAVING (:minVisitas IS NULL OR COUNT(q.id)>=:minVisitas)
                    """;  
            TypedQuery<ReporteClientesDTO> query = entityManager.createQuery(jpql, ReporteClientesDTO.class);
            query.setParameter("nombre", (nombreCliente != null && !nombreCliente.isEmpty()) ? "%" + nombreCliente + "%" : null);
            query.setParameter("minVisitas", (minVisitas != null) ? minVisitas.longValue() : null);
            return query.getResultList();
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al realizar la consulta.", ex);
        }
    }
    
}
