import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số (100-999): ");
        int n = sc.nextInt();

        // Kiểm tra hợp lệ
        if (n < 100 || n > 999) {
            System.out.println("Số nhập vào không hợp lệ");
            return;
        }

        // Tách số
        int hundreds = n / 100;
        int tens = (n / 10) % 10;
        int units = n % 10;

        String result = "";

        // Đọc hàng trăm
        switch (hundreds) {
            case 1: result += "Một trăm "; break;
            case 2: result += "Hai trăm "; break;
            case 3: result += "Ba trăm "; break;
            case 4: result += "Bốn trăm "; break;
            case 5: result += "Năm trăm "; break;
            case 6: result += "Sáu trăm "; break;
            case 7: result += "Bảy trăm "; break;
            case 8: result += "Tám trăm "; break;
            case 9: result += "Chín trăm "; break;
        }

        // Đọc hàng chục và đơn vị
        if (tens == 0) {
            if (units != 0) {
                result += "lẻ ";
            }
        } else if (tens == 1) {
            result += "mười ";
        } else {
            switch (tens) {
                case 2: result += "hai mươi "; break;
                case 3: result += "ba mươi "; break;
                case 4: result += "bốn mươi "; break;
                case 5: result += "năm mươi "; break;
                case 6: result += "sáu mươi "; break;
                case 7: result += "bảy mươi "; break;
                case 8: result += "tám mươi "; break;
                case 9: result += "chín mươi "; break;
            }
        }

        // Đọc hàng đơn vị
        switch (units) {
            case 1:
                result += (tens > 1) ? "mốt" : "một";
                break;
            case 2: result += "hai"; break;
            case 3: result += "ba"; break;
            case 4: result += "bốn"; break;
            case 5:
                result += (tens >= 1) ? "lăm" : "năm";
                break;
            case 6: result += "sáu"; break;
            case 7: result += "bảy"; break;
            case 8: result += "tám"; break;
            case 9: result += "chín"; break;
        }

        // In kết quả
        System.out.println("Cách đọc: " + result.trim());

        sc.close();
    }
}
