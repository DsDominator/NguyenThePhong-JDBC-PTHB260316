import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên N: ");
        int N = sc.nextInt();

        // Nếu số âm thì chuyển thành dương
        N = Math.abs(N);

        int sum = 0;

        // Tách từng chữ số và cộng lại
        while (N > 0) {
            int digit = N % 10; // lấy chữ số cuối
            sum += digit;       // cộng vào tổng
            N /= 10;            // bỏ chữ số cuối
        }

        // In kết quả
        System.out.println("Tổng các chữ số là: " + sum);

        sc.close();
    }
}
