
//                                                             Duplicate Parentheses


// Time Complexity :- O(n)


import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static boolean CheckDuplicate(String s){ // this function check Duplicate Parentheses
        Stack<Character>stack = new Stack<>(); // Stack
        for(int i=0;i<s.length();i++){ // iterating each character
            char c = s.charAt(i); // its hold the character
            //closing
            if(c == ')'){ // checking opening parentheses
            int count =0; // its count the total number of operand,operator between the parentheses.
            while(stack.peek() !='('){ // it's finding the pair
                stack.pop();
                count++; // increment count by 1
            }
            if(count<1){ // if be get count less than 1 so duplicate are present
                return true; // duplicate
            }
            else{
                stack.pop();
            }
            }
            else{
            stack.push(c);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("<--: Enter only parentheses with pair, operand, operator eg:- ((a+b)+(c+d)) :-->");
        System.out.println("Enter :- ");
        String s = sc.next();
        System.out.println(CheckDuplicate(s));
    }
}