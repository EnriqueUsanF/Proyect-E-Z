/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Empleados;
import java.util.List;

/**
 *
 * @author luigi
 */
public interface EmpleadosDAO {
    public void InsertarEmpleados(Empleados empleado);
    public void ModificarEmpleados(Empleados empleado);
    public void EliminarEmpleados(Empleados empleado);
    public List<Empleados> MostrarEmpleados();
}
