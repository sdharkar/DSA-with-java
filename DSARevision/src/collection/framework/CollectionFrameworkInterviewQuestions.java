package collection.framework;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Collection Framework Interview Questions
 * 
 * This file contains comprehensive interview questions covering:
 * 1. Core Collection Interfaces
 * 2. List Implementations
 * 3. Set Implementations  
 * 4. Map Implementations
 * 5. Queue Implementations
 * 6. Thread Safety
 * 7. Performance Characteristics
 * 8. Common Use Cases
 * 9. Best Practices
 */

public class CollectionFrameworkInterviewQuestions {

    public static void main(String[] args) {
        System.out.println("=== Collection Framework Interview Questions ===\n");
        
        // Run all question demonstrations
        demonstrateListQuestions();
        demonstrateSetQuestions();
        demonstrateMapQuestions();
        demonstrateQueueQuestions();
        demonstrateThreadSafetyQuestions();
        demonstratePerformanceQuestions();
        demonstrateCommonUseCases();
        demonstrateBestPractices();
    }

    // ==================== LIST INTERFACE QUESTIONS ====================
    
    public static void demonstrateListQuestions() {
        System.out.println("1. LIST INTERFACE QUESTIONS");
        System.out.println("==========================");
        
        // Q1: Difference between ArrayList and LinkedList
        System.out.println("\nQ1: What's the difference between ArrayList and LinkedList?");
        System.out.println("ArrayList: Dynamic array, O(1) random access, O(n) insertions/deletions");
        System.out.println("LinkedList: Doubly-linked list, O(n) random access, O(1) insertions/deletions at ends");
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        // Performance comparison
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i); // O(1) amortized
        }
        long arrayListTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i); // O(1)
        }
        long linkedListTime = System.nanoTime() - start;
        
        System.out.println("ArrayList add time: " + arrayListTime + " ns");
        System.out.println("LinkedList add time: " + linkedListTime + " ns");
        
        // Q2: Vector vs ArrayList
        System.out.println("\nQ2: What's the difference between Vector and ArrayList?");
        System.out.println("Vector: Thread-safe (synchronized), grows by 100%, legacy class");
        System.out.println("ArrayList: Not thread-safe, grows by 50%, modern implementation");
        
        Vector<Integer> vector = new Vector<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        
        // Q3: How to make ArrayList thread-safe?
        System.out.println("\nQ3: How to make ArrayList thread-safe?");
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();
        
        System.out.println("Option 1: Collections.synchronizedList()");
        System.out.println("Option 2: CopyOnWriteArrayList (for read-heavy scenarios)");
        System.out.println("Option 3: Vector (legacy)");
        
        // Q4: ArrayList capacity and growth
        System.out.println("\nQ4: How does ArrayList grow?");
        ArrayList<Integer> capacityDemo = new ArrayList<>();
        System.out.println("Default capacity: 10");
        System.out.println("Growth factor: 50% of current size");
        System.out.println("Initial size: " + capacityDemo.size());
        
        // Q5: Fail-fast vs Fail-safe iterators
        System.out.println("\nQ5: What are fail-fast and fail-safe iterators?");
        System.out.println("Fail-fast: ConcurrentModificationException when collection is modified during iteration");
        System.out.println("Fail-safe: No exception, works on snapshot of collection");
        
        // Demonstrate fail-fast
        try {
            ArrayList<String> failFastList = new ArrayList<>(Arrays.asList("A", "B", "C"));
            for (String item : failFastList) {
                if (item.equals("B")) {
                    failFastList.remove(item); // This will throw ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-fast example: " + e.getMessage());
        }
        
        // Demonstrate fail-safe
        CopyOnWriteArrayList<String> failSafeList = new CopyOnWriteArrayList<>(Arrays.asList("A", "B", "C"));
        for (String item : failSafeList) {
            if (item.equals("B")) {
                failSafeList.remove(item); // This won't throw exception
            }
        }
        System.out.println("Fail-safe example: No exception thrown");
    }

    // ==================== SET INTERFACE QUESTIONS ====================
    
    public static void demonstrateSetQuestions() {
        System.out.println("\n\n2. SET INTERFACE QUESTIONS");
        System.out.println("=========================");
        
        // Q1: Difference between HashSet, TreeSet, and LinkedHashSet
        System.out.println("\nQ1: What's the difference between HashSet, TreeSet, and LinkedHashSet?");
        
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        
        String[] elements = {"Zebra", "Apple", "Banana", "Cat"};
        
        for (String element : elements) {
            hashSet.add(element);
            treeSet.add(element);
            linkedHashSet.add(element);
        }
        
        System.out.println("HashSet (unordered): " + hashSet);
        System.out.println("TreeSet (sorted): " + treeSet);
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
        
        // Q2: HashSet internal working
        System.out.println("\nQ2: How does HashSet work internally?");
        System.out.println("HashSet is backed by HashMap");
        System.out.println("Elements are stored as keys in HashMap with a dummy value");
        System.out.println("Uses hashCode() and equals() for uniqueness");
        
        // Q3: Custom objects in HashSet
        System.out.println("\nQ3: How to use custom objects in HashSet?");
        System.out.println("Override hashCode() and equals() methods");
        
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(1, "Alice"));
        studentSet.add(new Student(1, "Alice")); // Won't be added if equals() is properly implemented
        System.out.println("Student set size: " + studentSet.size());
        
        // Q4: TreeSet with custom comparator
        System.out.println("\nQ4: How to use TreeSet with custom ordering?");
        TreeSet<Student> customOrderSet = new TreeSet<>((s1, s2) -> s2.name.compareTo(s1.name));
        customOrderSet.add(new Student(1, "Alice"));
        customOrderSet.add(new Student(2, "Bob"));
        customOrderSet.add(new Student(3, "Charlie"));
        System.out.println("Custom ordered TreeSet: " + customOrderSet);
    }

    // ==================== MAP INTERFACE QUESTIONS ====================
    
    public static void demonstrateMapQuestions() {
        System.out.println("\n\n3. MAP INTERFACE QUESTIONS");
        System.out.println("=========================");
        
        // Q1: Difference between HashMap, TreeMap, and LinkedHashMap
        System.out.println("\nQ1: What's the difference between HashMap, TreeMap, and LinkedHashMap?");
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        
        String[] keys = {"Zebra", "Apple", "Banana"};
        int[] values = {3, 1, 2};
        
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], values[i]);
            treeMap.put(keys[i], values[i]);
            linkedHashMap.put(keys[i], values[i]);
        }
        
        System.out.println("HashMap (unordered): " + hashMap);
        System.out.println("TreeMap (sorted by keys): " + treeMap);
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);
        
        // Q2: HashMap internal working
        System.out.println("\nQ2: How does HashMap work internally?");
        System.out.println("Uses array of buckets (Node<K,V>[])");
        System.out.println("Uses hashCode() to determine bucket");
        System.out.println("Handles collisions using linked list or tree (Java 8+)");
        System.out.println("Load factor: 0.75 (resize when 75% full)");
        
        // Q3: HashMap collision handling
        System.out.println("\nQ3: How does HashMap handle collisions?");
        System.out.println("Java 8+: Uses linked list initially, converts to tree when threshold reached");
        System.out.println("Threshold: 8 elements in a bucket for tree conversion");
        System.out.println("Tree conversion: When bucket has 8+ elements and total map size >= 64");
        
        // Q4: ConcurrentHashMap vs HashMap
        System.out.println("\nQ4: What's the difference between ConcurrentHashMap and HashMap?");
        System.out.println("ConcurrentHashMap: Thread-safe, uses segment locking");
        System.out.println("HashMap: Not thread-safe, better performance in single-threaded scenarios");
        
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Key1", 1);
        concurrentHashMap.put("Key2", 2);
        System.out.println("ConcurrentHashMap: " + concurrentHashMap);
        
        // Q5: WeakHashMap
        System.out.println("\nQ5: What is WeakHashMap?");
        System.out.println("Uses WeakReference for keys");
        System.out.println("Keys can be garbage collected when no strong references exist");
        System.out.println("Useful for caching scenarios");
        
        WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(new String("WeakKey"), 1);
        System.out.println("WeakHashMap size before GC: " + weakHashMap.size());
        System.gc();
        System.out.println("WeakHashMap size after GC: " + weakHashMap.size());
    }

    // ==================== QUEUE INTERFACE QUESTIONS ====================
    
    public static void demonstrateQueueQuestions() {
        System.out.println("\n\n4. QUEUE INTERFACE QUESTIONS");
        System.out.println("===========================");
        
        // Q1: PriorityQueue
        System.out.println("\nQ1: What is PriorityQueue?");
        System.out.println("Unbounded priority queue based on priority heap");
        System.out.println("Elements ordered by natural ordering or custom comparator");
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(5);
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        priorityQueue.offer(2);
        
        System.out.println("PriorityQueue (natural ordering):");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();
        
        // Q2: ArrayDeque vs LinkedList
        System.out.println("\nQ2: ArrayDeque vs LinkedList for queue operations?");
        System.out.println("ArrayDeque: More efficient, uses resizable array");
        System.out.println("LinkedList: More memory overhead, uses doubly-linked list");
        
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        LinkedList<String> linkedList = new LinkedList<>();
        
        // Performance comparison
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayDeque.offer("item" + i);
        }
        long arrayDequeTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.offer("item" + i);
        }
        long linkedListTime = System.nanoTime() - start;
        
        System.out.println("ArrayDeque offer time: " + arrayDequeTime + " ns");
        System.out.println("LinkedList offer time: " + linkedListTime + " ns");
        
        // Q3: BlockingQueue
        System.out.println("\nQ3: What is BlockingQueue?");
        System.out.println("Thread-safe queue that blocks when queue is empty or full");
        System.out.println("Useful for producer-consumer scenarios");
        
        // Q4: Stack vs ArrayDeque
        System.out.println("\nQ4: Stack vs ArrayDeque for stack operations?");
        System.out.println("ArrayDeque is more efficient than Stack");
        System.out.println("Stack extends Vector (legacy, synchronized)");
        System.out.println("ArrayDeque is not synchronized, better performance");
        
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        
        System.out.println("Stack operations with ArrayDeque:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // ==================== THREAD SAFETY QUESTIONS ====================
    
    public static void demonstrateThreadSafetyQuestions() {
        System.out.println("\n\n5. THREAD SAFETY QUESTIONS");
        System.out.println("==========================");
        
        // Q1: Thread-safe collections
        System.out.println("\nQ1: Which collections are thread-safe?");
        System.out.println("Thread-safe: Vector, Hashtable, ConcurrentHashMap, CopyOnWriteArrayList");
        System.out.println("Not thread-safe: ArrayList, LinkedList, HashMap, TreeMap, HashSet");
        
        // Q2: Collections.synchronizedXXX()
        System.out.println("\nQ2: How to make collections thread-safe?");
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
        
        System.out.println("Use Collections.synchronizedXXX() methods");
        System.out.println("All methods become synchronized");
        
        // Q3: ConcurrentHashMap vs synchronized HashMap
        System.out.println("\nQ3: ConcurrentHashMap vs synchronized HashMap?");
        System.out.println("ConcurrentHashMap: Better performance, segment-level locking");
        System.out.println("Synchronized HashMap: All operations synchronized, lower performance");
        
        // Q4: CopyOnWriteArrayList
        System.out.println("\nQ4: When to use CopyOnWriteArrayList?");
        System.out.println("Read-heavy scenarios with infrequent writes");
        System.out.println("Creates new copy on modification");
        System.out.println("No concurrent modification exceptions");
        
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add("Read");
        copyOnWriteList.add("Heavy");
        copyOnWriteList.add("Scenario");
        
        // Safe to iterate and modify
        for (String item : copyOnWriteList) {
            copyOnWriteList.add("New"); // No exception
        }
        System.out.println("CopyOnWriteArrayList size after modification: " + copyOnWriteList.size());
    }

    // ==================== PERFORMANCE QUESTIONS ====================
    
    public static void demonstratePerformanceQuestions() {
        System.out.println("\n\n6. PERFORMANCE QUESTIONS");
        System.out.println("========================");
        
        // Q1: Time complexity comparison
        System.out.println("\nQ1: Time complexity of common operations?");
        System.out.println("ArrayList: get/set O(1), add/remove O(n)");
        System.out.println("LinkedList: get/set O(n), add/remove O(1) at ends");
        System.out.println("HashMap: get/put/remove O(1) average");
        System.out.println("TreeMap: get/put/remove O(log n)");
        System.out.println("HashSet: add/remove/contains O(1) average");
        System.out.println("TreeSet: add/remove/contains O(log n)");
        
        // Q2: Memory usage
        System.out.println("\nQ2: Memory considerations?");
        System.out.println("LinkedList: More memory due to node overhead");
        System.out.println("ArrayList: Less memory, but may waste space");
        System.out.println("HashMap: Memory overhead for hash table structure");
        
        // Q3: Initial capacity
        System.out.println("\nQ3: How to optimize with initial capacity?");
        System.out.println("Set initial capacity to avoid resizing");
        
        ArrayList<Integer> optimizedList = new ArrayList<>(1000);
        HashMap<String, Integer> optimizedMap = new HashMap<>(1000, 0.75f);
        
        // Q4: Iteration performance
        System.out.println("\nQ4: Iteration performance?");
        System.out.println("ArrayList: Fastest iteration");
        System.out.println("LinkedList: Slower due to pointer chasing");
        System.out.println("HashMap: Depends on capacity and load factor");
        
        // Performance test
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            testList.add(i);
        }
        
        long start = System.nanoTime();
        for (Integer item : testList) {
            // Just iterate
        }
        long iterationTime = System.nanoTime() - start;
        System.out.println("ArrayList iteration time: " + iterationTime + " ns");
    }

    // ==================== COMMON USE CASES ====================
    
    public static void demonstrateCommonUseCases() {
        System.out.println("\n\n7. COMMON USE CASES");
        System.out.println("===================");
        
        // Q1: When to use ArrayList vs LinkedList
        System.out.println("\nQ1: When to use ArrayList vs LinkedList?");
        System.out.println("ArrayList: Random access, reading, iterating");
        System.out.println("LinkedList: Frequent insertions/deletions, implementing queue/stack");
        
        // Q2: When to use HashMap vs TreeMap
        System.out.println("\nQ2: When to use HashMap vs TreeMap?");
        System.out.println("HashMap: General purpose, no ordering required");
        System.out.println("TreeMap: When sorted keys are needed");
        
        // Q3: When to use HashSet vs TreeSet
        System.out.println("\nQ3: When to use HashSet vs TreeSet?");
        System.out.println("HashSet: General purpose, no ordering required");
        System.out.println("TreeSet: When sorted elements are needed");
        
        // Q4: Caching scenarios
        System.out.println("\nQ4: Caching scenarios?");
        System.out.println("LRU Cache: LinkedHashMap with access order");
        System.out.println("Weak references: WeakHashMap");
        System.out.println("Thread-safe cache: ConcurrentHashMap");
        
        // LRU Cache example
        LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 3; // Keep only 3 entries
            }
        };
        
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);
        lruCache.get("A"); // Access A, moves it to end
        lruCache.put("D", 4); // Removes B (eldest)
        
        System.out.println("LRU Cache: " + lruCache);
    }

    // ==================== BEST PRACTICES ====================
    
    public static void demonstrateBestPractices() {
        System.out.println("\n\n8. BEST PRACTICES");
        System.out.println("================");
        
        // Q1: Choosing the right collection
        System.out.println("\nQ1: How to choose the right collection?");
        System.out.println("1. Need ordering? -> List");
        System.out.println("2. Need uniqueness? -> Set");
        System.out.println("3. Need key-value pairs? -> Map");
        System.out.println("4. Need FIFO/LIFO? -> Queue/Deque");
        System.out.println("5. Need thread safety? -> Concurrent collections");
        
        // Q2: Avoiding common pitfalls
        System.out.println("\nQ2: Common pitfalls to avoid?");
        System.out.println("1. Modifying collection during iteration");
        System.out.println("2. Not overriding equals() and hashCode() for custom objects");
        System.out.println("3. Using raw types instead of generics");
        System.out.println("4. Not considering thread safety requirements");
        
        // Q3: Performance optimization
        System.out.println("\nQ3: Performance optimization tips?");
        System.out.println("1. Set appropriate initial capacity");
        System.out.println("2. Use appropriate load factor for HashMap");
        System.out.println("3. Choose right collection for your use case");
        System.out.println("4. Use bulk operations when possible");
        
        // Q4: Memory optimization
        System.out.println("\nQ4: Memory optimization tips?");
        System.out.println("1. Clear collections when no longer needed");
        System.out.println("2. Use trimToSize() for ArrayList");
        System.out.println("3. Consider WeakHashMap for caching");
        System.out.println("4. Avoid keeping references to unused collections");
        
        // Q5: Thread safety best practices
        System.out.println("\nQ5: Thread safety best practices?");
        System.out.println("1. Use concurrent collections for multi-threaded scenarios");
        System.out.println("2. Avoid Collections.synchronizedXXX() for high-performance scenarios");
        System.out.println("3. Use CopyOnWriteArrayList for read-heavy scenarios");
        System.out.println("4. Consider using ConcurrentHashMap for caching");
    }

    // Helper class for demonstrations
    static class Student {
        int id;
        String name;
        
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Student student = (Student) obj;
            return id == student.id && Objects.equals(name, student.name);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
        
        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "'}";
        }
    }
} 