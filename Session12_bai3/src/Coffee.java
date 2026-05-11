import java.util.Scanner;

public class Coffee extends Drink {

    public Coffee() {
    }

    public Coffee(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Cach pha che: Pha bang may");
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);
    }

    @Override
    public void displayData() {
        System.out.println("===== COFFEE =====");
        super.displayData();
    }
}