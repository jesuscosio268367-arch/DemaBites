package utileria;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 * Clase de utileria con metodos estaticos para la manipulacion
 * y gestion de componentes de la interfaz grafica.
 * @author Dario
 */
public class utilMetodos {
    
    /**
     * Reemplaza el contenido de un panel contenedor por el menu header del sistema.
     * @param contenedor El JPanel de destino que sera actualizado.
     * @param componente El Component que se desea insertar.
     */
    public static void insertarPanel(JPanel contenedor, Component componente) {
        contenedor.setLayout(new BorderLayout());
        contenedor.removeAll();
        contenedor.add(componente, BorderLayout.CENTER);
        contenedor.revalidate();
        contenedor.repaint();
    }
}
