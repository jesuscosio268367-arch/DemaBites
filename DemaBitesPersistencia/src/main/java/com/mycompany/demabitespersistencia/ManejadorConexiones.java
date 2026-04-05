package com.mycompany.demabitespersistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase encargada de proveer la conexion con la base de datos con JPA.
 * @author Dario
 */
public class ManejadorConexiones {
    
    /**
     * Crea y retorna un EntityManager para realizar operaciones en la base de datos.
     * @return EntityManager listo para gestionar transacciones y entidades.
     */
    public static EntityManager crearEntityManager(){
        // fabrica que permite construir entity managers a partir de ciertas configuraciones
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("DemaBitesDominioPU");
        // objeto que permite hacer operaciones de bd
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
}
