class Mammal extends Animal {
    protected boolean hasFur;

    public Mammal(String name, int age, boolean hasFur) {
        super(name, age); // Gọi constructor lớp cha
        this.hasFur = hasFur;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Có lông: " + (hasFur ? "Có" : "Không"));
    }
}
