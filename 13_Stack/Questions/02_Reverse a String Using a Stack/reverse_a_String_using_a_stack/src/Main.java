
//                                     Reverse a String using a Stack



import java.util.Scanner;
import java.util.Stack;
 
public class Main {

    public static String reverseString(String str){
        Stack<Character>s=new Stack<>(); // this is a stack (Using Java Collection FrameWork Stack)
        int idx = 0;  // iterating one by one character of string, starting index is zero
        while(idx<str.length()){
            s.push(str.charAt(idx)); // push the character
            idx++; // increment by 1
        }
        StringBuilder result = new StringBuilder("");  // using extra variable result its store reverse string.
        while(!s.isEmpty()){
            char curr = s.pop(); // top character pop and give to curr(its holding).
            result.append(curr); // concatenating curr with result
        }
        return result.toString(); // return the final reverse string(result)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("# Enter the any String :- ");
        String str = sc.nextLine();
        System.out.println("# Reverse String :-");
        System.out.print(reverseString(str));
    }
}
