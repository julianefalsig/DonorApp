package business.DTOs;

public class DonorQualificationStepDTO {

    private String firstName;
    private int currentStep;
    private String stepTitle;

    public DonorQualificationStepDTO(String firstName, int currentStep, String stepTitle){
        this.firstName = firstName;
        this.currentStep = currentStep;
        this.stepTitle = stepTitle;
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

    @Override
    public String toString() {
        return "DonorQualificationStepDTO{" +
                "firstName='" + firstName + '\'' +
                ", currentStep=" + currentStep +
                ", stepTitle='" + stepTitle + '\'' +
                '}';
    }
}
