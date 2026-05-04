import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student2> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== MENU SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm sinh viên GPA cao nhất");
            System.out.println("4. In tổng số sinh viên đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.println("\nNhập sinh viên " + (i + 1));
                        Student2 s = new Student2();
                        s.input();
                        list.add(s);
                    }
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("Danh sách rỗng!");
                    } else {
                        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
                        for (Student2 s : list) {
                            s.print();
                        }
                    }
                    break;

                case 3:
                    if (list.isEmpty()) {
                        System.out.println("Danh sách rỗng!");
                    } else {
                        double max = list.get(0).getGpa();

                        for (Student2 s : list) {
                            if (s.getGpa() > max) {
                                max = s.getGpa();
                            }
                        }

                        System.out.println("\n--- SINH VIÊN GPA CAO NHẤT ---");
                        for (Student2 s : list) {
                            if (s.getGpa() == max) {
                                s.print();
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Tổng số sinh viên đã tạo: "
                            + Student2.getTotalStudent());
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }
}