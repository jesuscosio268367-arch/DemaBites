package com.mycompany.demabitesdominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad JPA que representa la tabla "mesas" en la base de datos.
 * @author Emily Lara
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Long id;

    
    @Column(name = "numero_mesa", nullable = false, unique = true)
    private Integer numero;
    
    
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;
    
    /**
     * Constructor vacío obligatorio
     */
    public Mesa() {
        
    }

    /**
     * Constructor que inicializa los atributos principales de la mesa.
     * @param numero El número identificador físico de la mesa.
     * @param capacidad La cantidad máxima de personas que admite la mesa.
     */
    public Mesa(Integer numero, Integer capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el ID interno de la mesa.
     * @return El ID autogenerado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID interno de la mesa.
     * @param id El ID a asignar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el número visible de la mesa.
     * @return El número de la mesa.
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Establece el número visible de la mesa.
     * @param numero El número a asignar.
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la capacidad máxima de personas para la mesa.
     * @return La capacidad de la mesa.
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad de la mesa.
     * @param capacidad La capacidad a asignar.
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mesa " + numero + " (Capacidad: " + capacidad + ")";
    }
}