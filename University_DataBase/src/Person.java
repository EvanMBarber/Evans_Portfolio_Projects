public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String emailAddress;
    private long phoneNumber;

    Person(String firstName, String lastName, int age, String emailAddress, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    Person() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.emailAddress = "";
        this.phoneNumber = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName.length() == 0) {
            throw new IllegalArgumentException();
        }

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName.length() == 0) {
            throw new IllegalArgumentException();
        }

        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException();
        }

        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) throws IllegalArgumentException {
        if (emailAddress.length() == 0) {
            throw new IllegalArgumentException();
        }

        this.emailAddress = emailAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) throws IllegalArgumentException {
        if (phoneNumber < 1000000000L || phoneNumber > 9999999999L) // must be a 10 digit number
        {
            throw new IllegalArgumentException();
        }

        this.phoneNumber = phoneNumber;

    }

    public abstract String toString();
}
