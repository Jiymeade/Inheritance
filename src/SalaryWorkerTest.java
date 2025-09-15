import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {
    SalaryWorker salaryWorker;

    @BeforeEach
    void setUp () {
        salaryWorker = new SalaryWorker("20001", "Bella", "Swan", "Dr.",1998, 30.0,  52000.0);
    }
@Test
    void testCalculateWeeklyPay () {
        double expectedWeeklyPay = 52000.0 / 52;
        assertEquals(expectedWeeklyPay, salaryWorker.calculateWeeklyPay(40.0), 0.001);
}
@Test
    void testtoCSVDataRecord () {
        String expected = "20001,Bella,Swan,Dr.,1998,30.0,52000.0";
        assertEquals(expected, salaryWorker.toCSVDataRecord());
}
@Test
    void testtoJSON(){
    String expected = """
            {
            "ID": "20001",
            "firstName": "Bella",
            "lastName": "Swan",
            "title": "Dr.",
            "yob": 1998,
            "hourlyRate": 30.0,
            "annualsalary": 52000.0,
            }""";
    assertEquals(expected, salaryWorker.toJSON());

}
@Test
    void testtoXML(){
    String expected = """
            <SalaryWorker>
        <ID>20001</ID>
        <firstName>Bella</firstName>
        <lastName>Swan</lastName>
        <title>Dr.</title>
        <yob>1998</yob>
        <hourlyRate>30.0</hourlyRate>
        <annualSalary>52000.0</annualSalary>
        </SalaryWorker>
        """.formatted(salaryWorker.toXML());
}

}