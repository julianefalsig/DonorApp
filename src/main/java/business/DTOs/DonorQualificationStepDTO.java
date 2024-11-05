package business.DTOs;

public class DonorQualificationStepDTO {

    private String firstName;
    private int currentStep;
    private String stepTitle;

    private boolean Completed;

    public DonorQualificationStepDTO(String firstName, int currentStep, String stepTitle, boolean Completed){
        this.firstName = firstName;
        this.currentStep = currentStep;
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

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
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
                ", currentStep=" + currentStep +
                ", stepTitle='" + stepTitle + '\'' +
                ", Completed='" + Completed + '\'' +
                '}';
    }
}
