class Animal {
    public void makeSound() {
        System.out.println("Animal sound.");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Cat meows.");
    }
}

class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myAnimal.makeSound();
        myDog.makeSound();
        myCat.makeSound();
    }
}
