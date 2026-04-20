import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float width, height;
        float area, perimeter;

        System.out.print("Nhập chiều rộng: ");
        width = scanner.nextFloat();

        System.out.print("Nhập chiều cao: ");
        height = scanner.nextFloat();

        area = width * height;
        perimeter = 2 * (width + height);

        System.out.println("Diện tích hình chữ nhật: " + area);
        System.out.println("Chu vi hình chữ nhật: " + perimeter);
    }
}
