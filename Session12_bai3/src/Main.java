import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Drink> menu = new ArrayList<>();

        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Them mon vao menu");
            System.out.println("2. Hien thi menu");
            System.out.println("3. Ap dung giam gia");
            System.out.println("4. Xoa mon");
            System.out.println("5. Thong ke");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("1. Coffee");
                    System.out.println("2. Fruit Tea");
                    System.out.print("Nhap lua chon: ");

                    int type = Integer.parseInt(sc.nextLine());

                    Drink drink = null;

                    if (type == 1) {
                        drink = new Coffee();
                    } else if (type == 2) {
                        drink = new FruitTea();
                    }

                    if (drink != null) {
                        drink.inputData(sc);
                        menu.add(drink);

                        System.out.println("Them thanh cong");
                    }

                    break;

                case 2:

                    if (menu.isEmpty()) {
                        System.out.println("Menu rong");
                    } else {

                        for (Drink d : menu) {
                            d.displayData();
                            System.out.println("-------------------");
                        }
                    }

                    break;

                case 3:

                    if (menu.isEmpty()) {
                        System.out.println("Menu rong");
                    } else {

                        System.out.print("Nhap phan tram giam gia: ");
                        double discount = Double.parseDouble(sc.nextLine());

                        for (Drink d : menu) {
                            d.applyDiscount(discount);
                        }

                        System.out.println("Ap dung giam gia thanh cong");
                    }

                    break;

                case 4:

                    System.out.print("Nhap ID mon can xoa: ");
                    String deleteId = sc.nextLine();

                    boolean foundDelete = false;

                    for (int i = 0; i < menu.size(); i++) {

                        if (menu.get(i).getId().equalsIgnoreCase(deleteId)) {

                            menu.remove(i);

                            foundDelete = true;

                            System.out.println("Xoa thanh cong");
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Khong tim thay mon");
                    }

                    break;

                case 5:

                    if (menu.isEmpty()) {
                        System.out.println("Menu rong");
                    } else {

                        double sum = 0;

                        for (Drink d : menu) {
                            sum += d.getPrice();
                        }

                        double avg = sum / menu.size();

                        System.out.println("Tong gia tien: " + sum);
                        System.out.println("Gia trung binh: " + avg);
                    }

                    break;

                case 6:

                    System.out.println("Thoat chuong trinh");
                    System.exit(0);

                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}