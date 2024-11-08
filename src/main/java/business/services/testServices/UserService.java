package business.services.testServices;

import data.entities.User;
import data.HibernateController;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserService {

    private HibernateController hibernateController;

    // Dependency Injection via constructor
    public UserService(HibernateController hibernateController) {
        this.hibernateController = hibernateController;
    }

    public List<User> getAllUsers() {
        // Henter session fra Hibernate
        Session session = hibernateController.getSessionFactory().openSession();
        Transaction tx = null;
        List<User> users = null;

        try {
            tx = session.beginTransaction();
            // HQL-forespørgsel for at hente alle brugere
            users = session.createQuery("from DBUSER", User.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return users;
    }

}
