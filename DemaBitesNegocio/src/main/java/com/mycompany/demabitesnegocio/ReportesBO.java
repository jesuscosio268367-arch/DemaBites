package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import com.mycompany.demabitespersistencia.IReportesDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Dario
 */
public class ReportesBO implements IReportesBO {

    private final IReportesDAO reportesDAO;

    /**
     * Constructor con la dao necesaria para las consultas.
     * @param reportesDAO instancia que implemente IReportesDAO.
     */
    public ReportesBO(IReportesDAO reportesDAO) {
        this.reportesDAO = reportesDAO;
    }
    
    @Override
    public List<ReporteClientesDTO> reporteClientes(
            String nombreCliente, Integer minVisitas
    ) throws NegocioException {
        try {
           if (minVisitas != null && minVisitas < 0) {
                throw new NegocioException("El numero minimo de visitas no puede ser negativo.", null);
            }

            if (nombreCliente != null) {
                nombreCliente = nombreCliente.trim();
            }
            return reportesDAO.reporteClientes(nombreCliente, minVisitas);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al realizar el reporte de clientes.", ex);
        }
    }
    
}
