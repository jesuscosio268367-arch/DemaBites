/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demabitespersistencia;

import Enums.Unidad;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Jesus Omar
 */
public class IngredientesDAOTest {

    private IngredientesDAO dao;

    @BeforeEach
    public void init() {
        this.dao = new IngredientesDAO();
    }

    @Test
    public void testRegistrarProductoFuncionaOK() {
        //Setup
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Leche",
                Unidad.MILILITROS,
                10,
                null
        );

        assertDoesNotThrow(() -> {
            Ingrediente ingrediente = dao.registrarIngrediente(nuevoIngrediente);
            assertNotNull(ingrediente.getId());
        });
    }

    @Test
    public void testNoPermiteProductoRepetido() {
        //Setup
        NuevoIngredienteDTO ingredienteExistente = new NuevoIngredienteDTO(
                "Azucar",
                Unidad.GRAMOS,
                10,
                null);
        
        NuevoIngredienteDTO ingredienteRepetido = new NuevoIngredienteDTO(
                "Azucar",
                Unidad.GRAMOS,
                10,
                null
        );
       
        // esta dentro del assertDoesNotThrow para que no lance ninguna excepcion el metodo de consultar
        // y luego el assertTrue es para verificar que si encunetra una coincidencia, la validacion esta en la BO
        // si regresa True no te deja registrar el ingrediente
        assertDoesNotThrow(() -> {
            dao.registrarIngrediente(ingredienteExistente);
            boolean resultado = dao.consultarPorNombreUnidad(ingredienteRepetido.getNombre(), ingredienteRepetido.getUnidad());
            assertTrue(resultado);
        });
    }

    @Test
    public void testPermiteAgregarProductoConUnidadDiferenteOK(){
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(
                "Leche",
                Unidad.PIEZAS,
                10,
                null
        );
        
        // es la misma logica que el anterior, la validacion esta en la BO
        // si lanza false te permitira agregar un producto con el mismo nombre
        // pero con diferente unidad
        assertDoesNotThrow(() -> {
            boolean resultado = dao.consultarPorNombreUnidad(nuevoIngrediente.getNombre(), nuevoIngrediente.getUnidad());
            assertFalse(resultado);
        });
        
    }
    
    @Test
    public void testConsultarTodosLosIngredientesOK(){
        NuevoIngredienteDTO ingrediete1 = new NuevoIngredienteDTO("Cebolla", Unidad.GRAMOS, 8, null);
        NuevoIngredienteDTO ingrediete2 = new NuevoIngredienteDTO("Sal", Unidad.GRAMOS, 5, null);
        NuevoIngredienteDTO ingrediete3 = new NuevoIngredienteDTO("Pimienta", Unidad.GRAMOS, 20, null);
        
        assertDoesNotThrow(() -> {
            dao.registrarIngrediente(ingrediete1);
            dao.registrarIngrediente(ingrediete2);
            dao.registrarIngrediente(ingrediete3);
            
            List<Ingrediente> lista = dao.consultarIngredientes();
            
            assertNotNull(lista);
            
            assertTrue(lista.size() == 3);
        });
    }
    
}
