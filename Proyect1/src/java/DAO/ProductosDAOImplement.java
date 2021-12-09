/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Productos;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luigi
 */
public class ProductosDAOImplement implements ProductosDAO{
    

    @Override
    public void InsertarProductos(Productos producto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
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
    public void ModificarProductos(Productos producto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
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
    public void EliminarProductos(Productos producto) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
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
    public List<Productos> MostrarProductos() {
        Session session = null;
        List<Productos> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Productos");
            lista = (List<Productos>)query.list();
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
