package collection.framework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set Theory and Implementation Details
 * 
 * 1. HashSet
 * - Implements Set interface using a hash table (actually a HashMap internally)
 * - Offers constant time O(1) performance for basic operations (add, remove, contains)
 * - Does not maintain insertion order
 * - Allows null element
 * - Not synchronized (not thread-safe)
 * - Load factor (default 0.75) and initial capacity (default 16) affect performance
 * - Best for: When order doesn't matter and you need fast access/lookup
 * 
 * 2. TreeSet
 * - Implements NavigableSet interface using a Red-Black tree
 * - Elements are stored in sorted (ascending) order
 * - Offers O(log n) performance for basic operations
 * - Cannot store null elements
 * - Not synchronized (not thread-safe)
 * - Elements must implement Comparable or use a Comparator
 * - Best for: When you need elements in sorted order
 * 
 * 3. LinkedHashSet
 * - Extends HashSet, implements Set interface
 * - Maintains insertion order using a doubly-linked list
 * - Offers O(1) performance for basic operations
 * - Allows null element
 * - Not synchronized (not thread-safe)
 * - Uses more memory than HashSet due to linked list maintenance
 * - Best for: When you need to maintain insertion order with fast access
 * 
 * Common Use Cases:
 * - HashSet: Removing duplicates from a collection without caring about order
 * - TreeSet: Maintaining a sorted collection of unique elements
 * - LinkedHashSet: Maintaining unique elements in insertion order
 */


public class SetExamples {

    public static void main(String[] args) {

        //HashSet: Unordered, allows null
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(1);
        System.out.println("Hashset: "+ hashSet);

        // Common Set Operations
        hashSet.add(3);                   // Add element
        hashSet.remove(2);                // Remove element
        boolean contains = hashSet.contains(1); // Check if element exists
        int size = hashSet.size();        // Get size
        boolean isEmpty = hashSet.isEmpty(); // Check if empty
        hashSet.clear();                  // Remove all elements
        
        // Bulk Operations
        Set<Integer> otherSet = new HashSet<>();
        otherSet.add(4);
        otherSet.add(5);
        
        hashSet.addAll(otherSet);         // Add all elements from another set
        hashSet.removeAll(otherSet);      // Remove all elements that exist in other set
        hashSet.retainAll(otherSet);      // Keep only elements that exist in both sets
        boolean isSubset = hashSet.containsAll(otherSet); // Check if contains all elements
        
        System.out.println("HashSet after operations: " + hashSet);

        //TreeSet: Sorted, not null
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println("TreeSet: " + treeSet);

        // TreeSet Operations
        treeSet.add(4);                   // Add element
        treeSet.remove(1);                // Remove element
        boolean treeContains = treeSet.contains(2); // Check if element exists
        int treeSize = treeSet.size();    // Get size
        
        // Navigation Operations (Specific to TreeSet)
        Integer first = ((TreeSet<Integer>) treeSet).first(); // Get minimum element
        Integer last = ((TreeSet<Integer>) treeSet).last();   // Get maximum element
        Integer lower = ((TreeSet<Integer>) treeSet).lower(3);    // Strictly less than
        Integer higher = ((TreeSet<Integer>) treeSet).higher(3);  // Strictly greater than
        Integer floor = ((TreeSet<Integer>) treeSet).floor(3);    // Less than or equal to
        Integer ceiling = ((TreeSet<Integer>) treeSet).ceiling(3);// Greater than or equal to
        
        // Subset Views
        Set<Integer> headSet = ((TreeSet<Integer>) treeSet).headSet(3);    // Elements less than 3
        Set<Integer> tailSet = ((TreeSet<Integer>) treeSet).tailSet(3);    // Elements greater than or equal to 3
        Set<Integer> subSet = ((TreeSet<Integer>) treeSet).subSet(2, 4);   // Elements between 2 (inclusive) and 4 (exclusive)
        
        System.out.println("TreeSet after operations: " + treeSet);

        //LinkedHashSet: Maintains insertion order
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        System.out.println("LinkedHashSet: "+ linkedHashSet);//// Elements will maintain insertion order: 3, 1, 2

        // LinkedHashSet Operations
        linkedHashSet.add(4);                   // Add element
        linkedHashSet.remove(1);                // Remove element
        boolean linkedContains = linkedHashSet.contains(2); // Check if element exists
        int linkedSize = linkedHashSet.size();  // Get size
        boolean linkedEmpty = linkedHashSet.isEmpty(); // Check if empty
        linkedHashSet.clear();                  // Remove all elements
        
        // Bulk Operations for LinkedHashSet
        Set<Integer> otherLinkedSet = new LinkedHashSet<>();
        otherLinkedSet.add(5);
        otherLinkedSet.add(6);
        
        linkedHashSet.addAll(otherLinkedSet);   // Add all elements from another set
        linkedHashSet.removeAll(otherLinkedSet); // Remove all elements that exist in other set
        linkedHashSet.retainAll(otherLinkedSet); // Keep only elements that exist in both sets
        boolean isLinkedSubset = linkedHashSet.containsAll(otherLinkedSet); // Check if contains all elements
        
        System.out.println("LinkedHashSet after operations: " + linkedHashSet);



        
        
    }

}
