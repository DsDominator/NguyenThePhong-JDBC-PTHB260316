public class Car extends MotorVehicle {

    public Car(String brand, int year, String fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine starts with push button.");
    }

    public void openTrunk() {
        System.out.println("Opening car trunk.");
    }
}