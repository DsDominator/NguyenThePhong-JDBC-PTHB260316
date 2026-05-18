import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Danh sách số nguyên hợp lệ
        ArrayList<Integer> validNumbers = new ArrayList<>();

        int invalidCount = 0;

        System.out.println("Nhập các chuỗi (gõ 'exit' để kết thúc):");

        while (true) {

            System.out.print("Nhập chuỗi: ");
            String input = sc.nextLine();

            // Kiểm tra kết thúc
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {

                // Chuyển đổi chuỗi sang số nguyên
                int number = Integer.parseInt(input);

                // Lưu số hợp lệ
                validNumbers.add(number);

                System.out.println("Hợp lệ -> " + number);

            } catch (NumberFormatException e) {

                // Đếm chuỗi không hợp lệ
                invalidCount++;

                System.out.println(
                        "Không hợp lệ: '" + input + "' không phải số nguyên!"
                );
            }
        }

        // Thống kê kết quả
        System.out.println("\n===== KẾT QUẢ =====");

        System.out.println(
                "Số lượng chuỗi hợp lệ: " + validNumbers.size()
        );

        System.out.println(
                "Số lượng chuỗi không hợp lệ: " + invalidCount
        );

        System.out.println(
                "Danh sách số nguyên hợp lệ: " + validNumbers
        );

        sc.close();
    }
}