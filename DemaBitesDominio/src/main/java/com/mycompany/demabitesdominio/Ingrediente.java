/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesdominio;

import Enums.Unidad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jesus Omar
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "unidad", nullable = false)
    private Unidad unidad;
    
    @Column(name = "stock", nullable = false)
    private double stock;
    
    @Column(name = "imagen", nullable = true)
    private byte[] imagenIngrediente;
    
    @OneToMany(mappedBy = "ingrediente")
    private List<ProductoIngrediente> productos = new ArrayList<>();
    
    public Ingrediente(){
        // Constructor por defecto
    }

    public Ingrediente(String nombre, Unidad unidad, double stock, byte[] imagenIngrediente) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.stock = stock;
        this.imagenIngrediente = imagenIngrediente;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    
    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public byte[] getImagenIngrediente() {
        return imagenIngrediente;
    }

    public void setImagenIngrediente(byte[] imagenIngrediente) {
        this.imagenIngrediente = imagenIngrediente;
    }

    public List<ProductoIngrediente> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoIngrediente> productos) {
        this.productos = productos;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.demabitesdominio.Ingrediente[ id=" + id + " ]";
    }
    
}
