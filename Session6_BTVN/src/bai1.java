import java.util.*;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] diem = null;
        int n = 0;

        while (true) {
            System.out.println("\n===== MENU QUAN LY DIEM =====");
            System.out.println("1. Nhap danh sach diem");
            System.out.println("2. In danh sach diem");
            System.out.println("3. Tinh diem trung binh");
            System.out.println("4. Tim diem cao nhat va thap nhat");
            System.out.println("5. Dem so luong dat va truot");
            System.out.println("6. Sap xep diem tang dan");
            System.out.println("7. Thong ke gioi va xuat sac");
            System.out.println("8. Thoat");
            System.out.print("Chon: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap so sinh vien: ");
                    n = sc.nextInt();
                    diem = nhapDiem(sc, n);
                    break;

                case 2:
                    inDanhSach(diem);
                    break;

                case 3:
                    tinhTrungBinh(diem);
                    break;

                case 4:
                    timMaxMin(diem);
                    break;

                case 5:
                    demDatTruot(diem);
                    break;

                case 6:
                    sapXepTang(diem);
                    break;

                case 7:
                    thongKeGioi(diem);
                    break;

                case 8:
                    System.out.println("Thoat!");
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static double[] nhapDiem(Scanner sc, int n) {
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Nhap diem SV " + (i + 1) + ": ");
                arr[i] = sc.nextDouble();
            } while (arr[i] < 0 || arr[i] > 10);
        }

        return arr;
    }

    public static void inDanhSach(double[] arr) {
        if (arr == null) {
            System.out.println("Chua nhap du lieu!");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("SV " + (i + 1) + ": " + arr[i]);
        }
    }

    public static void tinhTrungBinh(double[] arr) {
        if (arr == null) return;

        double sum = 0;
        for (double d : arr) sum += d;

        System.out.println("Diem trung binh: " + (sum / arr.length));
    }

    public static void timMaxMin(double[] arr) {
        if (arr == null) return;

        double max = arr[0], min = arr[0];

        for (double d : arr) {
            if (d > max) max = d;
            if (d < min) min = d;
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static void demDatTruot(double[] arr) {
        if (arr == null) return;

        int dat = 0, truot = 0;

        for (double d : arr) {
            if (d >= 5) dat++;
            else truot++;
        }

        System.out.println("Dat: " + dat);
        System.out.println("Truot: " + truot);
    }

    public static void sapXepTang(double[] arr) {
        if (arr == null) return;

        Arrays.sort(arr);
        System.out.println("Da sap xep!");
    }

    public static void thongKeGioi(double[] arr) {
        if (arr == null) return;

        int count = 0;

        for (double d : arr) {
            if (d >= 8) count++;
        }

        System.out.println("So SV gioi/xuat sac: " + count);
    }
}