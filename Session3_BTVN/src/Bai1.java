import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập thông tin
        System.out.print("Nhập tên khách hàng: ");
        String customerName = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String productName = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();

        System.out.print("Nhập số lượng: ");
        int quantity = sc.nextInt();

        System.out.print("Khách có thẻ thành viên (true/false): ");
        boolean isMember = sc.nextBoolean();

        // Tính toán
        double thanhTien = price * quantity;
        double giamGia = isMember ? thanhTien * 0.10 : 0;
        double vat = (thanhTien - giamGia) * 0.08;
        double tongThanhToan = thanhTien - giamGia + vat;

        // In hóa đơn
        System.out.println("\n===== HÓA ĐƠN =====");
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Sản phẩm: " + productName);
        System.out.println("Số lượng: " + quantity);

        System.out.printf("Đơn giá: %.2f\n", price);
        System.out.printf("Thành tiền: %.2f\n", thanhTien);
        System.out.printf("Giảm giá: %.2f\n", giamGia);
        System.out.printf("VAT (8%%): %.2f\n", vat);
        System.out.printf("Tổng thanh toán: %.2f\n", tongThanhToan);

        sc.close();
    }
}