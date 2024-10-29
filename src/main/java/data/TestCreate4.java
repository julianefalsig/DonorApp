package data;

import data.entities.MetaData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

@Test
public class TestCreate4 {
    public void TestCreate4() {
        //opretter forbindelse til hybernate controlleren
        HibernateController hibernateController =
                new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();
        //starter en transaktion
        Transaction transaction = session.beginTransaction();
        System.out.println("connection created");


        try {


            transaction.commit();
            System.out.println("DB udated");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
