/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import Enums.Unidad;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;
import com.mycompany.demabitespersistencia.IingredientesDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesus Omar
 */
public class IngredientesBO implements IingredientesBO{

    private final IingredientesDAO ingredientesDAO;
    
    public IngredientesBO(IingredientesDAO ingredientesDAO){
        this.ingredientesDAO = ingredientesDAO;
    }
    
    @Override
    public Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException {
        if(nuevoIngrediente.getNombre().trim().isEmpty()){
            throw new NegocioException("Error, el nombre no puede estar vacio", null);
        }
        if(nuevoIngrediente.getNombre().length() > 100){
            throw new NegocioException("Error, el nombre es demasiado largo", null);
        }
        if(nuevoIngrediente.getUnidad() == null){
            throw new NegocioException("Error, la unidad del ingrediente no puede ser nula", null);
        }
        if(nuevoIngrediente.getStock() < 0){
            throw new NegocioException("Error, el stock no puede ser negativo", null);
        }
        try{
            boolean existente = ingredientesDAO.consultarPorNombreUnidad(nuevoIngrediente.getNombre(), nuevoIngrediente.getUnidad());
            if(existente){
                throw new NegocioException("Ya existe el ingrediente con esta unidad", null);
            }
            Ingrediente ingrediente = ingredientesDAO.registrarIngrediente(nuevoIngrediente);
            return ingrediente;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error, no se pudo registrar el producto", ex);
        }
    }

    @Override
    public List<Ingrediente> consultarIngredientes() throws NegocioException {
        try{
            List<Ingrediente> listaIngredientes = ingredientesDAO.consultarIngredientes();
            return listaIngredientes;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al consultar los ingredientes", ex);
        }
    }

    @Override
    public Ingrediente actualizarStock(NuevoIngredienteDTO ingrediente) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Ingrediente> consultarIngredientesFiltro(String filtro) throws NegocioException {
        try{
            List<Ingrediente> listaIngredientes = ingredientesDAO.consultarIngredientesFiltro(filtro);
            return listaIngredientes;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al consultar los ingredientes", ex);
        }
    }
    
    @Override
    public Ingrediente buscarPorId(Long id) throws NegocioException {
        if (id == null || id <= 0) {
            throw new NegocioException("ID de ingrediente no valido para la busqueda.", null);
        }
        try {
            Ingrediente ingrediente = ingredientesDAO.buscarPorId(id);
            if (ingrediente == null) {
                throw new NegocioException("El ingrediente con ID " + id + " no fue encontrado.", null);
            }
            return ingrediente;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar el ingrediente por ID.", ex);
        }
    }
    
}
