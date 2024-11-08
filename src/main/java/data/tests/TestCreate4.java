package data.tests;

import data.HibernateController;
import data.entities.MetaData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.testng.annotations.Test;

@Test
public class TestCreate4 {
    public void TestCreate4() {

        //INACTIVE CLASS for updating MetaData
   /*
        HibernateController hibernateController =
                new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();
        System.out.println("Connection to database established.");

        try {
            String hql = "UPDATE MetaData m SET m.isCompleted = false WHERE m.isCompleted IS NULL";
            Query query = session.createQuery(hql);

            // Commit the transaction
            transaction.commit();
            System.out.println("MetaData updated successfully.");

        } catch (Exception e) {
            // If there is an exception, roll back the transaction
            if (transaction != null) {
                transaction.rollback();
                System.err.println("Transaction rolled back due to error.");
            }
            e.printStackTrace();

        } finally {
            // Close the session to release resources
            session.close();
            System.out.println("Session closed.");
        }
    */


/*
// creating links between QualificationStep and MetaDataTemplate
        try {
            // Retrieve MetaDataTemplate entries with IDs 152 and 153
            MetaDataTemplate template1 = session.find(MetaDataTemplate.class, 152);
            MetaDataTemplate template2 = session.find(MetaDataTemplate.class, 153);

            if (template1 == null || template2 == null) {
                System.out.println("Error: One or both MetaDataTemplate entries not found.");
                return;
            }



            // Retrieve all QualificationStep entries with stepNumber = 2
            List<QualificationStep> stepsWithStepNumber2 = session.createQuery(
                    "FROM QualificationStep WHERE stepNumber = 2", QualificationStep.class
            ).getResultList();


            // Create MetaData entries for each QualificationStep with both templates
            for (QualificationStep step : stepsWithStepNumber2) {
                MetaData metaData1 = new MetaData(false, step, template1);
                MetaData metaData2 = new MetaData(false, step, template2);

                // Link MetaData entries to the QualificationStep
                step.addMetaData(metaData1);
                step.addMetaData(metaData2);

                // Persist the MetaData entries (this will also update QualificationStep due to cascade)
                session.persist(metaData1);
                session.persist(metaData2);
            }

            // Commit transaction
            transaction.commit();
            System.out.println("MetaData entries linked successfully.");


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }*/
    }
}
