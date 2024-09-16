import java.util.*;

public class Main {

    public static void main(String[] args)
    {



        University uncc = new University();

        Scanner scnr = new Scanner(System.in);

        boolean programActive = true;

        while (programActive == true)
        {

            String choice = "";
            int menu_id = 1;

            while(menu_id == 1)
            {
                scnr = new Scanner(System.in);
                System.out.println("What would you like to do?\nnew student\nnew professor\nnew technician\nnew security officer\nlist all persons\nloadfile\nsavefile\nexit");
                choice = scnr.nextLine();
                switch (choice)
                {
                    case "new student": {
                       // System.out.println("you chose new student");
                        menu_id = 2;
                        break;
                    }
                    case "new professor":{
                        menu_id = 3;
                        break;
                    }
                    case "new technician":{
                        menu_id = 4;
                        break;
                    }
                    case "new security officer":{
                        menu_id = 5;
                        break;
                    }
                    case"list all persons":{
                        ArrayList<Person> list = uncc.getListOfPeople();
                        for(Person p: list)
                        {
                            System.out.println(p.toString());
                        }
                        System.out.println("done! \n");
                        break;
                    }
                    case"delete person": {
                        System.out.println("Please enter the id who you wish to remove or enter 0 to cancle: ");

                        boolean loopActive = true;
                        while (loopActive == true) {
                            try {
                                scnr = new Scanner(System.in);
                                long personToRemoveID = scnr.nextLong();
                                if (personToRemoveID == 0) // Condition to exit
                                {
                                    loopActive = false;
                                }
                                else {
                                    uncc.removePerson(personToRemoveID);
                                    loopActive = false;
                                }
                            }
                            catch (IllegalArgumentException e) {
                                System.out.println("entered ID was not found, please try again");

                            }

                        }
                        break;
                    }
                    case "savefile": {
                        System.out.println("Type in a file name (DO NOT INCLUDE EXTENSION): ");
                        scnr = new Scanner(System.in);
                        String fileNameToSave = scnr.nextLine();
                        uncc.saveFile(fileNameToSave);
                        break;
                    }
                    case "loadfile": {
                        System.out.println("Type in a file name (DO NOT INCLUDE EXTENSION): ");
                        scnr = new Scanner(System.in);
                        String fileNameToLoad = scnr.nextLine();
                        uncc.loadFile(fileNameToLoad);
                        break;
                    }
                    case "exit": {
                        System.out.println("closing...");
                        System.exit(0);
                    }
                    default: {
                        System.out.println("thats not an opion");
                        break;
                    }

                }
            }







            while (menu_id == 2) //Student creation process menus
            {
                boolean loopActive = true;
                Student pr = new Student();

                loopActive = true;
                while(loopActive == true) {
                    System.out.println("Enter first name");
                    try {
                        scnr = new Scanner(System.in);
                        String fName = scnr.nextLine();
                        pr.setFirstName(fName);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Name must not be blank, please try again");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter last name");
                    try {
                        scnr = new Scanner(System.in);
                        String lName = scnr.nextLine();
                        pr.setLastName(lName);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Name must not be blank, please try again");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter age");
                    try {
                        scnr = new Scanner(System.in);
                        int age = scnr.nextInt();
                        pr.setAge(age);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Age must not be negative");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You must enter a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter email");
                    try {
                        scnr = new Scanner(System.in);
                        String email = scnr.nextLine();
                        pr.setEmailAddress(email);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("email must not be blank, please try again");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter phonenumber ie 704XXXXXXX");
                    try {
                        scnr = new Scanner(System.in);
                        long phoneNumber = scnr.nextLong();
                        pr.setPhoneNumber(phoneNumber);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Phone numbers must be 10 digits");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You must enter a number/whole number");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter major");
                    try {
                        scnr = new Scanner(System.in);
                        String major = scnr.nextLine();
                        pr.setMajor(major);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("entry must not be blank");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter GPA");
                    try {
                        scnr = new Scanner(System.in);
                        double gpa = scnr.nextDouble();
                        pr.setGpa(gpa);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("gpa must be between 0.0 and 4.0");
                    }
                    catch(InputMismatchException e){
                        System.out.println("Entry must be a integer or decimal number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter Student ID, enter 0 if you don't have one and one will be created for you");
                    try {
                        scnr = new Scanner(System.in);
                        long id = scnr.nextLong();
                        if (id == 0){
                            pr.setStudentID(uncc.generateStudentID()); //Generating a Student ID
                            loopActive = false;
                        }
                        else
                        {
                            uncc.checkIDAvailability(id);
                            pr.setStudentID(id);
                            loopActive = false;
                        }

                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("ID is not proper length or was already taken");
                    }
                    catch(InputMismatchException e){
                        System.out.println("Entry must be a integer");
                    }
                }
                loopActive = true;
                while(loopActive == true) {

                    System.out.println("Enter amount of credits");
                    try {
                        scnr = new Scanner(System.in);
                        int credits = scnr.nextInt();
                        pr.setNumOfCredits(credits);
                        loopActive = false;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Entered number must not be negative");

                    } catch (InputMismatchException e) {
                        System.out.println("Entry must be ");

                    }
                }

                uncc.addPerson(pr); //adding finalized object
                System.out.println("Person added!");
                menu_id = 1; // returning to the main menu

            }
            while (menu_id == 3) //Professor creation process menu
            {
                boolean loopActive = true;
                Professor pr = new Professor();

                loopActive = true;
                while(loopActive == true) {
                    System.out.println("Enter first name");
                    try {
                        scnr = new Scanner(System.in);
                        String fName = scnr.nextLine();
                        pr.setFirstName(fName);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Name must not be blank, please try again");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter last name");
                    try {
                        scnr = new Scanner(System.in);
                        String lName = scnr.nextLine();
                        pr.setLastName(lName);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Name must not be blank, please try again");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter age");
                    try {
                        scnr = new Scanner(System.in);
                        int age = scnr.nextInt();
                        pr.setAge(age);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Age must not be negative");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You must enter a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter email");
                    try {
                        scnr = new Scanner(System.in);
                        String email = scnr.nextLine();
                        pr.setEmailAddress(email);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("email must not be blank, please try again");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter phonenumber ie 704XXXXXXX");
                    try {
                        scnr = new Scanner(System.in);
                        long phoneNumber = scnr.nextLong();
                        pr.setPhoneNumber(phoneNumber);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Phone numbers must be 10 digits");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You must enter a number/whole number");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter salary");
                    try {
                        scnr = new Scanner(System.in);
                        double salary = scnr.nextDouble();
                        pr.setSalary(salary);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("salary must not me a negative number");
                    }
                    catch(InputMismatchException e) {
                        System.out.println("amount must be a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter date hired (There's no calendar checker system so you can enter any number, preferably 8 digits");
                    try {
                        scnr = new Scanner(System.in);
                        int day = scnr.nextInt();
                        pr.setDateOfHire(day);
                        loopActive = false;
                    }
                    catch(InputMismatchException e) {
                        System.out.println("date must be a number");
                    }
                }

                while(loopActive == true)
                {

                    System.out.println("Is this person still working here? type: yes or no (I know its weird to be adding someone to the database when they are not. Like what, why even?)");

                        scnr = new Scanner(System.in);
                        String answer = scnr.nextLine();
                        switch (answer)
                        {
                            case "yes":
                            {
                                pr.setWorkingHere(true);
                                loopActive = false;
                            }
                            case "no":
                            {
                                pr.setWorkingHere(false);
                                loopActive = false;
                            }
                            default:
                            {
                                System.out.println("Not a proper answer");
                            }

                        }


                }
                loopActive = true;
                while(loopActive == true)
                {
                    System.out.println("Enter employee id, if you don't have one, press 0 and one will be created for you");
                    try {
                        scnr = new Scanner(System.in);
                        long id = scnr.nextLong();
                        if(id == 0)
                        {
                            pr.setEmployeeID(uncc.generateEmployeeID());
                            loopActive = false;
                        }
                        else {
                            uncc.checkIDAvailability(id);
                            pr.setEmployeeID(id);
                            loopActive = false;
                        }
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("number was either not 6 digits or it is taken");
                    }
                    catch(InputMismatchException e) {
                        System.out.println("ID must be a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter name of department");
                    try {
                        scnr = new Scanner(System.in);
                        String department = scnr.nextLine();
                        pr.setDepartment(department);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("entry must not be blank");
                    }
                }




                uncc.addPerson(pr); //adding finalized object
                System.out.println("Person added!");
                menu_id = 1; // returning to the main menu

            }
            while (menu_id == 4) //Technician creation process menu
            {
                boolean loopActive = true;
                Technician pr = new Technician();

                loopActive = true;
                while(loopActive == true) {
                    System.out.println("Enter first name");
                    try {
                        scnr = new Scanner(System.in);
                        String fName = scnr.nextLine();
                        pr.setFirstName(fName);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Name must not be blank, please try again");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter last name");
                    try {
                        scnr = new Scanner(System.in);
                        String lName = scnr.nextLine();
                        pr.setLastName(lName);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Name must not be blank, please try again");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter age");
                    try {
                        scnr = new Scanner(System.in);
                        int age = scnr.nextInt();
                        pr.setAge(age);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Age must not be negative");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You must enter a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter email");
                    try {
                        scnr = new Scanner(System.in);
                        String email = scnr.nextLine();
                        pr.setEmailAddress(email);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("email must not be blank, please try again");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter phonenumber ie 704XXXXXXX");
                    try {
                        scnr = new Scanner(System.in);
                        long phoneNumber = scnr.nextLong();
                        pr.setPhoneNumber(phoneNumber);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Phone numbers must be 10 digits");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You must enter a number/whole number");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter salary");
                    try {
                        scnr = new Scanner(System.in);
                        double salary = scnr.nextDouble();
                        pr.setSalary(salary);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("salary must not me a negative number");
                    }
                    catch(InputMismatchException e) {
                        System.out.println("amount must be a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter date hired (There's no calendar checker system so you can enter any number, preferably 8 digits");
                    try {
                        scnr = new Scanner(System.in);
                        int day = scnr.nextInt();
                        pr.setDateOfHire(day);
                        loopActive = false;
                    }
                    catch(InputMismatchException e) {
                        System.out.println("date must be a number");
                    }
                }

                while(loopActive == true)
                {

                    System.out.println("Is this person still working here? type: yes or no (I know its weird to be adding someone to the database when they are not. Like what, why even?)");

                    scnr = new Scanner(System.in);
                    String answer = scnr.nextLine();
                    switch (answer)
                    {
                        case "yes":
                        {
                            pr.setWorkingHere(true);
                            loopActive = false;
                        }
                        case "no":
                        {
                            pr.setWorkingHere(false);
                            loopActive = false;
                        }
                        default:
                        {
                            System.out.println("Not a proper answer");
                        }

                    }


                }
                loopActive = true;
                while(loopActive == true)
                {
                    System.out.println("Enter employee id, if you don't have one, press 0 and one will be created for you");
                    try {
                        scnr = new Scanner(System.in);
                        long id = scnr.nextLong();
                        if(id == 0)
                        {
                            pr.setEmployeeID(uncc.generateEmployeeID());
                            loopActive = false;
                        }
                        else {
                            uncc.checkIDAvailability(id);
                            pr.setEmployeeID(id);
                            loopActive = false;
                        }
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("number was either not 6 digits or it is taken");
                    }
                    catch(InputMismatchException e) {
                        System.out.println("ID must be a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter name of department");
                    try {
                        scnr = new Scanner(System.in);
                        String department = scnr.nextLine();
                        pr.setDepartment(department);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("entry must not be blank");
                    }
                }




                uncc.addPerson(pr); //adding finalized object
                System.out.println("Person added!");
                menu_id = 1; // returning to the main menu

            }
            while (menu_id == 5) //Security Officer creation process menu
            {
                boolean loopActive = true;
                SecurityOfficer pr = new SecurityOfficer();

                loopActive = true;
                while(loopActive == true) {
                    System.out.println("Enter first name");
                    try {
                        scnr = new Scanner(System.in);
                        String fName = scnr.nextLine();
                        pr.setFirstName(fName);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Name must not be blank, please try again");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter last name");
                    try {
                        scnr = new Scanner(System.in);
                        String lName = scnr.nextLine();
                        pr.setLastName(lName);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Name must not be blank, please try again");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter age");
                    try {
                        scnr = new Scanner(System.in);
                        int age = scnr.nextInt();
                        pr.setAge(age);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Age must not be negative");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You must enter a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter email");
                    try {
                        scnr = new Scanner(System.in);
                        String email = scnr.nextLine();
                        pr.setEmailAddress(email);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("email must not be blank, please try again");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter phonenumber ie 704XXXXXXX");
                    try {
                        scnr = new Scanner(System.in);
                        long phoneNumber = scnr.nextLong();
                        pr.setPhoneNumber(phoneNumber);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Phone numbers must be 10 digits");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("You must enter a number/whole number");
                    }
                }

                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter salary");
                    try {
                        scnr = new Scanner(System.in);
                        double salary = scnr.nextDouble();
                        pr.setSalary(salary);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("salary must not me a negative number");
                    }
                    catch(InputMismatchException e) {
                        System.out.println("amount must be a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter date hired (There's no calendar checker system so you can enter any number, preferably 8 digits");
                    try {
                        scnr = new Scanner(System.in);
                        int day = scnr.nextInt();
                        pr.setDateOfHire(day);
                        loopActive = false;
                    }
                    catch(InputMismatchException e) {
                        System.out.println("date must be a number");
                    }
                }

                while(loopActive == true)
                {

                    System.out.println("Is this person still working here? type: yes or no (I know its weird to be adding someone to the database when they are not. Like what, why even?)");

                    scnr = new Scanner(System.in);
                    String answer = scnr.nextLine();
                    switch (answer)
                    {
                        case "yes":
                        {
                            pr.setWorkingHere(true);
                            loopActive = false;
                        }
                        case "no":
                        {
                            pr.setWorkingHere(false);
                            loopActive = false;
                        }
                        default:
                        {
                            System.out.println("Not a proper answer");
                        }

                    }


                }
                loopActive = true;
                while(loopActive == true)
                {
                    System.out.println("Enter employee id, if you don't have one, press 0 and one will be created for you");
                    try {
                        scnr = new Scanner(System.in);
                        long id = scnr.nextLong();
                        if(id == 0)
                        {
                            pr.setEmployeeID(uncc.generateEmployeeID());
                            loopActive = false;
                        }
                        else {
                            uncc.checkIDAvailability(id);
                            pr.setEmployeeID(id);
                            loopActive = false;
                        }
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("number was either not 6 digits or it is taken");
                    }
                    catch(InputMismatchException e) {
                        System.out.println("ID must be a number");
                    }
                }
                loopActive = true;
                while(loopActive == true)
                {

                    System.out.println("Enter rank");
                    try {
                        scnr = new Scanner(System.in);
                        String rank = scnr.nextLine();
                        pr.setRank(rank);
                        loopActive = false;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("entry must not be blank");
                    }
                }




                uncc.addPerson(pr); //adding finalized object
                System.out.println("Person added!");
                menu_id = 1; // returning to the main menu

            }

        }

    }
}
