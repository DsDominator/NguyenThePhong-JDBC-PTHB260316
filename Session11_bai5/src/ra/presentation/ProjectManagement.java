package ra.presentation;

import ra.entity.Employee;
import ra.entity.Project;

import java.util.Arrays;
import java.util.Scanner;

public class ProjectManagement {
    private static Employee[] arrEmp = new Employee[100];
    private static int empCount = 0;
    private static Project[] arrProject = new Project[100];
    private static int proCount = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n============= QUẢN LÝ DỰ ÁN =============");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý dự án");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: employeeMenu(); break;
                case 2: projectMenu(); break;
                case 3: System.exit(0);
            }
        }
    }

    private static void employeeMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n============= QUẢN LÝ NHÂN VIÊN =============");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật thông tin");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Sắp xếp lương giảm dần");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn: ");
            int c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 1:
                    Employee e = new Employee();
                    e.inputData(sc, arrEmp, empCount);
                    arrEmp[empCount++] = e;
                    break;
                case 2:
                    for(int i=0; i<empCount; i++) arrEmp[i].displayData();
                    break;
                case 6:
                    Arrays.sort(arrEmp, 0, empCount, (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
                    System.out.println("Đã sắp xếp!");
                    break;
                case 7: back = true; break;
                // Các case khác bạn triển khai tương tự logic CRUD
            }
        }
    }

    private static void projectMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n============= QUẢN LÝ DỰ ÁN =============");
            System.out.println("1. Thêm dự án");
            System.out.println("2. Hiển thị danh sách dự án");
            System.out.println("3. Cập nhật dự án");
            System.out.println("4. Xóa dự án (chỉ khi chưa có NV)");
            System.out.println("5. Thêm nhân viên vào dự án");
            System.out.println("6. Tìm dự án theo tên");
            System.out.println("7. Thống kê NV theo vai trò");
            System.out.println("8. Tìm dự án đang chạy & gần kết thúc");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn: ");
            int c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1:
                    Project p = new Project();
                    p.inputData(sc, arrProject, proCount, arrEmp, empCount);
                    arrProject[proCount++] = p;
                    break;
                case 2:
                    for(int i=0; i<proCount; i++) arrProject[i].displayData();
                    break;
                case 4:
                    deleteProject();
                    break;
                case 5:
                    addEmployeeToProject();
                    break;
                case 9: back = true; break;
            }
        }
    }

    private static void addEmployeeToProject() {
        System.out.print("Nhập mã dự án: ");
        String pId = sc.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        String eId = sc.nextLine();

        Project p = null;
        for(int i=0; i<proCount; i++) if(arrProject[i].getProjectId().equals(pId)) p = arrProject[i];

        Employee e = null;
        for(int i=0; i<empCount; i++) if(arrEmp[i].getEmployeeId().equals(eId)) e = arrEmp[i];

        if(p != null && e != null) {
            Employee[] newEmps = Arrays.copyOf(p.getEmployees(), p.getEmployees().length + 1);
            newEmps[newEmps.length - 1] = e;
            p.setEmployees(newEmps);
            System.out.println("Thêm thành công!");
        } else {
            System.err.println("Không tìm thấy dự án hoặc nhân viên!");
        }
    }

    private static void deleteProject() {
        System.out.print("Nhập mã dự án cần xóa: ");
        String id = sc.nextLine();
        for (int i = 0; i < proCount; i++) {
            if (arrProject[i].getProjectId().equals(id)) {
                if (arrProject[i].getEmployees().length == 0) {
                    for (int j = i; j < proCount - 1; j++) arrProject[j] = arrProject[j + 1];
                    proCount--;
                    System.out.println("Xóa thành công!");
                } else {
                    System.err.println("Dự án đã có nhân viên, không thể xóa!");
                }
                return;
            }
        }
        System.err.println("Không tìm thấy mã dự án!");
    }
}
