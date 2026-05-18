import java.util.LinkedList;
import java.util.Scanner;
public class UserManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<User> users = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ NGƯỜI DÙNG =====");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng theo email");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập email: ");
                    String email = sc.nextLine();

                    System.out.print("Nhập số điện thoại: ");
                    String phone = sc.nextLine();

                    users.add(new User(name, email, phone));
                    System.out.println("Thêm người dùng thành công!");
                    break;

                case 2:
                    System.out.print("Nhập email cần xóa: ");
                    String deleteEmail = sc.nextLine();

                    boolean removed = false;

                    for (User u : users) {
                        if (u.getEmail().equalsIgnoreCase(deleteEmail)) {
                            users.remove(u);
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy email!");
                    }
                    break;

                case 3:
                    System.out.println("\n===== DANH SÁCH NGƯỜI DÙNG =====");

                    if (users.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (User u : users) {
                            System.out.println(u);
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