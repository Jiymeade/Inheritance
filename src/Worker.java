public class Worker extends Person {
    private double hourlyRate;
    public Worker(String ID, String firstName, String lastName, String title, int YOB, double hourlyRate) {
        super(ID, firstName, lastName, title, YOB);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculateWeeklyRate(double hoursWorked) {
        double regularHours = Math.min(40,  hoursWorked);
        double overtimeHours = Math.max(0,  hoursWorked - 40);
        double regularPay = regularHours * hourlyRate;
        double overtimePay = overtimeHours * hourlyRate * 1.5;
        return regularPay + overtimePay;
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40,  hoursWorked);
        double overtimeHours = Math.max(0,  hoursWorked - 40);
        double regularPay = regularHours * hourlyRate;
        double overtimePay = overtimeHours * hourlyRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.printf("Regular Hours: %.2f hrs @ $%.2f = $%.2f%n", regularHours, hourlyRate, regularPay);
        System.out.printf("Overtime Hours: %.2f hrs @ $%.2f = $%.2f%n", overtimeHours, hourlyRate * 1.5, overtimePay);
        System.out.printf("Total Pay: $%.2f%n", totalPay);
    }


    @Override
    public String toString() {
        return super.toString() + "Worker{" + "hourlyRate=" + hourlyRate + '}';
    }

    @Override
    public String toCSVDataRecord(){
        return super.toCSVDataRecord() + "," + hourlyRate;
    }



    @Override
    public String toJSON(){
        return "{\n" +
                "\"ID\": \"" + getID() + "\",\n" +
                "\"firstName\": \"" + getFirstname() + "\",\n" +
                "\"lastName\": \"" + getLastName() + "\",\n" +
                "\"title\": \"" + getTitle() + "\",\n" +
                "\"yob\": " + getYob() + ",\n" +
                "\"hourlyRate\": " + getHourlyRate() + "\n" +
                "}";
    }
    public String toXML(){
        return "<Worker>" +
                "<ID>" + this.getID() + "</ID>" +
                "<firstName>" + this.getFirstname() + "</firstName>" +
                "<lastName>" + this.getLastName() + "</lastName>" +
                "<title>" + this.getTitle() + "</title>" +
                "<YOB>" + this.getYob() + "</YOB>" +
                "<hourlyRate>" + this.getHourlyRate() + "</hourlyRate>" +
                "</Worker>";
    }


}
