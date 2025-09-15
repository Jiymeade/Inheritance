public class SalaryWorker extends Worker {
private double annualsalary;

public SalaryWorker(String ID, String firstName, String lastName, String title, int yob, double hourlyRate, double annualsalary) {
super(ID, firstName, lastName, title, yob, hourlyRate);
this.annualsalary = annualsalary;
}

public double getAnnualsalary() {
return annualsalary;
}

public void setAnnualsalary(double annualsalary) {
    this.annualsalary = annualsalary;
}


public double calculateWeeklyPay(double hoursWorked) {
   return annualsalary / 52.0;
}
@Override
    public void displayWeeklyPay(double hoursWorked) {
    double weeklyPay = calculateWeeklyPay(hoursWorked);
    System.out.println("Pay Summary for " + formalName());
    System.out.printf("Annual Salary: $%.2f%n", annualsalary);
    System.out.printf("Weekly Pay (annual salary / 52): $%.2f%n", weeklyPay);

}

@Override
    public String toCSVDataRecord() {
    return super.toCSVDataRecord() + "," + annualsalary;
}

@Override
    public String toJSON() {
    return "{\n" +
            "\"ID\": \"" + getID() + "\",\n" +
            "\"firstName\": \"" + getFirstname() + "\",\n" +
            "\"lastName\": \"" + getLastName() + "\",\n" +
            "\"title\": \"" + getTitle() + "\",\n" +
            "\"yob\": " + getYob() + ",\n" +
            "\"hourlyRate\": " + getHourlyRate() + ",\n" +
            "\"annualsalary\": " + getAnnualsalary() + ",\n" +
            "}";

}
public String toXML(){
    return "<SalaryWorker>\n" +
            "<ID>" + this.getID() + "</ID>" +
            "<firstName>" + this.getFirstname() + "</firstName>" +
            "<lastName>" + this.getLastName() + "</lastName>" +
            "<title>" + this.getTitle() + "</title>" +
            "<YOB>" + this.getYob() + "</YOB>" +
            "<hourlyRate>" + this.getHourlyRate() + "</hourlyRate>" +
            "<AnnualSalary>" + this.getAnnualsalary() + "</AnnualSalary>" +
            "</SalaryWorker>";

}
}
