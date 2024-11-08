package data.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "MetaData")
public class MetaData {

    @Id
    @GeneratedValue
    @Column(name= "SubStepID")
    private int subStepID;

    @Column(name = "isCompleted")
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "QualificationStepID")
    private QualificationStep qualificationStep;

    @ManyToOne
    @JoinColumn(name= "TemplateID")
    private MetaDataTemplate metaDataTemplate;

    //Empty Constructor
    public MetaData(){}
    //Full Constructor, minus substepID
    public MetaData( boolean isCompleted, QualificationStep qualificationStep, MetaDataTemplate metaDataTemplate){
        this.isCompleted = isCompleted;
        this.qualificationStep = qualificationStep;
        this.metaDataTemplate = metaDataTemplate;
    }

    public int getSubStepID(){
        return subStepID;
    }
    public void setSubStepID(int subStepID){
        this.subStepID =   subStepID;
    }

    public boolean getIsCompleted(){ return isCompleted;}

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public QualificationStep getQualificationStep() {
        return qualificationStep;
    }

    public void setQualificationStep(QualificationStep qualificationStep) {
        this.qualificationStep = qualificationStep;
    }

    public MetaDataTemplate getMetaDataTemplate() {
        return metaDataTemplate;
    }

    public void setMetaDataTemplate(MetaDataTemplate metaDataTemplate){
        this.metaDataTemplate = metaDataTemplate;

    }
}
