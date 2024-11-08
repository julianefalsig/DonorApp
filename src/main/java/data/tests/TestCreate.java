package data.tests;

import data.HibernateController;
import data.entities.Donor;
import data.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

@Test
public class TestCreate {

    public void testCreate() {
        //opretter forbindelse til hybernate controlleren
        HibernateController hibernateController =
                new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();
        //starter en transaktion
        Transaction transaction = session.beginTransaction();

        //opretter en ny bruger
        User user = new User();
        Donor donor = new Donor();
        System.out.println("UserID before commit: " + user.getId());
        user.setUsername("henrik");
        donor.setFirstName("Harry");
        //gemmer brugeren i databasaen
        session.persist(user);
        session.persist(donor);
        transaction.commit();
        //printer det nye ID
        System.out.println("UserID after commit: " + user.getId());
        //læser brugeren tilbage fra database
        Transaction readTransaction = session.beginTransaction();
        User readUser = session.get(User.class, user.getId());
        System.out.println("Read user back: " + readUser.toString());
        readTransaction.commit();
        //lukker sessionen
        session.close();
    }
}
