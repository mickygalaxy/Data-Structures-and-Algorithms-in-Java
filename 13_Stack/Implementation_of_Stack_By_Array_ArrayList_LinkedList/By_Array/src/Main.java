
/*


                         ----   ----   ----    ----   |  ||
                        |___     |    |___|   |       ||
                        ___|    |    |   |   |____    |  ||
 */

// Implementation Of Stack By Array

/*
Time Complexity :-
push() :- O(1)
pop()  :- O(1)
peek() :- O(1)
 */


import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    static class Stack{
        static int[]Array;  //Array declaration
        static int Top=-1; // Top is initially initialize by -1 because currently array or stack is empty (array start 0 index so be hard to initialize -1)
        static public  void sizeInitialize(int n){ // this is function for define the size
            Array = new int[n];   // initialize the size of array
        }

        static public void Peek(){ // this function show you top of the element which are present in side the stack
            if(Top==-1){   // if top is -1 so stack is empty means no element is present inside the stack
                System.out.println("\t\t -: 'Stack is Empty or Underflow' -:");
                return;
            }
            System.out.println("\t\t"+"Top Element is "+Array[Top]);  // its display the top element of the stack
        }
        //--------------------------------------------------------------------
        static public void Pop(){  // this function is for to delect  the top element inside the stack
            if(Top == -1){  // if top is -1 so stack is empty means no element is present inside the stack
                System.out.println("\t\t -: 'Stack is Empty or Underflow,can't be delect any element ' -:");

            }
            else{
                System.out.println("Delete Element is "+Array[Top]); // its display which element was deleted inside the stack at top position.
                Array[Top]=0;
                Top--; // decrement top
            }
        }
        //--------------------------------------------------------------------
        static public void Push(int data){ // Push Operation for adding element inside the stack
            if(Top == Total_size-1){  // Top is equal to total size of array so this scenario is overflow ,so you can't be adding the  element.
                System.out.println("\t\t -: \\'Stack is Overflow\\' -:");
            }
            else{

                Array[++Top]= data; // adding the element inside the stack and increment the top to add next element another block inside the stack.
            }
        }
        //----------------------------------------------------------------------



    }
    public static int Total_size; // this global variable its define the size of array or stack.
    public static void main(String[] args) { // Main Driver
        System.out.print("Enter the Total Number Of Size Of Stack :- ");
        Total_size = sc.nextInt();  // its store the size of array or stack
        Stack.sizeInitialize(Total_size); // calling function for define the size
        int choice; // this is indicated  the which operation you have to perform
        do{ // using do-while loop  because  this loop run at least one time its show the operation menu when you not perform any operation .
        System.out.println("\n\n---------------------------------");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t-: Stack Operation Menu :-");
        System.out.println("~# \tStop           : Select - 0"); // stop() the operation
        System.out.println("~# \tPush Operation : Select - 1"); // push()
        System.out.println("~# \tPoP  Operation : Select - 2"); // pop()
        System.out.println("~# \tPeek Operation : Select - 3"); // peek()
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("---------------------------------\n\n");
        System.out.print("Enter Your Choice To Perform Operation :- ");
        choice = sc.nextInt(); // take the value by user which operation to perform
            switch (choice) { // its check the choice which operation to perform
                case 1 -> {
                    System.out.println("Enter the data :- ");
                    int data = sc.nextInt();
                    Stack.Push(data); // calling push function
                    if (Stack.Top == Total_size - 1) {
                        break;
                    }
                }
                case 2 -> Stack.Pop(); // calling pop function
                case 3 -> Stack.Peek(); // calling peek function
            }
        }while(choice!=0); // if choice is 0 so condition is false so operation are stopped.
    }
}