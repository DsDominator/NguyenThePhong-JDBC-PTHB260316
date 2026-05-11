class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Đã vẽ hình tròn");
    }
}
