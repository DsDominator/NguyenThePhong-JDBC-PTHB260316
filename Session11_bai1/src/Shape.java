abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // Phương thức abstract
    abstract double getArea();

    abstract double getPerimeter();

    // Phương thức thường
    void displayInfo() {
        System.out.println("Tên hình: " + name);
    }
}
