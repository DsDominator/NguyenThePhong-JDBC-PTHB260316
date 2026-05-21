import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {

    static HashMap<Integer, Product> products = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    // Thêm sản phẩm
    public static void addProduct() {
        System.out.print("Nhap ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ten: ");
        String name = sc.nextLine();

        System.out.print("Nhap gia: ");
        double price = Double.parseDouble(sc.nextLine());

        Product p = new Product(id, name, price);
        products.put(id, p);

        System.out.println("Them san pham thanh cong!");
    }

    // Sửa sản phẩm
    public static void updateProduct() {
        System.out.print("Nhap ID can sua: ");
        int id = Integer.parseInt(sc.nextLine());

        if (products.containsKey(id)) {

            System.out.print("Nhap ten moi: ");
            String name = sc.nextLine();

            System.out.print("Nhap gia moi: ");
            double price = Double.parseDouble(sc.nextLine());

            Product p = products.get(id);
            p.setName(name);
            p.setPrice(price);

            System.out.println("Cap nhat thanh cong!");

        } else {
            System.out.println("Khong tim thay san pham!");
        }
    }

    // Xóa sản phẩm
    public static void deleteProduct() {
        System.out.print("Nhap ID can xoa: ");
        int id = Integer.parseInt(sc.nextLine());

        if (products.containsKey(id)) {
            products.remove(id);
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay san pham!");
        }
    }

    // Hiển thị danh sách
    public static void showProducts() {

        if (products.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("===== DANH SACH SAN PHAM =====");

        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Lọc sản phẩm giá > 100
    public static void filterProducts() {

        System.out.println("===== SAN PHAM CO GIA > 100 =====");

        products.values()
                .stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);
    }

    // Tính tổng giá trị sản phẩm
    public static void totalPrice() {

        double total = products.values()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Tong gia tri san pham: " + total);
    }

    public static void menu() {

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Sua san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Hien thi danh sach");
            System.out.println("5. Loc san pham gia > 100");
            System.out.println("6. Tong gia tri san pham");
            System.out.println("0. Thoat");

            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    updateProduct();
                    break;

                case 3:
                    deleteProduct();
                    break;

                case 4:
                    showProducts();
                    break;

                case 5:
                    filterProducts();
                    break;

                case 6:
                    totalPrice();
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh!");
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}