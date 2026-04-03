package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.util.List;

/**
 * Interfaz que define los metodos BO para las entidades Cliente.
 * @author Jesus Omar
 */
public interface IClientesBO {
    
    /**
     * Metodo con las validaciones de campo para crear un nuevo cliente frecuente.
     * @param nuevoClienteFrecuente DTO con la informacion del prospecto a cliente frecuente.
     * @return El cliente frecuente registrado.
     * @throws NegocioException Si se peresenta un error en la validacion, 
     * se encuentra un cliente con el mismo numero o hay un error en la persistencia.
     */
    public abstract ClienteFrecuente crearClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) 
            throws NegocioException;
    
    /**
     * Validaciones para la edicion de un cliente frecuente existente.
     * @param nuevoClienteFrecuenteActualizado DTO con los datos a modificar.
     * @return El cliente frecuente actualizado.
     * @throws NegocioException Si el se presenta un error en la validacion, el ID es invalido
     * se encuentra un cliente con el mismo numero o hay un error en la persistencia.
     */
    public abstract ClienteFrecuente editarClienteFrecuente(NuevoClienteFrecuenteActualizadoDTO nuevoClienteFrecuenteActualizado) 
            throws NegocioException;
   
    /**
     * Metodo para consultar todos los clientes frecuentes.
     * @return listado de todos los clientes frecuentes registrados.
     * @throws NegocioException Si ocurre un error al cargar los datos.
     */
    public abstract List<ClienteFrecuente> consultarTodos()
            throws NegocioException;
    
     /**
     * Metodo filtrar la busqueda de clientes.
     * @param filtro String el filtro.
     * @return Lista de clientes que coinciden con el criterio.
     * @throws NegocioException Si hay un error con la base de datos.
     * Validaciones para implementar el metodo en el buscador
     */
    public abstract List<ClienteFrecuente> filtrar(String filtro) 
            throws NegocioException;
    
    /**
     * Metodo para consultar por ID.
     * @param id El ID del cliente frecuente a consultar.
     * @return El cliente que coincide con el ID.
     * @throws NegocioException Si el ID no es valido o no se encuentra el cliente.
     */
    public ClienteFrecuente consultarPorId(Long id) 
            throws NegocioException;
}
