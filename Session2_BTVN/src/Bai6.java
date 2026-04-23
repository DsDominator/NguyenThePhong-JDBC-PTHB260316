import java.util.Scanner;

public class Bai6 {
    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;
        int digits = String.valueOf(num).length(); // số chữ số

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;

        while (true) {
            System.out.print("Nhập số nguyên dương N: ");
            if (sc.hasNextInt()) {
                N = sc.nextInt();
                if (N >= 0) {
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Số nhập vào không hợp lệ");
        }

        System.out.println("Các số Armstrong từ 0 đến " + N + " là:");
        for (int i = 0; i <= N; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }
}