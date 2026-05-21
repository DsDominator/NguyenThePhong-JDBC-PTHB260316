import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatManager {

    static List<Message> messages = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Gửi tin nhắn
    public static void sendMessage() {

        System.out.print("Nhap ten nguoi gui: ");
        String sender = sc.nextLine();

        System.out.print("Nhap noi dung: ");
        String content = sc.nextLine();

        Message msg = new Message(
                sender,
                content,
                LocalDateTime.now()
        );

        messages.add(msg);

        System.out.println("Gui tin nhan thanh cong!");
    }

    // Xem lịch sử chat
    public static void showMessages() {

        if (messages.isEmpty()) {
            System.out.println("Chua co tin nhan!");
            return;
        }

        System.out.println("\n===== LICH SU CHAT =====");

        messages.forEach(System.out::println);
    }

    // Lọc theo người gửi
    public static void filterBySender() {

        System.out.print("Nhap ten nguoi gui: ");
        String sender = sc.nextLine();

        System.out.println("\n===== TIN NHAN CUA " + sender + " =====");

        messages.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(sender))
                .forEach(System.out::println);
    }

    // Lọc theo ngày
    public static void filterByDate() {

        try {

            System.out.print("Nhap ngay (dd/MM/yyyy): ");
            String input = sc.nextLine();

            LocalDate date =
                    LocalDate.parse(input, dateFormatter);

            System.out.println("\n===== TIN NHAN NGAY " + input + " =====");

            messages.stream()
                    .filter(m ->
                            m.getTimestamp()
                                    .toLocalDate()
                                    .equals(date))
                    .forEach(System.out::println);

        } catch (DateTimeParseException e) {

            System.out.println("Sai dinh dang ngay!");
            System.out.println("Dung dinh dang dd/MM/yyyy");

        } catch (Exception e) {

            System.out.println("Co loi xay ra!");
        }
    }

    // Menu
    public static void menu() {

        while (true) {

            System.out.println("\n===== MENU CHAT =====");
            System.out.println("1. Gui tin nhan");
            System.out.println("2. Xem lich su chat");
            System.out.println("3. Loc theo nguoi gui");
            System.out.println("4. Loc theo ngay");
            System.out.println("0. Thoat");

            System.out.print("Chon chuc nang: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    sendMessage();
                    break;

                case 2:
                    showMessages();
                    break;

                case 3:
                    filterBySender();
                    break;

                case 4:
                    filterByDate();
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