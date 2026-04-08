package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.Comanda;
import com.mycompany.demabitesdominio.EstadoComanda;
import com.mycompany.demabitesdtos.NuevaComandaDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones y reglas de negocio para la gestión de Comandas.
 * Sirve como puente entre la capa de presentación/control y la capa de persistencia.
 * * @author Emily Lara
 */
public interface IComandaBO {
    
    /**
     * Valida y registra una nueva comanda en el sistema.
     * @param nuevaComanda DTO que contiene la información de la comanda y sus detalles.
     * @return La entidad Comanda registrada y con su folio generado.
     * @throws NegocioException Si no cumple las reglas de negocio (ej. sin mesa o sin productos) 
     * o si ocurre un error en la persistencia.
     */
    public abstract Comanda agregarComanda(NuevaComandaDTO nuevaComanda) throws NegocioException;
    
    /**
     * Modifica el estado actual de una comanda existente.
     * @param id El identificador único de la comanda a actualizar.
     * @param nuevoEstado El nuevo estado que se le asignará (ej. CERRADA, CANCELADA).
     * @return La entidad Comanda con su estado actualizado.
     * @throws NegocioException Si el ID es inválido, el estado es nulo, la comanda no existe, 
     * o falla la base de datos.
     */
    public abstract Comanda actualizarEstado(Long id, EstadoComanda nuevoEstado) throws NegocioException;
    
    /**
     * Busca y recupera una comanda utilizando su número de folio.
     * @param folio El folio único de la comanda (ej. OB-20231024-001).
     * @return La entidad Comanda que corresponde al folio buscado.
     * @throws NegocioException Si el folio está vacío, no se encuentra ninguna comanda con ese folio, 
     * o falla la consulta.
     */
    public abstract Comanda consultarPorFolio(String folio) throws NegocioException;
    
    /**
     * Recupera el historial completo de todas las comandas registradas en el sistema.
     * @return Una lista con todas las entidades Comanda.
     * @throws NegocioException Si ocurre un error al intentar recuperar los datos de la base de datos.
     */
    public abstract List<Comanda> consultarTodos() throws NegocioException;
    
    /**
     * Consulta y recupera una comanda específica utilizando su identificador único.
     * @param id El ID de la comanda a consultar.
     * @return La entidad Comanda que coincide con el ID proporcionado.
     * @throws NegocioException Si el ID proporcionado no es válido, no se encuentra la comanda, 
     * o si ocurre un error en la capa de persistencia.
     */
    public abstract Comanda consultar(Long id) throws NegocioException;
}