package business.DTOs;

public class DonorQualificationStepDTO {

    private String firstName;
    private int currentStep;
    private String stepTitle;

    private boolean completed;

    public DonorQualificationStepDTO(String firstName, int currentStep, String stepTitle, boolean completed){
        this.firstName = firstName;
        this.currentStep = currentStep;
        this.stepTitle = stepTitle;
        this.completed = completed;
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

    public boolean getCompleted(){ return completed;}

    public void setCompleted(boolean completed){ this.completed = completed;}

    @Override
    public String toString() {
        return "DonorQualificationStepDTO{" +
                "firstName='" + firstName + '\'' +
                ", currentStep=" + currentStep +
                ", stepTitle='" + stepTitle + '\'' +
                ", isCompleted='" + completed + '\'' +
                '}';
    }
}
