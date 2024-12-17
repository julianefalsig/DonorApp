package data.tests;
import data.HibernateController;
import data.entities.*;
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
            User user = new User();
            donor.setFirstName("Bastian");

            ///////////////SKIFT USERNAME skal være unikt/////////////
            user.setUsername("Bas");  user.setPassword("kodeord");
            ///////////////////SKIFT USERNAME///////////////////////////////


            // Set the relationship
            donor.setUser(user);
            user.setDonor(donor);

            List<String> stepTitleList = new ArrayList<>();
            stepTitleList.add("Sample Analysis");
            stepTitleList.add("Interview & information");
            stepTitleList.add("Medical examination");
            stepTitleList.add("Blood & urine test");
            stepTitleList.add("Donor profile");

            for (int i = 0; i < stepTitleList.size(); i++) {
                // Creating all qualification steps
                boolean isCompleted = (i == 0); // First step is completed, others are not
                QualificationStep qualificationStep = new QualificationStep(
                        i + 1,
                        stepTitleList.get(i),
                        isCompleted,
                        donor
                );

                // Add metadata as per conditions
                if (qualificationStep.getStepNumber() == 2) {
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(352, null)));
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(353, null)));
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(354, null)));
                }
                if (qualificationStep.getStepNumber() == 3) {
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(402, null)));
                }
                if (qualificationStep.getStepNumber() == 4) {
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(302, null)));
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(252, null)));
                }
                if (qualificationStep.getStepNumber() == 5) {
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(403, null)));
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(404, null)));
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(405, null)));
                    qualificationStep.addMetaData(new MetaData(false, new MetaDataTemplate(354, null)));
                }
                donor.addQualificationStep(qualificationStep);
            }

            // Persist both the user and the donor (cascade should handle related entities)
            session.persist(user);

            // Commit the transaction
            transaction.commit();
            System.out.println("Transaction succeeded. Donor ID: " + donor.getDonorId());
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

