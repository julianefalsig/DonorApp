
package data.tests;

import data.HibernateController;
import data.entities.MetaDataTemplate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

@Test
public class TestCreate3 {
            public void testCreate3() {
            //opretter forbindelse til hybernate controlleren
            HibernateController hibernateController =
                    new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
            SessionFactory sessionFactory = hibernateController.getSessionFactory();
            Session session = sessionFactory.openSession();
            //starter en transaktion
            Transaction transaction = session.beginTransaction();
            System.out.println("connection created");


            try {

                String s1 = "Information about medical examination";
                String s2 = "Upload baby picture";
                String s3 = "Personality test";
                String s4 = "Information about last interview";
                String s5 = "Appointment";


                MetaDataTemplate m1 = new MetaDataTemplate(s1);
                MetaDataTemplate m2 = new MetaDataTemplate(s2);
                MetaDataTemplate m3 = new MetaDataTemplate(s3);
                MetaDataTemplate m4 = new MetaDataTemplate(s4);
                MetaDataTemplate m5 = new MetaDataTemplate(s5);

                session.persist(m1);
                session.persist(m2);
                session.persist(m3);
                session.persist(m4);
                session.persist(m5);


                transaction.commit();
                System.out.println("The templates are in the DB");
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}

