public class Professor extends Faculty {
    private String department;

    public Professor(String firstName, String lastName, int age, String emailAddress, long phoneNumber, double salary, int dateOfHire, boolean isWorkingHere, long employeeID, String department) {
        super(firstName, lastName, age, emailAddress, phoneNumber, salary, dateOfHire, isWorkingHere, employeeID);
        this.department = department;
    }

    public Professor() {
        this.department = "";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) throws IllegalArgumentException {
        if (department.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.department = department;
    }

    @Override
    public String toString() {
        return "Professor," + this.getFirstName() + "," + this.getLastName() + "," + this.getAge() + "," + this.getEmailAddress() + "," + this.getPhoneNumber() + "," + this.getSalary()
                + "," + this.getDateOfHire() + "," + this.isWorkingHere() + "," + this.getEmployeeID() + "," + department;
    }
}
