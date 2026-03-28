/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesdtos;

/**
 *
 * @author Dario
 */
public class NuevoClienteFrecuenteActualizadoDTO {
    private final Long id;
    private String email;
    private String telefono;

    public NuevoClienteFrecuenteActualizadoDTO(Long id, String email, String telefono) {
        this.id = id;
        this.email = email;
        this.telefono = telefono;
    }
    
    public Long getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
