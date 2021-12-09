/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Clientes;
import java.util.List;

/**
 *
 * @author luigi
 */
public interface ClientesDAO {
    public void InsertarClientes(Clientes cliente);
    public void ModificarClientes(Clientes cliente);
    public void EliminarClientes(Clientes cliente);
    public List<Clientes> MostrarClientes();
}
