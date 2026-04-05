/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dario
 */
public class ManejadorConexiones {
    public static EntityManager crearEntityManager(){
        // fabrica que permite construir entity managers a partir de ciertas configuraciones
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("DemaBitesDominioPU");
        // objeto que permite hacer operaciones de bd
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
}
