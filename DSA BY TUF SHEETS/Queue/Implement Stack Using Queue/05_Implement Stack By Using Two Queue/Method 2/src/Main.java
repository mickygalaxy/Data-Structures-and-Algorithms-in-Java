
//                                 Implementation of Stack By Using Two Queue

//  Method - 2 ( Using PUSH Operation Expensive )

/*
-: Time Complexity :-
push() - O(n)
Pop()  - O(1)
Peek() - O(1)

-: Space Complexity :-
SP :- O(n)
The space complexity of the stack implementation using two queues is O(n), where n is the number of elements in the stack.

In the implementation, two queues, q1 and q2, are used to store the elements of the stack. Both queues can potentially hold up to n elements if the stack contains n elements.

When pushing an element onto the stack, all existing elements are temporarily moved from q1 to q2 and then back to q1. This results in a temporary storage requirement of 2n elements. However, after the push operation is complete, only q1 contains the stack elements, while q2 is empty.

Therefore, the actual space used by the stack is proportional to the number of elements in q1, which is equivalent to the number of elements in the stack. Hence, the space complexity is O(n).
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    //The Stack class is declared as a static nested class.
    // It contains two static queues, q1 and q2, which are instances of the Queue interface implemented by the LinkedList class.
    static class Stack {
        //two static queues q1 and q2 using the LinkedList implementation of the Queue interface. They will be used to store the elements of the stack.
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() { //The isEmpty() method checks if both q1 and q2 are empty, indicating that the stack is empty. It returns true if both queues are empty, and false otherwise.
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            // When pushing an element, we move all existing elements from q1 to q2,
            // then add the new element to q1, and finally move all elements from q2 back to q1.

            // Move all elements from q1 to q2
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            // Add the new element to q1
            q1.add(data);
            // Move all elements from q2 back to q1
            while (!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            // To pop an element, we simply remove and return the front element of q1.
            return q1.remove();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            // To peek at the top element, we simply return the front element of q1 without removing it.
            return q1.peek();
        }
    }

    public static void Menu() {
        System.out.println("#~ Stack Operation Menu ~#"); // this is a menu of Queue Operations
        System.out.println("# \tPush          :~ 1"); //  enter the data in queue
        System.out.println("# \tPoP           :~ 2");//   remove the data in queue
        System.out.println("# \tisEmpty       :~ 3");//   check queue is empty or not
        System.out.println("# \tPeek          :~ 4");//   display first enter the value
        System.out.println("# \tDispaly Stack :~ 5");
        System.out.println("# \tStop          :~ 0");//   stop operation

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
                    Stack.push(data);  // rear function calling and passing data
                    System.out.println("'Data Successfully added'");
                    break;
                case 2:
                    System.out.println("Remove data is " + Stack.pop()); // front function calling
                    System.out.println("'Data Successfully Removed'");
                    break;
                case 3:
                    System.out.println("Stack is Empty:- " + (Stack.isEmpty() ? "yes" : "No"));
                    break; // isEmpty function calling
                case 4:
                    System.out.println("Last Enter data is " + Stack.peek());
                    break; // peek function is calling
                case 0:
                    stop = false;
                    break; // stop the operation
                case 5:
                    while (!Stack.isEmpty()) {
                        System.out.println(Stack.peek());
                        Stack.pop();
                    }
            }
            System.out.println("\n--------------------------------------------------------\n");
        }
    }

}