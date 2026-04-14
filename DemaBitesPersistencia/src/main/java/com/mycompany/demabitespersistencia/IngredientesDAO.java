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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jesus Omar
 */
public class IngredientesDAO implements IingredientesDAO {

    private static final Logger LOGGER = Logger.getLogger(IngredientesDAO.class.getName());

    @Override
    public Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws PersistenciaException {

        Ingrediente ingrediente = NuevoIngredienteDTOAIngredienteAdapter.adapter(nuevoIngrediente);

        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(ingrediente);
            entityManager.getTransaction().commit();

            return ingrediente;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al registrar el Ingrediente...");
        }

    }

    @Override
    public List<Ingrediente> consultarIngredientes() throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            String jpql = "SELECT i FROM Ingrediente i";

            TypedQuery<Ingrediente> query = entityManager.createQuery(jpql, Ingrediente.class);
            List<Ingrediente> listaIngredientes = query.getResultList();

            return listaIngredientes;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al consultar los ingredientes");
        }
    }

    @Override
    public Ingrediente actualizarIngrediente(NuevoIngredienteDTO ingrediente) throws PersistenciaException {
        
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            
            Ingrediente ingredienteAActualizar = entityManager.find(Ingrediente.class, ingrediente.getId());
            Ingrediente ingredienteActualizado = NuevoIngredienteDTOAIngredienteAdapter.adapter(ingrediente);
            
            ingredienteAActualizar.setNombre(ingredienteActualizado.getNombre());
            ingredienteAActualizar.setStock(ingredienteActualizado.getStock());
            ingredienteAActualizar.setUnidad(ingredienteActualizado.getUnidad());
            ingredienteAActualizar.setImagenIngrediente(ingredienteActualizado.getImagenIngrediente());
            
            entityManager.merge(ingredienteAActualizar);
            entityManager.getTransaction().commit();
            
            return ingredienteAActualizar;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al actualizar el ingrediente");
        }
        
    }

    @Override
    public boolean consultarPorNombreUnidad(String nombre, Unidad unidad) throws PersistenciaException {

        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            String jpql = "SELECT COUNT(i) FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidad = :unidad";

            Long conteo = entityManager.createQuery(jpql, Long.class)
                    .setParameter("nombre", nombre)
                    .setParameter("unidad", unidad)
                    .getSingleResult();

            return conteo > 0;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se encontro ningun ingrediente");
        }

    }

    @Override
    public List<Ingrediente> consultarIngredientesFiltro(String filtro) throws PersistenciaException {

        try {
            EntityManager em = ManejadorConexiones.crearEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Ingrediente> cq = cb.createQuery(Ingrediente.class);
            Root<Ingrediente> ingrediente = cq.from(Ingrediente.class);

            if (filtro == null || filtro.isBlank()) {
                return consultarIngredientes();
            }

            String patron = "%" + filtro.trim().toLowerCase() + "%";

            Predicate pNombre = cb.like(cb.lower(ingrediente.get("nombre")), patron);
            Predicate pUnidad = cb.like(cb.lower(ingrediente.get("unidad")), patron);
            cq.where(cb.or(pNombre, pUnidad));

            return em.createQuery(cq).getResultList();
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No ha sido posible consultar los ingredientes", ex);
        }
    }

}
