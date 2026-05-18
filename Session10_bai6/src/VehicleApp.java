import java.util.ArrayList;
import java.util.Scanner;

public class VehicleApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Toyota", 2022, "Xăng"));
        vehicles.add(new Motorcycle("Honda", 2020, "Xăng"));
        vehicles.add(new Truck("Hyundai", 2019, "Dầu"));

        int choice;

        do {
            System.out.println("\n================ VEHICLE MANAGEMENT MENU =================");
            System.out.println("1. Hiển thị thông tin tất cả phương tiện");
            System.out.println("2. Kiểm tra Overriding: startEngine()");
            System.out.println("3. Kiểm tra Overloading: move()");
            System.out.println("4. Kiểm tra đa hình runtime (mảng Vehicle[])");
            System.out.println("5. Gọi các hành vi đặc trưng theo loại");
            System.out.println("6. Thêm phương tiện mới (Car/Motorcycle/Truck)");
            System.out.println("0. Thoát");
            System.out.println("==========================================================");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("\n--- DANH SÁCH PHƯƠNG TIỆN ---");

                    for (Vehicle v : vehicles) {
                        v.showInfo();
                        System.out.println("----------------------");
                    }
                    break;

                case 2:
                    System.out.println("\n--- OVERRIDING startEngine() ---");

                    for (Vehicle v : vehicles) {
                        v.startEngine();
                    }
                    break;

                case 3:
                    System.out.println("\n--- OVERLOADING move() ---");

                    Vehicle v = new Vehicle("Generic", 2024);

                    v.move();
                    v.move(80);

                    break;

                case 4:
                    System.out.println("\n--- ĐA HÌNH RUNTIME ---");

                    for (Vehicle vehicle : vehicles) {
                        vehicle.startEngine();
                    }

                    break;

                case 5:
                    System.out.println("\n--- HÀNH VI ĐẶC TRƯNG ---");

                    for (Vehicle vehicle : vehicles) {

                        if (vehicle instanceof Car) {
                            ((Car) vehicle).openTrunk();

                        } else if (vehicle instanceof Motorcycle) {
                            ((Motorcycle) vehicle).doWheelie();

                        } else if (vehicle instanceof Truck) {
                            ((Truck) vehicle).loadCargo();
                        }
                    }

                    break;

                case 6:

                    System.out.println("\nChọn loại phương tiện:");
                    System.out.println("1. Car");
                    System.out.println("2. Motorcycle");
                    System.out.println("3. Truck");
                    System.out.print("Nhập lựa chọn: ");

                    int type = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập hãng xe: ");
                    String brand = sc.nextLine();

                    System.out.print("Nhập năm sản xuất: ");
                    int year = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập loại nhiên liệu: ");
                    String fuel = sc.nextLine();

                    switch (type) {

                        case 1:
                            vehicles.add(new Car(brand, year, fuel));
                            System.out.println("Đã thêm Car.");
                            break;

                        case 2:
                            vehicles.add(new Motorcycle(brand, year, fuel));
                            System.out.println("Đã thêm Motorcycle.");
                            break;

                        case 3:
                            vehicles.add(new Truck(brand, year, fuel));
                            System.out.println("Đã thêm Truck.");
                            break;

                        default:
                            System.out.println("Loại phương tiện không hợp lệ.");
                    }

                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);

        sc.close();
    }
}