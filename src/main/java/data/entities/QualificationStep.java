package data.entities;

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

    @OneToMany (mappedBy = "qualificationStep", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MetaData> metaDataList;

    //Empty constructor
    public QualificationStep(){}

    //Full constructor minus stepID
    public QualificationStep(int stepNumber, String title, Donor donor){
        this.stepNumber = stepNumber;
        this.title = title;
        this.donor = donor;
    }
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

    public Donor getDonor(){return donor;}

    public void setDonor(Donor donor){
        this.donor = donor;
    }

    public List<MetaData> getMetaDataList() {
        return metaDataList;
    }

    public void setMetaDataList(List<MetaData> metaDatalist){
         this.metaDataList = metaDataList;
    }

    public void addMetaData(MetaData metaData){
         metaData.setQualificationStep(this);
         this.metaDataList.add(metaData);
    }
}
