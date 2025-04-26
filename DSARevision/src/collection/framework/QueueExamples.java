package collection.framework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Queue and Deque Theory and Implementation Details
 *
 * 1. PriorityQueue
 *  - Implements the Queue interface
 *  - Elements are ordered based on priority (natural ordering or Comparator)
 *  - Not thread-safe
 *  - Does not permit null elements
 *  - O(log(n)) time complexity for enqueueing and dequeueing (offer, poll)
 *  - O(1) for peek
 *  - Uses a heap data structure internally
 *
 * 2. ArrayDeque
 *  - Implements the Deque interface (double-ended queue)
 *  - Allows adding and removing elements from both ends
 *  - Not thread-safe
 *  - Does not permit null elements
 *  - Generally faster than LinkedList for Deque operations
 *  - Resizable array implementation
 *  - O(1) time complexity for adding/removing at both ends
 *
 * Common Use Cases:
 * - PriorityQueue: Task scheduling, event simulation, finding the smallest/largest element
 * - ArrayDeque: Implementing stacks and queues, managing history, breadth-first search
 */


public class QueueExamples {

	public static void main(String[] args) {

		//PriorityQueue: Heap-based priority queue
		Queue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(3);
		priorityQueue.offer(1);
		priorityQueue.offer(2);
		//Elements will be dequeued in natural order: 1,2,3
		System.out.println("PriorityQueue: " + priorityQueue);

		System.out.println("Head of queue: " + priorityQueue.peek());
		System.out.println("Removing head: " + priorityQueue.poll());
		System.out.println("Queue after poll: " + priorityQueue);
		System.out.println("Size of queue: " + priorityQueue.size());
		System.out.println("Is queue empty: " + priorityQueue.isEmpty());
		priorityQueue.offer(4);
		System.out.println("Queue after offer: " + priorityQueue);

		Deque<String> arrayDeque = new ArrayDeque<>();
		arrayDeque.addFirst("First");
		arrayDeque.addLast("Last");
        arrayDeque.pollFirst(); // Remove and return first element
        arrayDeque.pollLast(); // Remove and return last element
		System.out.println("ArrayDeque: "+ arrayDeque);

		arrayDeque.offerFirst("First");
		arrayDeque.offerLast("Last");
		System.out.println("ArrayDeque after offerFirst and offerLast: " + arrayDeque);

		System.out.println("Peek first: " + arrayDeque.peekFirst());
		System.out.println("Peek last: " + arrayDeque.peekLast());

		arrayDeque.removeFirst();
		arrayDeque.removeLast();
		System.out.println("ArrayDeque after removeFirst and removeLast: " + arrayDeque);

		arrayDeque.push("Element"); // Equivalent to addFirst
		System.out.println("ArrayDeque after push: " + arrayDeque);

		System.out.println("Popped element: " + arrayDeque.pop()); // Equivalent to removeFirst
		System.out.println("ArrayDeque after pop: " + arrayDeque);

		arrayDeque.add("Element");
		System.out.println("ArrayDeque after add: " + arrayDeque);
		System.out.println("Contains Element: " + arrayDeque.contains("Element"));
		System.out.println("Size of deque: " + arrayDeque.size());
		arrayDeque.clear();
		System.out.println("ArrayDeque after clear: " + arrayDeque);
		System.out.println("Is deque empty: " + arrayDeque.isEmpty());

		
	}

}
