import java.util.Scanner;

public class ZooApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo các đối tượng mẫu
        Dog dog = new Dog("Lu", 3, true);
        Cat cat = new Cat("Miu", 2, true);
        Elephant elephant = new Elephant("Voi Con", 10, false);

        // Mảng Animal để kiểm tra đa hình Runtime
        Animal[] animals = {dog, cat, elephant};

        int choice;
        do {
            System.out.println("\n================ ZOO MANAGEMENT MENU ================");
            System.out.println("1. Tạo đối tượng và hiển thị thông tin (Kế thừa + super)");
            System.out.println("2. Kiểm tra Overriding: gọi makeSound() của từng con vật");
            System.out.println("3. Kiểm tra Overloading: gọi eat() và eat(String)");
            System.out.println("4. Kiểm tra đa hình runtime (Animal array)");
            System.out.println("5. Gọi phương thức đặc trưng của từng loài");
            System.out.println("0. Thoát chương trình");
            System.out.println("======================================================");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dog.showInfo();
                    cat.showInfo();
                    elephant.showInfo();
                    break;
                case 2:
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    break;
                case 3:
                    dog.eat(); // eat() không tham số
                    dog.eat("Xương"); // eat(String) có tham số
                    break;
                case 4:
                    System.out.println("Duyệt mảng Animal (Đa hình):");
                    for (Animal a : animals) {
                        a.makeSound(); // Mỗi con vật sẽ kêu theo cách riêng của nó
                    }
                    break;
                case 5:
                    dog.fetchBall();
                    cat.climbTree();
                    elephant.sprayWater();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        sc.close();
    }
}