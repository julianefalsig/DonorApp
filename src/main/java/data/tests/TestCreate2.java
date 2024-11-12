package data.tests;

import data.HibernateController;
import data.entities.Donor;
import data.entities.MetaData;
import data.entities.MetaDataTemplate;
import data.entities.QualificationStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test
public class TestCreate2 {
    public void testCreate2() {
        // Create a connection to the Hibernate controller
        HibernateController hibernateController =
                new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        try {
            Donor donor = new Donor();
            // change donor name here
            donor.setFirstName("Anton");


            List<String> stepTitleList = new ArrayList<> ();
            stepTitleList.add("Sample Analysis");
            stepTitleList.add("Interview & information");
            stepTitleList.add("Medical examination");
            stepTitleList.add("Blood & urine test");
            stepTitleList.add("Donor profile");

            for(int i=0; i<stepTitleList.size(); i++){
                //Creating all qualification steps
                boolean isCompleted ;
                if(i==0){isCompleted = true;} else isCompleted = false;
                QualificationStep qualificationStep = new QualificationStep(i+1, stepTitleList.get(i),isCompleted, donor);
                qualificationStep.addMetaData(new MetaData(true, new MetaDataTemplate(152, null)));
                donor.addQualificationStep(qualificationStep);
            }
            session.persist(donor);
            transaction.commit();
            System.out.println("Transaction succeeded. Donor ID: " + donor.getDonorId());
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
