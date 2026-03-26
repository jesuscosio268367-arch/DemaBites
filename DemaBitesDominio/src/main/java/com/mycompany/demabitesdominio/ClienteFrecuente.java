/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesdominio;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Jesus Omar
 */
@Entity
@Table(name = "clientesFrecuentes")
public class ClienteFrecuente extends Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "email", nullable = true)
    private String email;
    
    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    public ClienteFrecuente(){
    }

    public ClienteFrecuente(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String telefono, LocalDate fechaRegistro ) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
