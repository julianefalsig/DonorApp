package data;

import data.Entities.Donor;
import data.Entities.MetaData;
import data.Entities.QualificationStep;
import data.Entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateController {//Should be a singleton…
    private final SessionFactory sessionFactory;

    public HibernateController(String dbUrl){
        Configuration configuration = new Configuration(); //NB org.hibernate.cfg.Configuration
        configuration.addAnnotatedClass(User.class); //remember to do this for all DB entities
        configuration.addAnnotatedClass(Donor.class);
        configuration.addAnnotatedClass(QualificationStep.class);
        configuration.addAnnotatedClass(MetaData.class);
        configuration.setProperty("hibernate.connection.username", System.getenv("donor22user"));
        configuration.setProperty("hibernate.connection.password", System.getenv("donor22pass"));
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://" + dbUrl);
        configuration.setProperty("hibernate.hbm2ddl.auto","update"); //update Schema - don't do this in prod
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
