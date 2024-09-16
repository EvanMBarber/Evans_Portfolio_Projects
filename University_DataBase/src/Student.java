public class Student extends Person {
    private String major;

    private double gpa;

    private long studentID;

    private int numOfCredits;

    public Student(String firstName, String lastName, int age, String emailAddress, long phoneNumber, String major, double gpa, long studentID, int numOfCredits) {
        super(firstName, lastName, age, emailAddress, phoneNumber);
        this.major = major;
        this.gpa = gpa;
        this.studentID = studentID;
        this.numOfCredits = numOfCredits;
    }

    public Student() {
        super();
        this.major = "";
        this.gpa = 0.0;
        this.studentID = 0;
        this.numOfCredits = 0;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) throws IllegalArgumentException {
        if (major.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) throws IllegalArgumentException {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException();
        }

        this.gpa = gpa;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) throws IllegalArgumentException {
        if (studentID < 100000000000L || studentID > 999999999999L) {
            throw new IllegalArgumentException();
        }

        this.studentID = studentID;
    }

    public int getNumOfCredits() {
        return numOfCredits;
    }

    public void setNumOfCredits(int numOfCredits) throws IllegalArgumentException {
        if (numOfCredits < 0) {
            throw new IllegalArgumentException();
        }

        this.numOfCredits = numOfCredits;
    }


    @Override
    public String toString() {
        return "Student," + this.getFirstName() + "," + this.getLastName() + "," + this.getAge() + "," + this.getEmailAddress() + "," + this.getPhoneNumber() + ","
                + this.getMajor() + "," + this.getGpa() + "," + this.getStudentID() + "," + this.getNumOfCredits();
    }
}
