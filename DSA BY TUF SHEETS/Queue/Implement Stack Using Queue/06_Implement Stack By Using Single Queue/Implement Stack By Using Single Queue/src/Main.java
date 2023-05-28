//                                               Implement Stack using single Queue

/*
Problem Statement: Implement a Stack using a single Queue.

Note: Stack is a data structure that follows the Last In First Out (LIFO) rule.

Note: Queue is a data structure that follows the First In First Out (FIFO) rule.

Explanation:
push(): Insert the element in the stack.
pop(): Remove and return the topmost element of the stack.
top(): Return the topmost element of the stack
size(): Return the size of the stack
 */

/*
~# "Solutiuon" #~

Intuition: As we know stack follows last in first out, which means we get the most recently inserted element whenever we remove an element from the stack. But queue follows first in first out, it means we get that element which we inserted in the starting at each deletion,
it means if we want to use the queue like a stack we have to arrange elements in the queue such that we get the most recent element at each deletion.

Approach:

Take a single queue.
push(x): Push the element in the queue.
Use a for loop of size()-1, remove element from queue and again push back to the queue, hence the most recent element becomes the most former element and vice versa.
pop(): remove the element from the queue.
top(): show the element at the top of the queue.
size(): size of the current queue.
 */

/*
Time Complexity: O(N)

Space Complexity: O(N)
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {

    static class Stack{
        static Queue<Integer> q = new LinkedList<>();

//This method checks if the stack is empty by calling the isEmpty() method of the underlying queue.
// It returns true if the queue is empty, indicating that the stack is empty.
        public static boolean isEmpty() {
            return q.isEmpty();
        }

        //This method adds an element to the stack. It adds the new element to the back of the queue and then rotates the queue by removing and re-adding each element, effectively placing the new element at the front of the queue.
        // This operation ensures that the most recently added element becomes the top of the stack.
        public static void push(int data){
            q.add(data);
            for(int i=0;i<q.size()-1;i++){
                q.add(q.remove());
            }
        }

        //This method removes and returns the top element from the stack. It first checks if the queue is empty and prints a message if it is. Otherwise,
        // it removes and returns the element from the front of the queue, which corresponds to the top of the stack.
        public static int pop(){
            if(q.isEmpty()){
                System.out.println("'queue is Empty'");
                return -1;
            }
            return q.remove();
        }

        //This method returns the top element of the stack without removing it. Similar to pop(), it checks if the queue is empty and prints a message if it is. Otherwise,
        // it returns the element at the front of the queue.
        public static int peek(){
            if(q.isEmpty()){
                System.out.println("'queue is Empty'");
                return -1;
            }
            return q.peek();
        }

    }
    public static void Menu() {
        System.out.println("#~ Stack Operation Menu ~#"); // this is a menu of Queue Operations
        System.out.println("# \tPush          :~ 1"); //  enter the data in queue
        System.out.println("# \tPoP           :~ 2");//   remove the data in queue
        System.out.println("# \tisEmpty       :~ 3");//   check queue is empty or not
        System.out.println("# \tPeek          :~ 4");//   display first enter the value
        System.out.println("# \tDisplay Stack :~ 5");
        System.out.println("# \tStop          :~ 0");//   stop operation

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean stop = true;
        while (stop) {
            Menu(); // menu function calling
            System.out.print("Choice :-  ");
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

/*
 implements a stack using a queue by utilizing the FIFO (First-In-First-Out) property of a queue.
 However, it's important to note that this implementation is not the most efficient way to implement a stack.
 It has a time complexity of O(n) for push and pop operations, where n is the number of elements in the stack,
 because it requires rotating the entire queue during each push operation.
 */