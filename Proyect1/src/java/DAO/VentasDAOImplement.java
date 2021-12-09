/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Ventas;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luigi
 */
public class VentasDAOImplement implements VentasDAO{
    

    @Override
    public void InsertarVentas(Ventas venta) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(venta);
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
    public void ModificarVentas(Ventas venta) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(venta);
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
    public void EliminarVentas(Ventas venta) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(venta);
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
    public List<Ventas> MostrarVentas() {
        Session session = null;
        List<Ventas> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Ventas");
            lista = (List<Ventas>)query.list();
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
