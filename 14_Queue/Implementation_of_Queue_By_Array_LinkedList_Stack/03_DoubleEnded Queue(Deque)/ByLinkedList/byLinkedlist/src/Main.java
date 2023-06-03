
//                      Deque Implement By Using Simple LinkedList

/*

-: Time Complexity :-

getFirst() && getLast()   or firstPeek()  &&  lastPeek()   :-
Time Complexity: O(1) - Accessing the first or last element of the deque takes constant time.
Space Complexity: O(1) - It uses a constant amount of memory.

removeFirst() && removeLast()   :-
Time Complexity: O(1) - Removing the first or last node from the deque takes constant time.
Space Complexity: O(1) - It uses a constant amount of memory.

addFirst() && addLast()   :-
Time Complexity: O(1) - Inserting a new node at the beginning or end of the deque takes constant time.
Space Complexity: O(1) - It uses a constant amount of memory to create a new node.

isEmpty()      :-
Time Complexity: O(1) - It performs a simple check on two pointers.
Space Complexity: O(1) - It uses a constant amount of memory.
 */

import java.util.Scanner;
public class Main {
    static class Deque{

        // Node class to represent each node in the deque
        private static class Node{
          int data;
          Node next;

          public Node(int data){
            this.data = data;
            this.next = null;
          }
        }
        // Pointers to the first and last nodes of the deque
    private static Node addFirst_removeFirst;  //head
    private static Node addLast_removeLast;   // tail

        // Check if the deque is empty
        public  static boolean isEmpty(){
           return addFirst_removeFirst  == null && addLast_removeLast == null;
        }

        // Add an element to the front of the deque
        public static void addFirst(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                // If the deque is empty, set both pointers to the new node
                addFirst_removeFirst = addLast_removeLast = newNode;
            }else{
                // Otherwise, insert the new node before the current first node
                newNode.next = addFirst_removeFirst;
            addFirst_removeFirst= newNode;}
        }

        // Add an element to the end of the deque
        public static void addLast(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                // If the deque is empty, set both pointers to the new node
                addFirst_removeFirst = addLast_removeLast = newNode;
            }else{
                // Otherwise, insert the new node after the current last node
                addLast_removeLast.next = newNode;
            addLast_removeLast = newNode;}
        }

        // Remove and return the element from the front of the deque
        public static int removeFirst(){
            if(isEmpty()){
                System.out.println(":- Deque is empty :-");
                return -1;
            }
            int temp = addFirst_removeFirst.data;
            addFirst_removeFirst = addFirst_removeFirst.next;
            if (addFirst_removeFirst == null) {
                // If the deque becomes empty after removal, update both pointers
                addLast_removeLast = null;
            }
            return temp;
        }

        // Remove and return the element from the end of the deque
        public static int removeLast(){
            if(isEmpty()){
                System.out.println(":- Deque is empty :-");
                return -1;
            }
            int temp = addLast_removeLast.data;
            Node current = addFirst_removeFirst;
            if (current.next == null) {
                // If the deque has only one element, update both pointers
                addFirst_removeFirst = addLast_removeLast = null;
                return temp;
            }
            // Find the second-to-last node and update the pointers
            while (current.next != addLast_removeLast) {
                current = current.next;
            }
            addLast_removeLast = current;
            addLast_removeLast.next = null;
            return temp;
        }

        // Return the element at the front of the deque without removing it
        public static int firstPeek(){
            if(isEmpty()){
                System.out.println(":- Deque is empty :-");
                return -1;
            }
            return addFirst_removeFirst.data;
        }

        // Return the element at the end of the deque without removing it
        public static int lastPeek(){
            if(isEmpty()){
                System.out.println(":- Deque is empty :-");
                return -1;
            }
            return addLast_removeLast.data;
        }

    }
    public static void Menu(){
        System.out.println("\t\t\t#~ DeQue Operation Menu ~#"); // this is a menu of Deque Operations
        System.out.println("# \taddFirst                                 :~ 1");
        System.out.println("# \taddLast                                  :~ 2");
        System.out.println("# \tremoveFirst                              :~ 3");
        System.out.println("# \tremoveLast                               :~ 4");
        System.out.println("# \tpeekFirst or getFirst                    :~ 5");
        System.out.println("# \tpeekLast  or getLast                     :~ 6");
        System.out.println("# \tisEmpty                                  :~ 7");
        System.out.println("# \tDisplay Deque all RemoveFirst            :~ 8");
        System.out.println("# \tDisplay Deque all RemoveLast             :~ 9");
        System.out.println("# \tStop                                     :~ 0");//   stop operation
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean stop = true;
        while(stop!=false){
            Menu(); // menu function calling
            System.out.print("Choice :-  ");
            int choice =sc.nextInt(); // choice any operation
            switch (choice){
                case 1: System.out.print("Enter the Data :- ");
                    int dataFirst = sc.nextInt();
                    Deque.addFirst(dataFirst);  // rearFirst function calling and passing data
                    System.out.println("'Data Successfully added'");
                    break;
                case 2: System.out.print("Enter the Data :- ");
                    int dataLast = sc.nextInt();
                    Deque.addLast(dataLast);  // rearLast function calling and passing data
                    System.out.println("'Data Successfully added'");
                    break;
                case 3: System.out.println("Remove data is "+Deque.removeFirst()); // frontFirst function calling
                    System.out.println("'Data Successfully Removed'");
                    break;
                case 4: System.out.println("Remove data is "+Deque.removeLast()); // frontLast function calling
                    System.out.println("'Data Successfully Removed'");
                    break;
                case 5: System.out.println("First Enter data is "+Deque.firstPeek()); break; // peekFirst function is calling
                case 6: System.out.println("First Enter data is "+Deque.lastPeek()); break; // peekLast function is calling
                case 7: System.out.println("Queue is Empty:- "+(Deque.isEmpty() ? "yes":"No")); break; // isEmpty function calling
                case 8:  while(Deque.addFirst_removeFirst!=null){
                         System.out.println(Deque.firstPeek());
                         Deque.removeFirst();
                         }
                case 9:  while(Deque.addLast_removeLast!=null){
                         System.out.println(Deque.lastPeek());
                         Deque.removeLast();
                         }
                case 0: stop = false; break; // stop the operation
            }
            System.out.println("\n--------------------------------------------------------\n");
        }
    }
}