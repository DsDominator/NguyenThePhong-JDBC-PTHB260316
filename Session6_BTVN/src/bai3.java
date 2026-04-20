import java.util.*;

public class bai3 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> danhSach = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n********** QUAN LY BIEN SO XE **********");
            System.out.println("1. Them bien so xe");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem bien so xe");
            System.out.println("4. Tim theo ma tinh");
            System.out.println("5. Sap xep tang dan");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    themBienSo();
                    break;
                case 2:
                    hienThi();
                    break;
                case 3:
                    timChinhXac();
                    break;
                case 4:
                    timTheoMaTinh();
                    break;
                case 5:
                    sapXep();
                    break;
                case 0:
                    System.out.println("Thoat!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static void themBienSo() {
        System.out.print("Nhap bien so (VD: 30F-123.45): ");
        String bs = sc.nextLine().trim();

        if (kiemTraBienSo(bs)) {
            danhSach.add(bs);
            System.out.println("Them thanh cong!");
        } else {
            System.out.println("Bien so khong hop le!");
        }
    }

    public static void hienThi() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("Danh sach bien so:");
        for (String bs : danhSach) {
            System.out.println(bs);
        }
    }

    public static void timChinhXac() {
        System.out.print("Nhap bien so can tim: ");
        String input = sc.nextLine().trim();

        if (danhSach.contains(input)) {
            System.out.println("Tim thay!");
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    public static void timTheoMaTinh() {
        System.out.print("Nhap ma tinh (VD: 30): ");
        String ma = sc.nextLine();

        boolean found = false;

        for (String bs : danhSach) {
            if (bs.startsWith(ma)) {
                System.out.println(bs);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co bien so nao!");
        }
    }

    public static void sapXep() {
        Collections.sort(danhSach);
        System.out.println("Da sap xep tang dan!");
    }

    public static boolean kiemTraBienSo(String bs) {
        // VD: 30F-123.45
        String regex = "^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$";
        return bs.matches(regex);
    }
}