/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.EmpleadosDAO;
import DAO.EmpleadosDAOImplement;
import Model.Empleados;
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
public class empleadosBean {

    Empleados empleado;
    List<Empleados> empleados;

    public Empleados getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public List<Empleados> getEmpleados() {
        EmpleadosDAO dao = new EmpleadosDAOImplement();
        empleados = dao.MostrarEmpleados();
        return empleados;
    }
    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }
    /**
     * Creates a new instance of empleadosBean
     */
    public empleadosBean() {
        empleado = new Empleados();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        EmpleadosDAO dao = new EmpleadosDAOImplement();
        dao.InsertarEmpleados(empleado);
        empleado = new Empleados();
        addMessage("Empleado agregado");
    }
    
    public void actualizar(){
        EmpleadosDAO dao = new EmpleadosDAOImplement();
        dao.ModificarEmpleados(empleado);
        empleado = new Empleados();
        addMessage("Empleado actualizado");
    }
    
    public void eliminar(){
        EmpleadosDAO dao = new EmpleadosDAOImplement();
        dao.EliminarEmpleados(empleado);
        empleado = new Empleados();
        addMessage("Empleado eliminado");
    }
    
}
