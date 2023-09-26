

/*
                                                          Sort an array of 0s, 1s and 2s
                                                          ------------------------------
Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions.
( Expected: Single pass-O(N) and constant space).

-------------------------------------
---- Examples ----
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]

Input: nums = [0]
Output: [0]
--------------------------------------

/*
Time Complexity: O(N*logN)

Space Complexity: O(1)
 */




import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the size of array :- ");
        int size = sc.nextInt();
        int[]array = new int[size];
        System.out.println("-: enter the data [0, 1, 2] :- ");
        setData(array,size);
        betterApproach(array,size);
        displayData(array,size);
        
    }

    private static void displayData(int[] array, int size) {
        System.out.println("-: After sorted array :-");
        for(int i:array){
            System.out.println(i+" ");
        }
    }

    private static void betterApproach(int[] array, int size) {
           Arrays.sort(array);
    }

    private static void setData(int[] array, int size) {
        for(int i=0;i<size;i++){
            array[i] = sc.nextInt();
        }
    }
}