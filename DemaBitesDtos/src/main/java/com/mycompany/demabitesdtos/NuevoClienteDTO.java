package com.mycompany.demabitesdtos;

/**
 * DTO para el registro de un nuevo cliente.
 * @author Jesus Omar
 */
public class NuevoClienteDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    /**
     * Contructor vacio.
     */
    public NuevoClienteDTO() {
        
    }

    /**
     * Constructor con todos los campos.
     * @param nombres Los nombres del cliente.
     * @param apellidoPaterno El apellido paterno.
     * @param apellidoMaterno El apellido materno.
     */
    public NuevoClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /** @return El nombre o nombres del cliente. */
    public String getNombres() {
        return nombres;
    }

    /** @return El apellido paterno del cliente. */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /** @return El apellido materno del cliente. */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    
}
