package data.entities;
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
    @OneToMany (mappedBy = "donor", cascade = CascadeType.ALL, orphanRemoval = true) //delete on cascade --> id a donor is deleted, its related qualificationsteps will be deleted
    private List<QualificationStep> qualificationSteps;

    //No-argument constructor required for Hibernate to work
    public Donor() {}

    //Constructor - only first name reqired, give flexibility to associate qual-steps at any time
    public Donor( String firstName) {
        this.firstName = firstName;
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
