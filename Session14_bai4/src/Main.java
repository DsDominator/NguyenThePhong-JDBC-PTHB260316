import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> validPhones = new ArrayList<>();
        ArrayList<String> invalidPhones = new ArrayList<>();

        System.out.println(
                "Nhập các số điện thoại (cách nhau bằng dấu phẩy):"
        );

        String input = sc.nextLine();

        // Tách chuỗi theo dấu phẩy
        String[] phones = input.split(",");

        // Duyệt từng số điện thoại
        for (String phone : phones) {

            // Xóa khoảng trắng đầu/cuối
            phone = phone.trim();

            try {

                // Kiểm tra hợp lệ
                InvalidPhoneNumberLengthException
                        .validatePhoneNumber(phone);

                // Nếu hợp lệ
                validPhones.add(phone);

            } catch (InvalidPhoneNumberLengthException e) {

                // Nếu không hợp lệ
                invalidPhones.add(
                        phone + " : " + e.getMessage()
                );
            }
        }

        // Hiển thị kết quả
        System.out.println("\nSố điện thoại hợp lệ:");

        if (validPhones.isEmpty()) {
            System.out.println("Không có số hợp lệ");
        } else {
            for (String phone : validPhones) {
                System.out.println("- " + phone);
            }
        }

        System.out.println("\nSố điện thoại không hợp lệ:");

        if (invalidPhones.isEmpty()) {
            System.out.println("Không có số không hợp lệ");
        } else {
            for (String phone : invalidPhones) {
                System.out.println("- " + phone);
            }
        }

        sc.close();
    }
}