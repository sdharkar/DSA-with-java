package oops;

/**
 * This class provides explanations and simple code examples for each of the five SOLID principles.
 * SOLID is an acronym for five design principles intended to make software designs more
 * understandable, flexible, and maintainable.
 */
public class SOLIDPrinciples {

    public static void main(String[] args) {
        System.out.println("--- Demonstrating SOLID Principles ---\n");
        demonstrateSRP();
        demonstrateOCP();
        demonstrateLSP();
        demonstrateISP();
        demonstrateDIP();
    }

    // 1. Single Responsibility Principle (SRP)
    // A class should have only one reason to change.
    private static void demonstrateSRP() {
        System.out.println("1. Single Responsibility Principle (SRP)");
        System.out.println("   - An Invoice class should only handle invoice data, not printing.");
        System.out.println("   - A separate InvoicePrinter class handles the printing logic.");
        // Good Example:
        class Invoice {
            private final double amount;
            public Invoice(double amount) { this.amount = amount; }
            public double getAmount() { return amount; }
            // Calculation logic would go here
        }

        class InvoicePrinter {
            public void print(Invoice invoice) {
                System.out.println("   Printing Invoice: Amount = $" + invoice.getAmount());
            }
        }

        Invoice invoice = new Invoice(100.0);
        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);
        System.out.println("   ----------------------------------------------------");
    }

    // 2. Open/Closed Principle (OCP)
    // Software entities (classes, modules, functions) should be open for extension, but closed for modification.
    private static void demonstrateOCP() {
        System.out.println("\n2. Open/Closed Principle (OCP)");
        System.out.println("   - We can add new shapes (extensions) without modifying the AreaCalculator.");
        // Good Example:
        interface Shape {
            double area();
        }

        class Circle implements Shape {
            private final double radius;
            public Circle(double radius) { this.radius = radius; }
            public double area() { return Math.PI * radius * radius; }
        }

        class Square implements Shape {
            private final double side;
            public Square(double side) { this.side = side; }
            public double area() { return side * side; }
        }

        // This class is closed for modification but open for extension via the Shape interface.
        class AreaCalculator {
            public double calculateArea(Shape shape) {
                return shape.area();
            }
        }

        AreaCalculator calculator = new AreaCalculator();
        Circle circle = new Circle(5);
        Square square = new Square(4);
        System.out.printf("   Area of Circle: %.2f\n", calculator.calculateArea(circle));
        System.out.printf("   Area of Square: %.2f\n", calculator.calculateArea(square));
        System.out.println("   ----------------------------------------------------");
    }

    // 3. Liskov Substitution Principle (LSP)
    // Subtypes must be substitutable for their base types without altering the correctness of the program.
    private static void demonstrateLSP() {
        System.out.println("\n3. Liskov Substitution Principle (LSP)");
        System.out.println("   - A 'Penguin' is a 'Bird', but it can't fly. Forcing it to have a fly() method breaks LSP.");
        System.out.println("   - Better: A 'FlyingBird' subclass can be used wherever a 'Bird' is expected to fly.");

        // Good Example:
        class Bird {
            public void eat() { System.out.println("   Bird is eating."); }
        }

        class FlyingBird extends Bird {
            public void fly() { System.out.println("   FlyingBird is flying."); }
        }

        class Sparrow extends FlyingBird {}
        class Penguin extends Bird {} // Penguin doesn't extend FlyingBird

        FlyingBird sparrow = new Sparrow();
        sparrow.eat();
        sparrow.fly(); // This is valid and works as expected.

        Penguin penguin = new Penguin();
        penguin.eat(); // This is also valid.
        // penguin.fly(); // This would be a compile error, correctly preventing misuse.
        System.out.println("   ----------------------------------------------------");
    }

    // 4. Interface Segregation Principle (ISP)
    // Clients should not be forced to depend on interfaces they do not use.
    private static void demonstrateISP() {
        System.out.println("\n4. Interface Segregation Principle (ISP)");
        System.out.println("   - A 'Robot' worker shouldn't be forced to implement an 'eat' method.");
        System.out.println("   - Segregate interfaces into 'Workable' and 'Eatable'.");

        // Good Example:
        interface Workable { void work(); }
        interface Eatable { void eat(); }

        class HumanWorker implements Workable, Eatable {
            public void work() { System.out.println("   Human is working."); }
            public void eat() { System.out.println("   Human is eating."); }
        }

        class RobotWorker implements Workable {
            public void work() { System.out.println("   Robot is working."); }
        }

        HumanWorker human = new HumanWorker();
        human.work();
        human.eat();

        RobotWorker robot = new RobotWorker();
        robot.work();
        System.out.println("   ----------------------------------------------------");
    }

    // 5. Dependency Inversion Principle (DIP)
    // High-level modules should not depend on low-level modules. Both should depend on abstractions.
    private static void demonstrateDIP() {
        System.out.println("\n5. Dependency Inversion Principle (DIP)");
        System.out.println("   - A high-level 'NotificationService' should not depend on a low-level 'EmailClient'.");
        System.out.println("   - Both should depend on an abstraction, like 'MessageSender'.");

        // Good Example:
        interface MessageSender { void send(String message); }

        class EmailSender implements MessageSender {
            public void send(String message) { System.out.println("   Sending Email: " + message); }
        }

        class SmsSender implements MessageSender {
            public void send(String message) { System.out.println("   Sending SMS: " + message); }
        }

        // High-level module depends on the abstraction (MessageSender)
        class NotificationService {
            private final MessageSender sender;
            public NotificationService(MessageSender sender) { this.sender = sender; } // Dependency is injected
            public void notifyUser(String message) { sender.send(message); }
        }

        NotificationService emailNotifier = new NotificationService(new EmailSender());
        emailNotifier.notifyUser("Your order has shipped!");

        NotificationService smsNotifier = new NotificationService(new SmsSender());
        smsNotifier.notifyUser("Your package is out for delivery!");
        System.out.println("   ----------------------------------------------------");
    }
}