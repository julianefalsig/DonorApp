package data.Entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Donor")
public class Donor {
    //Attributes
    @Id
    @GeneratedValue
    @Column(name= "DonorID")
    private int donorId;
    @Column(name = "FirstName")
    private String firstName;
    @OneToMany (mappedBy = "donor")
    private List<QualificationStep> qualificationSteps;

    //No-argument constructor required for Hibernate to work
    public Donor() {}

    //Constructor
    public Donor( String firstName, List<QualificationStep> qualificationSteps) {
        this.firstName = firstName;
        this.qualificationSteps = qualificationSteps;
    }

    //getters and setters
    public int getDonorId(){
        return donorId;
    }

    public void setDonorId(int donorId){
        this.donorId = donorId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public List<QualificationStep> getQualificationSteps() {
        return qualificationSteps;
    }

    public void setQualificationSteps(List<QualificationStep> qualificationSteps) {
        this.qualificationSteps = qualificationSteps;
    }


}
