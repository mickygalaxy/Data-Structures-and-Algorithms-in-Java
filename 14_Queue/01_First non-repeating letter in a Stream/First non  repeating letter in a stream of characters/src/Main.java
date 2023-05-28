
//                                      First non-repeating letter in a stream of characters

/*
Time Complexity :- O(n)
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void Solution(String s){
        // Get the size of the input string
        int size = s.length();

        // Create a queue to store characters
        Queue<Character> q = new LinkedList<>();

        // Create an array to store the frequency of characters
        int[] frequancy = new int[27];

        // Initialize the frequency array with zeros
        Arrays.fill(frequancy, 0);

        // Iterate through each character in the string
        for(int i = 0; i < size; i++){
            // Get the current character
            char c = s.charAt(i);

            // Add the character to the queue
            q.add(c);

            // Increase the frequency of the character by 1
            frequancy[c - 'a']++;

            // Remove characters from the queue until we find a character with frequency 1
            while(!q.isEmpty() && frequancy[q.peek() - 'a'] > 1){
                q.remove();
            }

            // Check if the queue is empty
            if(q.isEmpty()){
                // If the queue is empty, print -1
                System.out.println("-1");
            }else{
                // If the queue is not empty, print the first non-repeating character in the queue
                System.out.println(q.peek());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Solution(s);
    }
}