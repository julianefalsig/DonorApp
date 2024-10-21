package business.services;

import business.DTOs.DonorQualificationStepDTO;
import data.HibernateController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class DonorService {
    private HibernateController hibernateController =
            new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
    private SessionFactory sessionFactory = hibernateController.getSessionFactory();
    Transaction transaction = null;

    // Fetching the list of donors from the DB from column FirstName
    //this method has mostly been for testing, can be deleted later on
    public List<String> getAllDonors() {
        Session session = sessionFactory.openSession();
        List<String> donors = null;

        try {
            transaction = session.beginTransaction();
            String hql = "SELECT d.firstName FROM Donor d";
            Query<String> query = session.createQuery(hql, String.class);
            donors = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback the transaction if an error occurs
            }
            throw new ServiceException("Failed to fetch all donors", e);
        } finally {
            session.close();
        }
        return donors;
    }

    public List<DonorQualificationStepDTO> getQualificationStepOnDonor(int donorId) {
        Session session = sessionFactory.openSession();
        List<DonorQualificationStepDTO> qualificationStepOnDonor = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT new business.DTOs.DonorQualificationStepDTO(d.firstName, q.stepNumber, q.title) " +
                    "FROM Donor d JOIN QualificationStep q ON d.donorId = q.donor " +
                    "WHERE d.donorId = :donorId";
            Query<DonorQualificationStepDTO> query = session.createQuery(hql, DonorQualificationStepDTO.class);
            query.setParameter("donorId", donorId);
            qualificationStepOnDonor = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ServiceException("Failed to get the donor step", e);
        } finally {
            session.close();
        }
        return qualificationStepOnDonor;
    }


}
