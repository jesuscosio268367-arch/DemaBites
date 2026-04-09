/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import Enums.Unidad;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdtos.NuevoIngredienteDTO;

/**
 *
 * @author Jesus Omar
 */
public class NuevoIngredienteDTOAIngredienteAdapter {
    
    public static Ingrediente adapter(NuevoIngredienteDTO nuevoIngrediente){
        
        Unidad unidad = Unidad.PIEZAS;
        if(nuevoIngrediente.getUnidad() == Unidad.GRAMOS){
            unidad = Unidad.GRAMOS;
        }else if(nuevoIngrediente.getUnidad() == Unidad.MILILITROS){
            unidad = Unidad.MILILITROS;
        }
        
        Ingrediente ingrediente = new Ingrediente(nuevoIngrediente.getNombre(), unidad, nuevoIngrediente.getStock(), nuevoIngrediente.getImagenIngrediente());
        return ingrediente;
        
    }
    
}
