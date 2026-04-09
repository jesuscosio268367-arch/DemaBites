/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Jesus Omar
 */
public interface IingredientesBO {
    
    public abstract Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente)throws NegocioException;
    
    public abstract List<Ingrediente> consultarIngredientes()throws NegocioException;
    
    public abstract Ingrediente actualizarStock(NuevoIngredienteDTO ingrediente)throws NegocioException;
    
}
