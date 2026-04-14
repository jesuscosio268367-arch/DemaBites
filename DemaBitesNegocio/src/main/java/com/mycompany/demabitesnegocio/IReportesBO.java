package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import com.mycompany.demabitesdtos.ReporteComandasDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz que define los metodos BO para las validaciones del modulo de Reportes.
 * @author Dario
 */
public interface IReportesBO {
    
    /**
     * Validaciones para hacer un reporte de clientes.
     * @param nombreCliente Nombre del cliente para buscar.
     * @param minVisitas Numero de veces minimo para la busqueda.
     * @return Lista de clientes que coincidan con el filtro.
     * @throws NegocioException Si ocurre un error en las validaciones.
     */
    public abstract List<ReporteClientesDTO> reporteClientes(String nombreCliente, Integer minVisitas)
            throws NegocioException;
    
    public List<ReporteComandasDTO> reporteComandasPorFecha(
            LocalDateTime fechaInicio, LocalDateTime fechaFin
    ) throws NegocioException;
    
}
