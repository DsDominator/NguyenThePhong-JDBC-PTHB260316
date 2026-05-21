import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1200));
        products.add(new Product("Mouse", 25));
        products.add(new Product("Keyboard", 80));
        products.add(new Product("Monitor", 300));

        ProductProcessor processor =
                new ProductProcessorImpl();

        // Kiểm tra sản phẩm đắt tiền
        if (processor.hasExpensiveProduct(products)) {

            System.out.println("Co san pham dat tien (>100)");

        } else {

            System.out.println("Khong co san pham dat tien");
        }

        // Tính tổng giá trị sản phẩm
        double total =
                processor.calculateTotalValue(products);

        System.out.println("\nTong gia tri san pham: " + total);

        // In danh sách sản phẩm
        ProductProcessor.printProductList(products);
    }
}