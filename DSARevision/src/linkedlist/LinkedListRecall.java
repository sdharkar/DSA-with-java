package linkedlist;

public class LinkedListRecall {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedListRecall() {
        head = null;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Get the size/length of the list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Position cannot be negative.");
            return;
        }

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int currentPosition = 0;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }


    // Delete the first node
    public void deleteFirst() {
        if (head == null) return;
        head = head.next;
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Delete at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) return;

        if (position < 0) {
            System.out.println("Position can't be negative.");
            return;
        }

        if (position == 0) {
            deleteFirst();
            return;
        }

        Node current = head;
        int currentPosition = 0;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        current.next = current.next.next;
    }


    // Search for a data in the linked list
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Get the data at a particular position
     public int get(int position)
     {
         if (position < 0)
         {
             System.out.println("Position can't be negative");
             return -1; // Or throw an exception
         }

         Node current = head;
         int currentPosition = 0;

         while(current!= null && currentPosition < position)
         {
             current = current.next;
             currentPosition++;
         }

         if (current == null) {
              System.out.println("Position out of bounds.");
             return -1;
         }
         
         return current.data;
     }
    
   // Reverse the linked list
    public void reverse()
    {
      Node prev = null;
      Node current = head;
      Node next = null;

      while (current != null)
      {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }

      head = prev;
    }
    
    // Print list to console
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Check for loop/cycle
    public boolean hasCycle()
    {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println("Linked List");
        LinkedListRecall list = new LinkedListRecall();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtBeginning(0);
        list.insertAtEnd(3);
        System.out.println("Linked list after insertions:");
        list.printList(); // 0 -> 1 -> 2 -> 3 -> null
        
        System.out.println("Size of list: " + list.size()); // Size of list: 4

        list.deleteFirst();
        System.out.println("Linked list after deleting first:");
        list.printList(); // 1 -> 2 -> 3 -> null

        list.deleteLast();
        System.out.println("Linked list after deleting last:");
        list.printList(); // 1 -> 2 -> null
        
        list.insertAtPosition(10, 1);
        System.out.println("Linked list after inserting 10 at position 1:");
        list.printList(); // 1 -> 10 -> 2 -> null
        
        list.deleteAtPosition(1);
        System.out.println("Linked list after deleting node at position 1");
        list.printList(); // 1 -> 2 -> null

        System.out.println("Search for 2: " + list.search(2)); // true
        System.out.println("Search for 5: " + list.search(5)); // false

        System.out.println("Element at position 1: " + list.get(1)); // Element at position 1: 2
        
        list.reverse();
        System.out.println("Linked list after reversing");
        list.printList();  // 2 -> 1 -> null
    
        // Create a list with a cycle
        LinkedListRecall cyclicList = new LinkedListRecall();
        cyclicList.insertAtEnd(1);
        cyclicList.insertAtEnd(2);
        cyclicList.insertAtEnd(3);
        cyclicList.head.next.next.next = cyclicList.head.next; //create cycle at node 2

        System.out.println("Cyclic linked list has cycle : " + cyclicList.hasCycle());  // true
    }
}
