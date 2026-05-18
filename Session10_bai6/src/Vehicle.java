public class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void showInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }

    public void startEngine() {
        System.out.println("Vehicle engine started.");
    }

    public void move() {
        System.out.println("Vehicle is moving.");
    }

    public void move(int speed) {
        System.out.println("Vehicle is moving at " + speed + " km/h.");
    }
}