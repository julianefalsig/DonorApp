package data.tests;

import data.HibernateController;
import data.entities.MetaData;
import data.entities.MetaDataTemplate;
import data.entities.QualificationStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class TestCreate4 {
    public void TestCreate4() {

        //INACTIVE CLASS for updating MetaData

        HibernateController hibernateController =
                new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        System.out.println("Connection to database established.");
/*
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


// creating links between QualificationStep and MetaDataTemplate
        try {
            // Retrieve MetaDataTemplate entries with IDs 152 and 153
            MetaDataTemplate template1 = session.find(MetaDataTemplate.class, 152);
            MetaDataTemplate template2 = session.find(MetaDataTemplate.class, 153);
            MetaDataTemplate template3 = session.find(MetaDataTemplate.class, 154);
            MetaDataTemplate template4 = session.find(MetaDataTemplate.class, 155);
            MetaDataTemplate template5 = session.find(MetaDataTemplate.class, 252);
            MetaDataTemplate template6 = session.find(MetaDataTemplate.class, 302);
            MetaDataTemplate template7 = session.find(MetaDataTemplate.class, 303);

            /*
            if (template1 == null || template2 == null || template3 == null) {
                System.out.println("Error: One or both MetaDataTemplate entries not found.");
                return;
            }*/


/*
            // Retrieve all QualificationStep entries with stepNumber = 2
            List<QualificationStep> stepsWithStepNumber2 = session.createQuery(
                    "FROM qualificationstep q WHERE q.stepNumber = 2", QualificationStep.class
            ).getResultList();

 */
            List<QualificationStep> stepsWithStepNumber3 = session.createQuery(
                    "SELECT q FROM QualificationStep q WHERE q.stepNumber = 3", QualificationStep.class
            ).getResultList();

            List<QualificationStep> stepsWithStepNumber4 = session.createQuery(
                    "SELECT q FROM QualificationStep q WHERE q.stepNumber = 4", QualificationStep.class
            ).getResultList();
            List<QualificationStep> stepsWithStepNumber5 = session.createQuery(
                    "SELECT q FROM QualificationStep q WHERE q.stepNumber = 5", QualificationStep.class
            ).getResultList();


/*
            // Create MetaData entries for each QualificationStep with both templates
            for (QualificationStep step : stepsWithStepNumber2) {
                MetaData metaData1 = new MetaData(false, template1);
                MetaData metaData2 = new MetaData(false, template2);

                // Link MetaData entries to the QualificationStep
                step.addMetaData(metaData1);
                step.addMetaData(metaData2);

                // Persist the MetaData entries (this will also update QualificationStep due to cascade)
                session.persist(metaData1);
                session.persist(metaData2);
            }

 */
            for (QualificationStep step : stepsWithStepNumber3) {
                MetaData metaData3 = new MetaData(false, template3);
                MetaData metaData4 = new MetaData(false, template4);
                MetaData metaData5 = new MetaData(false, template5);

                // Link MetaData entries to the QualificationStep
                step.addMetaData(metaData3);
                step.addMetaData(metaData4);
                step.addMetaData(metaData5);

                // Persist the MetaData entries (this will also update QualificationStep due to cascade)
                session.persist(metaData3);
                session.persist(metaData4);
                session.persist(metaData5);
            }
            for (QualificationStep step : stepsWithStepNumber4) {
                MetaData metaData6 = new MetaData(false, template6);

                // Link MetaData entries to the QualificationStep
                step.addMetaData(metaData6);
                // Persist the MetaData entries (this will also update QualificationStep due to cascade)
                session.persist(metaData6);
            }

            for (QualificationStep step : stepsWithStepNumber5) {
                MetaData metaData7 = new MetaData(false, template7);

                // Link MetaData entries to the QualificationStep
                step.addMetaData(metaData7);
                // Persist the MetaData entries (this will also update QualificationStep due to cascade)
                session.persist(metaData7);
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
        }
    }
}

/* ############################
        try {
            // Retrieve MetaDataTemplate entries by IDs
            MetaDataTemplate template1 = session.find(MetaDataTemplate.class, 252);

            if (template1 == null) {
                System.out.println("Error: One or both MetaDataTemplate entries not found.");
                return;
            }

            // Retrieve all QualificationStep entries by stepNumber
            List<QualificationStep> stepsWithStepNumber3 = session.createQuery(
                    "FROM QualificationStep WHERE stepNumber = 3", QualificationStep.class
            ).getResultList();


            // Create MetaData entries for each QualificationStep with both templates
            for (QualificationStep step : stepsWithStepNumber3) {
                MetaData metaData1 = new MetaData(false, step, template1);


                // Link MetaData entries to the QualificationStep
                step.addMetaData(metaData1);


                // Persist the MetaData entries (this will also update QualificationStep due to cascade)
                session.persist(metaData1);

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
        }
    }
}
 */
