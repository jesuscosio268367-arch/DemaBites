/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.ClienteFrecuente;
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
            throw new NegocioException("Error al crear al cliente", null);
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

    @Override
    public List<ClienteFrecuente> buscar(String filtro) throws NegocioException {
        try {
            if (filtro == null) {
                return clienteDAO.consultarTodos();
            }

            filtro = filtro.trim();
           
            if (filtro.isEmpty()) {
                return clienteDAO.consultarTodos();
            }

            filtro = filtro.toLowerCase();

            return clienteDAO.buscar(filtro);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar clientes", ex);
        }
    }

}
