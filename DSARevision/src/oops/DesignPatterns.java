package oops;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates some of the most common and fundamental Design Patterns in Java.
 * Design Patterns are reusable solutions to commonly occurring problems within a given context in software design.
 */
public class DesignPatterns {

    // Singleton Pattern: ConfigurationManager as a static nested class
    static class ConfigurationManager {
        private static volatile ConfigurationManager instance;
        private final long creationTime;

        private ConfigurationManager() {
            this.creationTime = System.nanoTime();
        }

        public static ConfigurationManager getInstance() {
            if (instance == null) {
                synchronized (ConfigurationManager.class) {
                    if (instance == null) {
                        instance = new ConfigurationManager();
                    }
                }
            }
            return instance;
        }

        public long getCreationTime() {
            return creationTime;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Common Design Patterns ---\n");
        demonstrateSingleton();
        demonstrateFactory();
        demonstrateObserver();
    }

    // 1. Singleton Pattern (Creational)
    // Ensures a class has only one instance and provides a global point of access to it.
    private static void demonstrateSingleton() {
        System.out.println("1. Singleton Pattern");
        System.out.println("   - Ensures only one instance of a class is created.");

        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        System.out.println("   Config1 hash: " + config1.hashCode());
        System.out.println("   Config2 hash: " + config2.hashCode());
        System.out.println("   Are instances the same? " + (config1 == config2));
        System.out.println("   ----------------------------------------------------");
    }

    // 2. Factory Pattern (Creational)
    // Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
    private static void demonstrateFactory() {
        System.out.println("\n2. Factory Pattern");
        System.out.println("   - Creates objects without exposing the instantiation logic to the client.");

        // Good Example: A factory for creating different types of notifications.
        interface Notification {
            void send(String message);
        }
        class EmailNotification implements Notification {
            public void send(String message) { System.out.println("   Sending Email: " + message); }
        }
        class SmsNotification implements Notification {
            public void send(String message) { System.out.println("   Sending SMS: " + message); }
        }

        class NotificationFactory {
            public Notification createNotification(String type) {
                if ("EMAIL".equalsIgnoreCase(type)) {
                    return new EmailNotification();
                } else if ("SMS".equalsIgnoreCase(type)) {
                    return new SmsNotification();
                }
                throw new IllegalArgumentException("Unknown notification type: " + type);
            }
        }

        NotificationFactory factory = new NotificationFactory();
        Notification email = factory.createNotification("EMAIL");
        email.send("Welcome aboard!");

        Notification sms = factory.createNotification("SMS");
        sms.send("Your package has arrived.");
        System.out.println("   ----------------------------------------------------");
    }

    // 3. Observer Pattern (Behavioral)
    // Defines a one-to-many dependency between objects so that when one object changes state,
    // all its dependents are notified and updated automatically.
    private static void demonstrateObserver() {
        System.out.println("\n3. Observer Pattern");
        System.out.println("   - When a subject's state changes, all its observers are notified.");

        // Good Example: A news agency (subject) notifying subscribers (observers).
        interface Observer { void update(String news); }
        class NewsSubscriber implements Observer {
            private final String name;
            public NewsSubscriber(String name) { this.name = name; }
            public void update(String news) { System.out.println("   " + name + " received news: " + news); }
        }

        class NewsAgency { // Subject
            private final List<Observer> subscribers = new ArrayList<>();
            public void subscribe(Observer observer) { subscribers.add(observer); }
            public void publishNews(String news) { subscribers.forEach(s -> s.update(news)); }
        }

        NewsAgency agency = new NewsAgency();
        agency.subscribe(new NewsSubscriber("Alice"));
        agency.subscribe(new NewsSubscriber("Bob"));
        agency.publishNews("Breaking: Java 21 is released!");
        System.out.println("   ----------------------------------------------------");
    }
}