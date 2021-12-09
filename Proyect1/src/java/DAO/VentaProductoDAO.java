/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.VentaProducto;
import java.util.List;

/**
 *
 * @author luigi
 */
public interface VentaProductoDAO {
    public void InsertarVentaProducto(VentaProducto ventaProducto);
    public void ModificarVentaProducto(VentaProducto ventaProducto);
    public void EliminarVentaProducto(VentaProducto ventaProducto);
    public List<VentaProducto> MostrarVentaProducto();
}
