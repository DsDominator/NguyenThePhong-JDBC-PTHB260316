package ra.presentation;

import ra.business.ProductBusiness;
import ra.entity.Product;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ProductApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("**************** PRODUCT MANAGEMENT ***************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("7. Thống kê số lượng sản phẩm theo danh mục");
            System.out.println("8. Thoát");

            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    List<Product> list =
                            ProductBusiness.getAllProducts();

                    list.forEach(System.out::println);
                    break;

                case 2:

                    try {

                        Product product = new Product();

                        System.out.print("Tên sản phẩm: ");
                        String name = scanner.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Tên không được để trống");
                            break;
                        }

                        product.setProductName(name);

                        System.out.print("Giá sản phẩm: ");
                        float price =
                                Float.parseFloat(scanner.nextLine());

                        if (price <= 0) {
                            System.out.println("Giá phải > 0");
                            break;
                        }

                        product.setProductPrice(price);

                        System.out.print("Tiêu đề: ");
                        product.setProductTitle(scanner.nextLine());

                        System.out.print("Ngày tạo (yyyy-MM-dd): ");

                        String dateStr = scanner.nextLine();

                        SimpleDateFormat sdf =
                                new SimpleDateFormat("yyyy-MM-dd");

                        product.setProductCreated(
                                sdf.parse(dateStr));

                        System.out.print("Danh mục: ");
                        product.setProductCatalog(
                                scanner.nextLine());

                        product.setProductStatus(true);

                        boolean result =
                                ProductBusiness.insertProduct(product);

                        if (result) {
                            System.out.println("Thêm thành công");
                        } else {
                            System.out.println("Thêm thất bại");
                        }

                    } catch (Exception e) {
                        System.out.println("Dữ liệu không hợp lệ");
                    }

                    break;

                case 8:
                    System.exit(0);

                default:
                    System.out.println("Vui lòng chọn từ 1-8");
            }
        }
    }
}