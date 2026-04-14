package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import com.mycompany.demabitespersistencia.IClienteDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 * Clase de objeto de negocio para la validacion de clientes.
 * @author Jesus Omar
 */
public class ClienteBO implements IClientesBO {

    private final IClienteDAO clienteDAO;

    /**
     * Contructor con la dao necesaria para la persistencia.
     * @param clienteDAO instancia que implementa IClienteDAO.
     */
    public ClienteBO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /**
     * Metodo con las validaciones de campo para crear un nuevo cliente frecuente.
     * @param nuevoClienteFrecuente DTO con la informacion del prospecto a cliente frecuente.
     * @return El cliente frecuente registrado.
     * @throws NegocioException Si se presenta un error en la validacion,
     * se encuentra un cliente con el mismo numero o hay un error en la persistencia.
     */
    @Override
    public ClienteFrecuente crearClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) throws NegocioException {
        if (nuevoClienteFrecuente.getNombres() == null) {
            throw new NegocioException("El nombre no puede estar vacio", null);
        }
        if (nuevoClienteFrecuente.getApellidoPaterno() == null) {
            throw new NegocioException("El apellido paterno no puede estar vacio", null);
        }
        if (nuevoClienteFrecuente.getApellidoMaterno() == null) {
            throw new NegocioException("El apellido materno no puede estar vacio", null);
        }
        if (nuevoClienteFrecuente.getTelefono() == null) {
            throw new NegocioException("El telefono no puede estar vacio", null);
        }
        if (nuevoClienteFrecuente.getNombres().length() > 40) {
            throw new NegocioException("El nombre es demasiado largo", null);
        }
        if (nuevoClienteFrecuente.getApellidoPaterno().length() > 30) {
            throw new NegocioException("El apellido paterno es demasiado largo", null);
        }
        if (nuevoClienteFrecuente.getApellidoMaterno().length() > 30) {
            throw new NegocioException("El apellido materno es demasiado largo", null);
        }
        if (nuevoClienteFrecuente.getTelefono().length() > 10) {
            throw new NegocioException("El numero de telefono es demasiado largo", null);
        }
        if (nuevoClienteFrecuente.getEmail().length() > 60) {
            throw new NegocioException("El correo es demasiado largo", null);
        }
        try {
            ClienteFrecuente cliente = clienteDAO.generarClienteFrecuente(nuevoClienteFrecuente);
            return cliente;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al crear el cliente", ex);
        }
    } 
    
    /**
     * Validaciones para la edicion de un cliente frecuente existente.
     * @param nuevoClienteFrecuenteActualizado DTO con los datos a modificar.
     * @return El cliente frecuente actualizado.
     * @throws NegocioException Si el se presenta un error en la validacion, el ID es invalido
     * se encuentra un cliente con el mismo numero o hay un error en la persistencia.
     */
    @Override
    public ClienteFrecuente editarClienteFrecuente(NuevoClienteFrecuenteActualizadoDTO nuevoClienteFrecuenteActualizado) throws NegocioException {
        if (nuevoClienteFrecuenteActualizado.getId() == null || nuevoClienteFrecuenteActualizado.getId() <= 0) {
            throw new NegocioException("ID inválido", null);
        }
        if (nuevoClienteFrecuenteActualizado.getTelefono() == null || nuevoClienteFrecuenteActualizado.getTelefono().trim().isEmpty()) {
            throw new NegocioException("El teléfono no puede estar vacío", null);
        }
        if (!nuevoClienteFrecuenteActualizado.getTelefono().matches("\\d{10}")) {
            throw new NegocioException("El teléfono debe tener exactamente 10 dígitos", null);
        }
        if (nuevoClienteFrecuenteActualizado.getEmail() != null && nuevoClienteFrecuenteActualizado.getEmail().length() > 60) {
            throw new NegocioException("El correo es demasiado largo", null);
        }
        try {
            ClienteFrecuente existente = clienteDAO.consultarPorTelefono(nuevoClienteFrecuenteActualizado.getTelefono());
            if (existente != null && !existente.getId().equals(nuevoClienteFrecuenteActualizado.getId())) {
                throw new NegocioException("El número de teléfono ya está registrado por otro cliente.", null);
            }
            // El DAO hará el update de telefono encriptado y telefono hash
            return clienteDAO.editarClienteFrecuente(nuevoClienteFrecuenteActualizado);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al editar el cliente", ex);
        }
    }

    /**
     * Metodo para consultar todos los clientes frecuentes.
     * @return listado de todos los clientes frecuentes registrados.
     * @throws NegocioException Si ocurre un error al cargar los datos.
     */
    @Override
    public List<ClienteFrecuente> consultarTodos() throws NegocioException {
        try {
            List<ClienteFrecuente> listaClientes = clienteDAO.consultarTodos();
            return listaClientes;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al cargar los clientes", ex);
        }
    }

    /**
     * Metodo filtrar la busqueda de clientes.
     * @param filtro String el filtro.
     * @return Lista de clientes que coinciden con el criterio.
     * @throws NegocioException Si hay un error con la base de datos.
     * Validaciones para implementar el metodo en el buscador
     */
    @Override
    public List<ClienteFrecuente> filtrar(String filtro) throws NegocioException {
        try {
            if (filtro == null) {
                return clienteDAO.consultarTodos();
            }

            filtro = filtro.trim();
           
            if (filtro.isEmpty()) {
                return clienteDAO.consultarTodos();
            }

            filtro = filtro.toLowerCase();

            return clienteDAO.filtrar(filtro);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar clientes", ex);
        }
    }

    /**
     * Metodo para consultar por ID.
     * @param id El ID del cliente frecuente a consultar.
     * @return El cliente que coincide con el ID.
     * @throws NegocioException Si el ID no es valido o no se encuentra el cliente.
     */
    @Override
    public ClienteFrecuente consultarPorId(Long id) throws NegocioException {
        try {
            if (id == null || id <= 0) {
                throw new NegocioException("El ID del cliente no es valido.", null);
            }
            ClienteFrecuente cliente = clienteDAO.consultarPorId(id);
            return cliente;
        } catch (PersistenciaException ex) {
            throw new NegocioException("No pudimos obtener la informacion del cliente.", ex);
        }
    }
}
