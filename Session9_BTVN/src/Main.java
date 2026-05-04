import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chiều rộng: ");
        double width = sc.nextDouble();

        System.out.print("Nhập chiều cao: ");
        double height = sc.nextDouble();

        Rectangle rect = new Rectangle(width, height);


        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Diện tích: " + rect.getArea());
        System.out.println("Chu vi: " + rect.getPerimeter());

        System.out.println("\n--- THÔNG TIN ---");
        rect.printInfo();

        Book b1 = new Book("Java Basics", "John Doe", 19.99);
        Book b2 = new Book("OOP in Java", "Jane Smith", 25.5);
        Book b3 = new Book("Data Structures", "Alan Turing", 30.0);

        ArrayList<Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        System.out.println("=== DANH SÁCH SÁCH ===");
        for (Book b : list) {
            b.printInfo();
        }

        Student s1 = new Student(1, "Nguyen Van A", 20, 3.5);
        Student s2 = new Student(2, "Tran Thi B", 21, 3.8);
        Student s3 = new Student(3, "Le Van C", 19, 4.2); // sẽ bị giới hạn về 4.0

        System.out.println("=== DANH SÁCH SINH VIÊN ===");
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();

        System.out.println("\nTổng số sinh viên: " + Student.getCount());
    }
}
