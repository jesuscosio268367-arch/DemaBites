package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdtos.MesaDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la entidad Mesa.
 * @author Emily Lara
 * 270719
 */
public interface IMesaBO {
    
    /**
     * Consulta todas las mesas que se encuentran disponibles actualmente, 
     * es decir, aquellas que no tienen una comanda en estado ABIERTA.
     * @return Una lista de objetos que representan las mesas libres.
     * @throws NegocioException Si ocurre un error al procesar la solicitud 
     * o al acceder a la capa de persistencia.
     */
    public List<MesaDTO> consultarMesasDisponibles() throws NegocioException;
}