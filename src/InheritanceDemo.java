import javax.naming.Name;
import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        Worker w1 = new Worker("W001", "Jane", "Doe", "Ms.", 1990, 20.0);
        Worker w2 = new Worker("W002", "John", "Doe", "Mr.", 1990, 22.5);
        Worker w3 = new Worker("W003", "Mary", "Doe", "Ms.", 2002, 18.75);

        SalaryWorker sw1 = new SalaryWorker("SW010", "Happy", "Holly", "Dr.", 1998,30.0, 78000);
        SalaryWorker sw2 = new SalaryWorker("SW011", "Bruce", "Lee", "Fighter", 1975, 32.5, 85000);
        SalaryWorker sw3 = new SalaryWorker("SW012", "Marshall", "Lee", "Prof.", 1988, 28.0, 72000);

        ArrayList<Worker> allWorkers = new ArrayList<>();
        allWorkers.add(w1);
        allWorkers.add(w2);
        allWorkers.add(w3);
        allWorkers.add(sw1);
        allWorkers.add(sw2);
        allWorkers.add(sw3);

        double[] weeklyHours = {40,50,40};

        for(int week=0;week<3;week++){
            double hours = weeklyHours[week];
            System.out.println("----------------------------------------------------------------");
            System.out.println("Week" + (week+1) + "Pay Report");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-10s %-5s%n", "Name", "Type", "Weekly Pay");
            System.out.println("-------------------------------------------------------------------");

            for(Worker w : allWorkers){
                String Name = w.formalName();
                String Type =  (w instanceof SalaryWorker) ? "Salary" : "Hourly";
                double Pay = w.calculateWeeklyRate(hours);
                System.out.printf("%-20s %-15s $%-14.2f%n", Name, Type, Pay);

            }
            System.out.println();

        }

    }
}
