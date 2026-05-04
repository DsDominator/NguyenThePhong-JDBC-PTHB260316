import java.util.Scanner;

public class bai6 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double[] salaries = inputData();

        int choice;
        do {
            showMenu();
            choice = getChoice();

            switch (choice) {
                case 1:
                    displaySalaries(salaries);
                    break;
                case 2:
                    sortSalaries(salaries);
                    break;
                case 3:
                    searchSalary(salaries);
                    break;
                case 4:
                    statistics(salaries);
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    // ===== Nhập dữ liệu =====
    public static double[] inputData() {
        int n;
        do {
            System.out.print("Nhập số lượng nhân viên: ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Số lượng phải > 0!");
            }
        } while (n <= 0);

        double[] salaries = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập lương nhân viên [" + i + "]: ");
            salaries[i] = sc.nextDouble();
        }
        return salaries;
    }

    // ===== Menu =====
    public static void showMenu() {
        System.out.println("\n--- QUẢN LÝ LƯƠNG NHÂN VIÊN ---");
        System.out.println("1. Xem danh sách lương");
        System.out.println("2. Sắp xếp lương");
        System.out.println("3. Tìm kiếm lương cụ thể");
        System.out.println("4. Thống kê lương");
        System.out.println("5. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    public static int getChoice() {
        return sc.nextInt();
    }

    // ===== Hiển thị =====
    public static void displaySalaries(double[] salaries) {
        System.out.println("Danh sách lương:");
        for (int i = 0; i < salaries.length; i++) {
            System.out.println("Nhân viên " + i + ": " + salaries[i]);
        }
    }

    // ===== Sắp xếp =====
    public static void sortSalaries(double[] salaries) {
        System.out.println("1. Tăng dần");
        System.out.println("2. Giảm dần");
        System.out.print("Chọn kiểu sắp xếp: ");
        int type = sc.nextInt();

        for (int i = 0; i < salaries.length - 1; i++) {
            for (int j = i + 1; j < salaries.length; j++) {
                if ((type == 1 && salaries[i] > salaries[j]) ||
                        (type == 2 && salaries[i] < salaries[j])) {

                    double temp = salaries[i];
                    salaries[i] = salaries[j];
                    salaries[j] = temp;
                }
            }
        }

        System.out.println("Danh sách sau khi sắp xếp:");
        displaySalaries(salaries);
    }

    // ===== Tìm kiếm =====
    public static void searchSalary(double[] salaries) {
        System.out.print("Nhập lương cần tìm: ");
        double x = sc.nextDouble();

        boolean found = false;
        for (int i = 0; i < salaries.length; i++) {
            if (salaries[i] == x) {
                System.out.println("Tìm thấy tại vị trí: " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy!");
        }
    }

    // ===== Thống kê =====
    public static void statistics(double[] salaries) {
        double sum = 0;
        double max = salaries[0];
        double min = salaries[0];

        for (double s : salaries) {
            sum += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }

        double avg = sum / salaries.length;

        int countAboveAvg = 0;
        for (double s : salaries) {
            if (s > avg) countAboveAvg++;
        }

        System.out.println("Tổng lương: " + sum);
        System.out.println("Lương trung bình: " + avg);
        System.out.println("Lương cao nhất: " + max);
        System.out.println("Lương thấp nhất: " + min);
        System.out.println("Số NV lương > trung bình: " + countAboveAvg);
    }
}