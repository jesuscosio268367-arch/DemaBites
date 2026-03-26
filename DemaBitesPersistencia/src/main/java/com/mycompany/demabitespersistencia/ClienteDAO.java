/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

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
                nuevoClienteFrecuente.getTelefono(),
                nuevoClienteFrecuente.getEmail(),
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
    
}
