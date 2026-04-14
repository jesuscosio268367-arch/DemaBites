/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;
import com.mycompany.demabitespersistencia.IingredientesDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 *La clase ingredientesBO se comunnica con la DAO
 * y presentacion, transforma las DTO de ingredientes
 * y valida que no se creen objetos con valores no validos
 * @author Jesus Omar
 */
public class IngredientesBO implements IingredientesBO {

    private final IingredientesDAO ingredientesDAO;
    
    public IngredientesBO(IingredientesDAO ingredientesDAO){
        this.ingredientesDAO = ingredientesDAO;
    }
    
    /**
     * Valida que todos los parametrospara registar un ingrediente esten bien
     * @param nuevoIngrediente
     * @return regresa el Ingrediente que se registro
     * @throws NegocioException si hay un error al registar el ingrediente
     */
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
    
    /**
     * Llama a la DAO para hacer la consulta
     * @return regresa la lista de todos los Ingredientes
     * @throws NegocioException si hay un error al contular
     */
    @Override
    public List<Ingrediente> consultarIngredientes() throws NegocioException {
        try{
            List<Ingrediente> listaIngredientes = ingredientesDAO.consultarIngredientes();
            return listaIngredientes;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al consultar los ingredientes", ex);
        }
    }

    /**
     * Valida que no hayan valores nulos
     * @param ingrediente
     * @return regresa el ingrediente actualizado
     * @throws NegocioException si hay un error al actualizar el ingrediente
     */
    @Override
    public Ingrediente actualizarIngrediente(NuevoIngredienteDTO ingrediente) throws NegocioException {
        if(ingrediente.getNombre() == null || ingrediente.getNombre().isEmpty()){
            throw new NegocioException("El nombre no puede estar vacio", null);
        }
        if(ingrediente.getUnidad() == null){
            throw new NegocioException("La unidad no puede ser nula", null);
        }
        if(ingrediente.getStock() < 0){
            throw new NegocioException("El stock no puede ser negativo", null);
        }
        
        try{
            Ingrediente ingredienteActualizado = ingredientesDAO.actualizarIngrediente(ingrediente);
            return ingredienteActualizado;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al actualizar el ingrediente", ex);
        }
    }

    /**
     * Llama a la DAO para consultar ingredientes por filtro
     * @param filtro
     * @return regresa la lista de los ingredientes que coinciden
     * con el filtro
     * @throws NegocioException si hay un error al consultar ingredientes
     */
    @Override
    public List<Ingrediente> consultarIngredientesFiltro(String filtro) throws NegocioException {
        try{
            List<Ingrediente> listaIngredientes = ingredientesDAO.consultarIngredientesFiltro(filtro);
            return listaIngredientes;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al consultar los ingredientes", ex);
        }
    }

    /**
     * Valida que el id no sea negativo ni nulo y llama a la DAO
     * para buscar el ingrediente por ID
     * @param id
     * @return regresa el ingrediente que coincide con el ID
     * @throws NegocioException si hay un error al buscar o
     * no cumple con las validaciones
     */
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

    /**
     * Llama a la DAO para eliminar un ingrediente
     * @param id
     * @return el ingrediente que se elimino
     * @throws NegocioException si hay un error al 
     * eliminar el cliente
     */
    @Override
    public Ingrediente eliminarIngrediente(Long id) throws NegocioException {
        try{
            return ingredientesDAO.eliminarIngrediente(id);
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al eliminar el ingrediente", ex);
        }
    }
    
}