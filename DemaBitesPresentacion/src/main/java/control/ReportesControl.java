package control;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import com.mycompany.demabitesnegocio.IReportesBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitesnegocio.ReportesBO;
import com.mycompany.demabitespersistencia.ReportesDAO;
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
}
