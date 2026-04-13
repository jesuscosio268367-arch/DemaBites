/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import Enums.Unidad;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;
import com.mycompany.demabitesnegocio.IingredientesBO;
import com.mycompany.demabitesnegocio.IngredientesBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitespersistencia.IngredientesDAO;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Omar
 */
public class IngredientesControl {

    private final IingredientesBO ingredientesBO;

    public IngredientesControl() {
        this.ingredientesBO = new IngredientesBO(new IngredientesDAO());
    }

    public List<Ingrediente> cargarTablaIngredientes() {
        try {
            return ingredientesBO.consultarIngredientes();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar ingredientes: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    public void registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente, JFrame ventana) {
        try {
            ingredientesBO.registrarIngrediente(nuevoIngrediente);

            JOptionPane.showMessageDialog(
                    ventana,
                    "¡El ingrediente ha sido guardado con éxito!"
            );
            
            Navegacion.getControlNavegacion().abrirFrameIngredientes();
            ventana.dispose();
                    
        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Ingrediente> buscarIngredientes(String filtro) {
        try {
            return ingredientesBO.consultarIngredientesFiltro(filtro);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar ingredientes: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
