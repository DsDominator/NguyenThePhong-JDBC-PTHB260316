import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InvoiceManager manager = new InvoiceManager();

        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ HÓA ĐƠN =====");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Nhập mã hóa đơn: ");
                    String id = sc.nextLine();

                    System.out.print("Nhập số tiền: ");
                    double amount = Double.parseDouble(sc.nextLine());

                    manager.add(new Invoice(id, amount));
                    break;

                case 2:
                    manager.display();

                    System.out.print("Nhập vị trí cần sửa: ");
                    int updateIndex = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập mã hóa đơn mới: ");
                    String newId = sc.nextLine();

                    System.out.print("Nhập số tiền mới: ");
                    double newAmount = Double.parseDouble(sc.nextLine());

                    manager.update(updateIndex, new Invoice(newId, newAmount));
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
