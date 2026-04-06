package com.mycompany.demabitesdtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) que representa una Nueva Comanda.
 * Se utiliza para transportar la información de una comanda desde la capa de 
 * presentación hacia las capas de negocio y persistencia sin exponer las 
 * entidades JPA directamente.
 * * @author Emily Lara
 * 270719
 */
public class NuevaComandaDTO {

    private Long id;
    private String folio;
    private LocalDateTime fechaHora;
    private EstadoComanda estado;
    private Double total;
    private MesaDTO mesa; 
    private NuevoClienteFrecuenteDTO cliente;
    private List<DetalleComandaDTO> detalles;

    /**
     * Constructor por defecto.
     * Crea una instancia vacía de NuevaComandaDTO.
     */
    public NuevaComandaDTO() {
        
    }

    /**
     * Constructor que inicializa una NuevaComandaDTO con los datos principales.
     * * @param folio El folio único de la comanda (Formato: OB-YYYYMMDD-XXX).
     * @param fechaHora La fecha y hora en la que se abrió la comanda.
     * @param estado El estado actual de la comanda ("Abierta, Entregada o Cancelada)
     * @param total El monto total acumulado de los productos en la comanda.
     * @param mesa El DTO de la mesa asociada a la comanda.
     * @param cliente El DTO del cliente frecuente asociado (puede ser nulo si es Cliente General).
     */
    public NuevaComandaDTO(String folio, LocalDateTime fechaHora, EstadoComanda estado, Double total, MesaDTO mesa, NuevoClienteFrecuenteDTO cliente) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.total = total;
        this.mesa = mesa;
        this.cliente = cliente;
    }

    /**
     * Obtiene el identificador único de la comanda.
     * @return El id de la comanda.
     */
    public Long getId(){ 
        return id; 
    }
    
    /**
     * Establece el identificador único de la comanda.
     * @param id El nuevo id a asignar.
     */
    public void setId(Long id){ 
        this.id = id; 
    }

    /**
     * Obtiene el folio de la comanda.
     * @return El folio en formato OB-YYYYMMDD-XXX.
     */
    public String getFolio(){ 
        return folio; 
    }
    
    /**
     * Establece el folio de la comanda.
     * @param folio El nuevo folio a asignar.
     */
    public void setFolio(String folio){ 
        this.folio = folio;
    }

    /**
     * Obtiene la fecha y hora de creación de la comanda.
     * @return La fecha y hora de la comanda.
     */
    public LocalDateTime getFechaHora(){ 
        return fechaHora; 
    }

    /**
     * Establece la fecha y hora de creación de la comanda.
     * @param fechaHora La nueva fecha y hora a asignar.
     */
    public void setFechaHora(LocalDateTime fechaHora){ 
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el estado actual de la comanda.
     * @return El estado de la comanda (Abierta, Entregada o Cancelada).
     */
    public EstadoComanda getEstado(){ 
        return estado;
    }
    
    /**
     * Establece el estado de la comanda.
     * @param estado El nuevo estado a asignar.
     */
    public void setEstado(EstadoComanda estado){ 
        this.estado = estado; 
    }

    /**
     * Obtiene el monto total de la comanda.
     * @return El total a pagar.
     */
    public Double getTotal(){ 
        return total; 
    }
    
    /**
     * Establece el monto total de la comanda.
     * @param total El nuevo total a asignar.
     */
    public void setTotal(Double total){ 
        this.total = total; 
    }

    /**
     * Obtiene la mesa asociada a la comanda.
     * @return Un objeto MesaDTO que representa la mesa.
     */
    public MesaDTO getMesa(){
        return mesa; 
    }

    /**
     * Establece la mesa para esta comanda.
     * @param mesa El objeto MesaDTO a asociar.
     */
    public void setMesa(MesaDTO mesa){ 
        this.mesa = mesa; 
    }

    /**
     * Obtiene el cliente asociado a la comanda.
     * @return Un objeto NuevoClienteFrecuenteDTO, o nulo si es Cliente General.
     */
    public NuevoClienteFrecuenteDTO getCliente(){
        return cliente; 
    }
    
    /**
     * Establece el cliente para esta comanda.
     * @param cliente El objeto NuevoClienteFrecuenteDTO a asociar.
     */
    public void setCliente(NuevoClienteFrecuenteDTO cliente){ 
        this.cliente = cliente; 
    }

    /**
     * Obtiene la lista de productos (detalles) agregados a la comanda.
     * @return Una lista de DetalleComandaDTO.
     */
    public List<DetalleComandaDTO> getDetalles(){ 
        return detalles; 
    }
    
    /**
     * Establece la lista de productos (detalles) de la comanda.
     * @param detalles La nueva lista de DetalleComandaDTO a asociar.
     */
    public void setDetalles(List<DetalleComandaDTO> detalles){ 
        this.detalles = detalles; 
    }

    /**
     * Devuelve una representación en formato de texto de la NuevaComandaDTO.
     * @return Una cadena con el folio, estado y total de la comanda.
     */
    @Override
    public String toString() {
        return "NuevaComandaDTO{" + "folio=" + folio + ", estado=" + estado + ", total=" + total + '}';
    }
}