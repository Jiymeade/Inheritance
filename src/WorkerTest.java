import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
private Worker worker;

@BeforeEach
void setUp() {
    worker = new Worker("10000", "Malisa", "Rain", "Ms.", 1995, 20.0);

}

@Test
    void testCalculateWeeklyPayUnder40Hours() {
    double hoursWorked = 35.0;
    double expectedPay = 35.0 * 20.0;
    assertEquals(expectedPay, worker.calculateWeeklyRate(hoursWorked), 0.001);
}

@Test
    void testCalculateWeeklyPayExactly40Hours() {
    double hoursWorked = 40.0;
    double expectedPay = 40.0 * 20.0;
    assertEquals(expectedPay, worker.calculateWeeklyRate(hoursWorked), 0.001);
}

@Test
    void testCalculateWeeklyPayOvertime() {
    double hoursWorked = 45.0;
    double expectedPay = (40.0 * 20.0) + (5.0 * 20.0 * 1.5);
    assertEquals(expectedPay, worker.calculateWeeklyRate(hoursWorked), 0.001);
}
@Test
    void testtoCVSDataRecord(){
    String expected = "10000,Malisa,Rain,Ms.,1995,20.0";
    assertEquals(expected, worker.toCSVDataRecord());
}

@Test
    void testtoJSON(){
    String expected = """
            {
            "ID": "10000",
            "firstName": "Malisa",
            "lastName": "Rain",
            "title": "Ms.",
            "yob": 1995,
            "hourlyRate": 20.0
            }""";
            assertEquals(expected, worker.toJSON());
}
@Test
    void testtoXML(){
    String expected = """
            <Worker>
        <ID>10000</ID>
        <firstName>Malisa</firstName>
        <lastName>Rain</lastName>
        <title>Ms.</title>
        <yob>1995</yob>
        <hourlyRate>20.0</hourlyRate>
        </Worker>
    """;
    }

}