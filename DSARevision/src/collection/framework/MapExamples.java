package collection.framework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map Interface Theory and Implementation Details
 *
 * 1. HashMap
 *  - Implements the Map interface
 *  - Allows null keys and null values
 *  - Unordered collection
 *  - O(1) average time complexity for get and put operations
 *  - Not synchronized (not thread-safe)
 *
 * 2. TreeMap
 *  - Implements the SortedMap interface
 *  - Does not allow null keys
 *  - Ordered collection based on the natural ordering of its keys, or by a Comparator provided at map creation time
 *  - O(log n) time complexity for get and put operations
 *  - Not synchronized (not thread-safe)
 *
 * 3. LinkedHashMap
 *  - Extends HashMap
 *  - Maintains insertion order
 *  - Allows null keys and null values
 *  - O(1) average time complexity for get and put operations
 *  - Not synchronized (not thread-safe)
 */


public class MapExamples {

	public static void main(String[] args) {

		//HashMap: Unordered, allows null
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("One", 1);
		hashMap.put("Two", 2);
		System.out.println("Hashmap: "+ hashMap);

		System.out.println("Size of HashMap: " + hashMap.size());
		System.out.println("Is HashMap empty? " + hashMap.isEmpty());
		System.out.println("Value for key 'One': " + hashMap.get("One"));
		System.out.println("Contains key 'One'? " + hashMap.containsKey("One"));
		System.out.println("Contains value '1'? " + hashMap.containsValue(1));

		hashMap.put("Three", 3);
		System.out.println("HashMap after adding 'Three': " + hashMap);

		hashMap.replace("Two", 22);
		System.out.println("HashMap after replacing 'Two': " + hashMap);

		hashMap.remove("One");
		System.out.println("HashMap after removing 'One': " + hashMap);

		Map<String, Integer> anotherMap = new HashMap<>();
		anotherMap.put("Four", 4);
		anotherMap.put("Five", 5);

		hashMap.putAll(anotherMap);
		System.out.println("HashMap after putAll: " + hashMap);

		hashMap.clear();
		System.out.println("HashMap after clear: " + hashMap);
		System.out.println("Is HashMap empty after clear? " + hashMap.isEmpty());


		//TreeMap: Sorted by keys
		Map<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("B", 2);
		treeMap.put("A", 1);
		treeMap.put("C", 3);
		System.out.println("TreeMap: "+ treeMap);

		System.out.println("Size of TreeMap: " + treeMap.size());
		System.out.println("Is TreeMap empty? " + treeMap.isEmpty());
		System.out.println("Value for key 'A': " + treeMap.get("A"));
		System.out.println("Contains key 'A'? " + treeMap.containsKey("A"));
		System.out.println("Contains value '1'? " + treeMap.containsValue(1));

		treeMap.put("D", 4);
		System.out.println("TreeMap after adding 'D': " + treeMap);

		treeMap.replace("B", 22);
		System.out.println("TreeMap after replacing 'B': " + treeMap);

		treeMap.remove("A");
		System.out.println("TreeMap after removing 'A': " + treeMap);

		Map<String, Integer> anotherTreeMap = new TreeMap<>();
		anotherTreeMap.put("E", 5);
		anotherTreeMap.put("F", 6);

		treeMap.putAll(anotherTreeMap);
		System.out.println("TreeMap after putAll: " + treeMap);

		//treeMap.clear(); //Cannot add null key in TreeMap
		//System.out.println("TreeMap after clear: " + treeMap);
		//System.out.println("Is TreeMap empty after clear? " + treeMap.isEmpty());

		//LinkedHashMap: Maintains insertion order
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("First", 1);
		linkedHashMap.put("Second", 2);
		System.out.println("LinkedHashMap: "+ linkedHashMap);

		System.out.println("Size of LinkedHashMap: " + linkedHashMap.size());
		System.out.println("Is LinkedHashMap empty? " + linkedHashMap.isEmpty());
		System.out.println("Value for key 'First': " + linkedHashMap.get("First"));
		System.out.println("Contains key 'First'? " + linkedHashMap.containsKey("First"));
		System.out.println("Contains value '1'? " + linkedHashMap.containsValue(1));

		linkedHashMap.put("Third", 3);
		System.out.println("LinkedHashMap after adding 'Third': " + linkedHashMap);

		linkedHashMap.replace("Second", 22);
		System.out.println("LinkedHashMap after replacing 'Second': " + linkedHashMap);

		linkedHashMap.remove("First");
		System.out.println("LinkedHashMap after removing 'First': " + linkedHashMap);

		Map<String, Integer> anotherLinkedHashMap = new LinkedHashMap<>();
		anotherLinkedHashMap.put("Fourth", 4);
		anotherLinkedHashMap.put("Fifth", 5);

		linkedHashMap.putAll(anotherLinkedHashMap);
		System.out.println("LinkedHashMap after putAll: " + linkedHashMap);

		linkedHashMap.clear();
		System.out.println("LinkedHashMap after clear: " + linkedHashMap);
		System.out.println("Is LinkedHashMap empty after clear? " + linkedHashMap.isEmpty());
 		

	}

}
