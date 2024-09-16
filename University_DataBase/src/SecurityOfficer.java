public class SecurityOfficer extends Faculty {
    private String rank;

    public SecurityOfficer(String firstName, String lastName, int age, String emailAddress, long phoneNumber, double salary, int dateOfHire, boolean isWorkingHere, long employeeID, String rank) {
        super(firstName, lastName, age, emailAddress, phoneNumber, salary, dateOfHire, isWorkingHere, employeeID);
        this.rank = rank;
    }

    public SecurityOfficer() {

        this.rank = "rank";
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        if (rank.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.rank = rank;
    }


    @Override
    public String toString() {
        return "SecurityOfficer," + this.getFirstName() + "," + this.getLastName() + "," + this.getAge() + "," + this.getEmailAddress() + "," + this.getPhoneNumber() + "," + this.getSalary()
                + "," + this.getDateOfHire() + "," + this.isWorkingHere() + "," + this.getEmployeeID() + "," + rank;
    }
}
