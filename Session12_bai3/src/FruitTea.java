import java.util.Scanner;

public class FruitTea extends Drink {

    public FruitTea() {
    }

    public FruitTea(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Cach pha che: Lac voi da va trai cay tuoi");
    }

    @Override
    public void inputData(Scanner sc) {
        super.inputData(sc);
    }

    @Override
    public void displayData() {
        System.out.println("===== FRUIT TEA =====");
        super.displayData();
    }
}
