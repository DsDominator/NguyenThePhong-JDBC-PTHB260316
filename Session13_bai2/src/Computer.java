import java.util.Scanner;

public class Computer extends Asset {
    private int ram;
    private String cpu;

    public Computer() {
    }

    public Computer(String assetCode, String name, double purchasePrice, int ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.8;
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);

        System.out.print("Nhap RAM: ");
        ram = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap CPU: ");
        cpu = sc.nextLine();
    }

    @Override
    public void displayData() {
        System.out.println("===== COMPUTER =====");
        super.displayData();
        System.out.println("RAM: " + ram);
        System.out.println("CPU: " + cpu);
    }
}