package com.mycompany.demabitesdtos;

import java.time.LocalDateTime;

/**
 * DTO para la visualizacion de reporte de un cliente.
 * @author Dario
 */
public class ReporteClientesDTO {
    private String nombreCliente;
    private Integer numeroVisitas;
    private Double totalGastado;
    private LocalDateTime ultimaVisita;

    /**
     * Contructor vacio
    */
    public ReporteClientesDTO() {
        
    }

    /**
     * Contructor con todos los atributos.
     * @param nombreCliente Nombre del cliente al que se le realiza el reporte. 
     * @param numeroVisitas Numero de veces que el cliente a realizado una comanda.
     * @param totalGastado Total gastado entre comandas realizadas.
     * @param ultimaVisita Ultima visita del cliente (ultima comanda realizada).
     */
    public ReporteClientesDTO(String nombreCliente, Integer numeroVisitas, Double totalGastado, LocalDateTime ultimaVisita) {
        this.nombreCliente = nombreCliente;
        this.numeroVisitas = numeroVisitas;
        this.totalGastado = totalGastado;
        this.ultimaVisita = ultimaVisita;
    }

    /** @return El nombre del cliente consultado. */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /** @param nombreCliente El nombre de cliente que se asignara al reporte. */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /** @return El numero de visitas del cliente consultado. */
    public Integer getNumeroVisitas() {
        return numeroVisitas;
    }

    /** @param numeroVisitas El numero de visitas que se asignara al reporte. */
    public void setNumeroVisitas(Integer numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    /** @return El total gastado del cliente consultado. */
    public Double getTotalGastado() {
        return totalGastado;
    }

    /** @param totalGastado El total gastado que se asignara al reporte. */
    public void setTotalGastado(Double totalGastado) {
        this.totalGastado = totalGastado;
    }

    /** @return La ultima visita del cliente consultado. */
    public LocalDateTime getUltimaVisita() {
        return ultimaVisita;
    }

    /** @param ultimaVisita La ultima visita que se asignara al reporte. */
    public void setUltimaVisita(LocalDateTime ultimaVisita) {
        this.ultimaVisita = ultimaVisita;
    }
    
}
