package oops;

public class OopsRecall {
    // 1. Encapsulation
    // Encapsulation is the concept of wrapping data (variables) and code (methods) together as a single unit.
    // It restricts direct access to some of the object's components, which is achieved using access modifiers.
    static class EncapsulatedClass {
        private int value; // private variable
        public void setValue(int value) { // public setter
            this.value = value;
        }
        public int getValue() { // public getter
            return value;
        }
    }

    // 2. Inheritance
    // Inheritance is the mechanism by which one class (child/subclass) acquires the properties and behaviors of another class (parent/superclass).
    static class Animal {
        void sound() {
            System.out.println("Animal makes a sound");
        }
    }
    static class Dog extends Animal {
        void sound() {
            System.out.println("Dog barks");
        }
    }

    // 3. Polymorphism
    // Polymorphism means "many forms". It allows one interface to be used for a general class of actions.
    // The most common use is method overriding (runtime polymorphism).
    static void makeSound(Animal animal) {
        animal.sound();
    }

    // 4. Abstraction
    // Abstraction is the concept of hiding the complex implementation details and showing only the essential features of the object.
    // It is achieved using abstract classes and interfaces.
    static abstract class Shape {
        abstract void draw();
    }
    static class Circle extends Shape {
        void draw() {
            System.out.println("Drawing Circle");
        }
    }

    // Main method to demonstrate all concepts
    public static void main(String[] args) {
        // Encapsulation
        EncapsulatedClass obj = new EncapsulatedClass();
        obj.setValue(42);
        System.out.println("Encapsulation: Value = " + obj.getValue());

        // Inheritance & Polymorphism
        Animal a = new Animal();
        Dog d = new Dog();
        a.sound(); // Animal sound
        d.sound(); // Dog barks
        makeSound(a); // Animal sound
        makeSound(d); // Dog barks (polymorphism)

        // Abstraction
        Shape s = new Circle();
        s.draw();
    }
}
