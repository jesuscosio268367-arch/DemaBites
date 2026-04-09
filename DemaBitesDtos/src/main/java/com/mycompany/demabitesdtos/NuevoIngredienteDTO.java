/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesdtos;

import Enums.Unidad;

/**
 *
 * @author Jesus Omar
 */
public class NuevoIngredienteDTO {
    
    private String nombre;
    private Unidad unidad;
    private double stock;
    private byte[] imagenIngrediente;

    public NuevoIngredienteDTO(String nombre, Unidad unidad, double stock, byte[] imagenIngrediente) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.stock = stock;
        this.imagenIngrediente = imagenIngrediente;
    }

    
    public String getNombre() {
        return nombre;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public double getStock() {
        return stock;
    }

    public byte[] getImagenIngrediente() {
        return imagenIngrediente;
    }
    
    
    
}
