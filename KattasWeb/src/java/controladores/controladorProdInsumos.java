
package controladores;

import entidades.Insumo;
import entidades.Producto;
import entidades.ProductosInsumos;
import facades.InsumoFacade;
import facades.ProductoFacade;
import facades.ProductosInsumosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


@Named(value = "controladorProdInsumos")
@SessionScoped
public class controladorProdInsumos implements Serializable {

    @EJB
    ProductosInsumosFacade insumo_prodRepo;
    
    @EJB
    InsumoFacade insumo;
    
    @EJB
    ProductoFacade producRepo;
    
    ProductosInsumos prodInsum;
    Producto producto;
    Insumo in;
    
    
    public void init(){
        prodInsum = new ProductosInsumos();
        producto = new Producto();
        in = new Insumo();
    }

    public ProductosInsumos getProdInsum() {
        return prodInsum;
    }

    public void setProdInsum(ProductosInsumos prodInsum) {
        this.prodInsum = prodInsum;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Insumo getIn() {
        return in;
    }

    public void setIn(Insumo in) {
        this.in = in;
    }
    
       
    public controladorProdInsumos() {
    }
    
    public List<ProductosInsumos> consultarInsumosProductos(){
        return insumo_prodRepo.findAll();
    }
    
    public void agregarInsumosProducto(int id){
        prodInsum.setFkidProducto(producRepo.find(id));
        prodInsum.setFkidInsumo(insumo.find(in.getIdInsumo()));
        insumo_prodRepo.create(prodInsum);
        prodInsum = new ProductosInsumos();
    }
    
    public void editarProdInsumos(){
        insumo_prodRepo.edit(prodInsum);
    }
    
    public void eliminarInsumoProducto(ProductosInsumos insumoProd){
        insumo_prodRepo.remove(insumoProd);
    }
    
    
    
}

