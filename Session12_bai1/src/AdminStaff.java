import java.util.Scanner;

public class AdminStaff extends Staff implements ICapability {
    private double bonus;

    public AdminStaff() {
    }

    public AdminStaff(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void checkPerformance() {
        if (bonus >= 2000000) {
            System.out.println("Nhan vien lam viec tot");
        } else {
            System.out.println("Can cai thien hieu suat");
        }
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);

        System.out.print("Nhap bonus: ");
        bonus = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("===== NHAN VIEN HANH CHINH =====");
        super.displayData();
        System.out.println("Bonus: " + bonus);
        checkPerformance();
    }
}