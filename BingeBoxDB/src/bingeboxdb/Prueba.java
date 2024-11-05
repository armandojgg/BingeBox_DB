/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bingeboxdb;

import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Armando
 */

public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try { //SessionFactory instancia = (SessionFactory) HibernateUtil.buildSessionFactory();
            //Sesiones. Factory crea la sesión conforme al fichero de configuración de hibernate
            //Session. Crea la sesión de conexión a la base de datos
            SessionFactory instancia = new Configuration().configure("C:/Users/MEDAC/Documents/NetBeansProjects/BingeBoxDB/src/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Actors.class).buildSessionFactory();
            Session session = instancia.openSession();
            //Creamos objetos
            Actors a = new Actors("Juan", "Americano", "Masculino");
            //Transacciones. Insertamos objeto en la tabla
            session.beginTransaction();
            session.save(a);
            session.getTransaction().commit();
            System.out.println("Registro insertado");
            session.close();
        } catch (HibernateException he) {
            System.out.println(he);
        } finally {

        }

    }
}
