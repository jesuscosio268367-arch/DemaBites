/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesus Omar
 */
public interface IClientesBO {
    
    public abstract ClienteFrecuente crearClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) throws NegocioException;
   
    public abstract List<ClienteFrecuente> consultarTodos()throws NegocioException;
    
    public abstract List<ClienteFrecuente> coincidenciaPorNombre(String nombreBusqueda)throws NegocioException;
    
    public abstract List<ClienteFrecuente> coincidenciaPorNumero(String numeroBusqueda)throws NegocioException;
    
}
