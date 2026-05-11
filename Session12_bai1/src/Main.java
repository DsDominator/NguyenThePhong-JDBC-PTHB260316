import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Staff> staffList = new ArrayList<>();

        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Them moi");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Thoat");
            System.out.print("Nhap lua chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("1. Them Giang vien");
                    System.out.println("2. Them Nhan vien hanh chinh");
                    System.out.print("Nhap lua chon: ");

                    int type = Integer.parseInt(sc.nextLine());

                    Staff staff = null;

                    if (type == 1) {
                        staff = new Lecturer();
                    } else if (type == 2) {
                        staff = new AdminStaff();
                    }

                    if (staff != null) {
                        staff.inputData(sc);
                        staffList.add(staff);
                        System.out.println("Them thanh cong");
                    }

                    break;

                case 2:
                    if (staffList.isEmpty()) {
                        System.out.println("Danh sach rong");
                    } else {
                        for (Staff s : staffList) {
                            s.displayData();
                            System.out.println("-------------------");
                        }
                    }

                    break;

                case 3:
                    System.out.print("Nhap ID can cap nhat: ");
                    String updateId = sc.nextLine();

                    boolean foundUpdate = false;

                    for (Staff s : staffList) {
                        if (s.getId().equalsIgnoreCase(updateId)) {

                            System.out.println("Nhap thong tin moi:");
                            s.inputData(sc);

                            foundUpdate = true;
                            System.out.println("Cap nhat thanh cong");
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("Khong tim thay nhan vien");
                    }

                    break;

                case 4:
                    System.out.print("Nhap ID can xoa: ");
                    String deleteId = sc.nextLine();

                    boolean foundDelete = false;

                    for (int i = 0; i < staffList.size(); i++) {
                        if (staffList.get(i).getId().equalsIgnoreCase(deleteId)) {

                            staffList.remove(i);

                            foundDelete = true;
                            System.out.println("Xoa thanh cong");
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Khong tim thay nhan vien");
                    }

                    break;

                case 5:
                    System.out.println("Thoat chuong trinh");
                    System.exit(0);

                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}