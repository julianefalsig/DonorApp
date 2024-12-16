package business.services.testServices;

import business.services.ServiceException;
import data.entities.Donor;
import data.entities.User;
import data.HibernateController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {

    private HibernateController hibernateController =
            new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
    private SessionFactory sessionFactory = hibernateController.getSessionFactory();
    Transaction tx = null;
    public User getUser(String username) {
        Session session = hibernateController.getSessionFactory().openSession();

        try {
            tx = session.beginTransaction();

            String hql = "SELECT u FROM User u WHERE u.username = :username";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);

            List<User> users = query.list();

            if (users.size() > 1) {
                throw new ServiceException("Multiple users found with the same username");
            }

            tx.commit();
            return users.isEmpty() ? null : users.get(0);

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new ServiceException("Failed to fetch user", e);
        } finally {
            session.close();
        }
    }


}
