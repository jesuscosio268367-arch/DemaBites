/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.util.List;

/**
 *
 * @author Jesus Omar
 */
public interface IClientesBO {
    
    public abstract ClienteFrecuente crearClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) 
            throws NegocioException;
    
    public abstract ClienteFrecuente editarClienteFrecuente(NuevoClienteFrecuenteActualizadoDTO nuevoClienteFrecuenteActualizado) 
            throws NegocioException;
   
    public abstract List<ClienteFrecuente> consultarTodos()
            throws NegocioException;
    
    public abstract List<ClienteFrecuente> buscar(String filtro) 
            throws NegocioException;
    
    public ClienteFrecuente consultarPorId(Long id) 
            throws NegocioException;
}
