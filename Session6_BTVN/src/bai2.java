import java.util.Scanner;

public class bai2 {
    static Scanner sc = new Scanner(System.in);

    static String hoTen = "";
    static String email = "";
    static String phone = "";
    static String password = "";

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n********** QUAN LY NGUOI DUNG **********");
            System.out.println("1. Nhap thong tin nguoi dung");
            System.out.println("2. Chuan hoa ho ten");
            System.out.println("3. Kiem tra email hop le");
            System.out.println("4. Kiem tra so dien thoai hop le");
            System.out.println("5. Kiem tra mat khau hop le");
            System.out.println("6. Thoat");
            System.out.print("Lua chon: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    nhapThongTin();
                    break;
                case 2:
                    hoTen = chuanHoaTen(hoTen);
                    System.out.println("Ho ten sau chuan hoa: " + hoTen);
                    break;
                case 3:
                    if (kiemTraEmail(email)) {
                        System.out.println("Email hop le");
                    } else {
                        System.out.println("Email khong hop le");
                    }
                    break;
                case 4:
                    if (kiemTraPhone(phone)) {
                        System.out.println("So dien thoai hop le");
                    } else {
                        System.out.println("So dien thoai khong hop le");
                    }
                    break;
                case 5:
                    if (kiemTraPassword(password)) {
                        System.out.println("Mat khau hop le");
                    } else {
                        System.out.println("Mat khau khong hop le");
                    }
                    break;
                case 6:
                    System.out.println("Thoat!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static void nhapThongTin() {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();

        System.out.print("Nhap email: ");
        email = sc.nextLine();

        System.out.print("Nhap so dien thoai: ");
        phone = sc.nextLine();

        System.out.print("Nhap mat khau: ");
        password = sc.nextLine();
    }

    public static String chuanHoaTen(String name) {
        name = name.trim().replaceAll("\\s+", " ");
        String[] words = name.split(" ");
        StringBuilder result = new StringBuilder();

        for (String w : words) {
            result.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1).toLowerCase())
                    .append(" ");
        }

        return result.toString().trim();
    }

    public static boolean kiemTraEmail(String email) {
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";
        return email.matches(regex);
    }

    public static boolean kiemTraPhone(String phone) {
        // 0xxxxxxxxx hoặc +84xxxxxxxxx
        String regex = "^(0|\\+84)[0-9]{9}$";
        return phone.matches(regex);
    }

    public static boolean kiemTraPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%]).{8,}$";
        return password.matches(regex);
    }
}