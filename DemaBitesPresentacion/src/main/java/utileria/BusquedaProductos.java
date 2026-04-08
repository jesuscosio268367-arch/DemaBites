package utileria;

import com.mycompany.demabitesdtos.ProductoDTO;
import com.mycompany.demabitesutilidades.IBusqueda;
import java.util.ArrayList;
import java.util.List;

/**
 * Estrategia específica para buscar Productos desde la comanda (CON DATOS DE PRUEBA).
 * @author Emily Lara
 */
public class BusquedaProductos implements IBusqueda {

    public BusquedaProductos() {
        // PRODUCTOS BO PENDIENTE
    }

    @Override
    public String[] getColumnas() {
        return new String[]{"ID", "Nombre", "Categoría", "Precio"};
    }

    @Override
    public List<?> buscar(String textoBusqueda) {
       
        // SE TRABAJA CON DATOS DUMMY 
        List<ProductoDTO> productosFalsos = new ArrayList<>();
        
        // Creamos 3 productos de mentira simulando lo que regresaría la base de datos
        productosFalsos.add(new ProductoDTO(1L, "Hamburguesa Clásica", 120.00));
        productosFalsos.add(new ProductoDTO(2L, "Papas Fritas", 50.00));
        productosFalsos.add(new ProductoDTO(3L, "Refresco Cocacola", 35.00));

        // Filtramos manualmente solo para que el buscador parezca real
        List<ProductoDTO> resultados = new ArrayList<>();
        String filtro = textoBusqueda.toLowerCase();
        
        for (ProductoDTO p : productosFalsos) {
            if (p.getNombre().toLowerCase().contains(filtro)) {
                resultados.add(p);
            }
        }
        
        return resultados; // Devolvemos la lista de prueba
    }

    @Override
    public Object[] aFila(Object entidad) {
        ProductoDTO producto = (ProductoDTO) entidad;
        
        return new Object[]{
            producto.getId(),
            producto.getNombre(),
            "Platillo", 
            "$" + String.format("%.2f", producto.getPrecio())
        };
    }
}