/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesdtos;

/**
 *
 * @author emy
 */
public class MesaDTO {
    private Long id;
    private Integer numeroMesa; 

    public MesaDTO(){
        
    }

    public Long getId(){
        return id; 
    }
    
    public void setId(Long id){ 
        this.id = id; 
    }

    public Integer getNumeroMesa(){
        return numeroMesa; 
    }
    
    public void setNumeroMesa(Integer numeroMesa){ 
        this.numeroMesa = numeroMesa;
    }

    @Override
    public String toString() {
        return "Mesa " + numeroMesa; 
    }   
}
