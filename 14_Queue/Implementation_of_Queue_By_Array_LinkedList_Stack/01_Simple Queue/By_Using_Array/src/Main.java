
//                                          Implementation Of Queue By Using Array

/*
             Time Complexity
add              O(1)
remove           O(n)
peek             O(1)

 (disadvantage its take too much time for removing operation  and its size is fixed)
 */

import java.util.Scanner;
public class Main {
    static class Queue{ // This is a Queue
        static int[] arr; // initialize array ( Simulator )
        static int size; // initialize size
        static int rear; // initialize rear

        // Constructor
        Queue(int n){ // n is size of array
            arr = new int[n]; // declaration array
            size = n;  // declaration the size of array
            rear = -1; // declaration the staring rear and is not pointing any index
        }


        // empty function for checking array is empty or not
        public static boolean isEmpty(){ // Time Complexity :-  O(1)
            return rear == -1; // rear is not pointing any index it's means array is empty
        }


        // add method ( enqueue )
        public static void add(int data){ // Time Complexity :-  O(1)
            if(rear == size-1){ // this condition checking space inside the array is full or not
                System.out.println("Queue is full"); // it's full, so you can't be added any data inside the queue
                return;
            }
            rear = rear+1; // it's pointing (rear+1) index
            arr[rear] = data; // holding the data
        }


        // remove ( dequeue )
        public static int remove(){  // Time Complexity :-  O(n)
            if(isEmpty()){ // checking queue is empty or not
                System.out.println("Empty Queue");
                return -1;
            }
            int front  = arr[0]; // front take the value front side which one to delete
            for(int i=0;i<rear;i++){ //  shifting the value
                arr[i] = arr[i+1];
            }
            rear = rear-1; // rear pointing to previous index
            return front; // return the front value which one deleted
        }


        // Peek
       public static int peek(){ // Time Complexity :-  O(1)
         if(isEmpty()){ // checking queue is empty or not
            System.out.println("Empty Queue");
            return -1;
         }
        return arr[0]; // front side value (first come)
       }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Total Number Of Size Of Queue :- ");
        int Total_size = sc.nextInt();  // its store the size of array or Queue
        Queue q = new Queue(Total_size);
        int choice; // this is indicated  the which operation you have to perform
        do{ // using do-while loop  because  this loop run at least one time its show the operation menu when you not perform any operation .
            System.out.println("\n\n---------------------------------");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t-: Queue Operation Menu :-");
            System.out.println("~# \tStop               : Select - 0"); // stop() the operation
            System.out.println("~# \tenqueue Operation  : Select - 1"); // enqueue() or add()
            System.out.println("~# \tdequeue  Operation : Select - 2"); // dequeue() or remove()
            System.out.println("~# \tpeek Operation     : Select - 3"); // peek()
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("---------------------------------\n\n");
            System.out.print("Enter Your Choice To Perform Operation :- ");
            choice = sc.nextInt(); // take the value by user which operation to perform
            switch (choice) { // its check the choice which operation to perform
                case 1 -> {
                    System.out.println("Enter the data :- ");
                    int data = sc.nextInt();
                    Queue.add(data); // calling enqueue function
                }
                case 2 -> System.out.println(Queue.remove()); // calling dequeue function
                case 3 -> System.out.println(Queue.peek()); // calling peek function
            }
        }while(choice!=0); // if choice is 0 so condition is false so operation are stopped.

        while(!Queue.isEmpty()){
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }

}