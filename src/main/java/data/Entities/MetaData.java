package data.Entities;

import jakarta.persistence.*;

@Entity
@Table (name = "MetaData")
public class MetaData {

    @Id
    @GeneratedValue
    @Column(name= "SubStepID")
    private int subStepID;
    @Column(name = "InfoText")
    private String infoText;

    @Column(name = "Completed")
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "QualificationStepID")
    private QualificationStep qualificationStep;

    //Empty Constructor
    public MetaData(){}
    //Full Constructor, minus substepID
    public MetaData(String infoText, boolean completed, QualificationStep qualificationStep){
        this.infoText = infoText;
        this.completed = completed;
        this.qualificationStep = qualificationStep;
    }

    public int getSubStepID(){
        return subStepID;
    }
    public void setSubStepID(int subStepID){
        this.subStepID =   subStepID;
    }

    public String getInfoText(){
        return infoText;
    }

    public void setInfoText(String infoText){
        this.infoText = infoText;
    }

    public boolean getCompleted(){ return completed;}

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public QualificationStep getQualificationStep() {
        return qualificationStep;
    }

    public void setQualificationStep(QualificationStep qualificationStep) {
        this.qualificationStep = qualificationStep;
    }
}
