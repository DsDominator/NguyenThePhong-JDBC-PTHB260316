import java.util.Scanner;

public abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;

    public Asset() {
    }

    public Asset(String assetCode, String name, double purchasePrice) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public abstract double getMarketValue();

    public void inputData(Scanner sc) {
        System.out.print("Nhap ma tai san: ");
        assetCode = sc.nextLine();

        System.out.print("Nhap ten tai san: ");
        name = sc.nextLine();

        System.out.print("Nhap gia mua: ");
        purchasePrice = Double.parseDouble(sc.nextLine());
    }

    public void displayData() {
        System.out.println("Ma tai san: " + assetCode);
        System.out.println("Ten tai san: " + name);
        System.out.println("Gia mua: " + purchasePrice);
        System.out.println("Gia tri hien tai: " + getMarketValue());
    }

    public String getAssetCode() {
        return assetCode;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}