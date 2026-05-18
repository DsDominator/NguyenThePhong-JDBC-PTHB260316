import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Danh sách sản phẩm
        List<Product> products =
                new ArrayList<>();

        // Danh sách đơn hàng
        Map<String, Order> orders =
                new HashMap<>();

        int choice = -1;

        do {

            System.out.println("\n================ MENU ================");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Hiển thị sản phẩm");
            System.out.println("4. Tạo đơn hàng");
            System.out.println("5. Thêm sản phẩm vào đơn hàng");
            System.out.println("6. Hiển thị đơn hàng");
            System.out.println("0. Thoát");
            System.out.println("======================================");

            System.out.print("Lựa chọn của bạn: ");

            try {

                choice =
                        Integer.parseInt(sc.nextLine());

                switch (choice) {

                    // ===== THÊM SẢN PHẨM =====
                    case 1:

                        System.out.print("Nhập ID: ");
                        int id =
                                Integer.parseInt(
                                        sc.nextLine()
                                );

                        System.out.print("Nhập tên: ");
                        String name =
                                sc.nextLine();

                        System.out.print("Nhập giá: ");
                        double price =
                                Double.parseDouble(
                                        sc.nextLine()
                                );

                        // Kiểm tra giá
                        if (price <= 0) {

                            throw new Exception(
                                    "Giá sản phẩm phải > 0"
                            );
                        }

                        products.add(
                                new Product(
                                        id,
                                        name,
                                        price
                                )
                        );

                        System.out.println(
                                "Thêm sản phẩm thành công!"
                        );

                        break;

                    // ===== XÓA SẢN PHẨM =====
                    case 2:

                        System.out.print(
                                "Nhập ID cần xóa: "
                        );

                        int deleteId =
                                Integer.parseInt(
                                        sc.nextLine()
                                );

                        Product removeProduct = null;

                        for (Product p : products) {

                            if (p.getId() == deleteId) {

                                removeProduct = p;
                                break;
                            }
                        }

                        if (removeProduct == null) {

                            throw new Exception(
                                    "Sản phẩm không tồn tại!"
                            );
                        }

                        products.remove(removeProduct);

                        System.out.println(
                                "Xóa sản phẩm thành công!"
                        );

                        break;

                    // ===== HIỂN THỊ SẢN PHẨM =====
                    case 3:

                        System.out.println(
                                "\n===== DANH SÁCH SẢN PHẨM ====="
                        );

                        if (products.isEmpty()) {

                            System.out.println(
                                    "Danh sách trống!"
                            );

                        } else {

                            for (Product p : products) {
                                System.out.println(p);
                            }
                        }

                        break;

                    // ===== TẠO ĐƠN HÀNG =====
                    case 4:

                        System.out.print(
                                "Nhập mã đơn hàng: "
                        );

                        String orderKey =
                                sc.nextLine();

                        System.out.print(
                                "Nhập Order ID: "
                        );

                        int orderId =
                                Integer.parseInt(
                                        sc.nextLine()
                                );

                        orders.put(
                                orderKey,
                                new Order(orderId)
                        );

                        System.out.println(
                                "Tạo đơn hàng thành công!"
                        );

                        break;

                    // ===== THÊM SP VÀO ĐƠN =====
                    case 5:

                        System.out.print(
                                "Nhập mã đơn hàng: "
                        );

                        String key =
                                sc.nextLine();

                        Order order =
                                orders.get(key);

                        if (order == null) {

                            throw new Exception(
                                    "Đơn hàng không tồn tại!"
                            );
                        }

                        System.out.print(
                                "Nhập ID sản phẩm: "
                        );

                        int productId =
                                Integer.parseInt(
                                        sc.nextLine()
                                );

                        Product foundProduct = null;

                        for (Product p : products) {

                            if (p.getId() == productId) {

                                foundProduct = p;
                                break;
                            }
                        }

                        if (foundProduct == null) {

                            throw new Exception(
                                    "Sản phẩm không tồn tại!"
                            );
                        }

                        order.addProduct(foundProduct);

                        break;

                    // ===== HIỂN THỊ ĐƠN HÀNG =====
                    case 6:

                        System.out.print(
                                "Nhập mã đơn hàng: "
                        );

                        String showKey =
                                sc.nextLine();

                        Order showOrder =
                                orders.get(showKey);

                        if (showOrder == null) {

                            throw new Exception(
                                    "Đơn hàng không tồn tại!"
                            );
                        }

                        System.out.println(
                                "\n===== THÔNG TIN ĐƠN HÀNG ====="
                        );

                        System.out.println(showOrder);

                        break;

                    case 0:

                        System.out.println(
                                "Thoát chương trình!"
                        );

                        break;

                    default:

                        System.out.println(
                                "Lựa chọn không hợp lệ!"
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Lỗi: Vui lòng nhập đúng kiểu dữ liệu số!"
                );

            } catch (Exception e) {

                System.out.println(
                        "Lỗi: " + e.getMessage()
                );
            }

        } while (choice != 0);

        sc.close();
    }
}
