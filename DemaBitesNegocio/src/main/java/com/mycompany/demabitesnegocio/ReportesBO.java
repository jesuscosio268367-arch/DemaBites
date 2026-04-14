package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import com.mycompany.demabitesdtos.ReporteComandasDTO;
import com.mycompany.demabitespersistencia.IReportesDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase de Objetos de negocio para la validacion de reportes.
 * @author Dario
 */
public class ReportesBO implements IReportesBO {

    private final IReportesDAO reportesDAO;

    /**
     * Constructor con la dao necesaria para las consultas.
     * @param reportesDAO instancia que implemente IReportesDAO.
     */
    public ReportesBO(IReportesDAO reportesDAO) {
        this.reportesDAO = reportesDAO;
    }
    
    /**
     * Validaciones para hacer un reporte de clientes.
     * @param nombreCliente Nombre del cliente para buscar.
     * @param minVisitas Numero de veces minimo para la busqueda.
     * @return Lista de clientes que coincidan con el filtro.
     * @throws NegocioException Si ocurre un error en las validaciones.
     */
    @Override
    public List<ReporteClientesDTO> reporteClientes(
            String nombreCliente, Integer minVisitas
    ) throws NegocioException {
        try {
           if (minVisitas != null && minVisitas < 0) {
                throw new NegocioException("El numero minimo de visitas no puede ser negativo.", null);
            }

            if (nombreCliente != null) {
                nombreCliente = nombreCliente.trim();
            }
            return reportesDAO.reporteClientes(nombreCliente, minVisitas);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al realizar el reporte de clientes.", ex);
        }
    }
    
    @Override
    public List<ReporteComandasDTO> reporteComandasPorFecha(
            LocalDateTime fechaInicio, LocalDateTime fechaFin
    ) throws NegocioException {
        try {
            if (fechaInicio == null || fechaFin == null) {
                throw new NegocioException("Las fechas de inicio y fin son obligatorias.", null);
            }
            if (fechaInicio.isAfter(fechaFin)) {
                throw new NegocioException("La fecha de inicio no puede ser posterior a la fecha de fin.", null);
            }
            
            return reportesDAO.reporteComandasPorFecha(fechaInicio, fechaFin);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar el reporte de comandas.", ex);
        }
    }
    
}
