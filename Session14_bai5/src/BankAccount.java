public class BankAccount {

    private String accountId;
    private double balance;

    // Constructor rỗng
    public BankAccount() {
    }

    // Constructor đầy đủ tham số
    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    // Getter & Setter
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Gửi tiền
    public void deposit(double amount) throws Exception {

        if (amount <= 0) {
            throw new Exception(
                    "Số tiền gửi phải lớn hơn 0!"
            );
        }

        balance += amount;

        System.out.println(
                "Gửi tiền thành công vào tài khoản "
                        + accountId
        );
    }

    // Rút tiền
    public void withdraw(double amount) throws Exception {

        if (amount <= 0) {
            throw new Exception(
                    "Số tiền rút phải lớn hơn 0!"
            );
        }

        if (amount > balance) {
            throw new Exception(
                    "Số dư không đủ để rút!"
            );
        }

        balance -= amount;

        System.out.println(
                "Rút tiền thành công từ tài khoản "
                        + accountId
        );
    }

    // Chuyển tiền
    public void transfer(BankAccount target, double amount)
            throws Exception {

        if (target == null) {
            throw new Exception(
                    "Tài khoản đích không tồn tại!"
            );
        }

        if (amount <= 0) {
            throw new Exception(
                    "Số tiền chuyển phải lớn hơn 0!"
            );
        }

        if (amount > balance) {
            throw new Exception(
                    "Số dư không đủ để chuyển!"
            );
        }

        // Trừ tiền tài khoản nguồn
        balance -= amount;

        // Cộng tiền tài khoản đích
        target.balance += amount;

        System.out.println(
                "Chuyển tiền thành công từ "
                        + accountId
                        + " -> "
                        + target.accountId
        );
    }

    @Override
    public String toString() {
        return "Số tài khoản: " + accountId +
                " | Số dư: " + balance;
    }
}