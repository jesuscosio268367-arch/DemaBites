package com.mycompany.demabitesnegocio;

import com.mycompany.demabitesdominio.Comanda;
import com.mycompany.demabitesdominio.EstadoComanda;
import com.mycompany.demabitesdtos.NuevaComandaDTO;
import com.mycompany.demabitespersistencia.IComandaDAO;
import com.mycompany.demabitespersistencia.PersistenciaException;
import java.util.List;

/**
 * Objeto de Negocio para la gestión de comandas.
 * Aplica las reglas de negocio antes de persistir los datos.
 * @author Emily Lara
 */
public class ComandaBO implements IComandaBO {

    private final IComandaDAO comandaDAO;

    /**
     * Constructor que recibe el DAO de comandas.
     * @param comandaDAO instancia de la persistencia.
     */
    public ComandaBO(IComandaDAO comandaDAO) {
        this.comandaDAO = comandaDAO;
    }

    /**
     * Regla de Negocio: Para agregar una comanda, la mesa debe estar asignada
     * y debe haber al menos un producto en los detalles.
     */
    @Override
    public Comanda agregarComanda(NuevaComandaDTO nuevaComanda) throws NegocioException {
        // Validamos que venga una mesa
        if (nuevaComanda.getMesa() == null || nuevaComanda.getMesa().getId() == null) {
            throw new NegocioException("Debe seleccionar una mesa para abrir la comanda.", null);
        }

        // Validamos que la comanda no esté vacía (Regla: No hay pedidos sin productos)
        if (nuevaComanda.getDetalles() == null || nuevaComanda.getDetalles().isEmpty()) {
            throw new NegocioException("La comanda debe tener al menos un producto.", null);
        }

        // Validamos que el total sea coherente
        if (nuevaComanda.getTotal() <= 0) {
            throw new NegocioException("El total de la comanda debe ser mayor a cero.", null);
        }

        try {
            // Si todo está bien, mandamos llamar al DAO
            return comandaDAO.agregarComanda(nuevaComanda);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar la comanda en el sistema.", ex);
        }
    }

    /**
     * Regla de Negocio: Solo se puede actualizar el estado si la comanda existe.
     */
    @Override
    public Comanda actualizarEstado(Long id, EstadoComanda nuevoEstado) throws NegocioException {
        if (id == null || id <= 0) {
            throw new NegocioException("El ID de la comanda no es válido.", null);
        }
        
        if (nuevoEstado == null) {
            throw new NegocioException("El nuevo estado no puede ser nulo.", null);
        }

        try {
            Comanda comanda = comandaDAO.actualizarEstado(id, nuevoEstado);
            if (comanda == null) {
                throw new NegocioException("No se encontró la comanda con el ID proporcionado.", null);
            }
            return comanda;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar cambiar el estado de la comanda.", ex);
        }
    }

    @Override
    public Comanda consultarPorFolio(String folio) throws NegocioException {
        if (folio == null || folio.trim().isEmpty()) {
            throw new NegocioException("El folio de búsqueda no puede estar vacío.", null);
        }

        try {
            Comanda comanda = comandaDAO.consultarPorFolio(folio);
            if (comanda == null) {
                throw new NegocioException("No existe ninguna comanda con el folio: " + folio, null);
            }
            return comanda;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar la comanda por folio.", ex);
        }
    }

    @Override
    public List<Comanda> consultarTodos() throws NegocioException {
        try {
            return comandaDAO.consultarTodos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener el listado de comandas.", ex);
        }
    }
}