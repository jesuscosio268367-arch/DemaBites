package control;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import com.mycompany.demabitesdtos.ReporteComandasDTO;
import com.mycompany.demabitesnegocio.IReportesBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitesnegocio.ReportesBO;
import com.mycompany.demabitespersistencia.ReportesDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Controlador para gestionar la vista de reportes.
 * @author Dario
 */
public class ReportesControl {
    private final IReportesBO reportesBO;

    /**
     * Contructor de la clase que se conecta con la 
     * BO para la utilizacion de sus metodos.
     */
    public ReportesControl() {
        this.reportesBO = new ReportesBO(new ReportesDAO());
    }

    /**
     * Obtiene los datos del reporte y maneja la comunicacion con el Frame.
     * @param nombre Nombre del cliente.
     * @param minVisitas Minimo de visitas.
     * @param ventana Referencia al JFrame.
     * @return Lista de DTOs.
     */
    public List<ReporteClientesDTO> consultarReporte(String nombre, Integer minVisitas, JFrame ventana) {
        try {
            return reportesBO.reporteClientes(nombre, minVisitas);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error de negocio.", JOptionPane.WARNING_MESSAGE);
        }
        return new ArrayList<>();
    }
    
    /**
    * Coordina la consulta del reporte de comandas por rango de fechas
    * Maneja las excepciones de negocio mostrando un mensaje de advertencia en la ventana principal
    * @param inicio Fecha inicial capturada en la interfaz
    * @param fin Fecha final capturada en la interfaz
    * @param ventana Referencia al JFrame para posicionar el cuadro de diálogo de error
    * @return Lista de objetos DTO para llenar la tabla de la interfaz
    */
    public List<ReporteComandasDTO> consultarReporteComandas(
            LocalDateTime inicio, LocalDateTime fin, JFrame ventana) {
        try {
            return reportesBO.reporteComandasPorFecha(inicio, fin);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error de negocio", JOptionPane.WARNING_MESSAGE);
            return new ArrayList<>();
        }
    }
    
}
