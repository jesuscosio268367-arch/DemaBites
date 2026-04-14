package com.mycompany.demabitespresentacion;

import control.Navegacion;

/**
 * Clase main para correr el sistema.
 * @author Jesus Omar
 */
public class MainDemabites {

    public static void main(String[] args) {
        Navegacion.getControlNavegacion().inicializar(new FrameInicioSesion());
    }
}
