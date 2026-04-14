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
    /**
     * 
     * @param nuevoIngrediente
     * @return
     * @throws NegocioException 
     */
    public abstract Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente)throws NegocioException;
    /**
     * 
     * @return
     * @throws NegocioException 
     */
    public abstract List<Ingrediente> consultarIngredientes()throws NegocioException;
    /**
     * 
     * @param ingrediente
     * @return
     * @throws NegocioException 
     */
    public abstract Ingrediente actualizarIngrediente(NuevoIngredienteDTO ingrediente)throws NegocioException;
    /**
     * 
     * @param filtro
     * @return
     * @throws NegocioException 
     */
    public abstract List<Ingrediente> consultarIngredientesFiltro(String filtro) throws NegocioException;
    /**
     * 
     * @param id
     * @return
     * @throws NegocioException 
     */
    public abstract Ingrediente buscarPorId (Long id) throws NegocioException;
    /**
     * 
     * @param id
     * @return
     * @throws NegocioException 
     */
    public abstract Ingrediente eliminarIngrediente(Long id)throws NegocioException;
 
}
