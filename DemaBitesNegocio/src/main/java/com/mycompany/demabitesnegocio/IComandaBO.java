package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.Comanda;
import com.mycompany.demabitesdominio.EstadoComanda;
import com.mycompany.demabitesdtos.NuevaComandaDTO;
import java.util.List;

/**
 *
 * @author Emily Lara
 */
public interface IComandaBO {
    
    public abstract Comanda agregarComanda(NuevaComandaDTO nuevaComanda) throws NegocioException;
    
    public abstract Comanda actualizarEstado(Long id, EstadoComanda nuevoEstado) throws NegocioException;
    
    public abstract Comanda consultarPorFolio(String folio) throws NegocioException;
    
    public abstract List<Comanda> consultarTodos() throws NegocioException;
}
