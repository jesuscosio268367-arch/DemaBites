/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.util.List;

/**
 *
 * @author Dario
 */
public interface IClienteDAO {
    public abstract ClienteFrecuente generarClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente)
            throws PersistenciaException;
    public abstract List<ClienteFrecuente> consultarTodos()
            throws PersistenciaException;
    
   public List<ClienteFrecuente> buscar(String filtro) 
           throws PersistenciaException;
}
