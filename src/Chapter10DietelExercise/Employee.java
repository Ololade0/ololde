package Chapter10DietelExercise;

public abstract class Employee {
    private String firstName;
    private  String lastName;
    private String socialSecurityNumber;

public Employee(String firstName,String lastName,String socialSecurityNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;

}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String toString(){
    return String.format("%s %s%n social security number: %s", getFirstName(),getLastName(), getSocialSecurityNumber());

    }

    public abstract double earnings();
}