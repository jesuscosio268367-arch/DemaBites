package com.mycompany.demabitesdominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase Entidad Comanda.
 * Entidad JPA que representa una Comanda en el sistema y se mapea a la tabla "comandas".
 * Almacena la información de una orden realizada en una mesa del restaurante.
 * * @author Emily Lara
 * 270719
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comanda")
    private Long id;

    @Column(name = "folio", nullable = false, unique = true, length = 20)
    private String folio; 

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoComanda estado;

    @Column(name = "total", nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = true)
    private ClienteFrecuente cliente;

    @OneToMany(
        cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
        mappedBy = "comanda" 
    )
    private List<DetalleComanda> detalles;

    /**
     * Constructor por defecto.
     */
    public Comanda() {
        
    }

    /**
     * Constructor que inicializa la entidad Comanda con sus datos principales.
     * * @param folio El folio único de la comanda (Formato: OB-YYYYMMDD-XXX).
     * @param fechaHora La fecha y hora exacta de creación.
     * @param estado El estado actual de la comanda (ABIERTA, ENTREGADA, CANCELADA).
     * @param total El monto total acumulado de la comanda.
     * @param mesa La entidad Mesa donde se está realizando el consumo.
     * @param cliente La entidad ClienteFrecuente asignada (nulo si es cliente general).
     */
    public Comanda(String folio, LocalDateTime fechaHora, EstadoComanda estado, Double total, Mesa mesa, ClienteFrecuente cliente) {
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.total = total;
        this.mesa = mesa;
        this.cliente = cliente;
    }

    /**
     * Obtiene el identificador único autogenerado de la comanda en la base de datos.
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
     * Obtiene el folio de registro de la comanda.
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
     * Obtiene la fecha y hora en la que se abrió la comanda.
     * @return La fecha y hora de la comanda.
     */
    public LocalDateTime getFechaHora(){ 
        return fechaHora; 
    }
    
    /**
     * Establece la fecha y hora de la comanda.
     * @param fechaHora La nueva fecha y hora a asignar.
     */
    public void setFechaHora(LocalDateTime fechaHora){ 
        this.fechaHora = fechaHora; 
    }

    /**
     * Obtiene el estado actual de la comanda.
     * @return El enumerador EstadoComanda correspondiente.
     */
    public EstadoComanda getEstado(){ 
        return estado; 
    }
    
    /**
     * Establece el estado de la comanda.
     * @param estado El nuevo EstadoComanda a asignar.
     */
    public void setEstado(EstadoComanda estado){
        this.estado = estado; 
    }

    /**
     * Obtiene el costo total de la comanda.
     * @return El total a pagar.
     */
    public Double getTotal(){ 
        return total; 
    }
    
    /**
     * Establece el costo total de la comanda.
     * @param total El nuevo total a asignar.
     */
    public void setTotal(Double total){ 
        this.total = total; 
    }

    /**
     * Obtiene la mesa asociada a la comanda.
     * @return La entidad Mesa vinculada.
     */
    public Mesa getMesa(){ 
        return mesa; 
    }
    
    /**
     * Establece la mesa para esta comanda.
     * @param mesa La entidad Mesa a vincular.
     */
    public void setMesa(Mesa mesa){ 
        this.mesa = mesa; 
    }

    /**
     * Obtiene el cliente frecuente asociado a la comanda.
     * @return La entidad ClienteFrecuente vinculada (o nulo si es general).
     */
    public ClienteFrecuente getCliente(){ 
        return cliente; 
    }
    
    /**
     * Establece el cliente frecuente para esta comanda.
     * @param cliente La entidad ClienteFrecuente a vincular.
     */
    public void setCliente(ClienteFrecuente cliente){ 
        this.cliente = cliente; 
    }

    /**
     * Obtiene la lista de detalles (productos) que conforman la comanda.
     * @return Lista de entidades DetalleComanda.
     */
    public List<DetalleComanda> getDetalles(){ 
        return detalles; 
    }
    
    /**
     * Establece la lista de detalles (productos) de la comanda.
     * @param detalles La nueva lista de DetalleComanda.
     */
    public void setDetalles(List<DetalleComanda> detalles){ 
        this.detalles = detalles; 
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", estado=" + estado + ", total=" + total + '}';
    }
}