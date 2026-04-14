/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesus Omar
 */
public interface IingredientesBO {
    
    public abstract Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente)throws NegocioException;
    
    public abstract List<Ingrediente> consultarIngredientes()throws NegocioException;
    
    public abstract Ingrediente actualizarIngrediente(NuevoIngredienteDTO ingrediente)throws NegocioException;
    
    public abstract List<Ingrediente> consultarIngredientesFiltro(String filtro) throws NegocioException;
    
    public abstract Ingrediente buscarPorId (Long id) throws NegocioException;
    
    public abstract Ingrediente eliminarIngrediente(Long id)throws NegocioException;
 
}
