/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import com.mycompany.demabitesnegocio.ClienteBO;
import com.mycompany.demabitesnegocio.IClientesBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitespersistencia.ClienteDAO;
import com.mycompany.demabitesutilidades.SeguridadUtil;
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

    private void mostrarError(JFrame ventana, String mensaje, Exception ex) {
        JOptionPane.showMessageDialog(
            ventana,
            mensaje + ": " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    // Este método es nuevo y privado para no repetir código
    // Se encarga de convertir el destastre (la encriptación) de la base de datos en números legibles
    private void desencriptarTelefonos(List<ClienteFrecuente> lista) {
        for (ClienteFrecuente cliente : lista) {
            if (cliente.getTelefonoEncriptado() != null) {
                String telLegible = SeguridadUtil.desencriptar(cliente.getTelefonoEncriptado());
                cliente.setTelefono(telLegible); // Seteamos el valor temporal para la vista
            }
        }
    }
    
    public void registrarCliente(NuevoClienteFrecuenteDTO nuevoCliente, JFrame ventana){
        try{
            clientesBO.crearClienteFrecuente(nuevoCliente);

            JOptionPane.showMessageDialog(
                ventana, 
                "El cliente ha sido registrado con éxito!"
            );

            Navegacion.getControlNavegacion().abrirClientesFrame();
            ventana.dispose();

        } catch(NegocioException ex){
            mostrarError(ventana, "Error al registrar cliente", ex);
        }
    }
    
    public List<ClienteFrecuente> cargarTabla(){
        try{
            List<ClienteFrecuente> lista = clientesBO.consultarTodos();
            desencriptarTelefonos(lista);
            return lista;
        } catch(NegocioException ex){
            JOptionPane.showMessageDialog(
                null, 
                "No se pudieron cargar los clientes: " + ex.getMessage()
            );
            return new ArrayList<>();
        }
    }
    
    /**
     * Método filtrar
     * @param filtro
     * @param ventana
     * @return 
     * Implementado en el buscador
     */
    public List<ClienteFrecuente> filtrar(String filtro, JFrame ventana) {
        try {
            List<ClienteFrecuente> lista = clientesBO.filtrar(filtro);

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(
                    ventana,
                    "No se encontraron coincidencias. Mostrando todos los clientes.",
                    "Búsqueda",
                    JOptionPane.INFORMATION_MESSAGE
                );

                lista = clientesBO.consultarTodos();
            }

            desencriptarTelefonos(lista); // Desencriptamos antes de retornar
            return lista;

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(
                ventana,
                "Error al buscar clientes: " + ex.getMessage()
            );
            return new ArrayList<>();
        }
    }
      
    public ClienteFrecuente consultarPorId(Long id){
        try {
            ClienteFrecuente cliente = clientesBO.consultarPorId(id);
            if(cliente != null) {
                cliente.setTelefono(SeguridadUtil.desencriptar(cliente.getTelefonoEncriptado()));
            }
            return cliente;
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(
                null, 
                "Error al obtener cliente: " + ex.getMessage()
            );
            return null;
        }
    }

    public void editarCliente(NuevoClienteFrecuenteActualizadoDTO clienteEditado, JFrame ventana) {
        try {
            clientesBO.editarClienteFrecuente(clienteEditado);

            JOptionPane.showMessageDialog(
                ventana, 
                "¡El cliente ha sido actualizado con éxito!"
            );

            Navegacion.getControlNavegacion().abrirClientesFrame();
            ventana.dispose();

        } catch (NegocioException ex) {
            mostrarError(ventana, "Error al actualizar cliente", ex);
        }
    }
}
