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
    
    @Test
    public void testConsultarTodosEncuentraOk() {
        int cantidadClientes = 3; 
        assertDoesNotThrow(() -> {
            List<ClienteFrecuente> listaClientes = dao.consultarTodos();
            assertNotNull(listaClientes);
            assertEquals(listaClientes.size(), cantidadClientes);
            ClienteFrecuente primerCliente = listaClientes.get(0);
            assertNotNull(primerCliente.getId());
            assertNotNull(primerCliente.getNombres());
        });   
    }
    
    @Test
    public void testCoincidenciaPorNombreEncuentraOk(){
        int cantidadClientes = 2;
        String busquedaNombre = "Crist";
        assertDoesNotThrow(() -> {
            List<ClienteFrecuente> listaClientes = dao.coincidenciaPorNombre(busquedaNombre);
            assertNotNull(listaClientes);
            assertEquals(listaClientes.size(), cantidadClientes);
            assertTrue(listaClientes.get(0).getNombres().contains(busquedaNombre));
        });
    }
    
    @Test
    public void testCoincidenciaPorNumeroEncuentraOk(){
        int cantidadClientes = 2;
        String digitosTelefono = "5171";
        assertDoesNotThrow(() -> {
            List<ClienteFrecuente> listaClientes = dao.coincidenciaPorNumero(digitosTelefono);
            assertNotNull(listaClientes);
            assertEquals(listaClientes.size(), cantidadClientes);
            assertTrue(listaClientes.get(0).getTelefono().contains(digitosTelefono));
        });
    }
}
