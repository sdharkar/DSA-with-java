package collection.framework;

import java.util.ArrayList;
import java.util.List;

public class CollectionRecall {

    public static void main(String[] args){

        // List Interface Implementations
        System.out.println("=== ArrayList Demo ===");
        List<String> arrayList = new ArrayList<>();
        
        // ArrayList characteristics:
        // - Dynamic array implementation
        // - Fast random access O(1)
        // - Slow insertions/deletions O(n) except at end
        // - Not synchronized
        // - Grows by 50% when full
        // - Default capacity 10
        
        arrayList.add("First");
        arrayList.add("Second"); 
        arrayList.add(1, "Inserted");
        System.out.println("ArrayList: " + arrayList);
        
        // Common List Operations
        arrayList.set(0, "Updated");
        boolean contains = arrayList.contains("Second");
        int size = arrayList.size();
        String element = arrayList.get(1);
        arrayList.remove(0);
        
        System.out.println("After operations: " + arrayList);
        
        // Bulk Operations
        List<String> list2 = new ArrayList<>();
        list2.add("Third");
        list2.add("Fourth");
        
        arrayList.addAll(list2);
        System.out.println("After addAll: " + arrayList);
        
        arrayList.removeAll(list2); 
        System.out.println("After removeAll: " + arrayList);
        
        // LinkedList characteristics:
        // - Doubly-linked list implementation
        // - O(1) insertions/deletions at ends
        // - O(n) random access
        // - Not synchronized
        // - More memory overhead
        // - Good for frequent modifications
        
        System.out.println("\n=== Set Interface ===");
        // HashSet:
        // - Unordered collection of unique elements
        // - O(1) add/remove/contains
        // - Allows null
        // - Backed by HashMap
        
        // TreeSet:
        // - Sorted collection (Red-Black Tree)
        // - O(log n) operations
        // - Cannot store null
        // - Elements must be comparable
        
        // LinkedHashSet:
        // - Maintains insertion order
        // - O(1) operations
        // - Allows null
        // - More memory than HashSet
        
        System.out.println("\n=== Map Interface ===");
        // HashMap:
        // - Key-value pairs
        // - O(1) operations
        // - Allows null key and values
        // - Not synchronized
        
        // TreeMap:
        // - Sorted by keys
        // - O(log n) operations
        // - No null keys
        // - Keys must be comparable
        
        // LinkedHashMap:
        // - Maintains insertion order
        // - O(1) operations
        // - Allows null
        // - More memory overhead
        
        System.out.println("\n=== Queue Interface ===");
        // PriorityQueue:
        // - Heap implementation
        // - Natural ordering or custom comparator
        // - O(log n) for add/remove
        // - O(1) for peek
        
        // Deque:
        // - Double-ended queue
        // - Can be used as stack or queue
        // - ArrayDeque implementation is more efficient than Stack or LinkedList
    }

}
