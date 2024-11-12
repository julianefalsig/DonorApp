package data.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "MetaDataTemplate")
public class MetaDataTemplate {
    @Id
    @GeneratedValue
    @Column(name= "TemplateID")
    private int templateID;

    @Column(name= "InfoText")
    private String infoText;

    @OneToMany(mappedBy = "metaDataTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MetaData> metaDataList;

    public MetaDataTemplate(){}

    // Argument constructor
    public MetaDataTemplate(String infoText) {
        this.infoText = infoText;
    }

    public MetaDataTemplate(int ID, String infoText){
        this.templateID =ID;
        this.infoText = infoText;
    }

    // Getter and Setter for templateID
    public int getTemplateID() {
        return templateID;
    }

    public void setTemplateID(int templateID) {
        this.templateID = templateID;
    }

    // Getter and Setter for infoText
    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    // Getter and Setter for metaDataList
    public List<MetaData> getMetaDataList() {
        return metaDataList;
    }

    public void setMetaDataList(List<MetaData> metaDataList) {
        this.metaDataList = metaDataList;
    }
}

