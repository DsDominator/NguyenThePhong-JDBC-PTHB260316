import java.util.Scanner;

public class Student2 {
    private int id;
    private String name;
    private double gpa;

    private static int countStudent = 0;

    // hằng số
    public final double SCORE_FACTOR = 0.25;


    public Student2() {
        countStudent++;
    }

    public Student2(int id, String name, double gpa) {
        this(); // gọi constructor không tham số
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập tên: ");
        name = sc.nextLine();

        System.out.print("Nhập GPA: ");
        gpa = sc.nextDouble();
    }

    public void print() {
        System.out.println("ID: " + id +
                ", Name: " + name +
                ", GPA: " + gpa +
                ", Converted: " + (gpa * SCORE_FACTOR));
    }

    public double getGpa() {
        return gpa;
    }

    public static int getTotalStudent() {
        return countStudent;
    }
}