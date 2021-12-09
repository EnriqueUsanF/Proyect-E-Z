/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import DAO.ProductosDAO;
import DAO.ProductosDAOImplement;
import Model.Productos;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author luigi
 */
@ManagedBean
@ViewScoped
public class productosBean {

    Productos producto;
    List<Productos> productos;

    public Productos getProducto() {
        return producto;
    }
    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public List<Productos> getProductos() {
        ProductosDAO dao = new ProductosDAOImplement();
        productos = dao.MostrarProductos();
        return productos;
    }
    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
    /**
     * Creates a new instance of empleadosBean
     */
    public productosBean() {
        producto = new Productos();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        ProductosDAO dao = new ProductosDAOImplement();
        dao.InsertarProductos(producto);
        producto = new Productos();
        addMessage("Producto agregado");
    }
    
    public void actualizar(){
        ProductosDAO dao = new ProductosDAOImplement();
        dao.ModificarProductos(producto);
        producto = new Productos();
        addMessage("Producto actualizado");
    }
    
    public void eliminar(){
        ProductosDAO dao = new ProductosDAOImplement();
        dao.EliminarProductos(producto);
        producto = new Productos();
        addMessage("Producto eliminado");
    }
    
}
