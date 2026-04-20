//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter
import java.util.Scanner;
void main() {
  //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
  // to see how IntelliJ IDEA suggests fixing it.
    //Bai1
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập bán kính hình tròn: ");
    double radius = scanner.nextDouble();

    double area = Math.PI * radius * radius;
    System.out.println("Diện tích hình tròn là: " + area);
    //Bai2
    int firstNumber, secondNumber;

    System.out.print("Nhập số nguyên thứ nhất: ");
    firstNumber = scanner.nextInt();

    System.out.print("Nhập số nguyên thứ hai: ");
    secondNumber = scanner.nextInt();

    int sum = firstNumber + secondNumber;
    int difference = firstNumber - secondNumber;
    int product = firstNumber * secondNumber;
    int quotient = firstNumber / secondNumber;
    int remainder = firstNumber % secondNumber;

    System.out.println("First Number: " + firstNumber);
    System.out.println("Second Number: " + secondNumber);
    System.out.println("Tổng: " + sum);
    System.out.println("Hiệu: " + difference);
    System.out.println("Tích: " + product);
    System.out.println("Thương: " + quotient);
    System.out.println("Phần dư: " + remainder);

    //Bai3
    System.out.print("Nhập tử số phân số 1: ");
    int tu1 = scanner.nextInt();
    System.out.print("Nhập mẫu số phân số 1: ");
    int mau1 = scanner.nextInt();

    System.out.print("Nhập tử số phân số 2: ");
    int tu2 = scanner.nextInt();
    System.out.print("Nhập mẫu số phân số 2: ");
    int mau2 = scanner.nextInt();

    if (mau1 == 0 || mau2 == 0) {
        System.out.println("Mẫu số phải khác 0!");
        return;
    }

    int tuKQ = tu1 * mau2 + tu2 * mau1;
    int mauKQ = mau1 * mau2;
    System.out.println("Tổng hai phân số là: " + tuKQ + "/" + mauKQ);


}
