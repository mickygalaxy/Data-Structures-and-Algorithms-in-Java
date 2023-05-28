


//                                                 Implementation of Stack Using Two Queue


//Method - 1(By making POP operation costly)

/*
 -: Time Complexity :-
Push O(1)
Pop  O(n)
Peek O(n)
 */



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

      //The Stack class is declared as a static nested class.
     // It contains two static queues, q1 and q2, which are instances of the Queue interface implemented by the LinkedList class.
    static class Stack{
        //two static queues q1 and q2 using the LinkedList implementation of the Queue interface. They will be used to store the elements of the stack.
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){ //The isEmpty() method checks if both q1 and q2 are empty, indicating that the stack is empty. It returns true if both queues are empty, and false otherwise.
            return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int data){ // The push(int data) method is used to push an element onto the stack. If q1 is not empty, the new element is added to q1. Otherwise, if q1 is empty, the new element is added to q2.
            if(!q1.isEmpty()){
                q1.add(data);
            }
            else {
                q2.add(data);
            }
        }

        public static int pop(){ // The pop() method removes and returns the top element from the stack. It first checks if the stack is empty. If it is, it prints "empty stack" and returns -1 as an error indicator.
           // If q1 is not empty, it transfers all elements from q1 to q2 one by one until only the last element (top of the stack) remains in q1. This last element is removed from q1 and stored in the top variable. If q1 is empty, the same process is performed on q2.
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top =-1;

            //case-1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else { // case 2
                while (!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek(){ //peek() method is similar to pop(), but it does not remove the top element from the stack. Instead, it returns the top element without modifying the stack.
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top =-1;

            //case-1
            if(!q1.isEmpty()){
                while (!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }else { // case 2
                while (!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }
    public static void Menu() {
        System.out.println("#~ Stack Operation Menu ~#"); // this is a menu of Queue Operations
        System.out.println("# \tPush          :~ 1"); //  enter the data in queue
        System.out.println("# \tPoP           :~ 2");//   remove the data in queue
        System.out.println("# \tisEmpty       :~ 3");//   check queue is empty or not
        System.out.println("# \tPeek          :~ 4");//   display first enter the value
        System.out.println("# \tDispaly Stack :~ 5");
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
                case 5 :
                    while (!Stack.isEmpty()){
                        System.out.println(Stack.peek());
                        Stack.pop();
                    }
            }
            System.out.println("\n--------------------------------------------------------\n");
        }
    }

}