package controladores;

import entidades.Estado;
import entidades.Producto;
import entidades.Tamañoproducto;
import facades.EstadoFacade;
import facades.ProductoFacade;
import facades.TamañoproductoFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
// import org.primefaces.model.chart.PieChartModel;

@Named(value = "productoControlador")
@SessionScoped
public class ProductoControlador implements Serializable {

    private Part archivo;
    private String rutaImagen;

    /*private PieChartModel pieModel2;

    public PieChartModel getPieModel2() {
        return pieModel2;
    }

    public void setPieModel2(PieChartModel pieModel2) {
        this.pieModel2 = pieModel2;
    }*/

    @EJB
    ProductoFacade proFacade;

    @EJB
    EstadoFacade estadoRepo;

    @EJB
    TamañoproductoFacade tamProd;

    private Producto producto;
    private Estado estado;
    private Tamañoproducto prodTam;

    public Tamañoproducto getProdTam() {
        return prodTam;
    }

    public void setProdTam(Tamañoproducto prodTam) {
        this.prodTam = prodTam;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Part getArchivo() {
        return archivo;
    }

    public void setArchivo(Part archivo) {
        this.archivo = archivo;
    }

    @PostConstruct
    public void init() {
        producto = new Producto();
        estado = new Estado();
        prodTam = new Tamañoproducto();
        producto.setIdProducto(proFacade.count() + 1);
    }

    public ProductoControlador() {
    }

    public void productoVacio() {
        producto = new Producto();
    }

    public void crearProducto() {
        producto.setFkEstado(estadoRepo.find(1)); // Estar en stock por defecto
        producto.setFkTamaño(tamProd.find(prodTam.getIdTamaño()));

        // Variable para almacenar la ruta de los archivos.
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("images_prod");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\images_prod\\";
        try {
            this.rutaImagen = path + archivo.getSubmittedFileName();
            // Asignar los nombres a los archivos.

            InputStream entrada = archivo.getInputStream();
            byte[] data = new byte[entrada.available()];
            entrada.read(data);

            File fileServer = new File(this.rutaImagen);

            FileOutputStream salida = new FileOutputStream(fileServer);
            salida.write(data);

            salida.close();
            entrada.close();

        } catch (Exception e) {
            System.out.println("Errores en consola : " + e.getMessage());
        }

        producto.setImagenProducto("../images_prod/" + archivo.getSubmittedFileName()); // Ruta de la imagen
        proFacade.create(producto);
        confirm(producto);
        producto = new Producto();
        producto.setIdProducto(proFacade.count() + 1);

    }

    public void inabilitarProd(Producto producto) {
        producto.setFkEstado(estadoRepo.find(3));
        proFacade.edit(producto);
        eliminarConfirm(producto);
    }

    public List<Producto> consultarProductos() {
        return proFacade.findAll();
    }

    public void confirm(Producto producto) {
        addMessage("¡Registro Exitoso!", "Producto " + producto.getNombreproducto());
    }

    public void confirmEdit(Producto producto) {
        addMessage("¡Cambio Exitoso!", "¡Producto " + producto.getIdProducto() + " editado!");
    }

    public void eliminarConfirm(Producto producto) {
        addMessage("¡Producto Inabilitado!", "¡Producto " + producto.getIdProducto() + " inhabilitado!");
    }

    public void editarProducto() {
        producto.setFkTamaño(tamProd.find(prodTam.getIdTamaño()));
        producto.setFkEstado(estadoRepo.find(estado.getIdEstado()));
        proFacade.edit(producto);
        producto = new Producto();
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //Implementar graficos
    /*private void createPieModel2() {
        pieModel2 = new PieChartModel();

        int contadorStock = 0, contadorSinStock = 0, contadorStockBajo = 0; 
        
        List<Producto> listaProductos = proFacade.findAll();
        
        // Validar los estados con sus respectivos contadores.
        for (Producto producto : listaProductos) {
            if (producto.getFkEstado().getIdEstado() == 1) {
                contadorStock++;
            }
            
            if (producto.getFkEstado().getIdEstado() == 2) {
                contadorStockBajo++;
            }
            
            if (producto.getFkEstado().getIdEstado() == 3) {
                contadorSinStock++;
            }            
        }
        
        pieModel2.set("En Stock", contadorStock);
        pieModel2.set("Bajo Stock", contadorStockBajo);
        pieModel2.set("Sin Stock", contadorSinStock);

        pieModel2.setTitle("Grafica estados del producto");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        pieModel2.setShadow(false);
        
        // Reiniciar los valores
        contadorStock = 0;
        contadorSinStock = 0;
        contadorStockBajo = 0;
    }*/

}
