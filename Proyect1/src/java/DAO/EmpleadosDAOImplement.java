/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Empleados;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luigi
 */
public class EmpleadosDAOImplement implements EmpleadosDAO{
    

    @Override
    public void InsertarEmpleados(Empleados empleado) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(empleado);
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
    public void ModificarEmpleados(Empleados empleado) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(empleado);
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
    public void EliminarEmpleados(Empleados empleado) {
        Session session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(empleado);
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
    public List<Empleados> MostrarEmpleados() {
        Session session = null;
        List<Empleados> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Empleados");
            lista = (List<Empleados>)query.list();
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
