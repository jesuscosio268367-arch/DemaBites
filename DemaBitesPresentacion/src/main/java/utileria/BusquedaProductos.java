package utileria;

import com.mycompany.demabitesdominio.Producto;
import com.mycompany.demabitesdtos.ProductoDTO;
import com.mycompany.demabitesnegocio.IProductoBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitesnegocio.ProductoBO;
import com.mycompany.demabitespersistencia.ProductoDAO;
import com.mycompany.demabitesutilidades.IBusqueda;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Estrategia específica para buscar Productos desde la comanda (CON DATOS DE PRUEBA).
 * @author Emily Lara
 */
public class BusquedaProductos implements IBusqueda {

    private final IProductoBO productoBO;
    
    public BusquedaProductos() {
        this.productoBO = new ProductoBO(new ProductoDAO());
    }

    @Override
    public String[] getColumnas() {
        return new String[]{"ID", "Nombre", "Categoría", "Precio"};
    }

    @Override
    public List<?> buscar(String textoBusqueda) {
       try {
            // 1. Obtienes las entidades del dominio desde el BO
            List<Producto> productosEntidad = productoBO.localizarPorNombre(textoBusqueda);

            // 2. Creamos la lista de DTOs que vamos a devolver
            List<ProductoDTO> productosDTO = new ArrayList<>();

            // 3. Mapeo manual (Convertimos cada Producto a ProductoDTO)
            for (Producto p : productosEntidad) {
                productosDTO.add(new ProductoDTO(
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio()
                ));
            }

            return productosDTO; // Ahora devolvemos puras "manzanas" (DTOs)

        } catch (NegocioException ex) {
            return new ArrayList<>();
        }
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