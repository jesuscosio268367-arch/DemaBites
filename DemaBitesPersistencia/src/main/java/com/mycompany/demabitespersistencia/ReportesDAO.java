package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import com.mycompany.demabitesdtos.ReporteComandasDTO;
import java.time.LocalDateTime;
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

    /**
     * Consulta clientes y datos especificos de estos.
     * @param nombreCliente Nombre del cliente para buscar.
     * @param minVisitas Numero de veces minimo para la busqueda.
     * @return Lista de clientes que coincidan con el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    @Override
    public List<ReporteClientesDTO> reporteClientes(
            String nombreCliente, Integer minVisitas
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
             String jpql="""
                    SELECT new com.mycompany.demabitesdtos.ReporteClientesDTO(c.nombres, COUNT(q), SUM(q.total), MAX(q.fechaHora))
                    FROM Cliente c
                    JOIN c.comandas q
                    WHERE (:nombre IS NULL OR c.nombres LIKE :nombre)
                    GROUP BY c.id, c.nombres
                    HAVING (:minVisitas IS NULL OR COUNT(q)>=:minVisitas)
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
    
    @Override
    public List<ReporteComandasDTO> reporteComandasPorFecha(
            LocalDateTime fechaInicio, LocalDateTime fechaFin
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();

            String jpql = """
                    SELECT new com.mycompany.demabitesdtos.ReporteComandasDTO(
                        c.folio, 
                        c.fechaHora, 
                        m.numero, 
                        c.total, 
                        c.estado, 
                        cli.nombres
                    )
                    FROM Comanda c
                    JOIN c.mesa m
                    LEFT JOIN c.cliente cli
                    WHERE c.fechaHora BETWEEN :inicio AND :fin
                    ORDER BY c.fechaHora ASC
                    """;

            TypedQuery<ReporteComandasDTO> query = entityManager.createQuery(jpql, ReporteComandasDTO.class);
            query.setParameter("inicio", fechaInicio);
            query.setParameter("fin", fechaFin);

            return query.getResultList();

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al consultar comandas por fecha.", ex);
        }
    }
    
}
