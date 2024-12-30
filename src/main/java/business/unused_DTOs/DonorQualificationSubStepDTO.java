package business.unused_DTOs;
//Class created for fetching the Substep data for the donor

/// ---- INACTIVE CLASS ---- \\\\\

public class DonorQualificationSubStepDTO {
    private String infoText;
    private boolean isCompleted;

    public DonorQualificationSubStepDTO(){}
    public DonorQualificationSubStepDTO(String infoText, boolean isCompleted){
        this.infoText = infoText;
        this.isCompleted = isCompleted;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public boolean getIsCompleted(){
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

    public String toString(){
        return "DonorQualificationSubStepDTO{" +
                "Info Text='" + infoText + '\'' +
                ", Completed='" + isCompleted + '\'' +
                '}';
    }
}
