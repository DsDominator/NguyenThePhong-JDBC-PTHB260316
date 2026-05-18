import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Hàm tìm tài khoản theo mã
    public static BankAccount findAccount(
            List<BankAccount> accounts,
            String accountId
    ) {

        for (BankAccount acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                return acc;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Danh sách tài khoản
        List<BankAccount> accounts = new ArrayList<>();

        // Tạo tài khoản mẫu
        accounts.add(new BankAccount("ACC01", 500000));
        accounts.add(new BankAccount("ACC02", 1000000));
        accounts.add(new BankAccount("ACC03", 2000000));

        System.out.println("===== DANH SÁCH TÀI KHOẢN =====");

        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }

        try {

            // ===== GỬI TIỀN =====
            System.out.println("\n===== GỬI TIỀN =====");

            System.out.print("Nhập tài khoản cần gửi: ");
            String depositId = sc.nextLine();

            BankAccount depositAcc =
                    findAccount(accounts, depositId);

            if (depositAcc == null) {
                throw new Exception(
                        "Tài khoản không tồn tại!"
                );
            }

            System.out.print("Nhập số tiền gửi: ");
            double depositAmount =
                    Double.parseDouble(sc.nextLine());

            depositAcc.deposit(depositAmount);

            System.out.println(depositAcc);

            // ===== RÚT TIỀN =====
            System.out.println("\n===== RÚT TIỀN =====");

            System.out.print("Nhập tài khoản cần rút: ");
            String withdrawId = sc.nextLine();

            BankAccount withdrawAcc =
                    findAccount(accounts, withdrawId);

            if (withdrawAcc == null) {
                throw new Exception(
                        "Tài khoản không tồn tại!"
                );
            }

            System.out.print("Nhập số tiền rút: ");
            double withdrawAmount =
                    Double.parseDouble(sc.nextLine());

            withdrawAcc.withdraw(withdrawAmount);

            System.out.println(withdrawAcc);

            // ===== CHUYỂN TIỀN =====
            System.out.println("\n===== CHUYỂN TIỀN =====");

            System.out.print("Nhập tài khoản nguồn: ");
            String sourceId = sc.nextLine();

            BankAccount sourceAcc =
                    findAccount(accounts, sourceId);

            if (sourceAcc == null) {
                throw new Exception(
                        "Tài khoản nguồn không tồn tại!"
                );
            }

            System.out.print("Nhập tài khoản đích: ");
            String targetId = sc.nextLine();

            BankAccount targetAcc =
                    findAccount(accounts, targetId);

            System.out.print("Nhập số tiền chuyển: ");
            double transferAmount =
                    Double.parseDouble(sc.nextLine());

            sourceAcc.transfer(targetAcc, transferAmount);

            System.out.println("\n===== SAU KHI CHUYỂN =====");

            for (BankAccount acc : accounts) {
                System.out.println(acc);
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "Lỗi: Số tiền phải là số hợp lệ!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Lỗi: " + e.getMessage()
            );

        } finally {

            sc.close();
        }
    }
}