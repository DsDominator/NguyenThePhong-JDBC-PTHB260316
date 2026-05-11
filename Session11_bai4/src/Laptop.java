public class Laptop extends Device
        implements Connectable, Chargeable {

    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    void turnOn() {
        System.out.println(name + " đã bật");
    }

    @Override
    void turnOff() {
        System.out.println(name + " đã tắt");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " đang kết nối Wifi");
    }

    @Override
    public void charge() {
        System.out.println(name + " đang sạc pin");
    }
}