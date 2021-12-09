package Model;
// Generated 25/10/2020 08:43:19 PM by Hibernate Tools 4.3.1




import java.util.HashSet;
import java.util.Set;

/**
 * VentaProducto generated by hbm2java
 */
public class VentaProducto  implements java.io.Serializable {

    
     private Integer idVentaProducto;
     private Productos productos;
     private Integer cantidadProducto;
     private Set ventases = new HashSet(0);

    public VentaProducto() {
    }

    public VentaProducto(Productos productos, Integer cantidadProducto, Set ventases) {
       this.productos = productos;
       this.cantidadProducto = cantidadProducto;
       this.ventases = ventases;
    }
   
    public Integer getIdVentaProducto() {
        return this.idVentaProducto;
    }
    
    public void setIdVentaProducto(Integer idVentaProducto) {
        this.idVentaProducto = idVentaProducto;
    }
    
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public Integer getCantidadProducto() {
        return this.cantidadProducto;
    }
    
    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    public Set getVentases() {
        return this.ventases;
    }
    
    public void setVentases(Set ventases) {
        this.ventases = ventases;
    }


}