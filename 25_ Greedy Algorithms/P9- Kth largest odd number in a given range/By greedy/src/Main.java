
//-----------------------------------------------------------------------------------------------------------------------------------------------------------

//                                                " Kth largest odd number in a given range "

//-----------------------------------------------------------------------------------------------------------------------------------------------------------

/*
Given two variables L and R, indicating a range of integers from L to R inclusive, and a number K, the task is to find Kth largest odd number. If K > number of odd numbers in the range L to R then return 0.

Examples:

    Input: L = -10, R = 10, K = 8
    Output: -5
    Explanation:  The odd Numbers in the range are -9, -7, -5, -3, -1, 1, 3, 5, 7, 9 and the 8th Largest odd number is -5

    Input: L = -3, R = 3, K = 1
    Output: 3
 */
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
/*
# Greedy Approach Algorithm #

~ Initialize variables count and result to 0.
~ Adjust the range if necessary to include odd numbers: if L is even, increment L by 1; if R is even, decrement R by 1.
~ Iterate through the range from R to L in reverse order with a step size of 2.
  Increment count by 1.
~ If count is equal to K, assign the current number to result and break from the loop.
  If count is less than K, assign 0 to result to indicate that K is larger than the number of odd numbers.
~ Return the value of result as the Kth the largest odd number.

@ Time Complexity :- O((R - L)/2) or O(N), AND
@ Space Complexity :- O(1)
-----------------------------------------------------------------------------------------------------------------------------------------------------------

# Mathematical Approach Algorithm #

~ Adjust the range if necessary to include odd numbers: if L is even, increment L by 1; if R is even, decrement R by 1.
~ Calculate the total number of odd numbers in the range using the formula: numOddNumbers = (R - L) / 2 + 1.
~ If K is greater than numOddNumbers, return 0 to indicate that K is larger than the number of odd numbers.
~ Calculate the Kth the largest odd number using the formula: result = R - 2 * (K - 1).
~ Return the value of result as the Kth largest odd number.

@ Time Complexity :- O(1) and
@ Space Complexity :- O(1)

 */

//-----------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter Left Value :~");
        int left = sc.nextInt();
        System.out.print("Enter Right Value :~");
        int right = sc.nextInt();
        System.out.print("Enter 'kth' Value :~");
        int K = sc.nextInt();
        System.out.println("~: Brute Force Approach :~");
        findKthLargestOdd(left,right,K);  // brute force approach  (using iteration )     by greedy
        System.out.println("~: Better Approach :~");
        betterSolution(left,right,K);  // better approach  (using iteration)   by greedy
        System.out.println("~: Optimal Approach :~");
        optimalSolution(left,right,K);  // optimal Approach ( without iteration and it's solving by basic mathematics )  and ( In this function not using greedy approach )
    }

    public static void findKthLargestOdd(int L, int R, int K) {   // Time Complexity :- O((R - L)/2) or O(N), Space Complexity :- O(N)
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        // Adjust the range if necessary to include odd numbers
        if (L % 2 == 0) {
            L++; // Make L odd
        }
        if (R % 2 == 0) {
            R--; // Make R odd
        }

        // Collect all odd numbers within the adjusted range
        for (int i = L; i <= R; i += 2) {
            oddNumbers.add(i);
        }

        // Sort the odd numbers in descending order
        Collections.sort(oddNumbers, Collections.reverseOrder());

        // If K is greater than the number of odd numbers, return 0
        if (K > oddNumbers.size()) {
            return ;
        }

        // Return the Kth the largest odd number
        System.out.println(oddNumbers.get(K - 1));
    }

    private static void betterSolution(int left, int right, int K) {  // Time Complexity :- O((R - L)/2) or O(N)  '&' Space Complexity :- O(1)

        int r = right;
        int l = left;
        int count = 0;
        // Adjust the range if necessary to include odd numbers
        if (l % 2 == 0) {
            l++; // Make L odd
        }
        if (r % 2 == 0) {
            r--; // Make R odd
        }
        if(K<0){
            System.out.println(0);
            return;
        }
        if ((left == 0 && right == 0)) {
            System.out.println("@ given range is zero :- '[ 0 to 0 ]' @");
        }
        // If K is greater than the number of odd numbers, print or return 0
        else if(right<K){
            System.out.println("@ K is out of given range @");
        }
        // Iterate through the range in reverse order and find the Kth the largest odd number
        while (left < r )  {
                //System.out.println(r);
                count++;
                if(count==K){
                    System.out.println(r);
                    break;
                }
            r-=2;
        }
//

    }
    private static void optimalSolution(int left, int right, int k) { // Time Complexity :- O(1) and Space Complexity :- O(1)
             int l = left, r = right ;
             if(l%2==0){
                 l++;
             }
             if(r%2==0){
                 r--;
             }
             int numCount = ((r-l)/2 + 1);
             if(k>numCount){
                 System.out.println("@ K is out of given range @");
                 return;
             }
             System.out.println(r-(2*(k-1)));
    }
}