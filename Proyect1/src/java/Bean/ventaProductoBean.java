/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;



import DAO.VentaProductoDAO;
import DAO.VentaProductoDAOImplement;
import Model.Productos;
import Model.VentaProducto;
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
public class ventaProductoBean {

    VentaProducto ventaproducto;
    int idProducto;
    List<VentaProducto> ventaproductos;
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public VentaProducto getVentaProducto() {
        return ventaproducto;
    }
    public void setVentaProducto(VentaProducto ventaproducto) {
        this.ventaproducto = ventaproducto;
    }

    public List<VentaProducto> getVentaProductos() {
        VentaProductoDAO dao = new VentaProductoDAOImplement();
        ventaproductos = dao.MostrarVentaProducto();
        return ventaproductos;
    }
    public void setVentaProductos(List<VentaProducto> ventaproductos) {
        this.ventaproductos = ventaproductos;
    }
    /**
     * Creates a new instance of empleadosBean
     */
    public ventaProductoBean() {
        ventaproducto = new VentaProducto();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        VentaProductoDAO dao = new VentaProductoDAOImplement();
        
        Productos fk = new Productos();
        fk.setIdProducto(idProducto);
        ventaproducto.setProductos(fk);
        
        dao.InsertarVentaProducto(ventaproducto);
        ventaproducto = new VentaProducto();
        addMessage("Venta de producto agregado");
    }
    
    public void actualizar(){
        VentaProductoDAO dao = new VentaProductoDAOImplement();
        
        Productos fk = new Productos();
        fk.setIdProducto(idProducto);
        ventaproducto.setProductos(fk);
        
        dao.ModificarVentaProducto(ventaproducto);
        ventaproducto = new VentaProducto();
        addMessage("Venta de producto actualizado");
    }
    
    public void eliminar(){
        VentaProductoDAO dao = new VentaProductoDAOImplement();
        dao.EliminarVentaProducto(ventaproducto);
        ventaproducto = new VentaProducto();
        addMessage("Venta de producto eliminado");
    }
    
}
