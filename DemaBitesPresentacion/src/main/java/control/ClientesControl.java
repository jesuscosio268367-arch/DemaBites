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
 * Controlador de la interfaz de usuario para el modulo de Clientes.
 * @author Jesus Omar
 */
public class ClientesControl {
    
    private final IClientesBO clientesBO;
    
    
    /**
     * Contructor que inicializa el flujo de trabajo mediante instanciacion.
     */
    public ClientesControl(){
        this.clientesBO = new ClienteBO(new ClienteDAO());
    }

    /**
     * Muestra un cuadro dialogo con el error de la operacion.
     * @param ventana Frame padre para posicionar el mensaje.
     * @param mensaje Descripcion del error.
     * @param ex Excepcion capturada.
     */
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
    /**
     * Desencripta los telefonos de los clientes.
     * @param lista Lista de clientes a los que se le desencriptara los telefonos.
     */
    private void desencriptarTelefonos(List<ClienteFrecuente> lista) {
        for (ClienteFrecuente cliente : lista) {
            if (cliente.getTelefonoEncriptado() != null) {
                String telLegible = SeguridadUtil.desencriptar(cliente.getTelefonoEncriptado());
                cliente.setTelefono(telLegible); // Seteamos el valor temporal para la vista
            }
        }
    }
    
    /**
     * Gestiona el registro de un cliente.
     * @param nuevoCliente DTO con los datos del nuevo cliente.
     * @param ventana Frame actual para gestionar su cierre.
     */
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
    
    /**
     * Carga los clientes registrados y los prepara para ser mostrados.
     * @return Lista de los clientes legibles.
     */
    public List<ClienteFrecuente> cargarTabla(){
        try{
            List<ClienteFrecuente> listaClientes = clientesBO.consultarTodos();
            return listaClientes;
        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(null, "No se pudieron cargar los clientes" + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    /**
     * Método filtrar.
     * @param filtro criterio de busqueda.
     * @param ventana Frame padre.
     * @return Lista filtrada de clientes frecuentes.
     * Implementado en el buscador
     */
    public List<ClienteFrecuente> filtrar(String filtro, JFrame ventana) {
        try {
            return clientesBO.buscar(filtro);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, 
                "Error al buscar clientes: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    /**
     * Recupera un cliente por su ID y desencripta su telefono.
     * @param id ID del cliente.
     * @return Cliente frecuente con datos legibles.
     */
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

    /**
     * Gestiona la actualizacion de datos de un cliente.
     * @param clienteEditado DTO con la informacion actualizado.
     * @param ventana Frame de edicion para gestionar su cierre.
     */
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
