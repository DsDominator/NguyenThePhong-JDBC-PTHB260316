import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên theo GPA");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = Integer.parseInt(sc.nextLine());

                    if (n < 5) {
                        System.out.println("Phải nhập ít nhất 5 sinh viên!");
                        break;
                    }

                    for (int i = 0; i < n; i++) {

                        System.out.println("\nNhập sinh viên thứ " + (i + 1));

                        System.out.print("Nhập họ tên: ");
                        String name = sc.nextLine();

                        System.out.print("Nhập GPA: ");
                        double gpa = Double.parseDouble(sc.nextLine());

                        students.add(new Student(name, gpa));
                    }

                    System.out.println("Thêm danh sách sinh viên thành công!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên trống!");
                    } else {
                        System.out.println("\n===== DANH SÁCH SINH VIÊN =====");

                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String keyword = sc.nextLine();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.getName().toLowerCase()
                                .contains(keyword.toLowerCase())) {

                            System.out.println(s);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên!");
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên trống!");
                    } else {

                        System.out.println("\n===== PHÂN LOẠI SINH VIÊN =====");

                        for (Student s : students) {
                            System.out.println(
                                    s.getName() +
                                            " - GPA: " + s.getGpa() +
                                            " - Xếp loại: " + s.getRank()
                            );
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }
}