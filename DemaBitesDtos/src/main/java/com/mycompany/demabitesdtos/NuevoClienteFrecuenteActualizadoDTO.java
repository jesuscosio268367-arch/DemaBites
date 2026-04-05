package com.mycompany.demabitesdtos;

/**
 * DTO para la edicion de un cliente frecuente.
 * @author Dario
 */
public class NuevoClienteFrecuenteActualizadoDTO {
    private final Long id;
    private String email;
    private String telefono;

    /**
     * Constructor con todos los campos.
     * @param id El ID del cliente.
     * @param email El email del cliente.
     * @param telefono El telefono del cliente.
     */
    public NuevoClienteFrecuenteActualizadoDTO(Long id, String email, String telefono) {
        this.id = id;
        this.email = email;
        this.telefono = telefono;
    }
    
    /** @return El ID del cliente. */
    public Long getId() {
        return id;
    }

    /** @return El telefono del cliente. */
    public String getTelefono() {
        return telefono;
    }

    /** @return El email del cliente. */
    public String getEmail() {
        return email;
    }

    /** @param telefono El número de teléfono a asignar al cliente. */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /** @param email El correo electrónico a asignar al cliente. */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
