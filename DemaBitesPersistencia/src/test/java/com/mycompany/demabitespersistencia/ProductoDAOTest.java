package com.mycompany.demabitespersistencia;

import Enums.EstadoProducto;
import Enums.Tipo;
import com.mycompany.demabitesdominio.Producto;
import com.mycompany.demabitesdtos.IngredienteProductoDTO;
import com.mycompany.demabitesdtos.NuevoProductoDTO;
import com.mycompany.demabitesdtos.ProductoEstadoActualizadoDTO;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dario
 */
public class ProductoDAOTest {
    
//    private ProductoDAO dao;
//    
//    public ProductoDAOTest() {
//        this.dao = new ProductoDAO();
//    }
//
//    @Test
//    public void testGenerarProductoConIngredientesFuncionaOk() {
//        IngredienteProductoDTO ing1 = new IngredienteProductoDTO(1L, 2.5);
//        IngredienteProductoDTO ing2 = new IngredienteProductoDTO(9L, 1.0);
//        
//        NuevoProductoDTO nuevo = new NuevoProductoDTO(
//                "Pizza Pepperoni", 
//                250.0, 
//                "Con orilla de queso",
//                Enums.Tipo.PLATILLO, 
//                Arrays.asList(ing1, ing2),
//                null
//        );
//        
//        assertDoesNotThrow(() -> {
//            Producto guardado = dao.GenerarProducto(nuevo);
//            assertNotNull(guardado.getId());
//            assertEquals(2, guardado.getIngredientes().size());
//            assertEquals(guardado, guardado.getIngredientes().get(0).getProducto());
//        });
//    }
//
//    @Test
//    public void testBuscarPorIdEncuentraProducto() {
//        Long idBuscado = 1L;
//
//        assertDoesNotThrow(() -> {
//            Producto producto = dao.buscarPorId(idBuscado);
//                assertEquals(idBuscado, producto.getId());
//                assertEquals("Pizza Pepperoni", producto.getNombre());
//        });
//    }
//
//    @Test
//    public void testLocalizarPorNombreFuncionaOk() {
//        String filtro = "Pizza";
//
//        assertDoesNotThrow(() -> {
//            List<Producto> resultados = dao.localizarPorNombre(filtro);
//            assertNotNull(resultados);
//            assertFalse(resultados.isEmpty());
//            for (Producto p : resultados) {
//                assertTrue(p.getNombre().toLowerCase().contains(filtro.toLowerCase()));
//            }
//        });
//    }
//
//    @Test
//    public void testEditarEstadoProductoFuncionaOk() {
//        Long idAEditar = 1L;
//        ProductoEstadoActualizadoDTO dtoEstado = new ProductoEstadoActualizadoDTO(idAEditar, Enums.EstadoProducto.INACTIVO);
//
//        assertDoesNotThrow(() -> {
//            Producto editado = dao.editarEstadoProducto(dtoEstado);
//            assertNotNull(editado);
//            assertEquals(EstadoProducto.INACTIVO, editado.getEstado());
//        });
//    }
//
//    @Test
//    public void testLocalizarPorCategoriaTraeResultados() {
//        Tipo tipoBusqueda = Tipo.BEBIDA;
//
//        assertDoesNotThrow(() -> {
//            List<Producto> lista = dao.localizarPorCategoria(tipoBusqueda);
//            assertNotNull(lista);
//            for (Producto p : lista) {
//                assertEquals(tipoBusqueda, p.getTipoProducto());
//            }
//        });
//    }
}
