# Collection Framework Interview Questions Guide

## Table of Contents
1. [Core Collection Interfaces](#core-collection-interfaces)
2. [List Interface Questions](#list-interface-questions)
3. [Set Interface Questions](#set-interface-questions)
4. [Map Interface Questions](#map-interface-questions)
5. [Queue Interface Questions](#queue-interface-questions)
6. [Thread Safety Questions](#thread-safety-questions)
7. [Performance Questions](#performance-questions)
8. [Common Use Cases](#common-use-cases)
9. [Best Practices](#best-practices)
10. [Advanced Questions](#advanced-questions)

---

## Core Collection Interfaces

### Q: What are the main interfaces in Java Collection Framework?
**A:** The main interfaces are:
- **Collection**: Root interface for all collections
- **List**: Ordered collection with duplicate elements
- **Set**: Unordered collection with unique elements
- **Map**: Key-value pairs (not part of Collection interface)
- **Queue**: FIFO collection
- **Deque**: Double-ended queue

### Q: What is the difference between Collection and Collections?
**A:** 
- **Collection**: Interface that represents a group of objects
- **Collections**: Utility class with static methods for collection operations

---

## List Interface Questions

### Q: What's the difference between ArrayList and LinkedList?

| Aspect | ArrayList | LinkedList |
|--------|-----------|------------|
| **Implementation** | Dynamic array | Doubly-linked list |
| **Random Access** | O(1) | O(n) |
| **Insertion/Deletion** | O(n) | O(1) at ends |
| **Memory** | Less overhead | More overhead (node references) |
| **Use Case** | Random access, reading | Frequent modifications |

### Q: When to use ArrayList vs LinkedList?
**A:** 
- **Use ArrayList when:**
  - You need random access to elements
  - You're doing more reading than writing
  - You need to iterate through elements frequently

- **Use LinkedList when:**
  - You need frequent insertions/deletions
  - You're implementing a queue or stack
  - You don't need random access

### Q: What's the difference between Vector and ArrayList?
**A:**
- **Vector**: Thread-safe (synchronized), grows by 100%, legacy class
- **ArrayList**: Not thread-safe, grows by 50%, modern implementation

### Q: How does ArrayList grow internally?
**A:** 
- Default initial capacity: 10
- Growth factor: 50% of current size
- When full, creates new array with larger size and copies elements

### Q: How to make ArrayList thread-safe?
**A:** Three options:
1. `Collections.synchronizedList(new ArrayList<>())`
2. `new CopyOnWriteArrayList<>()` (for read-heavy scenarios)
3. `new Vector<>()` (legacy)

### Q: What are fail-fast and fail-safe iterators?
**A:**
- **Fail-fast**: Throws `ConcurrentModificationException` when collection is modified during iteration
- **Fail-safe**: Works on snapshot, no exception thrown

---

## Set Interface Questions

### Q: What's the difference between HashSet, TreeSet, and LinkedHashSet?

| Aspect | HashSet | TreeSet | LinkedHashSet |
|--------|---------|---------|---------------|
| **Ordering** | Unordered | Sorted | Insertion order |
| **Performance** | O(1) average | O(log n) | O(1) average |
| **Null allowed** | Yes | No | Yes |
| **Implementation** | HashMap | Red-Black Tree | LinkedHashMap |

### Q: How does HashSet work internally?
**A:** 
- Backed by HashMap
- Elements stored as keys with dummy value (PRESENT)
- Uses `hashCode()` and `equals()` for uniqueness

### Q: How to use custom objects in HashSet?
**A:** Override `hashCode()` and `equals()` methods:
```java
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
```

---

## Map Interface Questions

### Q: What's the difference between HashMap, TreeMap, and LinkedHashMap?

| Aspect | HashMap | TreeMap | LinkedHashMap |
|--------|---------|---------|---------------|
| **Ordering** | Unordered | Sorted by keys | Insertion order |
| **Performance** | O(1) average | O(log n) | O(1) average |
| **Null keys** | Yes | No | Yes |
| **Implementation** | Hash table | Red-Black Tree | Hash table + linked list |

### Q: How does HashMap work internally?
**A:** 
- Uses array of buckets (`Node<K,V>[]`)
- Uses `hashCode()` to determine bucket
- Handles collisions using linked list or tree (Java 8+)
- Load factor: 0.75 (resize when 75% full)

### Q: How does HashMap handle collisions?
**A:** 
- **Java 8+**: Uses linked list initially, converts to tree when threshold reached
- **Threshold**: 8 elements in a bucket for tree conversion
- **Tree conversion**: When bucket has 8+ elements and total map size >= 64

### Q: What's the difference between ConcurrentHashMap and HashMap?
**A:**
- **ConcurrentHashMap**: Thread-safe, uses segment locking, better performance
- **HashMap**: Not thread-safe, better performance in single-threaded scenarios

### Q: What is WeakHashMap?
**A:** 
- Uses `WeakReference` for keys
- Keys can be garbage collected when no strong references exist
- Useful for caching scenarios

---

## Queue Interface Questions

### Q: What is PriorityQueue?
**A:** 
- Unbounded priority queue based on priority heap
- Elements ordered by natural ordering or custom comparator
- O(log n) for add/remove, O(1) for peek

### Q: ArrayDeque vs LinkedList for queue operations?
**A:**
- **ArrayDeque**: More efficient, uses resizable array
- **LinkedList**: More memory overhead, uses doubly-linked list

### Q: What is BlockingQueue?
**A:** 
- Thread-safe queue that blocks when queue is empty or full
- Useful for producer-consumer scenarios

### Q: Stack vs ArrayDeque for stack operations?
**A:**
- **ArrayDeque**: More efficient, not synchronized
- **Stack**: Extends Vector (legacy, synchronized)

---

## Thread Safety Questions

### Q: Which collections are thread-safe?
**A:** 
- **Thread-safe**: Vector, Hashtable, ConcurrentHashMap, CopyOnWriteArrayList
- **Not thread-safe**: ArrayList, LinkedList, HashMap, TreeMap, HashSet

### Q: How to make collections thread-safe?
**A:** 
- Use `Collections.synchronizedXXX()` methods
- Use concurrent collections (ConcurrentHashMap, CopyOnWriteArrayList)
- Use legacy thread-safe collections (Vector, Hashtable)

### Q: When to use CopyOnWriteArrayList?
**A:** 
- Read-heavy scenarios with infrequent writes
- Creates new copy on modification
- No concurrent modification exceptions

---

## Performance Questions

### Q: Time complexity of common operations?

| Collection | get/set | add/remove | contains |
|------------|---------|------------|----------|
| ArrayList | O(1) | O(n) | O(n) |
| LinkedList | O(n) | O(1) at ends | O(n) |
| HashMap | O(1) average | O(1) average | O(1) average |
| TreeMap | O(log n) | O(log n) | O(log n) |
| HashSet | - | O(1) average | O(1) average |
| TreeSet | - | O(log n) | O(log n) |

### Q: How to optimize collection performance?
**A:** 
1. Set appropriate initial capacity
2. Use appropriate load factor for HashMap
3. Choose right collection for your use case
4. Use bulk operations when possible

---

## Common Use Cases

### Q: When to use different collections?
**A:** 
- **ArrayList**: Random access, reading, iterating
- **LinkedList**: Frequent insertions/deletions, queue/stack implementation
- **HashMap**: General purpose, no ordering required
- **TreeMap**: When sorted keys are needed
- **HashSet**: General purpose, no ordering required
- **TreeSet**: When sorted elements are needed

### Q: How to implement LRU Cache?
**A:** Use LinkedHashMap with access order:
```java
LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > capacity;
    }
};
```

---

## Best Practices

### Q: How to choose the right collection?
**A:** 
1. Need ordering? → List
2. Need uniqueness? → Set
3. Need key-value pairs? → Map
4. Need FIFO/LIFO? → Queue/Deque
5. Need thread safety? → Concurrent collections

### Q: Common pitfalls to avoid?
**A:** 
1. Modifying collection during iteration
2. Not overriding equals() and hashCode() for custom objects
3. Using raw types instead of generics
4. Not considering thread safety requirements

### Q: Performance optimization tips?
**A:** 
1. Set appropriate initial capacity
2. Use appropriate load factor for HashMap
3. Choose right collection for your use case
4. Use bulk operations when possible

---

## Advanced Questions

### Q: How to implement a custom collection?
**A:** 
- Extend AbstractCollection, AbstractList, AbstractSet, etc.
- Implement required methods
- Consider implementing Iterable interface

### Q: What is the difference between Iterator and ListIterator?
**A:** 
- **Iterator**: Forward-only iteration
- **ListIterator**: Bidirectional iteration, can modify elements

### Q: How to sort collections?
**A:** 
- Use `Collections.sort()` for List
- Use TreeSet/TreeMap for automatic sorting
- Implement Comparable or use Comparator

### Q: What are the differences between Arrays.asList() and new ArrayList<>()?
**A:** 
- `Arrays.asList()`: Returns fixed-size list backed by array
- `new ArrayList<>()`: Returns resizable list

### Q: How to convert between different collection types?
**A:** 
- Use constructors: `new ArrayList<>(set)`
- Use `Collections.addAll()`
- Use Stream API: `list.stream().collect(Collectors.toSet())`

---

## Sample Interview Questions

### Q: Write a program to find duplicate elements in an array.
```java
public static List<Integer> findDuplicates(int[] arr) {
    Set<Integer> seen = new HashSet<>();
    Set<Integer> duplicates = new HashSet<>();
    
    for (int num : arr) {
        if (!seen.add(num)) {
            duplicates.add(num);
        }
    }
    
    return new ArrayList<>(duplicates);
}
```

### Q: Implement a custom LRU Cache.
```java
class LRUCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public V get(K key) {
        return cache.get(key);
    }
    
    public void put(K key, V value) {
        cache.put(key, value);
    }
}
```

### Q: Find the first non-repeating character in a string.
```java
public static char firstNonRepeating(String str) {
    Map<Character, Integer> count = new LinkedHashMap<>();
    
    for (char c : str.toCharArray()) {
        count.put(c, count.getOrDefault(c, 0) + 1);
    }
    
    for (Map.Entry<Character, Integer> entry : count.entrySet()) {
        if (entry.getValue() == 1) {
            return entry.getKey();
        }
    }
    
    return '\0';
}
```

---

## Key Takeaways

1. **Choose the right collection** based on your requirements
2. **Understand performance characteristics** of each collection
3. **Consider thread safety** requirements
4. **Override equals() and hashCode()** for custom objects
5. **Use generics** to ensure type safety
6. **Optimize with initial capacity** when possible
7. **Be aware of fail-fast vs fail-safe** iterators
8. **Use concurrent collections** for multi-threaded scenarios 