package ra.run;

import ra.business.TaskManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskManagement taskManagement =
                new TaskManagement();

        while (true) {

            System.out.println("\n===== TODO LIST =====");

            System.out.println("1. Thêm công việc");
            System.out.println("2. Danh sách công việc");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Xóa công việc");
            System.out.println("5. Tìm kiếm công việc");
            System.out.println("6. Thống kê công việc");
            System.out.println("0. Thoát");

            System.out.print("Chọn chức năng: ");

            try {

                int choice =
                        Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print(
                                "Nhập tên công việc: ");

                        String taskName =
                                sc.nextLine();

                        System.out.print(
                                "Nhập trạng thái: ");

                        String status =
                                sc.nextLine();

                        taskManagement.addTask(
                                taskName,
                                status
                        );

                        break;

                    case 2:

                        taskManagement.listTasks();

                        break;

                    case 3:

                        System.out.print(
                                "Nhập ID công việc: ");

                        int updateId =
                                Integer.parseInt(
                                        sc.nextLine());

                        System.out.print(
                                "Nhập trạng thái mới: ");

                        String newStatus =
                                sc.nextLine();

                        taskManagement.updateTaskStatus(
                                updateId,
                                newStatus
                        );

                        break;

                    case 4:

                        System.out.print(
                                "Nhập ID cần xóa: ");

                        int deleteId =
                                Integer.parseInt(
                                        sc.nextLine());

                        taskManagement.deleteTask(
                                deleteId
                        );

                        break;

                    case 5:

                        System.out.print(
                                "Nhập tên cần tìm: ");

                        String searchName =
                                sc.nextLine();

                        taskManagement.searchTaskByName(
                                searchName
                        );

                        break;

                    case 6:

                        taskManagement.taskStatistics();

                        break;

                    case 0:

                        System.out.println(
                                "Thoát chương trình!"
                        );

                        System.exit(0);

                    default:

                        System.out.println(
                                "Lựa chọn không hợp lệ!"
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Lỗi: Vui lòng nhập đúng số!"
                );

            } catch (Exception e) {

                System.out.println(
                        "Có lỗi xảy ra: "
                                + e.getMessage()
                );
            }
        }
    }
}