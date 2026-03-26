/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesdtos;

/**
 * DTO para el registro de un nuevo cliente frecuente.
 * @author Dario
 */
public class NuevoClienteFrecuenteDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String email;

    /**
     * Contructor vacio.
     */
    public NuevoClienteFrecuenteDTO() {
        
    }
     
    /**
     * Constructor con todos los campos.
     * @param nombres Los nombres del cliente.
     * @param apellidoPaterno El apellido paterno.
     * @param apellidoMaterno El apellido materno.
     * @param telefono El telefono del cliente.
     * @param email El email del cliente.
     */
    public NuevoClienteFrecuenteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String telefono) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono = telefono;
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

    /** @return El telefono del cliente. */
    public String getTelefono() {
        return telefono;
    }

    /** @return El email del cliente. */
    public String getEmail() {
        return email;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
