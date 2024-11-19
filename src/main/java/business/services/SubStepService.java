package business.services;
import business.DTOs.DonorQualificationStepDTO;
import business.DTOs.DonorQualificationSubStepDTO;
import data.HibernateController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
public class SubStepService {
    private HibernateController hibernateController =
            new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
    private SessionFactory sessionFactory = hibernateController.getSessionFactory();
/*

    // Fetch current substeps on a qualfificationstep
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
