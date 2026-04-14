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

    public abstract Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws PersistenciaException;

    public abstract List<Ingrediente> consultarIngredientes() throws PersistenciaException;

    public abstract Ingrediente actualizarIngrediente(NuevoIngredienteDTO ingrediente) throws PersistenciaException;

    public abstract boolean consultarPorNombreUnidad(String nombre, Unidad unidad) throws PersistenciaException;

    public abstract List<Ingrediente> consultarIngredientesFiltro(String filtro) throws PersistenciaException;
    
    public abstract Ingrediente buscarPorId (Long id) throws PersistenciaException;
 
}
