package utileria;

import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesutilidades.IBusqueda;
import control.IngredientesControl;
import java.util.List;

/**
 *
 * @author Dario
 */
public class BusquedaIngredientes implements IBusqueda{
    private final IngredientesControl control;

    public BusquedaIngredientes() {
        this.control = new IngredientesControl();
    }

    @Override
    public String[] getColumnas() {
        return new String[]{"ID", "Nombre", "Unidad de Medida"};
    }

    @Override
    public List<?> buscar(String textoBusqueda) {
        return control.buscarIngredientes(textoBusqueda); 
    }

    @Override
    public Object[] aFila(Object entidad) {
        Ingrediente ingrediente = (Ingrediente) entidad;
        
        return new Object[]{
            ingrediente.getId(),
            ingrediente.getNombre(),
            ingrediente.getUnidad()
        };
    }
}
