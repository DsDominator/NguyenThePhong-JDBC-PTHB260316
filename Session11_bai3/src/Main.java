// Main.java
public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[2];

        employees[0] = new FullTimeEmployee(1, "Nguyen Van A", 15000000);
        employees[1] = new PartTimeEmployee(2, "Tran Van B", 80, 50000);

        for (Employee e : employees) {

            e.showInfo();

            System.out.println("Lương: " + e.calculateSalary());

            if (e instanceof BonusEligible) {

                BonusEligible b = (BonusEligible) e;

                System.out.println("Thưởng: " + b.calculateBonus());
            }

            System.out.println("-------------------");
        }
    }
}