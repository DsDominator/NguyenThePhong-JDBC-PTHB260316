import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Số dư ban đầu
        double balance = 1_000_000;

        // Số dư tối thiểu
        final double MIN_BALANCE = 50_000;

        try {

            System.out.println("===== RÚT TIỀN NGÂN HÀNG =====");
            System.out.println("Số dư hiện tại: " + balance + " đồng");

            System.out.print("Nhập số tiền muốn rút: ");

            double withdrawAmount = sc.nextDouble();

            // Kiểm tra số tiền âm hoặc bằng 0
            if (withdrawAmount <= 0) {

                System.out.println(
                        "Lỗi: Số tiền rút phải lớn hơn 0!"
                );

            }
            // Kiểm tra vượt quá số dư
            else if (withdrawAmount > balance) {

                System.out.println(
                        "Lỗi: Số tiền rút vượt quá số dư!"
                );

            }
            // Kiểm tra số dư tối thiểu
            else if ((balance - withdrawAmount) < MIN_BALANCE) {

                System.out.println(
                        "Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!"
                );

            }
            // Rút thành công
            else {

                balance -= withdrawAmount;

                System.out.println("\nRút tiền thành công!");
                System.out.println(
                        "Số tiền đã rút: " + withdrawAmount + " đồng"
                );

                System.out.println(
                        "Số dư còn lại: " + balance + " đồng"
                );
            }

        } catch (InputMismatchException e) {

            System.out.println(
                    "Lỗi: Vui lòng nhập một số hợp lệ!"
            );

        } finally {

            sc.close();
        }
    }
}
