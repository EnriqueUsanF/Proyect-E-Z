/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ventas;
import java.util.List;

/**
 *
 * @author luigi
 */
public interface VentasDAO {
    public void InsertarVentas(Ventas venta);
    public void ModificarVentas(Ventas venta);
    public void EliminarVentas(Ventas venta);
    public List<Ventas> MostrarVentas();
}
