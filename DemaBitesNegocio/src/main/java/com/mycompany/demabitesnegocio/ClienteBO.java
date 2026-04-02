/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import com.mycompany.demabitespersistencia.IClienteDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Jesus Omar
 */
public class ClienteBO implements IClientesBO {

    private final IClienteDAO clienteDAO;

    public ClienteBO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public ClienteFrecuente crearClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) throws NegocioException {       
        if (nuevoClienteFrecuente.getNombres() == null || nuevoClienteFrecuente.getNombres().trim().isEmpty()) {
            throw new NegocioException("El nombre no puede estar vacío", null);
        }

        if (nuevoClienteFrecuente.getApellidoPaterno() == null || nuevoClienteFrecuente.getApellidoPaterno().trim().isEmpty()) {
            throw new NegocioException("El apellido paterno no puede estar vacío", null);
        }

        if (nuevoClienteFrecuente.getApellidoMaterno() == null || nuevoClienteFrecuente.getApellidoMaterno().trim().isEmpty()) {
            throw new NegocioException("El apellido materno no puede estar vacío", null);
        }

        if (nuevoClienteFrecuente.getTelefono() == null || nuevoClienteFrecuente.getTelefono().trim().isEmpty()) {
            throw new NegocioException("El teléfono no puede estar vacío", null);
        }

        if (!nuevoClienteFrecuente.getTelefono().matches("\\d{10}")) {
            throw new NegocioException("El teléfono debe tener exactamente 10 dígitos", null);
        }

         try {
            ClienteFrecuente existente = clienteDAO.consultarPorTelefono(nuevoClienteFrecuente.getTelefono());
            if (existente != null) {
                throw new NegocioException("Ya existe un cliente con ese número de teléfono", null);
            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al validar el teléfono", e);
        }

        if (nuevoClienteFrecuente.getNombres().length() > 50) {
            throw new NegocioException("El nombre es demasiado largo", null);
        }

        if (nuevoClienteFrecuente.getApellidoPaterno().length() > 50) {
            throw new NegocioException("El apellido paterno es demasiado largo", null);
        }

        if (nuevoClienteFrecuente.getApellidoMaterno().length() > 50) {
            throw new NegocioException("El apellido materno es demasiado largo", null);
        }

        if (nuevoClienteFrecuente.getEmail() != null && nuevoClienteFrecuente.getEmail().length() > 60) {
            throw new NegocioException("El correo es demasiado largo", null);
        }

        
        try {
            return clienteDAO.generarClienteFrecuente(nuevoClienteFrecuente);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al crear el cliente", ex);
        }
    }
    
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
            return clienteDAO.editarClienteFrecuente(nuevoClienteFrecuenteActualizado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al editar el cliente", ex);
        }
    }

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
     * Método filtrar
     * @param filtro
     * @return
     * @throws NegocioException 
     * Validaciones para implementar el metodo en el buscador
     */
    @Override
    public List<ClienteFrecuente> filtrar(String filtro) throws NegocioException {
        try {
            if (filtro == null || filtro.trim().isEmpty()) {
                return clienteDAO.consultarTodos();
            }

            return clienteDAO.filtrar(filtro.trim().toLowerCase());

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar clientes", ex);
        }
    }

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
