package utileria;

import com.mycompany.demabitesdominio.ClienteFrecuente;
import com.mycompany.demabitesdtos.NuevoClienteFrecuenteDTO;
import com.mycompany.demabitesnegocio.IClientesBO;
import com.mycompany.demabitesnegocio.ClienteBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitespersistencia.ClienteDAO;
import com.mycompany.demabitesutilidades.IBusqueda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Estrategia específica para buscar Clientes Frecuentes.
 * @author Emily Lara
 */
public class BusquedaClientes implements IBusqueda {

    private final IClientesBO clienteBO;

    public BusquedaClientes() {
        this.clienteBO = new ClienteBO(new ClienteDAO()); 
    }

    @Override
    public String[] getColumnas() {
        return new String[]{"ID", "Nombre Completo", "Teléfono", "Correo"};
    }

    @Override
    public List<?> buscar(String textoBusqueda) {
        try {
            List<ClienteFrecuente> listaDominio = clienteBO.filtrar(textoBusqueda);

            List<NuevoClienteFrecuenteDTO> listaDTO = new ArrayList<>();

            for (ClienteFrecuente clienteEntidad : listaDominio) {
                NuevoClienteFrecuenteDTO dto = new NuevoClienteFrecuenteDTO();
                dto.setId(clienteEntidad.getId());
                dto.setNombres(clienteEntidad.getNombres());
                dto.setApellidoPaterno(clienteEntidad.getApellidoPaterno());
                dto.setApellidoMaterno(clienteEntidad.getApellidoMaterno());
                dto.setTelefono(clienteEntidad.getTelefono());
                dto.setEmail(clienteEntidad.getEmail()); 
                
                listaDTO.add(dto);
            }
            
            return listaDTO;
            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar clientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    @Override
    public Object[] aFila(Object entidad) {
        NuevoClienteFrecuenteDTO cliente = (NuevoClienteFrecuenteDTO) entidad;
        
        return new Object[]{
            cliente.getId(),
            cliente.getNombres() + " " + cliente.getApellidoPaterno(),
            cliente.getTelefono(),
            cliente.getEmail() != null ? cliente.getEmail() : "N/A"
        };
    }
}