/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.mycompany.demabitespresentacion.FormClientes;
import com.mycompany.demabitespresentacion.FormEditarClientes;
import com.mycompany.demabitespresentacion.FrameClientes;
import com.mycompany.demabitespresentacion.MenuPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author Jesus Omar
 */
public class Navegacion {
    
    private static Navegacion controlNavegacion;
    private JFrame frameActual;
    private String pantallaActual = "";
    private Object datoTemporal;
    
    public String getPantallaActual() {
        return pantallaActual;
    }
    
    public void setDato(Object dato) {
        this.datoTemporal = dato;
    }

    public Object getDato() {
        return datoTemporal;
    }
    
    public static Navegacion getControlNavegacion(){
        if(controlNavegacion == null){
            controlNavegacion = new Navegacion();
        }
        return controlNavegacion;
    }
    
    public void inicializar(JFrame primerFrame) {
        this.frameActual = primerFrame;
        this.frameActual.setVisible(true);
        this.frameActual.setLocationRelativeTo(null);
    }
    
    public void abrirMenuPrincipal(){
        cambiarPantalla(new MenuPrincipal());
    }
    
    //Comandas
    //Productos
    //Ingredientes
    //Clientes
    public void abrirClientesForm(){
        this.pantallaActual = "";
        cambiarPantalla(new FormClientes());
    }
    
    public void abrirClientesFrame(){
        this.pantallaActual = "CLIENTES";
        cambiarPantalla(new FrameClientes());
    }
    
    public void abrirEditarClientesForm(){
        cambiarPantalla(new FormEditarClientes());
    }
    
    //Reportes
    
    public void cambiarPantalla(JFrame nuevo){
        if (frameActual != null) {
            frameActual.dispose();
        }
        this.frameActual = nuevo;
        this.frameActual.setVisible(true);
        this.frameActual.setLocationRelativeTo(null);
    }
 
}
