import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class University {

    private ArrayList<Person> persons = new ArrayList<>();


    public ArrayList<Person> getListOfPeople() {
        return persons;
    }
    public void setListOfPeople(ArrayList<Person> persons){
        this.persons = persons;
    }
    public void addPerson(Person p) {
        persons.add(p);
    }
    public void removePerson(long num) throws IllegalArgumentException{
        int currentIndex = 0;// so that we have an index number to use for add and remove
        for (Person p : persons) {
            if (p instanceof Student)
            {

                if (((Student)p).getStudentID() == num) {
                    persons.remove(currentIndex);
                    System.out.println("deletion successful");
                    return; // we need to break the loop once we find it, program gets mad if you edit arraylist during an for each looper iteration
                }
            }
            else if (p instanceof Faculty)
            {
                if(((Faculty) p).getEmployeeID() == num) //Cast to faculty so I can use method (didn't know I could do it this way. Thanks intellj)
                {
                    persons.remove(currentIndex);
                    System.out.println("deletion successful");
                    return;
                }
            }
            currentIndex++;
        }
        throw new IllegalArgumentException();

    }
    public void checkIDAvailability(long num) throws IllegalArgumentException
    {
        boolean idIsAvailable = true;
        for(Person p: persons)
        {
            if(p instanceof Student)
            {
                if(((Student)p).getStudentID() == num)
                {
                    idIsAvailable = false;
                }

            }
            else if(p instanceof Faculty)
            {
                if(((Faculty)p).getEmployeeID() == num)
                {
                    idIsAvailable = false;
                }

            }
            if(!idIsAvailable)
            {
                throw new IllegalArgumentException("Duplicate or attempted to duplicate ID's numbers");
            }

        }

    }
    public long generateStudentID()
    {
        long id = (long)((Math.random() * 900000000000L) + 100000000000L); //generating Id between 1000000000 to 9999999999
        while(true){

            try {
                this.checkIDAvailability(id);
                return id;
            } catch (IllegalArgumentException e) {
                System.out.println("Unusable number, retrying....");
            }
        }

    }
    public long generateEmployeeID()
    {
        long id = (long)((Math.random() * 900000L) + 100000L); //generating Id between 1000000000 to 9999999999
        while(true){

            try {
                this.checkIDAvailability(id);
                return id;
            } catch (IllegalArgumentException e) {
                System.out.println("Unusable number, retrying....");
            }
        }

    }
    public void saveFile(String fileName)
    {
        String extension = ".CSV";
        try {
            FileOutputStream file = new FileOutputStream(fileName + extension);
            PrintWriter writer = new PrintWriter(file);

            for(Person p: persons)
            {
                writer.write(p.toString() + "\n");
            }
            writer.close();
            file.close();
            System.out.println("File saved!");
        }
        catch (IOException e)
        {
            System.out.println("Error occurred during saving progress");
        }
    }
    public void loadFile(String fileName) throws IllegalArgumentException
    {
        ArrayList<Person> temp = new ArrayList<>();
        ArrayList<Long> ids = new ArrayList<>();

        String extension = ".CSV";
        int fileline = 1;

        try{
            File file = new File(fileName + extension);
            Scanner scnr = new Scanner(file);
            //This is for keeping track of which line in the file the program is reading from, in case there is an error reading, it should tell you what line it stopped on.
            while(scnr.hasNext())
            {
                String[] line = scnr.nextLine().split(",");


                switch(line[0]){

                    case "Student":

                        if(ids.contains(Long.parseLong(line[8]))){
                            throw new IllegalArgumentException();
                        }
                        else{
                            temp.add(new Student(line[1],line[2],Integer.parseInt(line[3]),line[4], Long.parseLong(line[5]),line[6],Double.parseDouble(line[7]),Long.parseLong(line[8]),Integer.parseInt(line[9])));
                            ids.add(Long.parseLong(line[8])); //adding id to the list of taken ids
                            break;
                        }

                    case "Professor":
                        if(ids.contains(Long.parseLong(line[9]))){
                            throw new IllegalArgumentException();
                        }
                        else{
                            temp.add(new Professor(line[1],line[2],Integer.parseInt(line[3]),line[4], Long.parseLong(line[5]),Double.parseDouble(line[6]),Integer.parseInt(line[7]),Boolean.getBoolean(line[8])
                            ,Long.parseLong(line[9]),line[10]));

                            ids.add(Long.parseLong(line[9]));
                            break;
                        }
                    case "Technician":
                        if(ids.contains(Long.parseLong(line[9]))){
                            throw new IllegalArgumentException();
                        }
                        else{
                            temp.add(new Technician(line[1],line[2],Integer.parseInt(line[3]),line[4], Long.parseLong(line[5]),Double.parseDouble(line[6]),Integer.parseInt(line[7]),Boolean.getBoolean(line[8])
                                    ,Long.parseLong(line[9]), line[10],line[11]));

                            ids.add(Long.parseLong(line[9]));
                            break;
                        }

                    case "SecurityOfficer":
                        if(ids.contains(Long.parseLong(line[9]))){
                            throw new IllegalArgumentException();
                        }
                        else{
                            temp.add(new SecurityOfficer(line[1],line[2],Integer.parseInt(line[3]),line[4], Long.parseLong(line[5]),Double.parseDouble(line[6]),Integer.parseInt(line[7]),Boolean.getBoolean(line[8])
                                    ,Long.parseLong(line[9]), line[10]));

                            ids.add(Long.parseLong(line[9]));
                            break;
                        }

                }
                fileline++;

            }
            this.setListOfPeople(temp); //Overwriting our university list
            System.out.println("File loaded!");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Duplicate ID was found in CSV, file could not open");
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Error trying to instantiate entry on file line:" + fileline + " please make sure entries in CVS are correct. File not loaded" ) ;
        }




    }
}
