//package com.mycompany.demabitespersistencia;
//
//import com.mycompany.demabitesdominio.ClienteFrecuente;
//import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
//import java.util.List;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author Dario
// */
//public class ClienteDAOTest {
//    
//    private ClienteDAO dao;
//    
//    public ClienteDAOTest() {
//        
//    }
//    
//    @BeforeEach()
//    public void init(){
//       this.dao = new ClienteDAO();
//    }
//    
//    @Test
//    public void testGenerarClienteFrecuenteFuncionaOk(){
//        NuevoClienteFrecuenteDTO nuevoClienteFrecuente = new NuevoClienteFrecuenteDTO("Oscar", "Ramon", "Camara", "email@gmail.com", "7654356278");
//        assertDoesNotThrow(() -> {
//            ClienteFrecuente clienteFrecuenteGuardado = dao.generarClienteFrecuente(nuevoClienteFrecuente);
//            assertNotNull(clienteFrecuenteGuardado.getId());
//        });
//    }
//    
//    @Test
//    public void testGenerarClienteFrecuenteSinCorreoFuncionaOk(){
//        NuevoClienteFrecuenteDTO nuevoClienteFrecuente = new NuevoClienteFrecuenteDTO(
//                "Tommy",
//                "Shelby",
//                "Peña",
//                null,
//                "6442835167"
//        );
//        assertDoesNotThrow(() -> {
//            ClienteFrecuente clienteFrecuenteGuardado = dao.generarClienteFrecuente(nuevoClienteFrecuente);
//            assertNotNull(clienteFrecuenteGuardado.getId());
//        });
//    }
//    
//    @Test
//    public void testConsultarTodosEncuentraOk() {
//        assertDoesNotThrow(() -> {
//            List<ClienteFrecuente> listaClientes = dao.consultarTodos();
//
//            assertNotNull(listaClientes);
//            assertFalse(listaClientes.isEmpty());
//
//
//            ClienteFrecuente cliente = listaClientes.get(0);
//            assertNotNull(cliente.getId());
//            assertNotNull(cliente.getNombres());
//        });
//    }
//
//        /**
//         * Caso: El teléfono SÍ existe en la BD
//         * Emy
//         */
//        @Test
//        public void testConsultarPorTelefonoExisteOk() {
//            String telefono = "6441234567";
//
//            // Primero insertamos un cliente con ese teléfono
//            NuevoClienteFrecuenteDTO nuevoCliente = new NuevoClienteFrecuenteDTO(
//                    "Juan",
//                    "Perez",
//                    "Lopez",
//                    "juan@test.com",
//                    telefono
//            );
//
//            assertDoesNotThrow(() -> {
//                dao.generarClienteFrecuente(nuevoCliente);
//
//                ClienteFrecuente cliente = dao.consultarPorTelefono(telefono);
//
//                assertNotNull(cliente);
//                assertEquals(telefono, cliente.getTelefono());
//            });
//        }
//
//        /**
//         * Caso: El teléfono NO existe en la BD
//         */
//        @Test
//        public void testConsultarPorTelefonoNoExisteOk() {
//            // Generamos un teléfono único para asegurar que no exista
//            String telefonoInexistente = "5456554545";
//
//            assertDoesNotThrow(() -> {
//                ClienteFrecuente cliente = dao.consultarPorTelefono(telefonoInexistente);
//
//                assertNull(cliente);
//            });
//        }
//
//        
//}   
