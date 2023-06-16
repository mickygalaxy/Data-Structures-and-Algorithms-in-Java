
//                                                  Generate Binary Number
// by queue
/*
Follow the given steps to solve the problem:
~ Create an empty queue of strings
~ Enqueue the first binary number “1” to the queue.
~ Now run a loop for generating and printing n binary numbers.
~ Dequeue and Print the front of queue.
~ Append “0” at the end of front item and enqueue it.
~ Append “1” at the end of front item and enqueue it.
 */
/*
Time Complexity :- O(n)
Space Complexity :- O(n)
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        generateBinaryNumber(num);
    }

    private static void generateBinaryNumber(int num) {
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<>();
        // Enqueue the first binary number
        q.add("1");
        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while(num-->0){
            // print the front of queue
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            // Store s1 before changing it
            String s2  = s1;
            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");
            // Append "1" to s2 and enqueue it. Note that s2
            // contains the previous front
            q.add(s2 + "1");
        }
    }
}