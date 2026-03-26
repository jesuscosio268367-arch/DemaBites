/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;

/**
 *
 * @author Jesus Omar
 */
public class ClienteBO implements IClientesBO{

    @Override
    public ClienteFrecuente crearClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) throws NegocioException {
        if(nuevoClienteFrecuente.getNombres() == null){
            throw new NegocioException("El nombre no puede estar vacio", null);
        }
        if(nuevoClienteFrecuente.getApellidoPaterno() == null){
            throw new NegocioException("El apellido paterno no puede estar vacio", null);
        }
        if(nuevoClienteFrecuente.getApellidoMaterno() == null){
            throw new NegocioException("El apellido materno no puede estar vacio", null);
        }
        if(nuevoClienteFrecuente.getTelefono() == null){
            throw new NegocioException("El telefono no puede estar vacio", null);
        }
        if(nuevoClienteFrecuente.getNombres().length() > 60){
            throw new NegocioException("El nombre es demasiado largo", null);
        }
        if(nuevoClienteFrecuente.getApellidoPaterno().length() > 60){
            throw new NegocioException("El apellido paterno es demasiado largo", null);
        }
        if(nuevoClienteFrecuente.getApellidoMaterno().length() > 60){
            throw new NegocioException("El apellido materno es demasiado largo", null);
        }
        if(nuevoClienteFrecuente.getTelefono().length() > 10){
            throw new NegocioException("El numero de telefono es demasiado largo", null);
        }
        if(nuevoClienteFrecuente.getEmail().length() > 60){
            throw new NegocioException("El correo es demasiado largo", null);
        }
        return null;
    }

    @Override
    public ClienteFrecuente consultarClientesFrecuentes() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
