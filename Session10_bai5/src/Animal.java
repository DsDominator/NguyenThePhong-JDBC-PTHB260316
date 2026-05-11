class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("Tên: " + name + ", Tuổi: " + age);
    }

    public void makeSound() {
        System.out.println("Động vật đang phát ra tiếng kêu...");
    }

    // Overloading eat()
    public void eat() {
        System.out.println(name + " đang ăn...");
    }

    public void eat(String food) {
        System.out.println(name + " đang ăn " + food);
    }
}
