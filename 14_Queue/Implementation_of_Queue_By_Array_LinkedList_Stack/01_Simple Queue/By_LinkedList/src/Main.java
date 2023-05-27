
//                                      Implementation of Queue By LinkedList

/*
-: Time Complexity :-
add()    :- O(1)
remove() :- O(1)
peek()   :- O(1)
 */



import javax.xml.stream.events.StartDocument;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node{ // Implemented LinkedList - Node
        int data;   // Initialize the data variable to store the data
        Node next; // Initialize the next pointer to refer next node (hold the next node address)

        public Node(int data){ // this is constructor and its one parameter that take value
            this.data = data;  //  assign the value to data
            this.next = null; //  next is not pointing any node
        }
    }

    static class Queue{ // this is queue class, its contain all Operation the of the Queue

        //------------------------------------------------------------
        static Node rear = null; // this is rear or tail
        static Node front = null; // this is front or head
        //------------------------------------------------------------
        public static int front(){ // this is method for remove the data
            if(isEmpty()){  // its check the queue is empty or not
                System.out.println("-: Empty Queue :-"); // if queue is empty, so you can't be removed any data
                return -1;
            }
            int value = front.data; // its store the data which one to remove
            if(rear == front){ // if position or refer of rear and front is same to initialize the null .
                rear = front = null;  // now it's not pointing any node
            }
            else{
                front = front.next; // data is removed then front pointer to update ,its pointed next node
            }
            return value; // its return the value which one is removed
        }
        //------------------------------------------------------------
        public static void rear(int data){ // this method for adding data
            Node newNode = new Node(data);  // create newNode
            if(rear==null){  // if initially rear is null
                rear = front = newNode;  // then assign the pointer to point ,now rear and front is pointing newNode
            }
           rear.next = newNode; // rear.next pointing newNode Address
           rear = newNode; // update rear pointer
        }
        //------------------------------------------------------------
        public static boolean isEmpty(){ // if rear and front is null so queue is empty no data is present

            return rear == null && front == null;
        }
        //------------------------------------------------------------
        public static int peek(){ // this method for display the data which one come first enter
            if(isEmpty()){
                System.out.println("-: Empty Queue :-");
                return -1;
            }
            return front.data;
        }
        //------------------------------------------------------------

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
                        Queue.rear(data);  // rear function calling and passing data
                        System.out.println("'Data Successfully added'");
                        break;
                case 2: System.out.println("Remove data is "+Queue.front()); // front function calling
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