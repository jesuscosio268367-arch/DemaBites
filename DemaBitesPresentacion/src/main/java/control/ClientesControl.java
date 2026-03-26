/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import com.mycompany.demabitesnegocio.ClienteBO;
import com.mycompany.demabitesnegocio.IClientesBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitespersistencia.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Omar
 */
public class ClientesControl {
    
    private final IClientesBO clientesBO;
    
    public ClientesControl(){
        this.clientesBO = new ClienteBO(new ClienteDAO());
    }
    
    public void registrarCliente(NuevoClienteFrecuenteDTO nuevoCliente, JFrame ventana){
        
        try{
            clientesBO.crearClienteFrecuente(nuevoCliente);
            JOptionPane.showMessageDialog(ventana, "El cliente ha sido registrado con exito!");
            Navegacion.getControlNavegacion().abrirClientesFrame(); // te regresa al frame de los clientes
            ventana.dispose(); // cierra el formulario para registabre rar al cliente
        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(
                    ventana, 
                    ex.getMessage(), 
                    "Error al registrar al cliente", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public List<ClienteFrecuente> cargarTabla(){
        try{
            List<ClienteFrecuente> listaClientes = clientesBO.consultarTodos();
            return listaClientes;
        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(null, "No se pudieron cargar los clientes" + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
}
