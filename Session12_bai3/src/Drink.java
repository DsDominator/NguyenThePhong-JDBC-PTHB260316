import java.util.Scanner;

public abstract class Drink implements IPromotion {
    protected String id;
    protected String name;
    protected double price;

    public Drink() {
    }

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract void prepare();

    public void inputData(Scanner sc) {

        System.out.print("Nhap ID: ");
        id = sc.nextLine();

        System.out.print("Nhap ten mon: ");
        name = sc.nextLine();

        System.out.print("Nhap gia: ");
        price = Double.parseDouble(sc.nextLine());
    }

    public void displayData() {
        System.out.println("ID: " + id);
        System.out.println("Ten mon: " + name);
        System.out.println("Gia: " + price);
        prepare();
    }

    @Override
    public void applyDiscount(double percentage) {
        price = price - (price * percentage / 100);
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
