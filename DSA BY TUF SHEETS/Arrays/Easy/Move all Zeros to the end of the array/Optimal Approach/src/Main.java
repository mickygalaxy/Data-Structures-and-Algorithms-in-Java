/*
//                            Move all Zeros to the end of the array

/*
Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.

Examples:

Example 1:
Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order

Example 2:
Input: 1,2,0,1,0,4,0
Output: 1,2,1,4,0,0,0
Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order

Optimal Approach
If we find a zero (say its index is 2) while traversing that means this place should be occupied by the immediate next non-zero elements (so that order will be maintained for non-zero elements) so we will place a pointer here (at 2) and we will try to find next non-negative integer using another pointer, once it was found that means zero places (2nd index) has to be occupied by this non-negative number and non-negative number will be occupied by zero.

Algorithm:
@ Start traversing from the first occurrence index of Zero
@ Tak 2 variables (i,j), i will be at the first occurrence of zero and j is at i+1
@ If element at j index is not zero then swap elements at i,j and increment i,j
@ If the element at j index is zero then only increment j.
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[]array = new int[size];
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
        Optimal(array);
        System.out.println("-: OutPut :-");
        for(int i : array){
            System.out.print(i+" ");
        }
    }

    private static void Optimal(int[] arr) {
        int k = 0;
        while (k < arr.length) {
            if (arr[k] == 0) {

                break;
            } else {
                k = k + 1;
            }
        }

        //finding zeros and immediate non-zero elements and swapping them
        int i = k, j = k + 1;

        while (i < arr.length && j < arr.length) {
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;

            }

            j++;

        }
    }
}