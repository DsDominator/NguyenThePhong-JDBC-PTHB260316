import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập 3 cạnh
        System.out.print("Nhập cạnh a: ");
        int a = sc.nextInt();

        System.out.print("Nhập cạnh b: ");
        int b = sc.nextInt();

        System.out.print("Nhập cạnh c: ");
        int c = sc.nextInt();

        // Kiểm tra hợp lệ (phải > 0 và thỏa mãn bất đẳng thức tam giác)
        if (a <= 0 || b <= 0 || c <= 0 ||
                a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        } else {
            // Phân loại tam giác

            // 1. Tam giác đều
            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều.");
            }
            // 2. Tam giác cân
            else if (a == b || a == c || b == c) {
                System.out.println("Đây là tam giác cân.");
            }
            // 3. Tam giác vuông
            else if (a * a + b * b == c * c ||
                    a * a + c * c == b * b ||
                    b * b + c * c == a * a) {
                System.out.println("Đây là tam giác vuông.");
            }
            // 4. Tam giác thường
            else {
                System.out.println("Đây là tam giác thường.");
            }
        }

        sc.close();
    }
}