class Dog extends Mammal {
    public Dog(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " sủa: Gâu gâu!");
    }

    public void fetchBall() {
        System.out.println(name + " đang chạy đi nhặt bóng.");
    }
}



