package utileria;

import control.IngredientesControl;
import java.util.List;

/**
 *
 * @author Dario
 */
public class BusquedaIngredientes {
    private final IngredientesControl control = new IngredientesControl();
    
    public String[] getColumnas() {
        return new String[]{"ID", "Nombre", "Unidad de Medida", "Cantidad"};
    }

//    public List<?> buscar(String texto) {
    
//    }
//
//    @Override
//    public Object[] aFila(Object item) {
//        IngredienteDTO ing = (IngredienteDTO) item;
//        return new Object[]{ing.getId(), ing.getNombre(), ing.getUnidadMedida(), ing.getStock()};
//    }
}
