public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Phương thức abstract
    abstract void pay();

    // Phương thức thường
    void printAmount() {
        System.out.println("Số tiền: " + amount);
    }
}