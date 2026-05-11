package ra.entity;

import java.util.Scanner;

public class Employee {
    public enum Role { DEV, TESTER, PM, BA }

    private String employeeId;
    private String employeeName;
    private Role role;
    private double salary;

    public Employee() {}

    public Employee(String employeeId, String employeeName, Role role, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
    }

    // Getter và Setter
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void inputData(Scanner scanner, Employee[] arrEmp, int index) {
        this.employeeId = inputEmployeeId(scanner, arrEmp, index);
        this.employeeName = inputEmployeeName(scanner);
        this.role = inputRole(scanner);
        this.salary = inputSalary(scanner);
    }

    private String inputEmployeeId(Scanner scanner, Employee[] arrEmp, int index) {
        while (true) {
            System.out.print("Nhập mã NV (E + 4 số): ");
            String id = scanner.nextLine();
            if (id.matches("^E\\d{4}$")) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrEmp[i].getEmployeeId().equals(id)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) return id;
                System.err.println("Mã nhân viên đã tồn tại!");
            } else {
                System.err.println("Sai định dạng! Ví dụ: E0001");
            }
        }
    }

    private String inputEmployeeName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên NV (6-30 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 6 && name.length() <= 30) return name;
            System.err.println("Độ dài tên không hợp lệ!");
        }
    }

    private Role inputRole(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Chọn Role (1.DEV, 2.TESTER, 3.PM, 4.BA): ");
                int choice = Integer.parseInt(scanner.nextLine());
                return Role.values()[choice - 1];
            } catch (Exception e) {
                System.err.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private double inputSalary(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập lương (>0): ");
                double sal = Double.parseDouble(scanner.nextLine());
                if (sal > 0) return sal;
                System.err.println("Lương phải lớn hơn 0!");
            } catch (Exception e) {
                System.err.println("Vui lòng nhập số!");
            }
        }
    }

    public void displayData() {
        System.out.printf("ID: %-6s | Tên: %-20s | Role: %-8s | Lương: %.2f\n",
                employeeId, employeeName, role, salary);
    }
}