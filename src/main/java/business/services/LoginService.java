package business.services;

import data.HibernateController;
import data.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

public class LoginService {

    private HibernateController hibernateController =
            new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
    private SessionFactory sessionFactory = hibernateController.getSessionFactory();
    Transaction transaction = null;


    public User validateUser(String username, String password) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            // Retrieve user by username
            String hql = "SELECT u FROM User u WHERE u.username = :username";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);

            User user = query.getSingleResult();
            transaction.commit();

            if (user == null) { //if the user doesn't exist
            return null;
            }

            // Validate the provided password with the hashed password
            if (BCrypt.checkpw(password, user.getPassword())) {
            return user; // Password matches
            } else {
            return null; // Password doesn't match
            }
        } catch (Exception e) {
        if (transaction != null) transaction.rollback();
        throw new RuntimeException("Error validating user", e);
    }
}


}

