package business.services.testServices;
import business.DTOs.DonorQualificationStepDTO;
import business.DTOs.DonorQualificationSubStepDTO;
import data.HibernateController;
import data.entities.Donor;
import data.entities.MetaData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.stream.Collectors;

public class SubStepService {

    // V. 2   Fetch current substeps on a qualfificationstep not using the DonorQualificationSubStepDTO
    HibernateController hibernateController =
            new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
    SessionFactory sessionFactory = hibernateController.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = null;

    //public List<MetaData> getSubstepsOnDonor()
/*
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
    }*/

/*
    // V. 1   Fetch current substeps on a qualfificationstep
    public List<DonorQualificationSubStepDTO> getSubStepsOnId(int qualificationStepID) {
        Session session = sessionFactory.openSession();
        List<DonorQualificationSubStepDTO> QualificationSubStep = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT new business.DTOs.DonorQualificationSubStepDTO(mdt.infoText, md.isCompleted) " +
                    "FROM MetaData md JOIN MetaDataTemplate mdt ON md.metaDataTemplate = mdt.templateID WHERE md.qualificationStep = :qualificationStepID";

            Query<DonorQualificationSubStepDTO> query = session.createQuery(hql, business.DTOs.DonorQualificationSubStepDTO.class);
            query.setParameter("qualificationStepID", qualificationStepID);
            QualificationSubStep = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ServiceException("Failed to get the substep information", e);
        } finally {
            session.close();
        }
        return QualificationSubStep;
    }
*/
}
