package business.services;
import business.DTOs.DonorQualificationStepDTO;
import data.HibernateController;
import data.entities.Donor;
import data.entities.QualificationStep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class QualificationStepService {
    private HibernateController hibernateController =
            new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
    private SessionFactory sessionFactory = hibernateController.getSessionFactory();

    public List<DonorQualificationStepDTO> getQualificationStepOnDonor(int donorId) {
        Session session = sessionFactory.openSession();
        List<DonorQualificationStepDTO> qualificationStepDTOs = null;
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Fetch the Donor along with their QualificationSteps
            String hql = "SELECT d FROM Donor d LEFT JOIN FETCH d.qualificationSteps WHERE d.donorId = :donorId";
            Query<Donor> donorQuery = session.createQuery(hql, Donor.class);
            donorQuery.setParameter("donorId", donorId);
            Donor donor = donorQuery.getSingleResult();

            // Map QualificationStep entities to DonorQualificationStepDTO
            qualificationStepDTOs = donor.getQualificationSteps().stream()
                    .map(step -> new DonorQualificationStepDTO(
                            donor.getFirstName(),
                            step.getStepNumber(),
                            step.getTitle(),
                            step.getIsCompleted()))
                    .collect(Collectors.toList());

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ServiceException("Failed to get the donor qualification steps", e);
        } finally {
            session.close();
        }

        return qualificationStepDTOs;
    }

/*
    ///// V. 2 new get qualificationstep attempt /////////////

    public List<QualificationStep> getQualificationStepOnDonor(int donorId) {
        Session session = sessionFactory.openSession();
        List<QualificationStep> qualificationStepOnDonor = null;
        Transaction transaction = null;


        try {
            transaction = session.beginTransaction();
            String fullDonor = "SELECT d FROM Donor d WHERE d.donorId = :donorId" ;
            Query<Donor> donorQuery = session.createQuery(fullDonor, Donor.class);
            donorQuery.setParameter("donorId", donorId);
            Donor donor1 = donorQuery.getSingleResult();
            System.out.println(donor1.toString());
            qualificationStepOnDonor = donor1.getQualificationSteps();
            donor1.getQualificationSteps().forEach(qualificationStep -> {
                System.out.println(qualificationStep.toString());}
            );
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
*/
/*    ////////// v. 1  Fetch current Qualification step by donorID/////////
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
    }*/
}