
//                                                              Valid Parentheses


//Time Complexity :- O(n)

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static Boolean Checking_Valid_parentheses(String s){ // this function check  valid parentheses or not.
        Stack<Character>stack = new Stack<Character>(); // This is a Stack
        for(int i=0;i<s.length();i++){ // loop for iterating each index
            char ch = s.charAt(i);// it's store the character
            if(ch == '(' || ch == '{' || ch =='['){ // it's check the character is opening parentheses
                stack.push(ch); // push the opening parentheses
            }
            else{
                if(stack.isEmpty()){ // stack is empty
                    return false; // there is not present any opining parentheses
                }
                if ((stack.peek() == '(' && ch == ')') || (stack.peek() == '{' && ch == '}') || (stack.peek()== '['  && ch == ']')) { // checking opening and closing pair are present or not
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){ // stack is empty
            return true;
        }
        else{ // stack is not empty
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter only Parentheses => () , {} , []");
        String s = sc.next();
        System.out.println(Checking_Valid_parentheses(s));
    }
}