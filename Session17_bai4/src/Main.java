package ra.run;

import ra.business.OrderManager;
import ra.entity.Customer;
import ra.entity.Order;
import ra.entity.Product;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OrderManager manager =
                new OrderManager();

        while (true) {

            System.out.println(
                    "\n===== SHOP MANAGEMENT ====="
            );

            System.out.println(
                    "1. Thêm sản phẩm"
            );

            System.out.println(
                    "2. Cập nhật khách hàng"
            );

            System.out.println(
                    "3. Tạo đơn hàng"
            );

            System.out.println(
                    "4. Danh sách đơn hàng"
            );

            System.out.println(
                    "5. Tìm đơn theo khách hàng"
            );

            System.out.println("0. Thoát");

            System.out.print(
                    "Lựa chọn: "
            );

            try {

                int choice =
                        Integer.parseInt(
                                sc.nextLine()
                        );

                switch (choice) {

                    case 1:

                        Product product =
                                new Product();

                        System.out.print(
                                "Tên sản phẩm: "
                        );

                        product.setName(
                                sc.nextLine()
                        );

                        System.out.print(
                                "Giá sản phẩm: "
                        );

                        product.setPrice(
                                Double.parseDouble(
                                        sc.nextLine()
                                )
                        );

                        manager.addProduct(
                                product
                        );

                        break;

                    case 2:

                        Customer customer =
                                new Customer();

                        System.out.print(
                                "ID khách hàng: "
                        );

                        int customerId =
                                Integer.parseInt(
                                        sc.nextLine()
                                );

                        System.out.print(
                                "Tên mới: "
                        );

                        customer.setName(
                                sc.nextLine()
                        );

                        System.out.print(
                                "Email mới: "
                        );

                        customer.setEmail(
                                sc.nextLine()
                        );

                        manager.updateCustomer(
                                customerId,
                                customer
                        );

                        break;

                    case 3:

                        Order order =
                                new Order();

                        System.out.print(
                                "Customer ID: "
                        );

                        order.setCustomerId(
                                Integer.parseInt(
                                        sc.nextLine()
                                )
                        );

                        order.setOrderDate(
                                new Date(
                                        System.currentTimeMillis()
                                )
                        );

                        System.out.print(
                                "Tổng tiền: "
                        );

                        order.setTotalAmount(
                                Double.parseDouble(
                                        sc.nextLine()
                                )
                        );

                        manager.createOrder(
                                order
                        );

                        break;

                    case 4:

                        manager.listAllOrders();

                        break;

                    case 5:

                        System.out.print(
                                "Nhập customer ID: "
                        );

                        int id =
                                Integer.parseInt(
                                        sc.nextLine()
                                );

                        manager.getOrdersByCustomer(
                                id
                        );

                        break;

                    case 0:

                        System.out.println(
                                "Thoát chương trình!"
                        );

                        System.exit(0);

                    default:

                        System.out.println(
                                "Lựa chọn không hợp lệ!"
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Sai kiểu dữ liệu!"
                );

            } catch (Exception e) {

                System.out.println(
                        "Có lỗi xảy ra: "
                                + e.getMessage()
                );
            }
        }
    }
}
