import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;
    private List<Product> products;

    // Constructor
    public Order(int orderId) {

        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Thêm sản phẩm vào đơn
    public void addProduct(Product product) {

        products.add(product);

        System.out.println(
                "Đã thêm sản phẩm vào đơn hàng!"
        );
    }

    // Tính tổng tiền
    public double totalPrice() {

        double total = 0;

        for (Product p : products) {
            total += p.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {

        return "Order ID: " + orderId +
                "\nProducts: " + products +
                "\nTotal: " + totalPrice();
    }
}
