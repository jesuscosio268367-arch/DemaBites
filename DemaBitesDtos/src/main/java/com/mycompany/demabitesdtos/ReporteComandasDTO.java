package com.mycompany.demabitesdtos;

import java.time.LocalDateTime;

/**
 *
 * @author Emy
 */
public class ReporteComandasDTO {
    private String folio;
    private LocalDateTime fechaHora;
    private Integer numeroMesa;
    private Double total;
    private Object estado;    
    private String nombreCliente;

    public ReporteComandasDTO() {
    }

    
    public ReporteComandasDTO(String folio, LocalDateTime fechaHora, Integer numeroMesa, Double total, Object estado, String nombreCliente) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.numeroMesa = numeroMesa;
        this.total = total;
        this.estado = estado;
        this.nombreCliente = nombreCliente;
    }
    
    public String getFolio() {
        return folio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Object getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
}
