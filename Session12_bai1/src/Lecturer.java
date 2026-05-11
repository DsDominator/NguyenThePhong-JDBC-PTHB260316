import java.util.Scanner;

public class Lecturer extends Staff implements ICapability {
    private int teachingHours;

    public Lecturer() {
    }

    public Lecturer(String id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + teachingHours * 200000;
    }

    @Override
    public void checkPerformance() {
        if (teachingHours >= 40) {
            System.out.println("Giang vien hoan thanh tot");
        } else {
            System.out.println("Can tang so gio giang day");
        }
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);

        System.out.print("Nhap so gio giang day: ");
        teachingHours = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("===== GIANG VIEN =====");
        super.displayData();
        System.out.println("So gio giang day: " + teachingHours);
        checkPerformance();
    }
}