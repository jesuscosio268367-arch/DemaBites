/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.mycompany.demabitespresentacion.FormClientes;
import com.mycompany.demabitespresentacion.FrameClientes;
import com.mycompany.demabitespresentacion.MenuPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author Jesus Omar
 */
public class Navegacion {
    
    private static Navegacion controlNavegacion;
    
    public static Navegacion getControlNavegacion(){
        if(controlNavegacion == null){
            controlNavegacion = new Navegacion();
        }
        return controlNavegacion;
    }
    
    public void abrirMenuPrincipal(){
        cambiarPantalla(new MenuPrincipal());
    }
    
    public void abrirClientesForm(){
        cambiarPantalla(new FormClientes());
    }
    
    public void abrirClientesFrame(){
        cambiarPantalla(new FrameClientes());
    }
    
    public void cambiarPantalla(JFrame nuevoFrame){
        nuevoFrame.setVisible(true);
        nuevoFrame.setLocationRelativeTo(null);
    }
    
    //prueva
}
