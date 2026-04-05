package com.mycompany.demabitespersistencia;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import java.util.List;

/**
 * Interfaz que define los metodos DAO para las entidades Cliente.
 * @author Dario
 */
public interface IClienteDAO {
    
    /**
     * Registra un nuevo cliente frecuente en el sistema.
     * @param nuevoClienteFrecuente DTO con la informacion del cliente que se registrara.
     * @return El cliente frecuente creado con su ID generado.
     * @throws PersistenciaException Si ocurre un error al acceder a la base de datos.
     */
    public abstract ClienteFrecuente generarClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente)
            throws PersistenciaException;
    
    /**
     * Edita un cliente frecuente del sistema.
     * @param nuevoClienteFrecuenteActualizado DTO con los datos actualizados.
     * @return El cliente frecuente con los cambios aplicados.
     * @throws PersistenciaException Si el cliente no existe o falla la actualizacion.
     */
    public abstract ClienteFrecuente editarClienteFrecuente (NuevoClienteFrecuenteActualizadoDTO nuevoClienteFrecuenteActualizado)
            throws PersistenciaException;
    
    /**
     * Consulta todos los clientes frecuentes que se encuentran en el sistema.
     * @return La lista de clientes frecuentes en el sistema.
     * @throws PersistenciaException Si hay un error en la consulta.
     */
    public abstract List<ClienteFrecuente> consultarTodos()
            throws PersistenciaException; 
    
    /**
     * Método filtrar.
     * @param filtro
     * @return lista Clientes Frecuentes
     * @throws PersistenciaException 
     * Método dinámico que filtra tanto por nombre como por correo o por telefono al mismo tiempo.
     * Es implementado en el buscador de la tabla de cliientes.
     */
    public List<ClienteFrecuente> filtrar(String filtro) 
           throws PersistenciaException;
    
    /**
     * Busca clientes frecuentes con su ID.
     * @param id ID del cliente frecuente a buscar.
     * @return El cliente frecuente encontrado.
     * @throws PersistenciaException Si no encuentra al cliente o ocurre un error en la busqueda.
     */
    public abstract ClienteFrecuente consultarPorId(Long id)
            throws PersistenciaException;
    
    /**
     * Método Consutar Por Teléfono
     * @param telefono
     * @return Cliente Frecuente
     * @throws PersistenciaException
     * Este método se encarga de consultar y validar si ya existe un numero de
     * teléfono registrado.
     * Este método es utilizado al momento de validar la existencia del registro de un cliente con el mismo número.
     */
    public abstract ClienteFrecuente consultarPorTelefono(String telefono)
            throws PersistenciaException;
}
