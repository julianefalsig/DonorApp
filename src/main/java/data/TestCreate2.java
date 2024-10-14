package data;

import data.Entities.Donor;
import data.Entities.MetaData;
import data.Entities.QualificationStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test
public class TestCreate2 {
    // ændring vjrkwngvkjrstæl
    public void testCreate2() {
        // Create a connection to the Hibernate controller
        HibernateController hibernateController =
                new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Create and save a donor
            Donor donor = new Donor();
            donor.setFirstName("Jan");
            session.persist(donor);

            // Create a qualification step and metadata
            QualificationStep qualificationStep = new QualificationStep(2, "Initial Interview", donor);
            MetaData metaData1 = new MetaData(
                    "Before your initial interview, you have to fill out the initial survey. You will find the link in your email.",
                    false,
                    qualificationStep
            );
            MetaData metaData2 = new MetaData(
                    "Please remember to prepare your family history, we are interested to know about your family's health/illnesses etc.",
                    false,
                    qualificationStep
            );

            // Add metadata to the qualification step
            List<MetaData> metaDataList = new ArrayList<>();
            metaDataList.add(metaData1);
            metaDataList.add(metaData2);

            qualificationStep.setMetaDataList(metaDataList);

            // Save the qualification step
            session.persist(qualificationStep);
            session.persist(metaData1);
            session.persist(metaData2);

            // Commit the transaction after all operations
            transaction.commit();

            System.out.println("Transaction succeeded. Donor ID: " + donor.getDonorId());
            System.out.println("QualificationStep ID: " + qualificationStep.getQualificationStepID());
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
