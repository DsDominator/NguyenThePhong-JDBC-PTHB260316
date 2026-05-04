import java.text.DecimalFormat;

public class CurrencyConverter {

    private static double rate;

    public static void setRate(double r) {
        if (r <= 0) {
            System.out.println("Tỉ giá không hợp lệ!");
            return;
        }
        rate = r;
    }

    public static double getRate() {
        return rate;
    }

    public static double toUSD(int vnd) {
        if (rate == 0) {
            System.out.println("Chưa thiết lập tỉ giá!");
            return 0;
        }
        return vnd / rate;
    }

    public static String formatUSD(double usd) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(usd);
    }

    public static void main(String[] args) {
        CurrencyConverter.setRate(24000); // 1 USD = 24,000 VND

        int vnd = 48000;
        double usd = CurrencyConverter.toUSD(vnd);

        System.out.println("VND: " + vnd);
        System.out.println("USD: " + CurrencyConverter.formatUSD(usd));
    }
}