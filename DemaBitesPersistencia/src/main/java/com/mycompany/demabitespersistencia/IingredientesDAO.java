/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import Enums.Unidad;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Jesus Omar
 */
public interface IingredientesDAO {
    /**
     * 
     * @param nuevoIngrediente
     * @return
     * @throws PersistenciaException 
     */
    public abstract Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws PersistenciaException;
    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    public abstract List<Ingrediente> consultarIngredientes() throws PersistenciaException;
    /**
     * 
     * @param ingrediente
     * @return
     * @throws PersistenciaException 
     */
    public abstract Ingrediente actualizarIngrediente(NuevoIngredienteDTO ingrediente) throws PersistenciaException;
    /**
     * 
     * @param nombre
     * @param unidad
     * @return
     * @throws PersistenciaException 
     */
    public abstract boolean consultarPorNombreUnidad(String nombre, Unidad unidad) throws PersistenciaException;
    /**
     * 
     * @param filtro
     * @return
     * @throws PersistenciaException 
     */
    public abstract List<Ingrediente> consultarIngredientesFiltro(String filtro) throws PersistenciaException;
    /**
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
     */
    public abstract Ingrediente buscarPorId (Long id) throws PersistenciaException;
    /**
     * 
     * @param id
     * @return
     * @throws PersistenciaException 
     */
    public abstract Ingrediente eliminarIngrediente(Long id)throws PersistenciaException;
 
}
