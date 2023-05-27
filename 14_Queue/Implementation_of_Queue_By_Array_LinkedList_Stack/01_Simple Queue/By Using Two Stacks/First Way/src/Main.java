
//  Methode -1                                  Implement Queue by using - 'Two Stack'
/*
Method 1 (By making enQueue operation costly): This method makes sure that oldest entered element is always at the top of stack 1, so that deQueue operation just pops from stack1.
To put the element at top of stack1, stack2 is used.
 */

/*
-: Time Complexity :-

[*] add or push() or enQueue(q, x) :- O(n)
While stack1 is not empty, push everything from stack1 to stack2.
Push x to stack1 (assuming size of stacks is unlimited).
Push everything back to stack1.
Here time complexity will be O(n)


[*] remove or pop() or deQueue(q): O(1)
If stack1 is empty then error
Pop an item from stack1 and return it
Here time complexity will be O(1)
 */



import java.util.Scanner;
import java.util.Stack;
public class Main {

    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {     // Check if the queue is empty
            return s1.isEmpty();
        }


        public static void add(int data){    // Add an element to the queue
            while(!s1.isEmpty()){           // Move all elements from s1 to s2
                s2.push(s1.pop());
            }
            s1.push(data);                 // Push the new element to s1
            while(!s2.isEmpty()){         // Move all elements back to s1 from s2
                s1.push(s2.pop());
            }
        }


        // Remove and return the front element from the queue
        public static int remove(){
            if(isEmpty()){
                System.out.println("'queue empty'");
                return -1;
            }
            return s1.pop();
        }


        // Return the front element of the queue without removing it
        public static int peek(){
            if(isEmpty()){
                System.out.println("'queue empty'");
                return -1;
            }
            return s1.peek();
        }


    }

    public static void Menu(){
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
        while(stop!=false){
            Menu(); // menu function calling
            System.out.print("Chooice :-  ");
            int choice = sc.nextInt(); // choice any operation
            switch (choice){
                case 1: System.out.print("Enter the Data :- ");
                    int data = sc.nextInt();
                    Queue.add(data);  // rear function calling and passing data
                    System.out.println("'Data Successfully added'");
                    break;
                case 2: System.out.println("Remove data is "+Queue.remove()); // front function calling
                    System.out.println("'Data Successfully Removed'");
                    break;
                case 3: System.out.println("Queue is Empty:- "+(Queue.isEmpty() ? "yes":"No")); break; // isEmpty function calling
                case 4: System.out.println("First Enter data is "+Queue.peek()); break; // peek function is calling
                case 0: stop = false; break; // stop the operation
            }
            System.out.println("\n--------------------------------------------------------\n");
        }
    }
}