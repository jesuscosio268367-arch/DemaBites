/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jesus Omar
 */
public class ClienteDAO implements IClienteDAO{

    private static final Logger LOGGER = Logger.getLogger(ClienteDAO.class.getName());
    
    @Override
    public ClienteFrecuente generarClienteFrecuente(
            NuevoClienteFrecuenteDTO nuevoClienteFrecuente
    ) throws PersistenciaException {
        ClienteFrecuente clienteFrecuente = new ClienteFrecuente(
                nuevoClienteFrecuente.getNombres(),
                nuevoClienteFrecuente.getApellidoPaterno(),
                nuevoClienteFrecuente.getApellidoMaterno(),
                nuevoClienteFrecuente.getEmail(),
                nuevoClienteFrecuente.getTelefono(),
                LocalDate.now()
        );
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(clienteFrecuente);
            entityManager.getTransaction().commit();
            return clienteFrecuente;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo crear un nuevo cliente frecuente", ex);
        }
    }
    
    
    @Override
    public ClienteFrecuente editarClienteFrecuente(
            NuevoClienteFrecuenteActualizadoDTO clienteFrecuenteActualizadoDTO
    ) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            ClienteFrecuente clienteExistente = entityManager.find(ClienteFrecuente.class, clienteFrecuenteActualizadoDTO.getId());
            clienteExistente.setTelefono(clienteFrecuenteActualizadoDTO.getTelefono());
            clienteExistente.setEmail(clienteFrecuenteActualizadoDTO.getEmail()); 
            entityManager.merge(clienteExistente);
            entityManager.getTransaction().commit();
            return clienteExistente;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al editar el cliente", ex);
        }
    }
    
    @Override
    public List<ClienteFrecuente> consultarTodos() throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            String jpql = "SELECT c FROM ClienteFrecuente c";
            TypedQuery<ClienteFrecuente> query = entityManager.createQuery(jpql, ClienteFrecuente.class);
            List<ClienteFrecuente> clientes = query.getResultList();
            entityManager.getTransaction().commit();
            return clientes;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al consultar clientes", ex);
        }
    }
    
    
    @Override
    public List<ClienteFrecuente> buscar(String filtro) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();

            String jpql = "SELECT DISTINCT c FROM ClienteFrecuente c " +
                          "WHERE LOWER(c.nombres) LIKE :filtro " +
                          "OR c.telefono LIKE :filtro " +
                          "OR (c.email IS NOT NULL AND LOWER(c.email) LIKE :filtro)";

            TypedQuery<ClienteFrecuente> query =
                    entityManager.createQuery(jpql, ClienteFrecuente.class);

            query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");

            return query.getResultList();

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al buscar clientes", ex);
        }
    }
    
    @Override
    public ClienteFrecuente consultarPorId(Long id) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            ClienteFrecuente cliente = entityManager.find(ClienteFrecuente.class, id);
            return cliente; 
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo encontrar el cliente", ex);
        }
    }

}
