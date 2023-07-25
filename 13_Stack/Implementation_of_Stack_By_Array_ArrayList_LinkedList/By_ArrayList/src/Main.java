
/*


                         ----   ----   ----    ----   |  ||
                        |___     |    |___|   |       ||
                        ___|    |    |   |   |____    |  ||
 */

// Implementation Of Stack By ArrayList

/*
Time Complexity :-
push() :- O(1)
pop()  :- O(1)
peek() :- O(1)
 */


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Scanner sc = new Scanner(System.in);
   static class Stack{ // this is Stack class
       static  ArrayList<Integer>stack= new ArrayList<>(); // using dynamic array to make a stack.

        public static boolean isEmpty(){ // isEmpty function check the stack is empty or not.
            return stack.size()==0;
        }
        public static void push(int data){ // Push Operation for adding element inside the stack

            stack.add(data); // adding the element inside the stack.
        }
        public static int pop(){ // this function is for to delect  the top element inside the stack
            if(isEmpty()){
                return -1;
            }
            int top = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return top;
        }
        public static int peek(){ // this function show you top of the element which are present in side the stack
            if(isEmpty()){
                return -1;
            }else {
            return stack.get(stack.size()-1);
        }
    }
    public static void main(String[] args) {
        int choice; // this is indicated  the which operation you have to perform
        do{ // using do-while loop  because  this loop run at least one time its show the operation menu when you not perform any operation .
            System.out.println("\n\n------------------------------------------------------------------");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t\t-: Stack Operation Menu :-");
            System.out.println("~# \tStop                           : Select - 0"); // stop() the operation
            System.out.println("~# \tPush Operation                 : Select - 1"); // push()
            System.out.println("~# \tPoP  Operation                 : Select - 2"); // pop()
            System.out.println("~# \tPeek Operation                 : Select - 3"); // peek()
            System.out.println("~# \tCheck is Stack is Empty or not : Select - 4");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("------------------------------------------------------------------\n\n");
            System.out.print("Enter Your Choice To Perform Operation :- ");
            choice = sc.nextInt(); // take the value by user which operation to perform
            switch (choice) { // its check the choice which operation to perform
                case 1 -> {
                    System.out.println("Enter the data :- ");
                    int data = sc.nextInt();
                    Stack.push(data); // calling push function
                }
                case 2 -> Stack.pop(); // calling pop function
                case 3 -> System.out.println(Stack.peek()); // calling peek function
                case 4 -> {
                    if(Stack.isEmpty()){
                        System.out.println("-: Stack is Underflow :-");// if top is 0 so stack is empty means no element is present inside the stack
                }
                else{
                        System.out.println("-: Stack is not Empty :-");
                   }
               }
            }
        }while(choice!=0); // if the choice is 0 so the condition is false then operations are stopped.



    }
}}
