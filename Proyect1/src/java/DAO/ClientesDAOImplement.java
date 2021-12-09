/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Clientes;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luigi
 */
public class ClientesDAOImplement implements ClientesDAO{
    

    @Override
    public void InsertarClientes(Clientes cliente) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cliente);
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
    public void ModificarClientes(Clientes cliente) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cliente);
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
    public void EliminarClientes(Clientes cliente) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
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
    public List<Clientes> MostrarClientes() {
        Session session = null;
        List<Clientes> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Clientes");
            lista = (List<Clientes>)query.list();
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
