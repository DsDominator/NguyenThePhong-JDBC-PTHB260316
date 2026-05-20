package ra.presentation;

import ra.entity.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InvoiceManagement {
    static Product[] arrProd = new Product[100];
    static int prodIndex = 0;

    static Invoice[] arrInvoice = new Invoice[100];
    static int invoiceIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("================ QUẢN LÝ HÓA ĐƠN =================");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý hóa đơn");
            System.out.println("3. Báo cáo doanh thu");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    productMenu(scanner);
                    break;
                case 2:
                    invoiceMenu(scanner);
                    break;
                case 3:
                    revenueMenu(scanner);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn từ 1-4");
            }

        } while (true);
    }

    // ================= PRODUCT MENU =================
    public static void productMenu(Scanner scanner) {
        do {
            System.out.println("=============== QUẢN LÝ SẢN PHẨM ===============");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo tên");
            System.out.println("4. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Product product = new Product();
                    product.inputData(scanner, arrProd, prodIndex);

                    arrProd[prodIndex] = product;
                    prodIndex++;

                    System.out.println("Thêm sản phẩm thành công!");
                    break;

                case 2:
                    if (prodIndex == 0) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (int i = 0; i < prodIndex; i++) {
                            arrProd[i].displayData();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên cần tìm: ");
                    String keyword = scanner.nextLine();

                    boolean found = false;

                    for (int i = 0; i < prodIndex; i++) {
                        if (arrProd[i].getProductName()
                                .toLowerCase()
                                .contains(keyword.toLowerCase())) {

                            arrProd[i].displayData();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Vui lòng chọn từ 1-4");
            }

        } while (true);
    }

    // ================= INVOICE MENU =================
    public static void invoiceMenu(Scanner scanner) {
        do {
            System.out.println("================ QUẢN LÝ HÓA ĐƠN ================");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Hiển thị danh sách hóa đơn");
            System.out.println("3. Tìm hóa đơn theo mã");
            System.out.println("4. Tìm hóa đơn theo tên khách hàng");
            System.out.println("5. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Invoice invoice = new Invoice();
                    invoice.inputData(scanner, arrProd, prodIndex);

                    arrInvoice[invoiceIndex] = invoice;
                    invoiceIndex++;

                    System.out.println("Thêm hóa đơn thành công!");
                    break;

                case 2:
                    if (invoiceIndex == 0) {
                        System.out.println("Danh sách hóa đơn trống!");
                    } else {
                        for (int i = 0; i < invoiceIndex; i++) {
                            arrInvoice[i].displayData();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã hóa đơn: ");
                    String invoiceId = scanner.nextLine();

                    boolean found = false;

                    for (int i = 0; i < invoiceIndex; i++) {
                        if (arrInvoice[i].getInvoiceId()
                                .equalsIgnoreCase(invoiceId)) {

                            arrInvoice[i].displayData();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy hóa đơn!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = scanner.nextLine();

                    boolean check = false;

                    for (int i = 0; i < invoiceIndex; i++) {
                        if (arrInvoice[i].getCustomerName()
                                .toLowerCase()
                                .contains(customerName.toLowerCase())) {

                            arrInvoice[i].displayData();
                            check = true;
                        }
                    }

                    if (!check) {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 5:
                    return;
            }

        } while (true);
    }

    // ================= REVENUE MENU =================
    public static void revenueMenu(Scanner scanner) {
        do {
            System.out.println("================ QUẢN LÝ DOANH THU ================");
            System.out.println("1. Tính tổng doanh thu");
            System.out.println("2. Tìm hóa đơn có giá trị lớn nhất");
            System.out.println("3. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    double totalRevenue = 0;

                    for (int i = 0; i < invoiceIndex; i++) {
                        totalRevenue += arrInvoice[i].getTotalAmount();
                    }

                    System.out.printf("Tổng doanh thu: %.2f\n", totalRevenue);
                    break;

                case 2:
                    if (invoiceIndex == 0) {
                        System.out.println("Chưa có hóa đơn!");
                    } else {
                        Invoice maxInvoice = arrInvoice[0];

                        for (int i = 1; i < invoiceIndex; i++) {
                            if (arrInvoice[i].getTotalAmount()
                                    > maxInvoice.getTotalAmount()) {

                                maxInvoice = arrInvoice[i];
                            }
                        }

                        System.out.println("Hóa đơn lớn nhất:");
                        maxInvoice.displayData();
                    }
                    break;

                case 3:
                    return;
            }

        } while (true);
    }
}