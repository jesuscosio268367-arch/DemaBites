/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dario
 */
public class ClienteDAOTest {
    
    private ClienteDAO dao;
    
    public ClienteDAOTest() {
        
    }
    
    @BeforeEach()
    public void init(){
       this.dao = new ClienteDAO();
    }
    
    @Test
    public void testGenerarClienteFrecuenteFuncionaOk(){
        NuevoClienteFrecuenteDTO nuevoClienteFrecuente = new NuevoClienteFrecuenteDTO(
                "Cristiano",
                "Ronaldo",
                "Gutierrez",
                "email@email.com",
                "6442835171"
        );
        assertDoesNotThrow(() -> {
            ClienteFrecuente clienteFrecuenteGuardado = dao.generarClienteFrecuente(nuevoClienteFrecuente);
            assertNotNull(clienteFrecuenteGuardado.getId());
        });
    }
    
    @Test
    public void testGenerarClienteFrecuenteSinCorreoFuncionaOk(){
        NuevoClienteFrecuenteDTO nuevoClienteFrecuente = new NuevoClienteFrecuenteDTO(
                "Tommy",
                "Shelby",
                "Peña",
                null,
                "6442835167"
        );
        assertDoesNotThrow(() -> {
            ClienteFrecuente clienteFrecuenteGuardado = dao.generarClienteFrecuente(nuevoClienteFrecuente);
            assertNotNull(clienteFrecuenteGuardado.getId());
        });
    }
    
}
