/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import Adapters.NuevoIngredienteDTOAIngredienteAdapter;
import Enums.Unidad;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jesus Omar
 */
public class IngredientesDAO implements IingredientesDAO {

    private static final Logger LOGGER = Logger.getLogger(IngredientesDAO.class.getName());
    
    @Override
    public Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws PersistenciaException {
        
        Ingrediente ingrediente = NuevoIngredienteDTOAIngredienteAdapter.adapter(nuevoIngrediente);
        
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(ingrediente);
            entityManager.getTransaction().commit();
            
            return ingrediente;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al registrar el Ingrediente...");
        }
        
    }

    @Override
    public List<Ingrediente> consultarIngredientes() throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            String jpql = "SELECT i FROM Ingrediente i";
            
            TypedQuery<Ingrediente> query = entityManager.createQuery(jpql, Ingrediente.class);
            List<Ingrediente> listaIngredientes = query.getResultList();
            
            return listaIngredientes;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al consultar los ingredientes");
        }
    }

    @Override
    public Ingrediente actualizarStock(NuevoIngredienteDTO ingrediente) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean consultarPorNombreUnidad(String nombre, Unidad unidad) throws PersistenciaException {
        
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            String jpql = "SELECT COUNT(i) FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidad = :unidad";
            
            Long conteo = entityManager.createQuery(jpql, Long.class)
                    .setParameter("nombre", nombre)
                    .setParameter("unidad", unidad)
                    .getSingleResult();
            
            return conteo > 0;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se encontro ningun ingrediente");
        }
        
    }
    
}
