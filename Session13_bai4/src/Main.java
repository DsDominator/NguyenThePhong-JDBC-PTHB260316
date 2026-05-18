import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderManager manager = new OrderManager();

        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ ĐƠN HÀNG =====");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Nhập mã đơn hàng: ");
                    String orderId = sc.nextLine();

                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = sc.nextLine();

                    manager.add(new Order(orderId, customerName));
                    break;

                case 2:
                    manager.display();

                    System.out.print("Nhập vị trí cần sửa: ");
                    int updateIndex = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập mã đơn hàng mới: ");
                    String newOrderId = sc.nextLine();

                    System.out.print("Nhập tên khách hàng mới: ");
                    String newCustomerName = sc.nextLine();

                    manager.update(updateIndex,
                            new Order(newOrderId, newCustomerName));
                    break;

                case 3:
                    manager.display();

                    System.out.print("Nhập vị trí cần xóa: ");
                    int deleteIndex = Integer.parseInt(sc.nextLine());

                    manager.delete(deleteIndex);
                    break;

                case 4:
                    manager.display();
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
