package linkedlist;

public class DoublyLinkedList {

    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
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

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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
        if (current.next != null) { // Avoid null pointer for insertion in last node
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;


        if (newNode.next == null) tail = newNode;
    }

    // Delete the first node
    public void deleteFirst() {
        if (isEmpty()) return;

        if (head == tail) { // Only one node
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.prev = null;

    }

    // Delete the last node
    public void deleteLast() {
        if (isEmpty()) return;

        if (head == tail) { // Only one node
            head = null;
            tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // Delete at a specific position
    public void deleteAtPosition(int position)
    {
       if (isEmpty()) return;

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
         while (current != null && currentPosition < position - 1)
        {
             current = current.next;
             currentPosition++;
         }

         if (current == null || current.next == null)
         {
              System.out.println("Position out of bounds.");
              return;
          }
      
        current.next = current.next.next;
        if (current.next != null) {
            current.next.prev = current;
        }
        else {
           tail = current;
        }
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
        while(current != null && currentPosition < position)
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

    // Reverse the list
    public void reverse() {
       Node current = head;
       Node temp;
       tail = head;

       while(current != null)
       {
           temp = current.prev;
           current.prev = current.next;
           current.next = temp;
           
          if (current.prev == null) head = current;
          current = current.prev;
       }
    }


    // Print list to console
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }


     // Print list in reverse order
    public void printListReverse() {
          Node current = tail;
          while (current != null) {
              System.out.print(current.data + " <-> ");
              current = current.prev;
          }
          System.out.println("null");
      }


    public static void main(String[] args) {
        System.out.println("Doubly Linked List");
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtBeginning(0);
        list.insertAtEnd(3);

        System.out.println("Doubly linked list after insertions:");
        list.printList(); // 0 <-> 1 <-> 2 <-> 3 <-> null
        
        System.out.println("Size of list : " + list.size()); // Size of list : 4

        list.deleteFirst();
        System.out.println("Doubly linked list after deleting first:");
        list.printList(); // 1 <-> 2 <-> 3 <-> null

        list.deleteLast();
        System.out.println("Doubly linked list after deleting last:");
        list.printList(); // 1 <-> 2 <-> null
        
         list.insertAtPosition(10, 1);
        System.out.println("Linked list after inserting 10 at position 1:");
        list.printList(); // 1 <-> 10 <-> 2 <-> null
       
        list.deleteAtPosition(1);
        System.out.println("Linked list after deleting node at position 1");
        list.printList(); // 1 <-> 2 <-> null

        System.out.println("Search for 2: " + list.search(2)); // true
        System.out.println("Search for 5: " + list.search(5)); // false
      
        System.out.println("Element at position 1: " + list.get(1)); // Element at position 1: 2
      
        System.out.println("Doubly linked list in reverse order");
        list.printListReverse(); // 2 <-> 1 <-> null
        
        list.reverse();
        System.out.println("Doubly linked list after reversing");
        list.printList(); // 2 <-> 1 <-> null
    }
}
