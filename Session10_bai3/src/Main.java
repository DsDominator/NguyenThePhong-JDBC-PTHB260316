class Computer {

    public double calculatePrice(double basePrice) {
        System.out.println("Cong thuc: Gia goc");
        return basePrice;
    }

    public double calculatePrice(double basePrice, double tax) {
        System.out.println("Cong thuc: Gia goc + Thue");
        return basePrice + tax;
    }

    public double calculatePrice(double basePrice, double tax, double discount) {
        System.out.println("Cong thuc: Gia goc + Thue - Giam gia");
        return basePrice + tax - discount;
    }
}

public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer();

        double price1 = computer.calculatePrice(1000);
        System.out.println("Gia 1: " + price1);

        System.out.println("----------------");

        double price2 = computer.calculatePrice(1000, 100);
        System.out.println("Gia 2: " + price2);

        System.out.println("----------------");

        double price3 = computer.calculatePrice(1000, 100, 50);
        System.out.println("Gia 3: " + price3);
    }
}