//                                                       Maximum Subarray Sum in an Array
//                               ( Brute Force Approach using nested loop(2-inside loop and 1 is outside loop)
/*
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
                   has the largest sum and returns its sum and prints the subarray.

                   -: Examples :-
Example 1:

Input: arr = [-2,1,-3,4,-1,2,1,-5,4]

Output: 6

Explanation: [4,-1,2,1] has the largest sum = 6.

Examples 2:

Input: arr = [1]

Output: 1

Explanation: Array has only one element and which is giving positive sum of 1.

 */
/*
Algorithm / Intuition
---------------------
Intuition:
----------
We will check the sum of every possible subarray and consider the maximum among them.
To get every possible subarray sum, we will be using three nested loops. The first loops(say i and j) will iterate over every possible starting index and ending index of a subarray. Basically, in each iteration, the subarray range will be from index i to index j. Using another loop we will get the sum of the elements of the subarray [i…..j]. Among all values of the sum calculated, we will consider the maximum one.

Approach:
--------
The steps are as follows:

-< First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = size of the array).
-< Inside the loop, we will run another loop(say j) that will signify the ending index of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
-< After that for each subarray starting from index i and ending at index j (i.e. arr[i….j]), we will run another loop to calculate the sum of all the elements(of that particular subarray).

Note -< We are selecting every possible subarray using two nested loops and for each of them, we add all its elements using another loop.
 */
/*

--< Time Complexity: O(N3), where N = size of the array.

--< Reason: We are using three nested loops, each running approximately N times.

--< Space Complexity: O(1) as we are not using any extra space.

 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of Array:-");
        int n = sc.nextInt();
        int[]  array = new int[n];
        setData(array,n);
       System.out.println(" The maximum subarray sum is: "+bruteForceApproach(array,n));
    }

    private static int bruteForceApproach(int[] array, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum
        for(int i =0 ;i< n;i++){
            for(int j = i;j<n;j++){
                // subarray = arr[i.....j]
                int sum  = 0;
                //add all the elements of subarray:
                for(int k = i;k<=j;k++){
                    sum+= array[k];
                }
                maxi = Math.max(sum,maxi);
            }
        }
        return maxi;
    }

    private static void setData(int[] array, int n) {
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
    }
}