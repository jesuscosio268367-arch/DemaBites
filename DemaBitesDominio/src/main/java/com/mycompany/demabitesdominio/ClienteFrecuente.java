package com.mycompany.demabitesdominio;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad que representa un Cliente Frecuente dentro del sistema.
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

    /**
     * Contructor vacio.
     */
    public ClienteFrecuente(){
        
    }

    /**
     * Contructor con todos los atributos del cliente frecuente a excepcion del ID.
     * @param nombres Los nombres del cliente.
     * @param apellidoPaterno El apellido paterno.
     * @param apellidoMaterno El apellido materno.
     * @param email El email del cliente.
     * @param telefonoEncriptado El telefono encriptado del cliente.
     * @param telefonoHash El hash del telefono.
     * @param fechaRegistro La fecha en la que el cliente se registro.
     */
    public ClienteFrecuente(String nombres, String apellidoPaterno, String apellidoMaterno, 
                            String email, String telefonoEncriptado, String telefonoHash, LocalDate fechaRegistro ) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.telefonoEncriptado = telefonoEncriptado;
        this.telefonoHash = telefonoHash;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    /** 
     * @return El telefono en texto plano (solo disponible después de desencriptar) 
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Permite guardar el telefono legible temporalmente para mostrarlo en la UI.
     * @param telefono El telefono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /** @return El telefono encriptado del cliente. */
    public String getTelefonoEncriptado() {
        return telefonoEncriptado;
    }

    /** @param telefonoEncriptado El telefono encriptado que se le asignara al clinte */
    public void setTelefonoEncriptado(String telefonoEncriptado) {
        this.telefonoEncriptado = telefonoEncriptado;
    }

    /** @return El hash del telefono */
    public String getTelefonoHash() {
        return telefonoHash;
    }

    /** @param telefonoHash El hash del telefono que se le asignara al cliente */
    public void setTelefonoHash(String telefonoHash) {
        this.telefonoHash = telefonoHash;
    }

    /** @return El email del cliente */
    public String getEmail() {
        return email;
    }

    /** @param email El email que se le asignara al cliente */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return La fecha de registro del cliente */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /** @param fechaRegistro La fecha de registro del cliente que se le asignara al cliente */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    /**
     * Compara la igualdad de dos clientes basandose en el ID.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ClienteFrecuente other = (ClienteFrecuente) obj;
        return getId() != null && getId().equals(other.getId());
    }

    /**
     * Genera el hash de identidad del objeto utilizando el ID.
     */
    @Override
    public int hashCode() {
        return (getId() != null) ? getId().hashCode() : 0;
    }

    /**
     * Devuelve una texto de los atributos del Cliente Frecuente.  
     */
    @Override
    public String toString() {
        return "ClienteFrecuente{"
                + "id=" + getId() 
                + ", nombres=" + getNombres() 
                + ", apellido paterno=" + getApellidoPaterno()
                + ", apellido materno=" + getApellidoMaterno()
                + ", telefono=" + getTelefono()
                + ", email=" + email 
                + ", fecha de registro=" + fechaRegistro
                + '}';
    }
}
