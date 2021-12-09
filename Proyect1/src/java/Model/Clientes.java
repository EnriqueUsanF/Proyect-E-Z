package Model;
// Generated 25/10/2020 08:43:19 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private Integer idCliente;
     private String nombre;
     private Long telefono;
     private String correo;
     private String direccion;
     private String tipoMenudeoMayoreo;
     private Set ventases = new HashSet(0);

    public Clientes() {
    }

    public Clientes(String nombre, Long telefono, String correo, String direccion, String tipoMenudeoMayoreo, Set ventases) {
       this.nombre = nombre;
       this.telefono = telefono;
       this.correo = correo;
       this.direccion = direccion;
       this.tipoMenudeoMayoreo = tipoMenudeoMayoreo;
       this.ventases = ventases;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Long getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTipoMenudeoMayoreo() {
        return this.tipoMenudeoMayoreo;
    }
    
    public void setTipoMenudeoMayoreo(String tipoMenudeoMayoreo) {
        this.tipoMenudeoMayoreo = tipoMenudeoMayoreo;
    }
    public Set getVentases() {
        return this.ventases;
    }
    
    public void setVentases(Set ventases) {
        this.ventases = ventases;
    }




}


