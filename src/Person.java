import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Person {
    public static void main(String[] args)
    {

    }
    private String ID;
    private String firstname;
    private String lastName;
    private String title;
    private int yob;


    public Person(String ID, String firstname, String lastname, String title, int yob){
            this.ID = ID;
            this.firstname = firstname;
            this.lastName = lastname;
            this.title = title;
            this.yob = yob;
        }

        public String toString () {
            return ID + " " + firstname + " " + lastName + " " + title + " " + yob;
        }

        public String getID () {
            return ID;
        }
        public void setID (String ID){
            this.ID = ID;
        }
        public String getFirstname () {
            return firstname;
        }
        public void setFirstname (String firstname){
            this.firstname = firstname;
        }
        public String getLastName () {
            return lastName;
        }
        public void setLastName (String lastName){
            this.lastName = lastName;
        }
        public String getTitle () {
            return title;
        }
        public void setTitle (String title){
            this.title = title;
        }
        public void setYob ( int yob){
            this.yob = yob;
        }
        public int getYob () {
            return yob;
        }
        public String year(){
        int currentYear = LocalDate.now().getYear();
            return getAge();
        }


        public String fullName () {
            return firstname + " " + lastName;
        }
        public String formalName () {
            return title + " " + fullName();
        }

        public String getAge () {
            int currentYear = LocalDate.now().getYear();
            return getAge(currentYear);
        }

        public String getAge ( int year){
            int age = year - yob;
            return String.valueOf(age);
        }


        public String toCSVDataRecord () {
            return ID + "," + firstname + "," + lastName + "," + title + "," + yob;
        }

        public String toJSON () {
            return "{\n" +
                    "\"ID\": \"" + ID + "\",\n" +
                    "\"firstname\": \"" + firstname + "\",\n" +
                    "\"lastName\": \"" + lastName + "\",\n" +
                    "\"title\": \"" + title + "\",\n" +
                    "\"yob\": " + yob + "\n" +
                    "}";
        }

        public String toXML () {
            return "<Person>\n" +
                    "  <ID>" + ID + "</ID>\n" +
                    "  <Firstname>" + firstname + "</Firstname>\n" +
                    "  <LastName>" + lastName + "</LastName>\n" +
                    "  <Title>" + title + "</Title>\n" +
                    "  <YOB>" + yob + "</YOB>\n" +
                    "</Person>";
        }


        @Override

        public boolean equals (Object o){
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return yob == person.yob && Objects.equals(ID, person.ID) && Objects.equals(firstname, person.firstname) && Objects.equals(lastName, person.lastName);
        }


        @Override
        public int hashCode () {
            return Objects.hash(ID, firstname, lastName, title, yob);
        }
    }

