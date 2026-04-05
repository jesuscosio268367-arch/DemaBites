/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.util.List;
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
        NuevoClienteFrecuenteDTO nuevoClienteFrecuente = new NuevoClienteFrecuenteDTO("Oscar", "Ramon", "Camara", "email@gmail.com", "7654356278");
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
    
    @Test
    public void testConsultarTodosEncuentraOk() {
        assertDoesNotThrow(() -> {
            List<ClienteFrecuente> listaClientes = dao.consultarTodos();

            assertNotNull(listaClientes);
            assertFalse(listaClientes.isEmpty());

            ClienteFrecuente cliente = listaClientes.get(0);
            assertNotNull(cliente.getId());
            assertNotNull(cliente.getNombres());
        });
    }
    
    
    
//    @Test
//    public void testBuscarPorTelefonoEncuentraOk() {
//        String filtro = "644";
//
//        assertDoesNotThrow(() -> {
//            List<ClienteFrecuente> listaClientes = dao.buscar(filtro);
//
//            assertNotNull(listaClientes);
//            assertFalse(listaClientes.isEmpty());
//
//            assertTrue(listaClientes.stream()
//                    .anyMatch(c -> 
//                        c.getTelefono() != null &&
//                        c.getTelefono().contains(filtro)
//                    ));
//        });
//    }
    
//    @Test
//    public void testBuscarPorCorreoEncuentraOk() {
//        String filtro = "@gmail";
//
//        assertDoesNotThrow(() -> {
//            List<ClienteFrecuente> listaClientes = dao.buscar(filtro);
//
//            assertNotNull(listaClientes);
//            assertFalse(listaClientes.isEmpty());
//
//            assertTrue(listaClientes.stream()
//                    .anyMatch(c -> 
//                        c.getEmail() != null &&
//                        c.getEmail().toLowerCase().contains(filtro.toLowerCase())
//                    ));
//        });
//    }
}
