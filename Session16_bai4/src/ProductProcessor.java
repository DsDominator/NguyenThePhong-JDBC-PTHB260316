import java.util.List;

public interface ProductProcessor {

    // Abstract method
    double calculateTotalValue(List<Product> products);

    // Static method
    static void printProductList(List<Product> products) {

        System.out.println("\n===== DANH SACH SAN PHAM =====");

        products.forEach(System.out::println);
    }

    // Default method
    default boolean hasExpensiveProduct(List<Product> products) {

        return products.stream()
                .anyMatch(p -> p.getPrice() > 100);
    }
}