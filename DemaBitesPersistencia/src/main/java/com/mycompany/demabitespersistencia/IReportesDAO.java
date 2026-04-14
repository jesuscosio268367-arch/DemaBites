package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
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
}
