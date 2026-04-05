package com.mycompany.demabitesnegocio;

/**
 * Excepcion personalizada para la capa de negocio del sistema.
 * @author Jesus Omar
 */
public class NegocioException extends Exception{
    
    /**
     * Excepcion con mensaje y la causa del error.
     * @param message El mensaje de descripcion de error.
     * @param cause La causa del error (esta se manda desde la capa de persistencia).
     */
    public NegocioException(String message, Throwable cause) {
        super(message,cause);
    }
    
}
