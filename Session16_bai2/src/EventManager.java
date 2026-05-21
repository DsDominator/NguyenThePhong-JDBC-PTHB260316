import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManager {

    static List<Event> events = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Thêm sự kiện
    public static void addEvent() {

        try {

            System.out.print("Nhap ten su kien: ");
            String name = sc.nextLine();

            System.out.print("Nhap thoi gian bat dau (dd/MM/yyyy HH:mm): ");
            String start = sc.nextLine();

            System.out.print("Nhap thoi gian ket thuc (dd/MM/yyyy HH:mm): ");
            String end = sc.nextLine();

            LocalDateTime startDate =
                    LocalDateTime.parse(start, formatter);

            LocalDateTime endDate =
                    LocalDateTime.parse(end, formatter);

            Event event = new Event(name, startDate, endDate);

            events.add(event);

            System.out.println("Them su kien thanh cong!");

        } catch (DateTimeParseException e) {

            System.out.println("Sai dinh dang ngay gio!");
            System.out.println("Dung dinh dang: dd/MM/yyyy HH:mm");

        } catch (Exception e) {

            System.out.println("Co loi xay ra!");
        }
    }

    // Hiển thị danh sách sự kiện
    public static void showEvents() {

        if (events.isEmpty()) {
            System.out.println("Danh sach su kien rong!");
            return;
        }

        System.out.println("\n===== DANH SACH SU KIEN =====");

        for (Event e : events) {
            System.out.println(e);
        }
    }

    // Menu
    public static void menu() {

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Them su kien");
            System.out.println("2. Hien thi danh sach su kien");
            System.out.println("0. Thoat");

            System.out.print("Chon chuc nang: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addEvent();
                    break;

                case 2:
                    showEvents();
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh!");
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
