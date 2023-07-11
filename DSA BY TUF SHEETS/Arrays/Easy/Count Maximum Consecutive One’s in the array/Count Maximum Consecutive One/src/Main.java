

//                                                      Count Maximum Consecutive One’s in the array

/*
Count Maximum Consecutive One’s in the array
Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.

Examples:

Example 1:
Input: prices = {1, 1, 0, 1, 1, 1}
Output: 3
Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.

Input: prices = {1, 0, 1, 1, 0, 1}
Output: 2
Explanation: There are two consecutive 1's in the array.

: Solution :
Disclaimer: Don’t jump directly to the solution, try it out yourself first.

Approach:  We maintain a variable count that keeps a track of the number of consecutive 1’s while traversing the array.
The other variable max_count maintains the maximum number of 1’s, in other words, it maintains the answer.

We start traversing from the beginning of the array. Since we can encounter either a 1 or 0 there can be two situations:-

If  the value at the current index is equal to 1 we increase the value of count by one. After updating  the count variable if it becomes more than the max_count  update the max_count.
If the value at the current index is equal to zero we make the variable count as 0 since there are no more consecutive ones.
 */

/*
Time Complexity: O(N) since the solution involves only a single pass.
Space Complexity: O(1) because no extra space is used.
 */

import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
      int N = sc.nextInt();
      int[]array = new int[N];
      for(int i=0;i<N;i++){
          array[i] = sc.nextInt();
      }
      countMaximumConsecutiveOne(array,N);
    }

    private static void countMaximumConsecutiveOne(int[] array, int n) {
        int count = 0;
        int maxCount = 0;
        int i=0;
        while(i<n){
            if(array[i]==1){
                count++;
                maxCount = Math.max(count,maxCount);

            }
            else{
                count = 0;
            }
            i++;
        }
        System.out.println(maxCount);
    }
}