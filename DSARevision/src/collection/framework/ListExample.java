package collection.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List Interface Implementations and Their Characteristics
 *
 * 1. ArrayList
 * - Implements List interface using a dynamic array
 * - Provides O(1) time complexity for random access
 * - O(n) time complexity for insertions/deletions (except at end)
 * - Better for storing and accessing data
 * - Not synchronized (not thread-safe)
 * - Grows by 50% of current size when full
 * - Default initial capacity is 10
 * - Best for: Random access and storing/iterating over data
 *
 * 2. LinkedList
 * - Implements List and Deque interfaces using doubly-linked list
 * - O(1) time complexity for insertions/deletions at beginning/end
 * - O(n) time complexity for random access
 * - Better for manipulating data (frequent insertions/deletions)
 * - Not synchronized (not thread-safe)
 * - Uses more memory due to node storage
 * - Best for: Frequent insertions/deletions, especially at ends
 *
 * 3. Vector
 * - Legacy class, similar to ArrayList but synchronized
 * - Thread-safe (all methods are synchronized)
 * - Less efficient than ArrayList due to synchronization overhead
 * - Grows by 100% of current size when full
 * - Default initial capacity is 10
 * - Best for: Legacy code or when thread safety is required
 *
 * Common Use Cases:
 * - ArrayList: General-purpose list, reading/iterating more than writing
 * - LinkedList: Frequent insertions/deletions, implementing queues/stacks
 * - Vector: When thread safety is required (though better alternatives exist)
 */


public class ListExample {

	public static void main(String[] args) {

		//ArrayList: Dynamic array implementation
		List<String> arrayList = new ArrayList<>();
		arrayList.add("First");
		arrayList.add("Second");
		System.out.println("ArrayList: "+ arrayList);

		// ArrayList Operations
		arrayList.add(1, "Inserted");     // Add at specific index
		arrayList.set(0, "Updated");      // Update element at index
		boolean isEmpty = arrayList.isEmpty(); // Check if empty
		int indexOf = arrayList.indexOf("Second"); // Find first occurrence
		int lastIndexOf = arrayList.lastIndexOf("Second"); // Find last occurrence
		
		// Bulk Operations
		List<String> otherList = new ArrayList<>();
		otherList.add("Third");
		otherList.add("Fourth");
		
		arrayList.addAll(otherList);      // Add all elements from another list
		arrayList.addAll(1, otherList);   // Add all elements at specific position
		arrayList.removeAll(otherList);   // Remove all elements that exist in other list
		arrayList.retainAll(otherList);   // Keep only elements that exist in both lists
		
		// SubList and Clear
		List<String> subList = arrayList.subList(0, 2); // Get view of portion of list
		arrayList.clear();                // Remove all elements
		
		// Array Operations
		String[] array = arrayList.toArray(new String[0]); // Convert to array
		arrayList = Arrays.asList(array); // Convert array to List
		
		System.out.println("ArrayList after operations: " + arrayList);

		//LinkedList: Doubly-linked list implementation
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("First");
		linkedList.add("Second");
		System.out.println("LinkedList: "+ linkedList);

		// LinkedList Operations
		linkedList.addFirst("Start");     // Now works without casting
		linkedList.addLast("End");        
		String first = linkedList.getFirst();
		String last = linkedList.getLast();   
		linkedList.removeFirst();         
		linkedList.removeLast();          
		
		// Queue Operations (LinkedList implements Queue)
		linkedList.offer("New");     // Removed casting
		String peek = linkedList.peek();
		String poll = linkedList.poll();
		
		// Stack Operations (LinkedList implements Deque)
		linkedList.push("Top");      // Removed casting
		String pop = linkedList.pop();
		
		// Bulk Operations
		List<String> otherLinkedList = new LinkedList<>();
		otherLinkedList.add("Third");
		otherLinkedList.add("Fourth");
		
		linkedList.addAll(otherLinkedList);      // Add all elements from another list
		linkedList.addAll(1, otherLinkedList);   // Add all elements at specific position
		linkedList.removeAll(otherLinkedList);   // Remove all elements that exist in other list
		linkedList.retainAll(otherLinkedList);   // Keep only elements that exist in both lists
		
		// SubList and Clear
		List<String> subLinkedList = linkedList.subList(0, 2); // Get view of portion of list
		linkedList.clear();                // Remove all elements
		
		System.out.println("LinkedList after operations: " + linkedList);

		//Vector: Thread-safe dynamic array (legacy)
		Vector<String> vector = new Vector<>();
		vector.add("First");
		System.out.println("Vector; "+ vector);

		// Vector Operations
		vector.addElement("Second");      // Legacy method to add element
		vector.insertElementAt("New", 1); // Insert at specific index
		vector.removeElement("First");    // Remove specific element
		vector.removeElementAt(0);        // Remove at index
		String vectorElement = vector.elementAt(0); // Get element at index
		int vectorSize = vector.size();   // Get size
		vector.setElementAt("Updated", 0); // Set element at index
		
		// Capacity Management
		vector.setSize(5);                // Set size (pads with null if needed)
		vector.ensureCapacity(10);        // Ensure minimum capacity
		int capacity = vector.capacity(); // Get current capacity
		vector.trimToSize();              // Trim capacity to current size
		
		// Enumeration (Legacy)
		Enumeration<String> elements = vector.elements(); // Get enumeration
		while(elements.hasMoreElements()) {
			String element = elements.nextElement();
		}
		
		// Bulk Operations
		Vector<String> otherVector = new Vector<>();
		otherVector.add("Third");
		otherVector.add("Fourth");
		
		vector.addAll(otherVector);       // Add all elements from another vector
		vector.removeAll(otherVector);    // Remove all elements that exist in other vector
		vector.retainAll(otherVector);    // Keep only elements that exist in both vectors
		boolean isSubset = vector.containsAll(otherVector); // Check if contains all elements
		
		// SubList and Clear
		List<String> subVector = vector.subList(0, 1); // Get view of portion of vector
		vector.clear();                   // Remove all elements
		
		System.out.println("Vector after operations: " + vector);


		

	}

}
