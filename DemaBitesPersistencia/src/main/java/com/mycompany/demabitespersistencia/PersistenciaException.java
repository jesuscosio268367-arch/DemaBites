package com.mycompany.demabitespersistencia;

/**
 * Excepcion personalizada para la capa de persistencia del sistema.
 * @author Dario
 */
public class PersistenciaException extends Exception {
    
    /**
     * Excepcion sin un mensaje detallado.
     */
    public PersistenciaException() {
        
    }

    /**
     * Excepcion con mensaje personaliza del error.
     * @param message El mensaje de descripcion de error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Excepcion con mensaje y con causa, usualmente usado para mostrar errores con loggers.
     * @param message El mensaje de descripcion de error.
     * @param cause La causa mandada por la base de datos.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}
