class Elephant extends Mammal {
    public Elephant(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " kêu: Ùm bòooo!");
    }

    public void sprayWater() {
        System.out.println(name + " đang phun nước bằng vòi.");
    }
}