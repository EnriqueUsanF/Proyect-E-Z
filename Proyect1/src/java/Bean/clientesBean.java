/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ClientesDAO;
import DAO.ClientesDAOImplement;
import Model.Clientes;
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
public class clientesBean {

    Clientes cliente;
    List<Clientes> clientes;

    public Clientes getCliente() {
        return cliente;
    }
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Clientes> getClientes() {
        ClientesDAO dao = new ClientesDAOImplement();
        clientes = dao.MostrarClientes();
        return clientes;
    }
    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }
    /**
     * Creates a new instance of empleadosBean
     */
    public clientesBean() {
        cliente = new Clientes();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        ClientesDAO dao = new ClientesDAOImplement();
        dao.InsertarClientes(cliente);
        cliente = new Clientes();
        addMessage("Cliente agregado");
    }
    
    public void actualizar(){
        ClientesDAO dao = new ClientesDAOImplement();
        dao.ModificarClientes(cliente);
        cliente = new Clientes();
        addMessage("Cliente actualizado");
    }
    
    public void eliminar(){
        ClientesDAO dao = new ClientesDAOImplement();
        dao.EliminarClientes(cliente);
        cliente = new Clientes();
        addMessage("Cliente eliminado");
    }
    
}
