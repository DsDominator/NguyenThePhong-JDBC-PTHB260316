import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm ký tự");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome");
            System.out.println("5. Chuẩn hóa chuỗi");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập chuỗi: ");
                    str = sc.nextLine();
                    break;

                case 2:
                    countCharacters(str);
                    break;

                case 3:
                    reverseString(str);
                    break;

                case 4:
                    checkPalindrome(str);
                    break;

                case 5:
                    str = normalizeString(str);
                    System.out.println("Chuỗi sau chuẩn hóa: " + str);
                    break;

                case 6:
                    System.out.println("Thoát chương trình!");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void countCharacters(String str) {
        int lower = 0, upper = 0, digit = 0, special = 0;

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) lower++;
            else if (Character.isUpperCase(c)) upper++;
            else if (Character.isDigit(c)) digit++;
            else special++;
        }

        System.out.println("Chữ thường: " + lower);
        System.out.println("Chữ hoa: " + upper);
        System.out.println("Chữ số: " + digit);
        System.out.println("Ký tự đặc biệt: " + special);
    }

    public static void reverseString(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Chuỗi đảo ngược: " + reversed);
    }

    public static void checkPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        if (cleaned.equals(reversed)) {
            System.out.println("Chuỗi là Palindrome");
        } else {
            System.out.println("Chuỗi không phải Palindrome");
        }
    }

    public static String normalizeString(String str) {
        str = str.trim().replaceAll("\\s+", " ");

        if (str.length() == 0) return str;

        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}