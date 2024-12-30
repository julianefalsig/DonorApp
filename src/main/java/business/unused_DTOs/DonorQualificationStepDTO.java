package business.unused_DTOs;

//Class created for fetching the qualificationstep data for the donor

/// ---- INACTIVE CLASS ---- \\\\\

public class DonorQualificationStepDTO {

    private String firstName;
    private int stepNumber;
    private String stepTitle;

    private boolean Completed;

    public DonorQualificationStepDTO(String firstName, int stepNumber, String stepTitle, boolean Completed){
        this.firstName = firstName;
        this.stepNumber = stepNumber;
        this.stepTitle = stepTitle;
        this.Completed = Completed;
    }
    public DonorQualificationStepDTO(){

    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = DonorQualificationStepDTO.this.stepNumber;
    }

    public String getStepTitle() {
        return stepTitle;
    }

    public void setStepTitle(String stepTitle) {
        this.stepTitle = stepTitle;
    }

    public boolean getIsCompleted(){ return Completed;}

    public void setIsCompleted(boolean isCompleted){ this.Completed = Completed;}

    @Override
    public String toString() {
        return "DonorQualificationStepDTO{" +
                "firstName='" + firstName + '\'' +
                ", stepNumber=" + stepNumber + '\''+
                ", stepTitle='" + stepTitle + '\'' +
                ", Completed='" + Completed + '\'' +
                '}';
    }
}
