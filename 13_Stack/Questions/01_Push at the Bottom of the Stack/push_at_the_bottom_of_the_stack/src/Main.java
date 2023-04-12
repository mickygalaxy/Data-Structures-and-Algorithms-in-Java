
//                                                           'Push at the bottom of the stack'

// by Recursion

// Time Complexity :- O(n)
// Space Complexity :- O(1)


import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){ // this is base condition. its check stack is empty ,so it's possible to push at the bottom data of the stack.
            s.push(data); // new data
            return;

        }
            int top = s.pop(); // top is temp type is store the top data. because be not lose this top data before pushing bottom data of the stack.
            pushAtBottom(s,data); // recursive call
            s.push(top); // after pushing bottom data of the stack then push top data.
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>(); // this is a stack (Using Java Collection FrameWork Stack)
        s.push(1); // push operation
        s.push(2);// push operation
        s.push(3);// push operation
        System.out.println("enter the data :- ");
        int data = sc.nextInt(); // new data take by user to provide to add inside the stack
        pushAtBottom(s,data); // calling function for add the data(by pushing at the bottom of the stack)

        while(!s.isEmpty()){
            System.out.println("| "+s.pop()+" |"); // print the top values
        }
        System.out.println(" ---");

    }
}