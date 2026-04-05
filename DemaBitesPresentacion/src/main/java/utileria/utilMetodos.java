/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utileria;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Dario
 */
public class utilMetodos {
    public static void insertarPanel(JPanel contenedor, Component componente) {
        contenedor.setLayout(new BorderLayout());
        contenedor.removeAll();
        contenedor.add(componente, BorderLayout.CENTER);
        contenedor.revalidate();
        contenedor.repaint();
    }
}
