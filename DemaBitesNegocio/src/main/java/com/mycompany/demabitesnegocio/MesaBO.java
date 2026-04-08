package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.Mesa;
import com.mycompany.demabitesdtos.MesaDTO;
import com.mycompany.demabitespersistencia.IMesaDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Clase que representa el Objeto de Negocio para la entidad Mesa.
 * Se encarga de aplicar la lógica y reglas de negocio relacionadas con las mesas
 * antes de comunicarse con la capa de persistencia.
 * * @author Emily Lara
 * 270719
 */
public class MesaBO implements IMesaBO {

    private static final Logger LOGGER = Logger.getLogger(MesaBO.class.getName());
    
    private final IMesaDAO mesaDAO;

    /**
     * Constructor que inicializa el objeto de negocio de mesas.
     * * @param mesaDAO Instancia de la interfaz de persistencia de mesas 
     * para acceder a la base de datos.
     */
    public MesaBO(IMesaDAO mesaDAO) {
        this.mesaDAO = mesaDAO;
    }

    /**
     * Consulta todas las mesas que se encuentran disponibles actualmente, 
     * es decir, aquellas que no tienen una comanda en estado ABIERTA.
     * Transforma las entidades obtenidas en objetos de transferencia de datos (DTO).
     * * @return Una lista de objetos que representan las mesas libres.
     * @throws NegocioException Si ocurre un error de persistencia al intentar 
     * recuperar la información de la base de datos.
     */
    @Override
    public List<MesaDTO> consultarMesasDisponibles() throws NegocioException {
        try {
            List<Mesa> mesas = mesaDAO.consultarMesasDisponibles();
            List<MesaDTO> mesasDTO = new ArrayList<>();
            
            // Transformamos de Entidad a DTO
            for (Mesa mesa : mesas) {
                MesaDTO dto = new MesaDTO();
                dto.setId(mesa.getId());
                dto.setNumeroMesa(mesa.getNumero());
                mesasDTO.add(dto);
            }
            
            return mesasDTO;
            
        } catch (PersistenciaException e) {
            LOGGER.severe("Error de persistencia al consultar mesas disponibles: " + e.getMessage());
            throw new NegocioException("No se pudieron cargar las mesas disponibles.", e);
        }
    }
}