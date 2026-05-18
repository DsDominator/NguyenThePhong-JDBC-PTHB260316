public class Motorcycle extends MotorVehicle {

    public Motorcycle(String brand, int year, String fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine starts with kick starter.");
    }

    public void doWheelie() {
        System.out.println("Motorcycle is doing a wheelie!");
    }
}