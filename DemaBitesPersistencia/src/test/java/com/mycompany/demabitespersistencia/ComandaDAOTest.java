package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.Comanda;
import com.mycompany.demabitesdominio.EstadoComanda;
import com.mycompany.demabitesdtos.DetalleComandaDTO;
import com.mycompany.demabitesdtos.MesaDTO;
import com.mycompany.demabitesdtos.NuevaComandaDTO;
import com.mycompany.demabitesdtos.ProductoDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para ComandaDAO
 * @author Emily Lara
 * 270719
 */
public class ComandaDAOTest {

    private ComandaDAO dao;

    @BeforeEach
    public void init() {
        this.dao = new ComandaDAO();
    }

    @Test
    public void testAgregarComandaFuncionaOk() {
        // Setup: Preparamos los datos
        NuevaComandaDTO nueva = new NuevaComandaDTO();
        nueva.setFechaHora(LocalDateTime.now());
        nueva.setTotal(350.0);
        
        MesaDTO mesa = new MesaDTO();
        mesa.setId(1L); 
        nueva.setMesa(mesa);

        List<DetalleComandaDTO> detalles = new ArrayList<>();
        DetalleComandaDTO det = new DetalleComandaDTO();
        det.setCantidad(2);
        det.setPrecioVenta(175.0);
        det.setComentarios("Sin cebolla");
        
        ProductoDTO prod = new ProductoDTO();
        prod.setId(1L);
        det.setProducto(prod);
        
        detalles.add(det);
        nueva.setDetalles(detalles);

        // Ejecución y Verificación
        assertDoesNotThrow(() -> {
            Comanda guardada = dao.agregarComanda(nueva);
            assertNotNull(guardada.getId(), "El ID no debe ser nulo tras guardar");
            assertNotNull(guardada.getFolio(), "Debe haber generado un folio");
            assertTrue(guardada.getFolio().startsWith("OB-"), "El folio debe tener el formato correcto");
            assertEquals(EstadoComanda.ABIERTA, guardada.getEstado(), "Debe iniciar en estado ABIERTA");
            assertEquals(1, guardada.getDetalles().size(), "Debe tener un detalle guardado");
        });
    }

    @Test
    public void testConsultarPorFolioFuncionaOk() {
        // Para que este test funcione, primero insertamos una o usamos un folio existente
        String folioExistente = "OB-20240405-001";
        
        assertDoesNotThrow(() -> {
            Comanda encontrada = dao.consultarPorFolio(folioExistente);
            if (encontrada != null) {
                assertEquals(folioExistente, encontrada.getFolio());
            }
        });
    }

    @Test
    public void testActualizarEstadoFuncionaOk() {
        Long idExistente = 1L;
        EstadoComanda nuevoEstado = EstadoComanda.ENTREGADA;

        assertDoesNotThrow(() -> {
            Comanda actualizada = dao.actualizarEstado(idExistente, nuevoEstado);
            if (actualizada != null) {
                assertEquals(nuevoEstado, actualizada.getEstado());
            }
        });
    }

    @Test
    public void testConsultarIdNoExiste() {
        Long idFake = 999999L;
        
        assertDoesNotThrow(() -> {
            Comanda comanda = dao.consultar(idFake);
            assertNull(comanda, "Debe retornar null si la comanda no existe");
        });
    }

    @Test
    public void testConsultarTodos() {
        assertDoesNotThrow(() -> {
            List<Comanda> lista = dao.consultarTodos();
            assertNotNull(lista, "La lista no debe ser nula (puede estar vacía)");
            System.out.println("Comandas encontradas: " + lista.size());
        });
    }
}