import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double weight, height, bmi;

        System.out.print("Nhập cân nặng (kg): ");
        weight = scanner.nextDouble();

        System.out.print("Nhập chiều cao (m): ");
        height = scanner.nextDouble();

        if (height <= 0) {
            System.out.println("Chiều cao phải lớn hơn 0!");
            return;
        }

        bmi = weight / (height * height);

        System.out.println("Chỉ số BMI của bạn là: " + bmi);
    }
}