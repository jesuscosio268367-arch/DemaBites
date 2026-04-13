package control;

import Enums.EstadoProducto;
import Enums.Tipo;
import com.mycompany.demabitesdominio.Ingrediente;
import com.mycompany.demabitesdominio.Producto;
import com.mycompany.demabitesdominio.ProductoIngrediente;
import com.mycompany.demabitesdtos.IngredienteProductoDTO;
import com.mycompany.demabitesdtos.NuevoProductoActualizadoDTO;
import com.mycompany.demabitesdtos.NuevoProductoDTO;
import com.mycompany.demabitesdtos.ProductoEstadoActualizadoDTO;
import com.mycompany.demabitesnegocio.IProductoBO;
import com.mycompany.demabitesnegocio.IingredientesBO;
import com.mycompany.demabitesnegocio.IngredientesBO;
import com.mycompany.demabitesnegocio.NegocioException;
import com.mycompany.demabitesnegocio.ProductoBO;
import com.mycompany.demabitespersistencia.IngredientesDAO;
import com.mycompany.demabitespersistencia.ProductoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Controlador de la interfaz de usuario del modulo de productos.
 * @author Dario
 */
public class ProductosControl {
    private final IProductoBO productoBO;
    private final IingredientesBO ingredienteBO;

    /**
     * Contructor de la clase que se conecta con la 
     * BO para la utilizacion de sus metodos.
     */
    public ProductosControl() {
        this.productoBO = new ProductoBO(new ProductoDAO());
        this.ingredienteBO = new IngredientesBO(new IngredientesDAO());
    }

    /**
     * Muestra un cuadro dialogo con el error de la operacion.
     * @param ventana Frame padre para posicionar el mensaje.
     * @param mensaje Descripcion del error.
     * @param ex Excepcion capturada.
     */
    private void mostrarError(JFrame ventana, String mensaje, Exception ex) {
        JOptionPane.showMessageDialog(
            ventana,
            mensaje + ": " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Carga los productos activos desde el BO.
     * @return La lista de productos activos.
     */
    public List<Producto> cargarTabla() {
        try {
            return productoBO.buscarActivos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar los productos: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Filtra los productos usando el buscador y el combo de tipos.
     * @param filtro String de filtrado.
     * @param tipo Filtro de tipo de producto.
     * @param ventana Frame padre donde se utiliza.
     * @return Lista de productos que cumplen con el filtro.
     */
    public List<Producto> filtrar(String filtro, Tipo tipo, JFrame ventana) {
        try {
            return productoBO.localizarPorNombreYCategoria(filtro, tipo);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(ventana, "Error al buscar productos: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Logica para el boton de registro de producto.
     * @param nuevo Los datos del producto que se creara.
     * @param ventana Frame actual.
     */
    public void registrarProducto(NuevoProductoDTO nuevo, JFrame ventana) {
        try {
            productoBO.GenerarProducto(nuevo);
            JOptionPane.showMessageDialog(ventana, "¡El producto se registró con éxito!");
            Navegacion.getControlNavegacion().abrirProductosFrame();
            ventana.dispose();
        } catch (NegocioException ex) {
            mostrarError(ventana, "Error al registrar producto.", ex);
        }
    }

    /**
     * Logica para el boton de editar producto.
     * @param editado Los datos del producto que se editara.
     * @param ventana Frame actual.
     */
    public void editarProducto(NuevoProductoActualizadoDTO editado, JFrame ventana) {
        try {
            productoBO.editarProducto(editado);
            JOptionPane.showMessageDialog(ventana, "Producto actualizado");
            Navegacion.getControlNavegacion().abrirProductosFrame();
            ventana.dispose();
        } catch (NegocioException ex) {
            mostrarError(ventana, "Error al editar producto.", ex);
        }
    }
    
    /**
    * Gestiona el cambio de estado (Activo/Inactivo) de un producto.
    * @param id ID del producto a modificar.
    * @param ventana Frame actual.
    */
    public void cambiarEstado(Long id, JFrame ventana) {
        try {
           Producto producto = productoBO.buscarPorId(id);

            if (producto != null) {
               EstadoProducto nuevoEstado = (producto.getEstado() == EstadoProducto.ACTIVO) 
                       ? EstadoProducto.INACTIVO : EstadoProducto.ACTIVO;
               ProductoEstadoActualizadoDTO dto = new ProductoEstadoActualizadoDTO();
               dto.setId(id);
               dto.setEstado(nuevoEstado);
               productoBO.editarEstadoProducto(dto);
               String msj = (nuevoEstado == EstadoProducto.ACTIVO) ? "activado" : "desactivado";
               JOptionPane.showMessageDialog(ventana, "El producto ha sido " + msj);
            }
        } catch (NegocioException ex) {
            mostrarError(ventana, "Error al cambiar el estado del producto.", ex);
        }
    }
    
    /**
     * Da los datos para el llenado de la tabla de edicion de 
     * ingredientes relacionados al producto que se editara.
     * @param id ID del producto que se editara.
     * @param ventana Frame actual.
     * @return Regresa la informacion y si ocurre un error no regresa nada.
     */
    public NuevoProductoActualizadoDTO consultarParaEditar(Long id, JFrame ventana) {
        try{
            Producto producto = productoBO.buscarPorId(id);
            if (producto == null) return null;
            List<IngredienteProductoDTO> ingredientesDTO = new ArrayList<>();

            for (ProductoIngrediente item : producto.getIngredientes()) {
                IngredienteProductoDTO ingDTO = new IngredienteProductoDTO(
                    item.getIngrediente().getId(), 
                    item.getCantidadRequerida()
                );
                ingDTO.setNombre(item.getIngrediente().getNombre());
                String unidadTxt = item.getIngrediente().getUnidad().name();
                ingDTO.setUnidad(unidadTxt);
                ingredientesDTO.add(ingDTO);
            }
            NuevoProductoActualizadoDTO dto = new NuevoProductoActualizadoDTO(
                producto.getNombre(),
                producto.getPrecio(),
                producto.getDescripcion(),
                ingredientesDTO,
                producto.getImagenProducto()
            );
            dto.setId(producto.getId());
            dto.setTipoProducto(producto.getTipoProducto());
            return dto;
        } catch (NegocioException ex) {
            mostrarError(ventana, "Error al consultar ingredientes relacionados al producto.", ex);
        }
        return null;
    }
    
    public void actualizarProducto(NuevoProductoActualizadoDTO dto, JFrame ventana) {
        try {
            productoBO.editarProducto(dto); 
            JOptionPane.showMessageDialog(ventana, "¡Producto actualizado con éxito!");
            Navegacion.getControlNavegacion().abrirProductosFrame();
            ventana.dispose();
        } catch (NegocioException ex) {
            mostrarError(ventana, "Error al actualizar el producto", ex);
        }
    }
}