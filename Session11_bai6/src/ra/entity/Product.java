package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private ProductStatus status;

    public Product() {
    }

    public Product(String productId, String productName, double price, ProductStatus status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int index) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (Cxxx/Sxxx/Axxx): ");
            productId = scanner.nextLine();

            if (productId.matches("[CSA]\\d{3}")) {
                break;
            }
            System.out.println("Mã không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            productName = scanner.nextLine();

            if (productName.length() >= 10 && productName.length() <= 50) {
                boolean isExist = false;

                for (int i = 0; i < index; i++) {
                    if (arrProd[i].getProductName().equalsIgnoreCase(productName)) {
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {
                    break;
                }
            }

            System.out.println("Tên sản phẩm không hợp lệ hoặc bị trùng!");
        }

        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            price = Double.parseDouble(scanner.nextLine());

            if (price > 0) {
                break;
            }

            System.out.println("Giá phải > 0");
        }

        System.out.println("Chọn trạng thái:");
        System.out.println("1. AVAILABLE");
        System.out.println("2. OUT_OF_STOCK");
        System.out.println("3. STOP_SELLING");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                status = ProductStatus.AVAILABLE;
                break;
            case 2:
                status = ProductStatus.OUT_OF_STOCK;
                break;
            case 3:
                status = ProductStatus.STOP_SELLING;
                break;
            default:
                status = ProductStatus.AVAILABLE;
        }
    }

    public void displayData() {
        System.out.printf("Mã SP: %s | Tên SP: %s | Giá: %.2f | Trạng thái: %s\n",
                productId, productName, price, status);
    }
}