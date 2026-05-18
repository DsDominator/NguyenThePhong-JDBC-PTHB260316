import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên: ");

            int number = sc.nextInt();

            // Kiểm tra số hợp lệ
            if (number <= 0) {
                System.out.println(
                        "Lỗi: Số phải lớn hơn 0 để kiểm tra số nguyên tố!"
                );
            } else {

                // Kiểm tra số nguyên tố
                if (isPrime(number)) {
                    System.out.println(number + " là số nguyên tố.");
                } else {
                    System.out.println(number + " không phải là số nguyên tố.");
                }
            }

        } catch (InputMismatchException e) {

            System.out.println(
                    "Lỗi: Bạn phải nhập một số nguyên hợp lệ!"
            );

        } finally {
            sc.close();
        }
    }
}
