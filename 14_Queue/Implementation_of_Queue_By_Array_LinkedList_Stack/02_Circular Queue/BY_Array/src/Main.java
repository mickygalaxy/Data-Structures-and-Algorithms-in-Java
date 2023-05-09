

//                                                   Circular Queue
// Implement By Array
/*
Time Complexity :-
add() --> O(1)
remove() --> O(1)
peek() --> O(1).
 */

import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    static class Queue{ // queue class
        static int[]Array;  // declare the array
        static int size;  // declare the size of array
        static int rear; // declare the rear pointer
        static int front;  // declare the front pointer
        Queue(int Size){ // this is a constructor it's having one parameter  take an array size.
            Array = new int[Size]; // Initialize the array size
            size = Size; // it's hold the size
            rear = -1;  // now rear is not pointing any index
            front = -1; // now front is not pointing any index
        }
        public static boolean isEmpty(){ // this function check queue is empty or not
            return rear == -1 && front == -1;  //its true is empty its mean inside queue there no element present
        }
        public static boolean isFull(){ // this function check queue is full or not
            return (rear+1)%size == front; // its true is full its mean inside queue all memory block full so there is no space.
        }
        public void add(int data){  // this function add the element
            if(isFull()){ // if queue is full ,cannot be added the element ,all memory space are full.
                System.out.println("queue is full");
                return;
            }
            if(front==-1){ // if initially starting rear is pointing index 0 ,so also update front because front is point which index value to remove  when its required to remove.
                front = 0;
            }
            rear = (rear+1)%size; // update the rear pointer
            Array[rear] = data; // add the data at the rear pointer position
        }
        public static int remove(){ //this function remove the element
            if(isEmpty()){ // if queue is empty,cannot be remove null element.
                System.out.println("Empty queue");
                return -1;
            }
            int result = Array[front]; // its hold the which element are deleting at the front position.
            if(rear == front){ // if rear is equal to front position. to update there is not pointing any index.
                rear = front = -1;
            }
            else{
                front = (front+1)%size; // update the front pointer
            }
            return result; // return the deleting value
        }
        public static int peek(){ // this function show the first come
            if(isEmpty()){ // if queue is empty,cannot be remove null element.
                System.out.println("Empty queue");
                return -1;
            }
            return Array[front];
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of /'queue/' :- ");
        int size = sc.nextInt(); // its take the size of queue
        Queue q =new Queue(size); //  creating the object
        int choice; // this is indicated  the which operation you have to perform
        do{ // using do-while loop  because  this loop run at least one time its show the operation menu when you not perform any operation .
            System.out.println("\n\n---------------------------------");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t-: Circular Queue Operation Menu :-");
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
                    q.add(data); // calling enqueue function
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