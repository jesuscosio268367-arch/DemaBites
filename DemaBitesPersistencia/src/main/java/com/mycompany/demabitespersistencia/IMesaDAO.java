package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.Mesa;
import java.util.List;

/**
 * Interfaz para las operaciones de base de datos de la entidad Mesa.
 * @author Emily Lara
 */
public interface IMesaDAO {
    
    /**
     * Consulta las mesas que no tienen una comanda en estado ABIERTA.
     * @return Lista de mesas disponibles.
     * @throws PersistenciaException Si ocurre un error en la base de datos.
     */
    public List<Mesa> consultarMesasDisponibles() throws PersistenciaException;
}