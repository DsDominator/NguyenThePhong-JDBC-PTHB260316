import java.util.Scanner;

public class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice() {
    }

    public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.9;
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);

        System.out.print("Nhap so cong ket noi: ");
        numberOfPorts = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("===== NETWORK DEVICE =====");
        super.displayData();
        System.out.println("So cong ket noi: " + numberOfPorts);
    }
}