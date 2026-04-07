package control;

import com.mycompany.demabitesdominio.Comanda;
import com.mycompany.demabitesdominio.EstadoComanda;
import com.mycompany.demabitesdtos.NuevaComandaDTO;
import com.mycompany.demabitesnegocio.ComandaBO;
import com.mycompany.demabitesnegocio.IComandaBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitespersistencia.ComandaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Controlador para el módulo de Comandas.
 * @author Emily Lara
 */
public class ComandasControl {

    private final IComandaBO comandaBO;

    public ComandasControl() {
        this.comandaBO = new ComandaBO(new ComandaDAO());
    }

    public void registrarComanda(NuevaComandaDTO nueva, JFrame ventana) {
        try {
            Comanda resultado = comandaBO.agregarComanda(nueva);
            JOptionPane.showMessageDialog(ventana, "¡Comanda abierta con éxito! Folio: " + resultado.getFolio());
            
            // Regresamos a la pantalla principal de comandas
            Navegacion.getControlNavegacion().abrirComandasFrame();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Comanda> cargarTablaComandas() {
        try {
            return comandaBO.consultarTodos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar comandas: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    public void actualizarEstado(Long id, EstadoComanda nuevoEstado, JFrame ventana) {
        try {
            comandaBO.actualizarEstado(id, nuevoEstado);
            JOptionPane.showMessageDialog(ventana, "Estado actualizado a: " + nuevoEstado);
            // Actualizamos la pantalla actual
            Navegacion.getControlNavegacion().abrirComandasFrame();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Comanda buscarPorFolio(String folio, JFrame ventana) {
        try {
            return comandaBO.consultarPorFolio(folio);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Búsqueda", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    /**
     * Filtra las comandas basándose en folio, número de mesa o nombre del cliente.
     * @param filtro Texto a buscar
     * @return Lista de comandas que coinciden con el filtro
     */
    public List<Comanda> filtrar(String filtro) {
        try {
            List<Comanda> todas = comandaBO.consultarTodos();
            
            // Si el buscador está vacío, devolvemos todas las comandas
            if (filtro == null || filtro.trim().isEmpty() || filtro.equals("Ingrese folio, cliente o mesa...")) {
                return todas;
            }
            
            List<Comanda> filtradas = new ArrayList<>();
            String busqueda = filtro.toLowerCase().trim();
            
            for (Comanda c : todas) {
                String folio = c.getFolio().toLowerCase();
                String numMesa = (c.getMesa() != null) ? String.valueOf(c.getMesa().getNumero()) : "";
                
                String nombreCliente = "Cliente general";
                if (c.getCliente() != null) {
                    nombreCliente = (c.getCliente().getNombres() + " " + c.getCliente().getApellidoPaterno()).toLowerCase();
                }
                // Si la búsqueda coincide con alguno de los tres, lo agregamos a la lista
                if (folio.contains(busqueda) || nombreCliente.contains(busqueda) || numMesa.equals(busqueda)) {
                    filtradas.add(c);
                }
            }
            return filtradas;
            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al filtrar comandas: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}