public class Main {
    public static void main(String[] args) {

        // Tạo mảng Device[]
        Device[] devices = new Device[3];

        devices[0] = new SmartPhone(1, "iPhone");
        devices[1] = new Laptop(2, "Dell XPS");
        devices[2] = new Television(3, "Samsung TV");

        // Duyệt mảng
        for (Device d : devices) {

            d.turnOn();

            // Nếu hỗ trợ Wifi
            if (d instanceof Connectable) {
                Connectable c = (Connectable) d;
                c.connectWifi();
            }

            // Nếu sạc được
            if (d instanceof Chargeable) {
                Chargeable ch = (Chargeable) d;
                ch.charge();
            }

            d.turnOff();

            System.out.println("-------------------");
        }
    }
}
