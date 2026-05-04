//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Dog dog = new Dog("Buddy", 3, "Brown");
    Cat cat = new Cat("Kitty", 2, "Persian");

    dog.makeSound();
    dog.meow();

    cat.makeSound();
    cat.bark();
}
