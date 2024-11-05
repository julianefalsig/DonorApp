package business.services;
import business.DTOs.DonorQualificationStepDTO;
import data.HibernateController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QualificationStepService {
    private HibernateController hibernateController =
            new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
    private SessionFactory sessionFactory = hibernateController.getSessionFactory();

    // Fetch current Qualification step by donorID
    public List<DonorQualificationStepDTO> getQualificationStepOnDonor(int donorId) {
        Session session = sessionFactory.openSession();
        List<DonorQualificationStepDTO> qualificationStepOnDonor = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT new business.DTOs.DonorQualificationStepDTO(d.firstName, q.stepNumber, q.title, q.isCompleted) " +
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