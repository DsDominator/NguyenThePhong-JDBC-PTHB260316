import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> danhSach = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n*************** MENU ***************");
            System.out.println("1. Thêm tên sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm tên sinh viên chứa từ khóa");
            System.out.println("4. Đếm số sinh viên có tên bắt đầu bằng chữ cái");
            System.out.println("5. Sắp xếp danh sách tên A-Z");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String ten = sc.nextLine();
                    danhSach.add(ten);
                    System.out.println("Đã thêm!");
                    break;

                case 2:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách rỗng!");
                    } else {
                        System.out.println("Danh sách sinh viên:");
                        for (int i = 0; i < danhSach.size(); i++) {
                            System.out.println((i + 1) + ". " + danhSach.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập từ khóa: ");
                    String keyword = sc.nextLine().toLowerCase();
                    boolean found = false;

                    for (String name : danhSach) {
                        if (name.toLowerCase().contains(keyword)) {
                            System.out.println(name);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập chữ cái: ");
                    char c = sc.nextLine().toLowerCase().charAt(0);
                    int count = 0;

                    for (String name : danhSach) {
                        if (!name.isEmpty() && Character.toLowerCase(name.charAt(0)) == c) {
                            count++;
                        }
                    }

                    System.out.println("Số sinh viên: " + count);
                    break;

                case 5:
                    Collections.sort(danhSach);
                    System.out.println("Đã sắp xếp danh sách!");
                    break;

                case 6:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);

        sc.close();
    }
}
