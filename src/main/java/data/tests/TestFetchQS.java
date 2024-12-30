package data.tests;

import org.testng.annotations.Test;
import business.services.ServiceException;
import data.HibernateController;
import data.entities.Donor;
import data.entities.QualificationStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Test
public class TestFetchQS {
    public void testFetchQS() {
        HibernateController hibernateController =
                    new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        SessionFactory sessionFactory = hibernateController.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //Select all qualification steps for donor with ID 502
            String hql = "SELECT qs FROM QualificationStep qs WHERE qs.donor = :donor";
            Query<QualificationStep> query = session.createQuery(hql, QualificationStep.class);
            Donor donor = new Donor();
            donor.setDonorId(952);
            //donor is an en
            query.setParameter("donor", donor);
            var qs = query.getResultList();
            qs.forEach(qualificationStep -> System.out.println(qualificationStep.toString()));
            transaction.commit();
            transaction = session.beginTransaction();

            //Querying the donor with ID 502 and fetching all qualification steps (Cascade.ALL)

            String fullDonor = "SELECT d FROM Donor d WHERE d.donorId = :donorId" ;
            Query<Donor> donorQuery = session.createQuery(fullDonor, Donor.class);
            donorQuery.setParameter("donorId", 952);
            Donor donor1 = donorQuery.getSingleResult();
            System.out.println(donor1.toString());
            donor1.getQualificationSteps().forEach(qualificationStep -> System.out.println(qualificationStep.toString()));

            //DonorQualificationStepDTO dqs = new DonorQualificationStepDTO();
            //donor1.getQualificationSteps().forEach(qualificationStep -> { });
            //dqs.setFirstName(donor1.getFirstName());
            //dqs.setStepNumber(donor1.);


            String hql2 = "SELECT d FROM Donor d JOIN FETCH d.qualificationSteps WHERE d.donorId = :donorId";
            Donor donor2 = session.createQuery(hql2, Donor.class)
                    .setParameter("donorId", 952)
                    .getSingleResult();
            System.out.println(donor2);

            Donor donor3 = session.get(Donor.class, 952);
            System.out.println(donor3);

            //String hql3 = "SELECT d FROM Donor d JOIN FETCH d.qualificationSteps WHERE d.donorId = :donorId";
            //Donor donor4 = session.get(Don)

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ServiceException("Failed to get the donor step", e);
        } finally {
            session.close();
        }
    }
}
