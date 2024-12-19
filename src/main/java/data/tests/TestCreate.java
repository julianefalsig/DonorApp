package data.tests;

import data.HibernateController;
import data.entities.Donor;
import data.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;
import org.testng.annotations.Test;

@Test
public class TestCreate {
// TEST CLASS FOR CREATING USERS/SUPERUSERS
    public void testCreate() {
        //opretter forbindelse til hybernate controlleren
        HibernateController hibernateController =
                new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();
        //starter en transaktion
        Transaction transaction = session.beginTransaction();

        //Set username and password
        String username = "Hanne"; //ALWAYS CHANGES
        String password = "super";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(username, hashed);
        //gemmer brugeren i databasaen
        session.persist(user);
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
