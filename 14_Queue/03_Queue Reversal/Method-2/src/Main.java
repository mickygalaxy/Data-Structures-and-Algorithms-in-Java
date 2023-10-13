//                                            Queue Reversal (Method-2)
/*
Time Complexity :- O(n)
SpaceComplexity :- O(n)
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 
import java.util.Stack;

public class Main {
    static Queue<Integer> q = new LinkedList<>();

    static class QueueB{
        public static boolean isEmpty(){
            return q.isEmpty();
        }
        public static void add(int data){
            q.add(data);
            Queue_Reversal();
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("'empty queue'");
                return -1;
            }
            return q.remove();
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("'empty queue'");
                return -1;
            }
            return q.peek();
        }
    }

    public static void Queue_Reversal(){ // reversal Logic
        for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());
        }
    }

    public static void Display(){
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
        System.out.println("\n");
    }
    public static void Menu() {
        System.out.println("#~ Queue Operation Menu ~#"); // this is a menu of Queue Operations
        System.out.println("# \tRear          :~ 1"); //  enter the data in queue
        System.out.println("# \tFront         :~ 2");//   remove the data in queue
        System.out.println("# \tisEmpty       :~ 3");//   check queue is empty or not
        System.out.println("# \tPeek          :~ 4");//   display first enter the value
        System.out.println("# \tDispaly Queue :~ 5");
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
                    QueueB.add(data);  // rear function calling and passing data
                    System.out.println("'Data Successfully added'");
                    break;
                case 2:
                    System.out.println("Remove data is " + QueueB.remove()); // front function calling
                    System.out.println("'Data Successfully Removed'");
                    break;
                case 3:
                    System.out.println("Stack is Empty:- " + (QueueB.isEmpty() ? "yes" : "No"));
                    break; // isEmpty function calling
                case 4:
                    System.out.println("Last Enter data is " + QueueB.peek());
                    break; // peek function is calling
                case 0:
                    stop = false;
                    break; // stop the operation
                case 5:
                    Display();
            }
        }
        System.out.println("\n--------------------------------------------------------\n");
    }


}
