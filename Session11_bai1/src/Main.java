//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Shape[] shapes = new Shape[2];

    shapes[0] = new Rectangle(5, 3);
    shapes[1] = new Circle(4);

    for (Shape s : shapes) {

        s.displayInfo();

        System.out.println("Diện tích: " + s.getArea());
        System.out.println("Chu vi: " + s.getPerimeter());

        Drawable d = (Drawable) s;
        d.draw();

        System.out.println("-------------------");
    }
}
