package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import com.mycompany.demabitesdtos.ReporteComandasDTO;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz que define los metodos DAO para el modulo de Reportes.
 * @author Dario
 */
public interface IReportesDAO {
    
    /**
     * Consulta clientes y datos especificos de estos.
     * @param nombreCliente Nombre del cliente para buscar.
     * @param minVisitas Numero de veces minimo para la busqueda.
     * @return Lista de clientes que coincidan con el filtro.
     * @throws PersistenciaException Si ocurre un error al ejecutar la consulta.
     */
    public List<ReporteClientesDTO> reporteClientes(String nombreCliente, Integer minVisitas) 
            throws PersistenciaException;
    
    /**
    * Consulta las comandas registradas en un rango de fechas específico.
    * Este método recupera el folio, fecha, mesa, total, estado y nombre del cliente.
    * @param fechaInicio Fecha y hora inicial del rango de búsqueda.
    * @param fechaFin Fecha y hora final del rango de búsqueda.
    * @return Una lista de con la información de las comandas encontradas.
    * @throws PersistenciaException Si ocurre un error de sintaxis o conexión en la base de datos.
    */
   List<ReporteComandasDTO> reporteComandasPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws PersistenciaException;
   
}
