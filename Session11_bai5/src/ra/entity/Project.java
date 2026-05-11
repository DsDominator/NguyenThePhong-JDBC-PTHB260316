package ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project {
    public enum ProjectStatus { PLANNING, RUNNING, FINISHED }

    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee[] employees = new Employee[0];
    private ProjectStatus status;

    public Project() {}

    // Getter và Setter
    public String getProjectId() { return projectId; }
    public String getProjectName() { return projectName; }
    public Employee[] getEmployees() { return employees; }
    public void setEmployees(Employee[] employees) { this.employees = employees; }
    public LocalDate getEndDate() { return endDate; }
    public ProjectStatus getStatus() { return status; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setStatus(ProjectStatus status) { this.status = status; }

    public void inputData(Scanner scanner, Project[] arrProject, int index, Employee[] arrEmp, int empIndex) {
        this.projectId = inputProjectId(scanner, arrProject, index);
        this.projectName = inputProjectName(scanner, arrProject, index);
        this.startDate = inputDate(scanner, "Bắt đầu");
        this.endDate = inputEndDate(scanner, this.startDate);
        this.status = inputStatus(scanner);
        // Việc thêm nhân viên sẽ được thực hiện qua chức năng riêng trong menu để linh hoạt hơn
    }

    private String inputProjectId(Scanner scanner, Project[] arrProject, int index) {
        while (true) {
            System.out.print("Nhập mã dự án (P + 4 ký tự): ");
            String id = scanner.nextLine();
            if (id.matches("^P.{4}$")) return id;
            System.err.println("Sai định dạng!");
        }
    }

    private String inputProjectName(Scanner scanner, Project[] arrProject, int index) {
        while (true) {
            System.out.print("Nhập tên dự án (10-50 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() < 10 || name.length() > 50) {
                System.err.println("Độ dài không hợp lệ!");
                continue;
            }
            boolean isExist = false;
            for (int i = 0; i < index; i++) {
                if (arrProject[i].getProjectName().equals(name)) {
                    isExist = true; break;
                }
            }
            if (!isExist) return name;
            System.err.println("Tên dự án đã tồn tại!");
        }
    }

    private LocalDate inputDate(Scanner scanner, String type) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Nhập ngày " + type + " (dd/MM/yyyy): ");
                return LocalDate.parse(scanner.nextLine(), dtf);
            } catch (Exception e) {
                System.err.println("Định dạng ngày không đúng!");
            }
        }
    }

    private LocalDate inputEndDate(Scanner scanner, LocalDate startDate) {
        while (true) {
            LocalDate end = inputDate(scanner, "Kết thúc");
            if (!end.isBefore(startDate)) return end;
            System.err.println("Ngày kết thúc phải sau hoặc bằng ngày bắt đầu!");
        }
    }

    private ProjectStatus inputStatus(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Trạng thái (1.PLANNING, 2.RUNNING, 3.FINISHED): ");
                int choice = Integer.parseInt(scanner.nextLine());
                return ProjectStatus.values()[choice - 1];
            } catch (Exception e) {
                System.err.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void displayData() {
        System.out.println("--------------------------------------------------");
        System.out.printf("Mã DA: %s | Tên DA: %s\n", projectId, projectName);
        System.out.printf("Thời gian: %s -> %s | Trạng thái: %s\n", startDate, endDate, status);
        System.out.println("Nhân viên tham gia:");
        if (employees.length == 0) System.out.println("  (Chưa có nhân viên)");
        for (Employee e : employees) {
            System.out.printf("  - %s (%s)\n", e.getEmployeeName(), e.getRole());
        }
    }
}
