public class Truck extends MotorVehicle {

    public Truck(String brand, int year, String fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println("Truck engine starts loudly.");
    }

    public void loadCargo() {
        System.out.println("Truck is loading cargo.");
    }
}