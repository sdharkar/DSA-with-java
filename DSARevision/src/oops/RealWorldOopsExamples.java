package oops;

/**
 * This class demonstrates real-world applications of the four core OOP principles
 * using examples commonly found in Java and Spring Boot applications.
 */
public class RealWorldOopsExamples {

    public static void main(String[] args) {
        System.out.println("--- Real-World OOPs Examples in Java/Spring Boot ---\n");

        demonstrateEncapsulation();
        demonstrateInheritance();
        demonstratePolymorphism();
        demonstrateAbstraction();
    }

    /**
     * Encapsulation: Bundling data and methods that operate on that data, and restricting
     * direct access to some of an object's components.
     */
    public static void demonstrateEncapsulation() {
        System.out.println("1. Encapsulation Example: A Spring Boot @Entity or a JavaBean");
        System.out.println("   A 'User' entity encapsulates its data (id, name) with private fields and provides public getters/setters.");
        System.out.println("   This protects the object's state, ensures data integrity (e.g., validation in setters), and is a core principle of JavaBeans and JPA entities.");
        System.out.println("   ----------------------------------------------------");
        /*
         * @Entity
         * public class User {
         *     @Id
         *     private Long id;
         *     private String name;
         *
         *     // Public getters and setters provide controlled access
         *     public Long getId() { return id; }
         *     public void setId(Long id) { this.id = id; }
         *     public String getName() { return name; }
         *     public void setName(String name) { this.name = name; }
         * }
         */
    }

    /**
     * Inheritance: A mechanism where a new class derives from an existing class,
     * inheriting its properties and behaviors.
     */
    public static void demonstrateInheritance() {
        System.out.println("\n2. Inheritance Example: Custom Application Exceptions");
        System.out.println("   Creating a specific exception 'ResourceNotFoundException' that inherits from 'RuntimeException'.");
        System.out.println("   This allows for specific error handling (e.g., in a Spring @ControllerAdvice) while reusing the behavior of a standard Java exception.");
        System.out.println("   ----------------------------------------------------");
        /*
         * public class ResourceNotFoundException extends RuntimeException {
         *     public ResourceNotFoundException(String message) {
         *         super(message);
         *     }
         * }
         */
    }

    /**
     * Polymorphism: The ability of an object to take on many forms. The most common use
     * is when a parent class reference is used to refer to a child class object.
     */
    public static void demonstratePolymorphism() {
        System.out.println("\n3. Polymorphism Example: Spring Dependency Injection with Interfaces");
        System.out.println("   A controller can depend on a 'NotificationService' interface. At runtime, Spring can inject different implementations (EmailService, SmsService) without changing the controller's code.");
        System.out.println("   This allows the system to be flexible and extensible. The controller treats all notification services the same way, regardless of their specific type.");
        System.out.println("   ----------------------------------------------------");
        /*
         * public interface NotificationService { void sendNotification(String message); }
         * @Component("email") public class EmailService implements NotificationService { ... }
         * @Component("sms") public class SmsService implements NotificationService { ... }
         *
         * @RestController
         * public class OrderController {
         *     private final NotificationService notificationService;
         *
         *     // Spring injects a concrete implementation based on configuration or @Qualifier.
         *     // The controller code is decoupled from the concrete implementation.
         *     public OrderController(@Qualifier("email") NotificationService service) {
         *         this.notificationService = service;
         *     }
         * }
         */
    }

    /**
     * Abstraction: Hiding complex implementation details and showing only the essential
     * features of the object.
     */
    public static void demonstrateAbstraction() {
        System.out.println("\n4. Abstraction Example: Spring Data JPA Repositories");
        System.out.println("   Developers define a 'UserRepository' interface extending JpaRepository. They don't need to write the implementation for CRUD operations.");
        System.out.println("   Spring provides the implementation at runtime, hiding the complex database interaction logic (SQL queries, transaction management, connection handling).");
        System.out.println("   ----------------------------------------------------");
        /*
         * // Developer only defines the interface and custom query methods.
         * public interface UserRepository extends JpaRepository<User, Long> {
         *     // No implementation needed for save(), findById(), findAll(), etc.
         *     // The complexity is abstracted away by the Spring Data framework.
         *     Optional<User> findByUsername(String username); // Spring even implements this based on the method name.
         * }
         */
    }
}