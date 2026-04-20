import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vanToc,thoiGian,quangDuong;

        System.out.print("Nhập vận tốc (km/h): ");
        vanToc = scanner.nextDouble();

        if (vanToc <= 0) {
            System.out.println("Vận tốc phải lớn hơn 0!");
            return;
        }

        System.out.print("Nhập thời gian (giờ): ");
        thoiGian = scanner.nextDouble();

        if (thoiGian <= 0) {
            System.out.println("Thời gian phải lớn hơn 0!");
            return;
        }



        quangDuong = vanToc*thoiGian;

        System.out.println("Quãng đường của bạn là: " + quangDuong + " km");
    }
}