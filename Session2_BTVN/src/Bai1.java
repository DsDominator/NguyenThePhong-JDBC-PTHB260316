import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương N: ");
        int N = sc.nextInt();

        // Kiểm tra hợp lệ
        if (N <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int sum = 0;

            // Tính tổng từ 1 đến N
            for (int i = 1; i <= N; i++) {
                sum += i;
            }

            // In kết quả
            System.out.println("Tổng từ 1 đến " + N + " là: " + sum);
        }

        sc.close();
    }
}
