public class CreditCardPayment extends Payment implements Refundable {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Thanh toán bằng thẻ tín dụng");
        printAmount();
    }

    @Override
    public void refund() {
        System.out.println("Hoàn tiền qua thẻ tín dụng");
    }
}