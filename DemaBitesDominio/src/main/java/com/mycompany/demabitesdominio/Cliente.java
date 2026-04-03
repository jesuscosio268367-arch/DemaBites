package com.mycompany.demabitesdominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Entidad que representa un Cliente dentro del sistema.
 * @author Jesus Omar
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cliente")
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombres;
    
    @Column(name = "apellidoPaterno", nullable = false, length = 60)
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno", nullable = false, length = 60)
    private String apellidoMaterno;

    /**
     * Contructor vacio.
     */
    public Cliente(){
    }

    /**
     * Constructor con todos los atributos de Cliente a excepcion de id.
     * @param nombres Los nombres del cliente.
     * @param apellidoPaterno El apellido paterno.
     * @param apellidoMaterno El apellido materno.
     */
    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
    
    /** @return El ID unico del cliente. */
    public Long getId() {
        return id;
    }

    /** @param id El ID unico a asignar al cliente. */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return El nombre o nombres del cliente. */
    public String getNombres() {
        return nombres;
    }

    /** @param nombres El nombre o nombres a asignar al cliente. */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /** @return El apellido paterno del cliente. */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /** @param apellidoPaterno El apellido paterno a asignar al cliente. */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /** @return El apellido materno del cliente. */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /** @param apellidoMaterno El apellido materno a asignar al cliente. */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    /**
     * Genera un codigo unico para el objeto basado en su ID.
     * @return int con el valor hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara este cliente con otro objeto. 
     * @param object Objeto a comparar.
     * @return true si los IDs coinciden.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Representacion textual del cliente. 
     * @return String donde se imprimen todos los datos del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{"
                + "id=" + id + 
                ", nombres=" + nombres + 
                ", apellidoPaterno=" + apellidoPaterno + 
                ", apellidoMaterno=" + apellidoMaterno 
                + '}';
    }
    
}
