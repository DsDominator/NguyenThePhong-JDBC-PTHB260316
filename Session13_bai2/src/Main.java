import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void searchAsset(ArrayList<Asset> list, String assetCode) {

        boolean found = false;

        for (Asset a : list) {
            if (a.getAssetCode().equalsIgnoreCase(assetCode)) {
                a.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay tai san");
        }
    }

    public static void searchAsset(ArrayList<Asset> list, double price) {

        boolean found = false;

        for (Asset a : list) {
            if (a.getPurchasePrice() > price) {
                a.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co tai san phu hop");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Asset> assetList = new ArrayList<>();

        AssetManager manager = new AssetManager();

        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Nhap tai san");
            System.out.println("2. Xuat bao cao");
            System.out.println("3. Tim kiem");
            System.out.println("4. Sua gia mua");
            System.out.println("5. Thoat");
            System.out.print("Nhap lua chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("1. Computer");
                    System.out.println("2. Network Device");
                    System.out.print("Nhap lua chon: ");

                    int type = Integer.parseInt(sc.nextLine());

                    Asset asset = null;

                    if (type == 1) {
                        asset = new Computer();
                    } else if (type == 2) {
                        asset = new NetworkDevice();
                    }

                    if (asset != null) {
                        asset.inputData(sc);
                        assetList.add(asset);
                        System.out.println("Them thanh cong");
                    }

                    break;

                case 2:

                    if (assetList.isEmpty()) {
                        System.out.println("Danh sach rong");
                    } else {

                        for (Asset a : assetList) {
                            a.displayData();
                            manager.showValue(a);
                            System.out.println("---------------------");
                        }
                    }

                    break;

                case 3:

                    System.out.println("1. Tim theo ma");
                    System.out.println("2. Tim theo gia");
                    System.out.print("Nhap lua chon: ");

                    int searchChoice = Integer.parseInt(sc.nextLine());

                    if (searchChoice == 1) {

                        System.out.print("Nhap ma tai san: ");
                        String code = sc.nextLine();

                        searchAsset(assetList, code);

                    } else if (searchChoice == 2) {

                        System.out.print("Nhap muc gia: ");
                        double price = Double.parseDouble(sc.nextLine());

                        searchAsset(assetList, price);
                    }

                    break;

                case 4:

                    System.out.print("Nhap ma tai san can sua: ");
                    String updateCode = sc.nextLine();

                    boolean found = false;

                    for (Asset a : assetList) {

                        if (a.getAssetCode().equalsIgnoreCase(updateCode)) {

                            System.out.print("Nhap gia mua moi: ");
                            double newPrice = Double.parseDouble(sc.nextLine());

                            a.setPurchasePrice(newPrice);

                            found = true;

                            System.out.println("Cap nhat thanh cong");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Khong tim thay tai san");
                    }

                    break;

                case 5:

                    System.out.println("Thoat chuong trinh");
                    System.exit(0);

                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}