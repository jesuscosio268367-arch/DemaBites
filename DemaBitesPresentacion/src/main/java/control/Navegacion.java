package control;

import com.mycompany.demabitesdtos.ReporteClientesDTO;
import com.mycompany.demabitespresentacion.FormClientes;
import com.mycompany.demabitespresentacion.FormEditarClientes;
import com.mycompany.demabitespresentacion.FormEditarProductos;
import com.mycompany.demabitespresentacion.FormProductos;
import com.mycompany.demabitespresentacion.FormularioIngredientes;
import com.mycompany.demabitespresentacion.FrameClientes;
import com.mycompany.demabitespresentacion.FrameComandas;
import com.mycompany.demabitespresentacion.FrameProductos;
import com.mycompany.demabitespresentacion.FrameReportes;
import com.mycompany.demabitespresentacion.FrameReportesClientes;
import com.mycompany.demabitespresentacion.FrameReportesComandas;
import com.mycompany.demabitespresentacion.IngredientesForm;
import com.mycompany.demabitespresentacion.MenuPrincipal;
import com.mycompany.demabitespresentacion.NuevaComandaForm;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JFrame;

/**
 * Clase que se encarga de la nevagacion entre pantallas.
 * @author Jesus Omar
 */
public class Navegacion {
    
    private static Navegacion controlNavegacion;
    private JFrame frameActual;
    private String pantallaActual = "";
    //Objeto para mandar cualquier tipo de dato de una pantalla a otra
    private Object datoTemporal;
    private Long idSeleccionado;
    private String rol;

    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol){
        this.rol = rol;
    }
    
    /**
     * Obtiene el identificador de la pantalla que se esta visualizando.
     * @return String con el nombre de la pantalla.
     */
    public String getPantallaActual() {
        return pantallaActual;
    }
    
    /**
     * Almacena un objeto de forma temporal para utilizarse en otra pantalla.
     * @param dato el objeto que se almacenara.
     */
    public void setDato(Object dato) {
        this.datoTemporal = dato;
    }

    /**
     * Recupera el objeto almacenado temporalmente.
     * @return El objeto guardado.
     */
    public Object getDato() {
        return datoTemporal;
    }
    
    /**
     * Guarda el ID de una entidad seleccionada para su uso en otra pantalla.
     * @param id ID de la entidad.
     */
    public void setIdSeleccionado(Long id) {
        this.idSeleccionado = id;
    }

    /**
     * Recupera el ID de la entidad.
     * @return Long con ID almacenado.
     */
    public Long getIdSeleccionado() {
        return idSeleccionado;
    }
    
    /**
     * Obtiene la intancia unica de la clase Navegacion.
     * @return Instancia unica de Navegacion.
     */
    public static Navegacion getControlNavegacion(){
        if(controlNavegacion == null){
            controlNavegacion = new Navegacion();
        }
        return controlNavegacion;
    }
    
    /**
     * Establece el primer frame de la aplicacion y lo hace visible.
     * @param primerFrame El JFrame de inicio.
     */
    public void inicializar(JFrame primerFrame) {
        this.frameActual = primerFrame;
        this.frameActual.setVisible(true);
        this.frameActual.setLocationRelativeTo(null);
    }
    
    /**
     * Si el usuario se identifica como mesero abre las comandas
     * si se identifica como administrador abre el menu principal
     */
    public void abrirMenuPrincipal(){
        if(this.rol.equals("MESERO")){
            abrirComandasFrame();
        }else{
            cambiarPantalla(new MenuPrincipal());
        }
    }
    
    //Comandas
    
    /**
    * Abre el frame principal donde se ve la lista de comandas.
    */
    public void abrirComandasFrame() {
        this.pantallaActual = "COMANDAS";
        cambiarPantalla(new FrameComandas()); 
    }
    
    public void abrirNuevaComandaForm() {
        this.pantallaActual = "NUEVA_COMANDA";
        // Asumiendo que tu form se llama FormComanda
         cambiarPantalla(new NuevaComandaForm());
    }
    
    //Productos
    
    public void abrirProductosFrame(){
        this.pantallaActual = "PRODUCTOS";
        cambiarPantalla(new FrameProductos());
    }
    
    public void abrirProductosForm(){
        this.pantallaActual = "NUEVO_PRODUCTO";
        cambiarPantalla(new FormProductos());
    }
    
    public void abrirEditarProductosForm(){
        this.pantallaActual = "EDITAR_PRODUCTO";
        cambiarPantalla(new FormEditarProductos());
    }
    
    //Ingredientes
    
    public void abrirFrameIngredientes(){
        this.pantallaActual = "INGREDIENTES";
        cambiarPantalla(new IngredientesForm());
    }
    
    //Clientes
    
    /**
     * Cierra la pantalla actual y abre FormClientes.
     */
    public void abrirClientesForm(){
        this.pantallaActual = "NUEVO_CLIENTE";
        cambiarPantalla(new FormClientes());
    }
    
    /**
     * Cierra la pantalla actual y abre FrameCientes.
     */
    public void abrirClientesFrame(){
        this.pantallaActual = "CLIENTES";
        cambiarPantalla(new FrameClientes());
    }
    
    /**
     * Cierra la pantalla actual y abre FormEditarClientes.
     */
    public void abrirEditarClientesForm(){
        this.pantallaActual = "EDITAR_CLIENTES";
        cambiarPantalla(new FormEditarClientes());
    }
    
    //Reportes
    
    /**
     * Cierra la pantalla actual y abre FrameReportes.
     */
    public void abrirReportesFrame(){
        this.pantallaActual = "REPORTES";
        cambiarPantalla(new FrameReportes());
    }
    
    /**
     * Cierra la pantalla actual y abre FrameReportesComandas.
     */
    public void abrirReportesComandasFrame(LocalDateTime inicio, LocalDateTime fin){
        this.pantallaActual = "REPORTES_COMANDAS";
        cambiarPantalla(new FrameReportesComandas(inicio, fin));
    }
    
    /**
     * Cierra la pantalla actual y abre FrameReportesClientes.
     */
    public void abrirReportesClientesFrame(List<ReporteClientesDTO> lista){
        this.pantallaActual = "REPORTES_CLIENTES";
        FrameReportesClientes nuevoFrame = new FrameReportesClientes();
        nuevoFrame.cargarDatos(lista);
        cambiarPantalla(nuevoFrame);
    }
    
    
    /**
     * Realiza el cambio de pantallas, cierra el frame actual y centra el nuevo.
     * @param nuevo El nuevo JFrame a mostrar.
     */
    public void cambiarPantalla(JFrame nuevo){
        if (frameActual != null) {
            frameActual.dispose();
        }
        this.frameActual = nuevo;
        this.frameActual.setVisible(true);
        this.frameActual.setLocationRelativeTo(null);
    }
    
    
 
}
