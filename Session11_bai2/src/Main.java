public class Main {
    public static void main(String[] args) {

        // Tạo mảng Payment[]
        Payment[] payments = new Payment[3];

        payments[0] = new CashPayment(100000);
        payments[1] = new CreditCardPayment(250000);
        payments[2] = new EWalletPayment(500000);

        // Duyệt mảng
        for (Payment p : payments) {

            p.pay();

            // Nếu đối tượng có Refundable
            if (p instanceof Refundable) {
                Refundable r = (Refundable) p;
                r.refund();
            }

            System.out.println("-------------------");
        }
    }
}

