
//                                                 Find the missing number in an array

/*Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N.
 Find the number(between 1 to N), that is not present in the given array.*/

/*
Example 1:
Input Format: N = 5, array[] = {1,2,4,5}
Result: 3
Explanation: In the given array, number 3 is missing. So, 3 is the answer.

Example 2:
Input Format: N = 3, array[] = {1,3}
Result: 2
Explanation: In the given array, number 2 is missing. So, 2 is the answer.
 */
/*
Naive Approach(Brute-force approach):

Intuition: For each number between 1 to N, we will try to find it in the given array using linear search. And if we don’t find any of them, we will return the number.

# Approach:

~ The algorithm steps are as follows:

  1) We will run a loop(say i) from 1 to N.
  2) For each integer, i, we will try to find it in the given array using linear search.
        1) For that, we will run another loop to iterate over the array and consider a flag variable to indicate if the element exists in the array. Flag = 1 means the element is present and flag = 0 means the element is missing.
        2)Initially, the flag value will be set to 0. While iterating the array, if we find the element, we will set the flag to 1 and break out from the loop.
          Now, for any number i, if we cannot find it, the flag will remain 0 even after iterating the whole array and we will return the number.
# Dry run:

Assume given array = {1, 3} and N = 3.

@ Note: For each number, before starting the linear search, we set the flag to 0.

For i = 1, flag = 0
We will try to find 1 in the array using linear search and in the first index, we can find it and the flag will be 1. So, it is not the missing number.

For i = 2, flag = 0
We will try to find 2 in the given array using linear search. But number 2 is not present and the flag will remain 0. So, we will return 2 as it is the missing number.
 */
/*

# Time Complexity: O(N^2), where N = size of the array+1.
             Reason: In the worst case i.e. if the missing number is N itself, the outer loop will run for N times,
             and for every single number the inner loop will also run for approximately N times. So, the total time complexity will be O(N2).
# Space Complexity: O(1), as we are not using any extra space.

 */

import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the Number :- ");
        int N = sc.nextInt();
        int[] Array = new int[N-1];
        System.out.println("-: Enter the Data ( range -> 1 to "+N+" ) :-");
        setData(Array,N-1);
        int ans = missingNumber(Array,N);
        if(ans!=0){
            System.out.println("Missing Number is "+missingNumber(Array,N));
        }else{
            System.out.println("All Number Are Present");
        }
    }

    private static int missingNumber(int[] array, int n) {
        int ans =0;
        for(int i=1;i<=n;i++){
            int flag = 0;
            for(int j=0;j<n-1;j++){
                if(i== array[j]){
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                return i;
            }
        }
        return ans;
    }

    private static void setData(int[] array, int N) {
        for(int i=0;i<N;i++){
            array[i] = sc.nextInt();
        }
    }
}