/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.VentaProducto;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luigi
 */
public class VentaProductoDAOImplement implements VentaProductoDAO{
    

    @Override
    public void InsertarVentaProducto(VentaProducto ventaProducto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ventaProducto);
            
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void ModificarVentaProducto(VentaProducto ventaProducto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(ventaProducto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void EliminarVentaProducto(VentaProducto ventaProducto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ventaProducto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally{
            if(session != null){
                session.close();
            }
        }    }

    @Override
    public List<VentaProducto> MostrarVentaProducto() {
        Session session = null;
        List<VentaProducto> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from VentaProducto");
            lista = (List<VentaProducto>)query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            if(session != null){
                session.close();
            }
        }
        return lista;
    }
}
