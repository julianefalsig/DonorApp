/*
package data;

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
            String s1 = "Before your interview, you must complete a survey  and thoroughly prepare by reviewing the provided preparation materials. It is important to be well-prepared, as this will help ensure a successful interview process.";
            String s2 = "https://www.europeanspermbank.com/donor-da-dk";
            String s3 = "You will need to undergo a thorough medical examination with a doctor we collaborate with. You must schedule the appointment yourself; you can find the contact information below. Additionally, please make sure to read the information's about the medical examination, so you know what to expect.";
            String s4 = "The examination will require you to remove all of your clothing. The doctor will conduct a thorough assessment of your body to determine if any further examinations are necessary. This will include evaluations of your vision, hearing, reflexes, as well as a skin assessment and a check for scoliosis, among other things.";
            MetaDataTemplate m1 = new MetaDataTemplate(s1);
            MetaDataTemplate m2 = new MetaDataTemplate(s2);
            MetaDataTemplate m3 = new MetaDataTemplate(s3);
            MetaDataTemplate m4 = new MetaDataTemplate(s4);
            session.persist(m1);
            session.persist(m2);
            session.persist(m3);
            session.persist(m4);

            transaction.commit();
            System.out.println("The Templates are in the DB");
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
*/
