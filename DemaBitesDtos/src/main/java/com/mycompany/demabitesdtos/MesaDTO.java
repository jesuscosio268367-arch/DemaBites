package com.mycompany.demabitesdtos;

/**
 * Objeto de Transferencia de Datos para la entidad Mesa.
 * Se utiliza para enviar información de las mesas a la capa de presentación 
 * sin exponer la entidad JPA directa.
 * @author Emily Lara
 * 270719
 */
public class MesaDTO {
    
    private Long id;
    private Integer numeroMesa; 

    /**
     * Constructor por defecto.
     */
    public MesaDTO(){
        
    }

    /**
     * Obtiene el identificador único de la mesa.
     * @return El ID de la mesa.
     */
    public Long getId(){
        return id; 
    }
    
    /**
     * Establece el identificador único de la mesa.
     * @param id El ID a asignar.
     */
    public void setId(Long id){ 
        this.id = id; 
    }

    /**
     * Obtiene el número asignado a la mesa.
     * @return El número de la mesa.
     */
    public Integer getNumeroMesa(){
        return numeroMesa; 
    }
    
    /**
     * Establece el número de la mesa.
     * @param numeroMesa El número a asignar.
     */
    public void setNumeroMesa(Integer numeroMesa){ 
        this.numeroMesa = numeroMesa;
    }

    /**
     * Retorna una representación en texto del DTO.
     * Este método es utilizado por los componentes gráficos (como JComboBox) 
     * para mostrar el texto en pantalla de forma automática.
     * @return Una cadena con el formato Mesa X.
     */
    @Override
    public String toString() {
        return "Mesa " + numeroMesa; 
    }   
}