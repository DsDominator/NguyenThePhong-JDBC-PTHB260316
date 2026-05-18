public class Invoice {

    private String invoiceId;
    private double amount;

    public Invoice(String invoiceId, double amount) {
        this.invoiceId = invoiceId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Mã hóa đơn: " + invoiceId +
                " | Số tiền: " + amount;
    }
}