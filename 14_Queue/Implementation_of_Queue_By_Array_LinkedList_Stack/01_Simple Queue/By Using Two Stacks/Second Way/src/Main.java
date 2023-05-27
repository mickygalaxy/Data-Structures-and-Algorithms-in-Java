//  Methode -2                                  Implement Queue by using - 'Two Stack'

/*
Method 2  (By making deQueue operation costly): In this method, in en-queue operation, the new element is entered at the top of stack1. In de-queue operation,
if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.
 */

/*
-: Time Complexity :-

enQueue or add()  :- O(1)
  1) Push x to stack1 (assuming size of stacks is unlimited).
  Here time complexity will be O(1)

deQueue or remove() :- O(n)
  1) If both stacks are empty then error.
  2) If stack2 is empty
       While stack1 is not empty, push everything from stack1 to stack2.
  3) Pop the element from stack2 and return it.
  Here time complexity will be O(n)

peek() :- O(n)
 */

import java.util.Scanner;
import java.util.Stack;
public class Main {

    //-----------------------------------------------------------------------------------------------------------------

    static class Queue {  // this is queue class
        static Stack<Integer> s1 = new Stack<>(); // implement stack by java collection framework
        static Stack<Integer> s2 = new Stack<>(); // implement stack by java collection framework

        public static boolean isEmpty() { //This method checks if the first stack (s1) is empty and returns a boolean value indicating whether the queue is empty or not.
            return s1.isEmpty();
        }

//-----------------------------------------------------------------------------------------------------------------

        public static void add(int data) { //This method adds an element to the queue by pushing it onto the first stack (s1).
            s1.push(data);
        }

        //-----------------------------------------------------------------------------------------------------------------


        public static int remove() { // This method removes and returns the front element from the queue. If the second stack (s2) is empty, it transfers all elements from the first stack (s1) to the second stack in reversed order before popping the top element from s2. This ensures that the oldest element in the queue is at the top of s2.
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            if (!s2.isEmpty()) {
                return s2.pop();
            } else {
                throw new IllegalStateException("Queue is empty");
            }
        }

//-----------------------------------------------------------------------------------------------------------------
        public static int peek() { // This method returns the front element of the queue without removing it. If the second stack (s2) is empty, it prints "'queue empty'" and returns -1 to indicate that the queue is empty.
            if (s2.isEmpty()) {
                System.out.println("'queue empty'");
                return -1;
            }
            return s2.peek();
        }

//-----------------------------------------------------------------------------------------------------------------

    }

    public static void Menu() {
        System.out.println("#~ Queue Operation Menu ~#"); // this is a menu of Queue Operations
        System.out.println("# \tEnqueue :~ 1"); //  enter the data in queue
        System.out.println("# \tDequeue :~ 2");//   remove the data in queue
        System.out.println("# \tisEmpty :~ 3");//   check queue is empty or not
        System.out.println("# \tPeek    :~ 4");//   display first enter the value
        System.out.println("# \tStop    :~ 0");//   stop operation
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean stop = true;
        while (stop != false) {
            Menu(); // menu function calling
            System.out.print("Chooice :-  ");
            int choice = sc.nextInt(); // choice any operation
            switch (choice) {
                case 1:
                    System.out.print("Enter the Data :- ");
                    int data = sc.nextInt();
                    Queue.add(data);  // rear function calling and passing data
                    System.out.println("'Data Successfully added'");
                    break;
                case 2:
                    System.out.println("Remove data is " + Queue.remove()); // front function calling
                    System.out.println("'Data Successfully Removed'");
                    break;
                case 3:
                    System.out.println("Queue is Empty:- " + (Queue.isEmpty() ? "yes" : "No"));
                    break; // isEmpty function calling
                case 4:
                    System.out.println("First Enter data is " + Queue.peek());
                    break; // peek function is calling
                case 0:
                    stop = false;
                    break; // stop the operation
            }
            System.out.println("\n--------------------------------------------------------\n");
        }
    }
}