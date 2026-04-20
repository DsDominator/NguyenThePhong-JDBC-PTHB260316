import java.util.Scanner;
import java.util.Random;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Nhập n (1-1000): ");
        int n = sc.nextInt();

        if (n < 1 || n > 1000) {
            System.out.println("n không hợp lệ!");
            return;
        }

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder result = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = rand.nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        System.out.println("Chuỗi ngẫu nhiên: " + result.toString());

        sc.close();
    }
}