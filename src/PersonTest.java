import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    Person p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Person("000001", "Juno", "Smith", "Ms.", 2000);
        p2 = new Person("000002", "Carlos", "Diaz", "Mr.", 1998);
        p3 = new Person("000003", "Jane", "Doe", "Ms.", 1999);
    }

    @Test
    void testFullName() {
        assertEquals("Juno Smith", p1.fullName());
        assertEquals("Carlos Diaz", p2.fullName());
        assertEquals("Jane Doe", p3.fullName());
    }
    @Test
    void testFormalName() {
        assertEquals("Ms. Juno Smith", p1.formalName());
        assertEquals("Mr. Carlos Diaz", p2.formalName());
        assertEquals("Ms. Jane Doe", p3.formalName());
    }

    @Test
    void testSetters(){
        p1.setID("000001");
        p1.setFirstname("Juno");
        p1.setLastName("Smith");
        p1.setYob(2000);


        assertEquals("Juno Smith", p1.fullName());
        assertEquals("Ms. Juno Smith", p1.formalName());
        assertEquals(2000, p1.getYob());


    }

    @Test
    void testGetAgeCurrentYear(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int expectedAge = currentYear-p1.getYob();
        assertEquals(String.valueOf(expectedAge), p1.getAge());
    }
    @Test
    void testGetAgeSpecificYear(){
        assertEquals("25", p1.getAge(2025));
        assertEquals("27", p2.getAge(2025));
    }

    @Test
    void testToCSV(){
        String expected = "000001,Juno,Smith,Ms.,2000";
        assertEquals(expected, p1.toCSVDataRecord());
    }

    @Test
    void testToJSON(){
        String expected = """
                          {
                          "ID": "000001",
                          "firstname": "Juno",
                          "lastName": "Smith",
                          "title": "Ms.",
                          "yob": 2000
                          }""";
        assertEquals(expected, p1.toJSON());


    }

    @Test
    void testToXML(){
        String expected = """
                <Person>
                  <ID>000001</ID>
                  <Firstname>Juno</Firstname>
                  <LastName>Smith</LastName>
                  <Title>Ms.</Title>
                  <YOB>2000</YOB>
                </Person>""";
        assertEquals(expected, p1.toXML());
    }
}
