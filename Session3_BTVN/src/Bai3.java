import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        int count = 0;
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        double totalBonus = 0;

        while (true) {
            // Menu
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Nhập lương (0 - 500 triệu, -1 để kết thúc): ");
                        double salary = sc.nextDouble();

                        if (salary == -1) break;

                        if (salary < 0 || salary > 500_000_000) {
                            System.out.println("Lương không hợp lệ, nhập lại!");
                            continue;
                        }

                        // Phân loại
                        if (salary < 5_000_000) {
                            System.out.println("Thu nhập thấp");
                        } else if (salary <= 15_000_000) {
                            System.out.println("Thu nhập trung bình");
                        } else if (salary <= 50_000_000) {
                            System.out.println("Thu nhập khá");
                        } else {
                            System.out.println("Thu nhập cao");
                        }

                        // Tính thưởng
                        double bonus = 0;
                        if (salary <= 5_000_000) {
                            bonus = salary * 0.05;
                        } else if (salary <= 15_000_000) {
                            bonus = salary * 0.10;
                        } else if (salary <= 50_000_000) {
                            bonus = salary * 0.15;
                        } else if (salary <= 100_000_000) {
                            bonus = salary * 0.20;
                        } else {
                            bonus = salary * 0.25;
                        }

                        totalBonus += bonus;

                        // Thống kê
                        count++;
                        sum += salary;

                        if (salary > max) max = salary;
                        if (salary < min) min = salary;
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double avg = sum / count;

                        System.out.println("\n===== THỐNG KÊ =====");
                        System.out.println("Số nhân viên: " + count);
                        System.out.printf("Lương trung bình: %.2f\n", avg);
                        System.out.printf("Lương cao nhất: %.2f\n", max);
                        System.out.printf("Lương thấp nhất: %.2f\n", min);
                        System.out.printf("Tổng tiền lương: %.2f\n", sum);;
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.printf("Tổng tiền thưởng: %.2f\n", totalBonus);
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}