public abstract class Faculty extends Person {

    private double salary;

    private int dateOfHire;

    private boolean isWorkingHere;

    private long employeeID;

    public Faculty(String firstName, String lastName, int age, String emailAddress, long phoneNumber, double salary, int dateOfHire, boolean isWorkingHere, long employeeID) {
        super(firstName, lastName, age, emailAddress, phoneNumber);
        this.salary = salary;
        this.dateOfHire = dateOfHire;
        this.isWorkingHere = isWorkingHere;
        this.employeeID = employeeID;
    }
    public Faculty() {
        super();
        this.salary = 0;
        this.dateOfHire = 0;
        this.isWorkingHere = false;
        this.employeeID = 0;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws IllegalArgumentException {
        if(salary < 0)
        {
            throw new IllegalArgumentException();
        }
        this.salary = salary;
    }

    public int getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(int dateOfHire) throws IllegalArgumentException
    {
        this.dateOfHire = dateOfHire;
    }

    public boolean isWorkingHere() {
        return isWorkingHere;
    }

    public void setWorkingHere(boolean workingHere) {
        isWorkingHere = workingHere;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) throws IllegalArgumentException {
        if(employeeID < 100000 || employeeID > 999999)
        {
            throw new IllegalArgumentException();
        }
        this.employeeID = employeeID;
    }
}
