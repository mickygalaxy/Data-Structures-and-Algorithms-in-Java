

//                        "Reverse a Stack"
 

// Time Complexity :- O(n)        Space Complexity :- O(1)


import java.util.Stack;

public class Main {   


    public static void Push_At_Bottom(Stack<Integer>s,int data){ // this function for push the data at bottom not the top
        if(s.isEmpty()){ // if stack is empty so now be push the data
            s.push(data);
          return;}
        int top = s.pop(); // remove the data from the top of the stack
        Push_At_Bottom(s,data); // calling recursive function
        s.push(top); // pushing the top  data
    }

    public static void ReverseTheStack(Stack<Integer>s){
        if(s.isEmpty()){  // if stack is empty so note that empty stack is a reverse stack
            return;
        }
       int top = s.pop(); //  pop the top element from the stack
       ReverseTheStack(s); //  calling recursive function
       Push_At_Bottom(s,top); // calling this function to push the data at the bottom . this function add the top data in place of bottom.
    }

    public static void Display_Stack(Stack<Integer>s){ // this function display the stack.
        int i =s.size()-1;

        while(i!=-1){
            System.out.println("| "+s.get(i)+" |");
            i--;
        }
        System.out.println(" --- ");
    }

    public static void main(String[] args) { // driver
        Stack<Integer>s = new Stack<>(); // this  is Stack (using java collection framework)
        s.push(1); // push operation
        s.push(2);
        s.push(3);
        s.push(4);
        Display_Stack(s); // calling display function
        ReverseTheStack(s); // calling ReverseTheStack function
        System.out.println("-: Reverse Stack :-");
        Display_Stack(s);
    }
}
