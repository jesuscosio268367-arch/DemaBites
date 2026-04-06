package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.Comanda;
import com.mycompany.demabitesdominio.EstadoComanda;
import com.mycompany.demabitesdtos.NuevaComandaDTO;
import java.util.List;

/**
 * Interfaz para las operaciones de base de datos de Comandas.
 * Define el contrato para el acceso a datos de la entidad Comanda.
 * @author Emily Lara
 * 270719
 */
public interface IComandaDAO {
    
    /**
     * Agrega una nueva comanda a la base de datos.
     * @param nuevaComanda DTO que contiene la información de la comanda a registrar.
     * @return La entidad Comanda persistida con su identificador generado.
     * @throws PersistenciaException Si ocurre un error al intentar guardar en la base de datos.
     */
    public abstract Comanda agregarComanda(NuevaComandaDTO nuevaComanda) throws PersistenciaException;
    
    /**
     * Actualiza el estado de una comanda registrada.
     * @param id El identificador único de la comanda a actualizar.
     * @param nuevoEstado El nuevo estado (ABIERTA, ENTREGADA, CANCELADA) a asignar.
     * @return La entidad Comanda con el estado actualizado.
     * @throws PersistenciaException Si ocurre un error en la actualización.
     */
    public abstract Comanda actualizarEstado(Long id, EstadoComanda nuevoEstado) throws PersistenciaException;
    
    /**
     * Consulta una comanda específica utilizando su identificador único.
     * @param id El identificador de la comanda en la base de datos.
     * @return La entidad Comanda encontrada.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public abstract Comanda consultar(Long id) throws PersistenciaException;
    
    /**
     * Consulta una comanda específica utilizando su folio único autogenerado.
     * @param folio El folio de la comanda con formato OB-YYYYMMDD-XXX.
     * @return La entidad Comanda encontrada, o null si no existe ningún registro con ese folio.
     * @throws PersistenciaException Si ocurre un error en la base de datos al realizar la búsqueda.
     */
    public abstract Comanda consultarPorFolio(String folio) throws PersistenciaException;
    
    /**
     * Consulta y devuelve todas las comandas registradas en el sistema.
     * @return Una lista de entidades Comanda.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta masiva.
     */
    public abstract List<Comanda> consultarTodos() throws PersistenciaException;
}