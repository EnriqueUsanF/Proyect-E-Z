/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Productos;
import java.util.List;

/**
 *
 * @author luigi
 */
public interface ProductosDAO {
    public void InsertarProductos(Productos producto);
    public void ModificarProductos(Productos producto);
    public void EliminarProductos(Productos producto);
    public List<Productos> MostrarProductos();
}
