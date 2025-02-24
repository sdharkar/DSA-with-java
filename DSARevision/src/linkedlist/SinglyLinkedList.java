package linkedlist;

public class SinglyLinkedList {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head of the list

    public SinglyLinkedList() {
        head = null; // Initial empty list
    }

    // 1. Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // 2. Get Size/Length of the list
    public int size() {
          int count = 0;
           Node current = head;
          while(current != null)
          {
             count++;
             current = current.next;
          }
          return count;
     }

    // 3. Insertion at the Beginning (Prepend)
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // New node points to the old head
        head = newNode;      // New node becomes the new head
    }
    
   // 4. Insertion at the End
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
    
    // 5. Insert at a Specific Position
    public void insertAtPosition(int data, int position)
    {
      if(position < 0)
      {
          System.out.println("Position can't be negative");
          return;
      }
        if(position == 0)
        {
            insertAtBeginning(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        int currentPosition = 0;

        while (current != null && currentPosition < position -1)
        {
            current = current.next;
            currentPosition++;
        }

        if(current == null)
        {
          System.out.println("Position out of bounds");
           return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // 6. Deletion at the Beginning
    public void deleteFirst() {
        if (head == null) return; // Empty list case
        head = head.next;         // Head points to the next node
    }

    // 7. Deletion at the End
    public void deleteLast() {
        if (head == null) return;
       if(head.next == null)
       {
           head = null;
           return;
       }
      Node current = head;
        while (current.next.next != null)
        {
            current = current.next;
        }
        current.next = null;
    }
    
    // 8. Delete at a Specific Position
     public void deleteAtPosition(int position)
     {
         if(head == null) return;
         if(position < 0)
         {
           System.out.println("Position can't be negative");
           return;
         }
         
         if (position == 0)
         {
             deleteFirst();
             return;
         }
          Node current = head;
        int currentPosition = 0;
          while(current != null && currentPosition < position -1)
         {
           current = current.next;
           currentPosition++;
         }

         if (current == null || current.next == null)
         {
           System.out.println("Position out of bounds");
           return;
         }

        current.next = current.next.next;
     }

    // 9. Search for an Element
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
    
    // 10. Get Element at a specific position
     public int get(int position)
     {
         if(position < 0)
         {
             System.out.println("Position can't be negative");
             return -1;
         }
         
         Node current = head;
         int currentPosition = 0;
         
         while (current != null && currentPosition < position)
         {
           current = current.next;
           currentPosition++;
         }
         
        if (current == null)
         {
            System.out.println("Position out of bounds");
             return -1;
         }
         
       return current.data;
     }


    // 11. Reverse the linked list
   public void reverse()
    {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // 12. Print the list to the console
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
     // 13. Detect Cycle/Loop in linked list
    public boolean hasCycle()
    {
      Node slow = head;
      Node fast = head;

      while (fast != null && fast.next != null)
      {
        slow = slow.next;
        fast = fast.next.next;

          if (slow == fast) return true;
      }
    return false;
    }


    public static void main(String[] args) {

        System.out.println("Singly Linked List");
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtBeginning(0);
        list.insertAtEnd(3);
         System.out.println("Size of list: " + list.size());  // Size of list: 4
        System.out.println("Linked list after insertions:");
        list.printList(); // 0 -> 1 -> 2 -> 3 -> null

        list.deleteFirst();
        System.out.println("Linked list after deleting first:");
        list.printList(); // 1 -> 2 -> 3 -> null

        list.deleteLast();
        System.out.println("Linked list after deleting last:");
        list.printList(); // 1 -> 2 -> null

        list.insertAtPosition(10, 1);
         System.out.println("Linked list after inserting 10 at position 1");
         list.printList(); // 1 -> 10 -> 2 -> null

        list.deleteAtPosition(1);
        System.out.println("Linked list after deleting at position 1");
        list.printList(); // 1 -> 2 -> null
         
        System.out.println("Element at position 1: " + list.get(1)); // Element at position 1: 2


        System.out.println("Search for 2: " + list.search(2)); // true
        System.out.println("Search for 5: " + list.search(5)); // false
        
        list.reverse();
        System.out.println("Linked list after reversing");
        list.printList();  // 2 -> 1 -> null

       // Create a list with cycle
      SinglyLinkedList cycleList = new SinglyLinkedList();
      cycleList.insertAtEnd(1);
      cycleList.insertAtEnd(2);
      cycleList.insertAtEnd(3);
      cycleList.head.next.next.next = cycleList.head.next; // create a loop at node 2

      System.out.println("Cyclic list has cycle: " + cycleList.hasCycle()); // true
    }
}