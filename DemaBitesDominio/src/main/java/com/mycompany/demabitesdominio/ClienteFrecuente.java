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
import javax.persistence.Transient;

/**
 *
 * @author Jesus Omar
 */
@Entity
@Table(name = "clientesFrecuentes")
public class ClienteFrecuente extends Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Transient // NO se guarda en la DB
    private String telefono;
    
    @Column(name = "telefono_encriptado", nullable = false, length = 255) //Este es el que recupera el dato. PARA VER
    private String telefonoEncriptado;
    
    @Column(name = "telefono_hash", nullable = false, length = 64, unique = true) //Este es para BUSCAR, ya que el hash siempre devuelve el mismo valor
    private String telefonoHash;
    
    @Column(name = "email", nullable = true, length = 60)
    private String email;
    
    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    public ClienteFrecuente(){
    }

    public ClienteFrecuente(String nombres, String apellidoPaterno, String apellidoMaterno, 
                            String email, String telefonoEncriptado, String telefonoHash, LocalDate fechaRegistro ) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.telefonoEncriptado = telefonoEncriptado;
        this.telefonoHash = telefonoHash;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    /** 
     * @return El teléfono en texto plano (solo disponible después de desencriptar) 
     */
    public String getTelefono() {
        return telefono;
    }

    /** 
     * Permite guardar el teléfono legible temporalmente para mostrarlo en la UI 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getTelefonoEncriptado() {
        return telefonoEncriptado;
    }

    public void setTelefonoEncriptado(String telefonoEncriptado) {
        this.telefonoEncriptado = telefonoEncriptado;
    }

    public String getTelefonoHash() {
        return telefonoHash;
    }

    public void setTelefonoHash(String telefonoHash) {
        this.telefonoHash = telefonoHash;
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
