import java.util.Scanner;

public abstract class Staff {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Staff() {
    }

    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateTotalSalary();

    public void inputData(Scanner sc) {
        System.out.print("Nhap ID: ");
        id = sc.nextLine();

        System.out.print("Nhap ten: ");
        name = sc.nextLine();

        System.out.print("Nhap luong co ban: ");
        baseSalary = Double.parseDouble(sc.nextLine());
    }

    public void displayData() {
        System.out.println("ID: " + id);
        System.out.println("Ten: " + name);
        System.out.println("Luong co ban: " + baseSalary);
        System.out.println("Luong thuc nhan: " + calculateTotalSalary());
    }

    public String getId() {
        return id;
    }
}