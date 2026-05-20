// File: InvoiceDetail.java
package ra.entity;

import java.util.Scanner;

public class InvoiceDetail {
    private Product product;
    private int quantity;
    private double subTotal;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Product product, int quantity, double subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        System.out.println("===== DANH SÁCH SẢN PHẨM =====");

        for (int i = 0; i < prodIndex; i++) {
            arrProd[i].displayData();
        }

        while (true) {
            System.out.print("Nhập mã sản phẩm cần mua: ");
            String productId = scanner.nextLine();

            boolean found = false;

            for (int i = 0; i < prodIndex; i++) {
                if (arrProd[i].getProductId().equalsIgnoreCase(productId)
                        && arrProd[i].getStatus() == ProductStatus.AVAILABLE) {

                    product = arrProd[i];
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }

            System.out.println("Không tìm thấy sản phẩm hoặc sản phẩm không bán!");
        }

        while (true) {
            System.out.print("Nhập số lượng: ");
            quantity = Integer.parseInt(scanner.nextLine());

            if (quantity > 0) {
                break;
            }

            System.out.println("Số lượng phải > 0");
        }

        subTotal = product.getPrice() * quantity;
    }

    public void displayData() {
        System.out.printf("Tên SP: %s | SL: %d | Thành tiền: %.2f\n",
                product.getProductName(), quantity, subTotal);
    }
}