
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

                String s1 = "";


                MetaDataTemplate m1 = new MetaDataTemplate(s1);


                session.persist(m1);



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

