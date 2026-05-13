import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    
    public static int AUTO_ID = 1;

    public final String WAREHOUSE_CODE = "KHO-01";

    public Product() {
    }

    public Product(String name, double price) {
        this.id = AUTO_ID;
        AUTO_ID++;

        this.name = name;
        this.price = price;
    }

    public void input(Scanner sc) {
        this.id = AUTO_ID;
        AUTO_ID++;

        System.out.print("Nhập tên sản phẩm: ");
        this.name = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        this.price = Double.parseDouble(sc.nextLine());
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Tên SP: " + name);
        System.out.println("Giá: " + price);
        System.out.println("Mã kho: " + WAREHOUSE_CODE);
        System.out.println("----------------------");
    }

    // Getter
    public double getPrice() {
        return price;
    }
}

