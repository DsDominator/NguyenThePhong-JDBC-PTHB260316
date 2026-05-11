class Car {

    // Thuộc tính
    int currentSpeed = 0;

    // Tăng tốc mặc định
    public void accelerate() {
        currentSpeed += 10;
        System.out.println("Car accelerates by default: +10 km/h");
    }

    // Tăng tốc theo giá trị truyền vào
    public void accelerate(int speed) {
        currentSpeed += speed;
        System.out.println("Car accelerates by " + speed + " km/h");
    }

    // Tăng tốc theo tốc độ và thời gian
    public void accelerate(int speed, int seconds) {
        int increase = speed * seconds;
        currentSpeed += increase;

        System.out.println(
                "Car accelerates " + increase + " km/h (speed x time)"
        );
    }

    // Hiển thị trạng thái tốc độ hiện tại
    public void printStatus() {
        System.out.println("Current speed: " + currentSpeed + " km/h");
    }
}

public class Main {
    public static void main(String[] args) {

        Car car = new Car();

        car.accelerate();
        car.printStatus();

        System.out.println("----------------");

        car.accelerate(20);
        car.printStatus();

        System.out.println("----------------");

        car.accelerate(5, 4);
        car.printStatus();
    }
}