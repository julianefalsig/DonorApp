package data.tests;

import data.entities.MetaData;
import data.entities.MetaDataTemplate;
import data.entities.QualificationStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class TestCreate4 {
    /* INACTIVE CLASS for creating links between QualificationStep and MetaDataTemplate
    public void TestCreate4() {


   //opretter forbindelse til hybernate controlleren
        HibernateController hibernateController =
                new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();
        //starter en transaktion
        Transaction transaction = session.beginTransaction();
        System.out.println("connection created");


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
        }
    }*/
}
