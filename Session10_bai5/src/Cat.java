class Cat extends Mammal {
    public Cat(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " kêu: Meo meo!");
    }

    public void climbTree() {
        System.out.println(name + " đang leo cây.");
    }
}