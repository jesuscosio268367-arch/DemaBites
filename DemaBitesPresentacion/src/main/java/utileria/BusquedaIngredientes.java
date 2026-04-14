package utileria;

import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesutilidades.IBusqueda;
import control.IngredientesControl;
import java.util.List;

/**
 * Estrategia especifica para buscar ingredientes desde la creacion de productos.
 * @author Dario
 */
public class BusquedaIngredientes implements IBusqueda{
    private final IngredientesControl control;

    /**
     * Contructor de la clase que se conecta con el 
     * control para la utilizacion de sus metodos.
     */
    public BusquedaIngredientes() {
        this.control = new IngredientesControl();
    }

    /**
     * Define los encabezados de la tabla de busqueda de ingredientes.
     * @return Arreglo de Strings con los nombres de los encabezados.
     */
    @Override
    public String[] getColumnas() {
        return new String[]{"ID", "Nombre", "Unidad de Medida"};
    }

    /**
     * Busca mediante un filtro.
     * @param textoBusqueda texto filtro de busqueda.
     * @return Lista de ingredientes que coinciden con el filtro.
     */
    @Override
    public List<?> buscar(String textoBusqueda) {
        return control.buscarIngredientes(textoBusqueda); 
    }

    /**
     * Tranforma el ingrediente en filas para su posterior uso en una tabla.
     * @param entidad La intidad que se tranforma (Ingrediente).
     * @return El arreglo con el contenido.
     */
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
