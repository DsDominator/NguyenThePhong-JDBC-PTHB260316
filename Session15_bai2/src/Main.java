import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SubjectManager<Subject> manager =
                new SubjectManager<>();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int choice = -1;

        do {

            System.out.println("\n===== QUẢN LÝ MÔN HỌC =====");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm môn học");
            System.out.println("3. Xóa môn học");
            System.out.println("4. Tìm kiếm theo tên");
            System.out.println("5. Lọc môn credits > 3");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn: ");

            try {

                choice =
                        Integer.parseInt(sc.nextLine());

                switch (choice) {

                    // ===== HIỂN THỊ =====
                    case 1:

                        manager.display();
                        break;

                    // ===== THÊM =====
                    case 2:

                        System.out.print("Nhập code: ");
                        String code = sc.nextLine();

                        System.out.print("Nhập tên môn học: ");
                        String name = sc.nextLine();

                        System.out.print("Nhập credits: ");

                        int credits =
                                Integer.parseInt(sc.nextLine());

                        // Kiểm tra credits
                        if (credits < 0 || credits > 10) {

                            throw new InvalidCreditsException(
                                    "Credits phải từ 0 -> 10"
                            );
                        }

                        System.out.print(
                                "Nhập ngày bắt đầu (dd/MM/yyyy): "
                        );

                        LocalDate startDate =
                                LocalDate.parse(
                                        sc.nextLine(),
                                        formatter
                                );

                        manager.add(
                                new Subject(
                                        code,
                                        name,
                                        credits,
                                        startDate
                                )
                        );

                        break;

                    // ===== XÓA =====
                    case 3:

                        System.out.print(
                                "Nhập code cần xóa: "
                        );

                        String deleteCode =
                                sc.nextLine();

                        manager.deleteByCode(deleteCode);

                        break;

                    // ===== TÌM KIẾM =====
                    case 4:

                        System.out.print(
                                "Nhập tên môn học cần tìm: "
                        );

                        String keyword =
                                sc.nextLine();

                        manager.searchByName(keyword);

                        break;

                    // ===== LỌC =====
                    case 5:

                        manager.filterCredits();

                        break;

                    case 0:

                        System.out.println(
                                "Thoát chương trình!"
                        );

                        break;

                    default:

                        System.out.println(
                                "Lựa chọn không hợp lệ!"
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Lỗi: Credits hoặc menu phải là số!"
                );

            } catch (InvalidCreditsException e) {

                System.out.println(
                        "Lỗi: " + e.getMessage()
                );

            } catch (Exception e) {

                System.out.println(
                        "Lỗi: " + e.getMessage()
                );
            }

        } while (choice != 0);

        sc.close();
    }
}
