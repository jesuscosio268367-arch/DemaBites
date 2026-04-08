package control;

import com.mycompany.demabitesdtos.MesaDTO;
import com.mycompany.demabitesnegocio.IMesaBO;
import com.mycompany.demabitesnegocio.MesaBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitespersistencia.MesaDAO;
import java.util.List;
import java.util.logging.Logger;

/**
 * Controlador para gestionar la vista de Mesas.
 * @author Emily Lara
 * 270719
 */
public class MesasControl {

    private static final Logger LOGGER = Logger.getLogger(MesasControl.class.getName());
    
    private final IMesaBO mesaBO;

    public MesasControl() {
        this.mesaBO = new MesaBO(new MesaDAO());
    }

    /**
     * Solicita la lista de mesas disponibles al BO.
     * @return Lista de MesaDTO o una lista vacía si hay un error.
     */
    public List<MesaDTO> obtenerMesasDisponibles() {
        try {
            return mesaBO.consultarMesasDisponibles();
        } catch (NegocioException e) {
            LOGGER.severe("Error en el controlador al consultar mesas disponibles: " + e.getMessage());
            return null;
        }
    }
}