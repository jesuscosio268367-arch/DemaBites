/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.util.List;

/**
 *
 * @author Dario
 */
public interface IClienteDAO {
    public abstract ClienteFrecuente generarClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente)
            throws PersistenciaException;
    public abstract ClienteFrecuente editarClienteFrecuente (NuevoClienteFrecuenteActualizadoDTO nuevoClienteFrecuenteActualizadoDTO)
            throws PersistenciaException;
    public abstract List<ClienteFrecuente> consultarTodos()
            throws PersistenciaException; 
    public List<ClienteFrecuente> filtrar(String filtro) 
           throws PersistenciaException;
    public abstract ClienteFrecuente consultarPorId(Long id)
            throws PersistenciaException;
    
    public abstract ClienteFrecuente consultarPorTelefono(String telefono)
            throws PersistenciaException;
}
