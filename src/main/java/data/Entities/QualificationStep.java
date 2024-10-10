package data.Entities;

import data.Entities.Donor;
import data.Entities.MetaData;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "QualificationStep")
public class QualificationStep {
    @Id
    @GeneratedValue
    @Column(name = "QualificationStepID")
    private int qualificationStepID;

    @Column(name = "StepNumber")
    private int stepNumber;

    @Column(name = "Title")
    private String title;

    @ManyToOne
    @JoinColumn (name = "DonorID")
    private Donor donor;

   /* @OneToMany (mappedBy = "qualificationStep")
    private List<MetaData> metaData;
                                         */
    //Get&Set
    public int getQualificationStepID(){
        return qualificationStepID;
    }

    public void setQualificationStepID(int qualificationStepID){
        this.qualificationStepID = qualificationStepID;
    }

    public int getStepNumber(){
        return stepNumber;
    }

    public void setStepNumber(int stepNumber){
        this.stepNumber = stepNumber;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    //no-argument constructor
    public QualificationStep(){}

    //constructor
    public QualificationStep(int qualificationStepID, int stepNumber, String title, Donor donor){
        this.qualificationStepID =qualificationStepID;
        this.stepNumber = stepNumber;
        this.title = title;
        this.donor = donor;
    }

}
