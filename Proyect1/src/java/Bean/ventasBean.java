/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;



import DAO.VentasDAO;
import DAO.VentasDAOImplement;
import Model.Clientes;
import Model.Empleados;
import Model.VentaProducto;
import Model.Ventas;
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
public class ventasBean {

    Ventas venta;
    
    int idVentaProducto;
    int idEmpleado;
    int idCliente;
    
    List<Ventas> ventas;
    
    public int getIdVentaProducto() {
        return idVentaProducto;
    }

    public void setIdVentaProducto(int idVentaProducto) {
        this.idVentaProducto = idVentaProducto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Ventas getVenta() {
        return venta;
    }
    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public List<Ventas> getVentas() {
        VentasDAO dao = new VentasDAOImplement();
        ventas = dao.MostrarVentas();
        return ventas;
    }
    public void setVentas(List<Ventas> ventas) {
        this.ventas = ventas;
    }
    /**
     * Creates a new instance of empleadosBean
     */
    public ventasBean() {
        venta = new Ventas();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        VentasDAO dao = new VentasDAOImplement();
        
        VentaProducto fk1 = new VentaProducto();
        fk1.setIdVentaProducto(idVentaProducto);
        venta.setVentaproducto(fk1);
        Clientes fk2 = new Clientes();
        fk2.setIdCliente(idCliente);
        venta.setClientes(fk2);
        Empleados fk3 = new Empleados();
        fk3.setIdEmpleado(idEmpleado);
        venta.setEmpleados(fk3);
        
        dao.InsertarVentas(venta);
        venta = new Ventas();
        addMessage("Venta agregado");
    }
    
    public void actualizar(){
        VentasDAO dao = new VentasDAOImplement();
        
        VentaProducto fk1 = new VentaProducto();
        fk1.setIdVentaProducto(idVentaProducto);
        venta.setVentaproducto(fk1);
        Clientes fk2 = new Clientes();
        fk2.setIdCliente(idCliente);
        venta.setClientes(fk2);
        Empleados fk3 = new Empleados();
        fk3.setIdEmpleado(idEmpleado);
        venta.setEmpleados(fk3);
        
        dao.ModificarVentas(venta);
        venta = new Ventas();
        addMessage("Venta actualizado");
    }
    
    public void eliminar(){
        VentasDAO dao = new VentasDAOImplement();
        dao.EliminarVentas(venta);
        venta = new Ventas();
        addMessage("Venta eliminado");
    }
    
}
