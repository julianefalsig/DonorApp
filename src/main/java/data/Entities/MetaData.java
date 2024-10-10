package data.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class MetaData {

    @Id
    @GeneratedValue
    @Column(name= "SubStepID")
    private int subStepID;
    private String infoText;
    private QualificationStep qualificationStep;


}
